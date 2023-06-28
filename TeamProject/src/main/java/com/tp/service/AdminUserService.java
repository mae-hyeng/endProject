package com.tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.entity.AdminUser;
import com.tp.repository.AdminUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminUserService {

	@Autowired
	AdminUserRepository adminUserRepository;
	
	public int loginCheck(final String username, final String password) {
		int result = 0;
		if(adminUserRepository.existsByUsername(username)) {
			AdminUser adminUser = adminUserRepository.findByUsername(username);
			if(adminUser.getPassword().equals(password)) {
				result = 0;
			}
		} else {
			result = 2;
		}
		return result;
	}
}
