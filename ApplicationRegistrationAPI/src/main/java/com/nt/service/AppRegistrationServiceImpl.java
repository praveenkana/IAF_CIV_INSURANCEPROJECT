package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.nt.bindings.CitizenAppRegistrationInputs;
import com.nt.entity.CitizenAppRegistrationEntity;
import com.nt.repository.AppRegistrationRepository;

@Service
public class AppRegistrationServiceImpl implements AppRegistrationService {

	@Autowired
	private AppRegistrationRepository apprepository;
	@Autowired
	private RestTemplate template;
	@Autowired
	private WebClient client;

	@Override
	public Integer registerCitizenApplication(CitizenAppRegistrationInputs inputs) throws InvalidServiceNumberException {

		String idCheckURL = "http://localhost:4040/check/identity/{serviceNumber}";
		// perform web service call to check whether individual is valid or not

		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<String> response = template.exchange(idCheckURL, HttpMethod.GET, null, String.class,
				inputs.getServiceNumber());
		String serNo = response.getBody();

		// String serNo =
		// client.get().uri(idCheckURL,inputs.getServiceNumber()).retrieve().bodyToMono(String.class).block();
		if (serNo == null || serNo.isBlank()) {

			return 0;
		}
		if (serNo.equalsIgnoreCase(inputs.getServiceNumber())) {
			// prepare entity object

			CitizenAppRegistrationEntity citizen = new CitizenAppRegistrationEntity();
			BeanUtils.copyProperties(inputs, citizen);
			inputs.setServiceNumber(serNo);
			// save object
			Integer appId = apprepository.save(citizen).getAppId();
			return appId;
		}
		throw new InvalidServiceNumberException("invalid service number");
	}

}
