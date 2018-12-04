package com.spring.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.spring.domain.Customer;
import com.spring.service.CustomerService;
import com.spring.utils.GetBeanWithName;

public class AddCustomerAction extends ActionSupport implements ModelDriven{
 
	private Customer customer = new Customer();
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	public String addCustomer() {
		// 从spring容器中获得CustomerServiceImpl对像
		/*
		ServletContext sc = ServletActionContext.getServletContext();
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		CustomerService cs = (CustomerService) ac.getBean("customerService");
		*/
		
		CustomerService cs = (CustomerService)GetBeanWithName.getObject("customerService");
		
			cs.addCustomer(customer);
		
		
		
		return "success";
	}
	

	
}
