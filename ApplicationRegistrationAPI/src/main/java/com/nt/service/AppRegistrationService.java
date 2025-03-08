package com.nt.service;

import com.nt.bindings.CitizenAppRegistrationInputs;

public interface AppRegistrationService {

	public Integer registerCitizenApplication(CitizenAppRegistrationInputs inputs) throws InvalidServiceNumberException;

}
