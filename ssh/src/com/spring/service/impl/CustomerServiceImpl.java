package com.spring.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.spring.dao.CustomerDao;
import com.spring.domain.Customer;
import com.spring.service.CustomerService;
import com.spring.utils.GetBeanWithName;
import com.spring.utils.PageBean;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;
	
	

	@Override
	public void addCustomer(Customer c) {
		// add a new  customer 
		CustomerDao dao = (CustomerDao) GetBeanWithName.getObject("customerDao");
		dao.save(c);
		
	}

	@Override
	public PageBean getCustomerPageBean(DetachedCriteria dc, Integer pageCount, Integer currentPage) {
		PageBean pageBean = null;
		try {
			// 根据条件获取customer数据
			Integer totalCount = customerDao.getTotalCount(dc);
			System.out.println("customer总条数：" + totalCount);
			System.out.println("创建pageBean对象");
			pageBean = new PageBean(currentPage, pageCount, totalCount);
			// 根据pageBean里的数据查询customer列表
			System.out.println("根据pageBean里的数据查询customer列表");
			List customets = customerDao.getObjectsList(dc, pageBean.getStartIndex(), pageBean.getPageCount());
			pageBean.setList(customets);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pageBean;
	}
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
}
