package com.spring.service;

import org.hibernate.criterion.DetachedCriteria;

import com.spring.domain.Customer;
import com.spring.utils.PageBean;

public interface CustomerService {

	void addCustomer(Customer c);
	PageBean getCustomerPageBean(DetachedCriteria dc,Integer pageCount,Integer currentPage);
}
