package com.sba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba.entity.UserProfiles;
import com.sba.repo.ContactsRepository;
import com.sba.repo.UserRepository;
import com.sba.service.RegistartionService;

@Service
public class RegistartionServiceImpl implements RegistartionService {
	@Autowired
	UserRepository repository;
	@Autowired
	ContactsRepository contactsRepository;
	@Override
	public UserProfiles register(UserProfiles user) {
		repository.save(user);
		System.out.println(user);
		
		contactsRepository.saveContacts(user.getContacts());
		
		return user;
	}

	@Override
	public UserProfiles getUserDetails(Long uId) {
		UserProfiles user=repository.findByUid(uId);
		System.out.println(user);
		user.setContacts(contactsRepository.getContactsByUid(uId));
		return user;
	}

	@Override
	public UserProfiles Login(UserProfiles user) {
		UserProfiles user2=repository.findByUserIdAndPassword(user.getUserId(),user.getPassword());
		return user2;
	}

	

}
