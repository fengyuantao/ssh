package com.spring.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.spring.dao.CustomerDao;
import com.spring.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void addCustomer(Customer c) {
		//add a new customer 
		 getHibernateTemplate().save(c);

	}

}
