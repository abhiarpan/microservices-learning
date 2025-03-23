package com.sba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sba.entity.UserProfiles;

@Repository
public interface UserRepository extends JpaRepository<UserProfiles, Long> {

	UserProfiles findByUid(Long uId);
	UserProfiles findByUserIdAndPassword(String userId,String password);

}
