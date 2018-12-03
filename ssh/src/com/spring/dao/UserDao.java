package com.spring.dao;

import java.util.List;

import com.spring.domain.User;

public interface UserDao {

	void save(User user);
	void deleteByName(String name);
	void updateWithName(String name,String NewName);
	User queryByName(String name);
	List<User> queryAll();
}
