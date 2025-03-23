package com.sba.repo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sba.entity.Contacts;

@FeignClient(url = "http://localhost:8899/contacts/" ,name="contacts")
public interface ContactsRepository {

	@PostMapping("/savecontacts")
	public Contacts saveContacts(@RequestBody Contacts contacts);
	@GetMapping("/getcontacts/{uid}")
	public Contacts getContactsByUid(@PathVariable Long uid);
	
	
}
