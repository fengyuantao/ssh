package com.spring.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.spring.domain.Customer;
import com.spring.utils.PageBean;

public interface CustomerDao {
	void addCustomer(Customer c);

	Integer totalCount(DetachedCriteria dc);

	List getCustomerListByName(DetachedCriteria dc, PageBean pageBean);

	Integer getCustomerCountByName(DetachedCriteria dc);
}
