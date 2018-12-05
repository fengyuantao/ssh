package com.spring.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.spring.domain.Customer;
import com.spring.service.CustomerService;
import com.spring.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven{
	private String cname;
	private Integer pageCount;
	private Integer currentPage;
	private CustomerService cs;
	
	public String CustomerList() {
		System.out.println("进入客户查询。。。。:"+cname);
		
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		// 判断并封装参数
		if(StringUtils.isNoneBlank(cname)) {
			dc.add(Restrictions.like("cname", "%"+cname+"%"));
		}
		 PageBean pages = cs.getCustomerPageBean(dc, pageCount, currentPage);
		 System.out.println("总页数："+pages.getTotalCount());
		 //获取到的数据放入request域中
		ActionContext.getContext().put("pages", pages);
		
		
		return "getCustomerList";
				
	}
	
	
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	
	
	
	public void setCname(String cname) {
		this.cname = cname;
	}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
