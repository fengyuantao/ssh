package com.spring.service.impl;

import com.spring.dao.CustomerDao;
import com.spring.domain.Customer;
import com.spring.service.CustomerService;
import com.spring.utils.GetBeanWithName;

public class CustomerServiceImpl implements CustomerService{

	@Override
	public void addCustomer(Customer c) {
		// add a new  customer 
		CustomerDao dao = (CustomerDao) GetBeanWithName.getObject("customerDao");
		dao.addCustomer(c);
		
	}

}
