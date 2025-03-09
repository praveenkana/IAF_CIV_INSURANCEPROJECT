package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.bindings.ChildrenInputs;
import com.nt.bindings.CitizenAppRegistrationInputs;
import com.nt.bindings.DC_SummaryInputs;
import com.nt.bindings.EducationInputs;
import com.nt.bindings.IncomeInputs;
import com.nt.bindings.PlanSelectionInputs;
import com.nt.entity.CitizenAppRegistrationEntity;
import com.nt.entity.DC_CaseEntity;
import com.nt.entity.DC_ChildrenEntity;
import com.nt.entity.DC_EducationEntity;
import com.nt.entity.DC_IncomeEntity;
import com.nt.entity.PlanEntity;
import com.nt.repository.AppRegistrationRepository;
import com.nt.repository.DC_CaseRepository;
import com.nt.repository.DC_ChildrenRepository;
import com.nt.repository.DC_EducationRepository;
import com.nt.repository.DC_IncomeRepository;
import com.nt.repository.PlanRepository;

@Service
public class DC_ManagementServiceImpl implements DC_ManagementService {

	@Autowired
	private AppRegistrationRepository apprepo;
	@Autowired
	private DC_CaseRepository caserepo;
	@Autowired
	private DC_EducationRepository edrepo;
	@Autowired
	private DC_ChildrenRepository childrepo;
	@Autowired
	private DC_IncomeRepository incomerepo;
	@Autowired
	private PlanRepository planrepo;

	@Override
	public Integer generateCaseNo(Integer appId) {

		Optional<CitizenAppRegistrationEntity> opt = apprepo.findById(appId);
		if (opt.isPresent()) {
			DC_CaseEntity cEntity = new DC_CaseEntity();
			cEntity.setAppId(appId);
			return caserepo.save(cEntity).getCaseNo();// save operation
		}

		return 0;
	}

	@Override
	public List<String> showAllPlans() {
		List<PlanEntity> planList = planrepo.findAll();
		/*
		 * List<String> list=new ArrayList<>(); planList.forEach(result->{ String
		 * planName = result.getPlanName(); list.add(planName); }); return list;
		 */
		List<String> list = planList.stream().map(plan -> plan.getPlanName()).toList();
		return list;
	}

	@Override
	public Integer savePlanSelction(PlanSelectionInputs plan) {

		Optional<DC_CaseEntity> opt = caserepo.findById(plan.getCaseNo());
		if (opt.isPresent()) {
			DC_CaseEntity caseEntity = opt.get();
			caseEntity.setPlanId(plan.getPlanId());
			caserepo.save(caseEntity);// update operation
			return caseEntity.getCaseNo();
		}

		return 0;
	}

	@Override
	public Integer saveIncomeDetails(IncomeInputs income) {
		DC_IncomeEntity iEntity = new DC_IncomeEntity();
		BeanUtils.copyProperties(income, iEntity);
		incomerepo.save(iEntity);
		return income.getCaseNo();
	}

	@Override
	public Integer saveEducationDetails(EducationInputs education) {
		DC_EducationEntity entity = new DC_EducationEntity();
		BeanUtils.copyProperties(education, entity);
		edrepo.save(entity);
		return education.getCaseNo();

	}

	@Override
	public Integer saveChildrenDetails(List<ChildrenInputs> children) {

		children.forEach(child -> {
			DC_ChildrenEntity childEntity = new DC_ChildrenEntity();
			BeanUtils.copyProperties(child, childEntity);
			// save each children entity
			childrepo.save(childEntity);
		});

		return children.get(0).getCaseNo();
	}

	@Override
	public DC_SummaryInputs showDC_Summary(Integer caseNo) {

		DC_IncomeEntity incomeEntity = incomerepo.findByCaseNo(caseNo);
		DC_EducationEntity educationEntity = edrepo.findByCaseNo(caseNo);
		List<DC_ChildrenEntity> childList = childrepo.findByCaseNo(caseNo);
		CitizenAppRegistrationEntity appEntity = null;
		String planName = null;
		Integer appId = null;
		Optional<DC_CaseEntity> opt = caserepo.findById(caseNo);
		if (opt.isPresent()) {
			Integer planId = opt.get().getPlanId();
			appId = opt.get().getAppId();
			Optional<PlanEntity> plan = planrepo.findById(planId);
			if (plan.isPresent()) {
				planName = plan.get().getPlanName();
			}
		}
		Optional<CitizenAppRegistrationEntity> opt1 = apprepo.findById(appId);
		if (opt1.isPresent()) {
			appEntity = opt1.get();
		}
		// convert entity objects to binding object
		IncomeInputs income = new IncomeInputs();
		BeanUtils.copyProperties(incomeEntity, income);
		EducationInputs education = new EducationInputs();
		BeanUtils.copyProperties(educationEntity, education);
		List<ChildrenInputs> childlist = new ArrayList<>();
		childList.forEach(child -> {
			ChildrenInputs childInput = new ChildrenInputs();
			BeanUtils.copyProperties(child, childInput);
			childlist.add(childInput);
		});
		CitizenAppRegistrationInputs appInputs = new CitizenAppRegistrationInputs();
		BeanUtils.copyProperties(appEntity, appInputs);
		DC_SummaryInputs summary = new DC_SummaryInputs();
		summary.setChInputs(childlist);
		summary.setCitizen(appInputs);
		summary.setEdInputs(education);
		summary.setPlanName(planName);
		summary.setIncomeInputs(income);

		return summary;
	}

}
