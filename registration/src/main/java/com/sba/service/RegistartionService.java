package com.sba.service;

import com.sba.entity.UserProfiles;

public interface RegistartionService {

	public UserProfiles register(UserProfiles user);
	public UserProfiles getUserDetails(Long uId);
	public UserProfiles Login(UserProfiles user);
	
	
}
