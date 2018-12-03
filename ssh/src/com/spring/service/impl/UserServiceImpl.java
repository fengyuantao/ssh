package com.spring.service.impl;

import javax.annotation.Resource;

import com.spring.dao.UserDao;
import com.spring.domain.User;

public class UserServiceImpl {
	@Resource(name="user")
	private User user;
	
	@Resource(name="userDao")
	private UserDao userDao;
	
     public void saveUser() {
    	 user.setName("lisa");
    	 user.setPassword("123456");
    	 userDao.save(user); 
     }
}
