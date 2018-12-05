package com.spring.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.spring.dao.CustomerDao;
import com.spring.domain.Customer;
import com.spring.utils.PageBean;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void addCustomer(Customer c) {
		//add a new customer 
		 getHibernateTemplate().save(c);

	}

	@Override
	public Integer getCustomerCountByName(DetachedCriteria dc) {
		// 查询条数
		System.out.println("我在查询客户数量");
		dc.setProjection(Projections.rowCount());
		List<Long> counts = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		
		dc.setProjection(null);
		if(counts != null && counts.size() > 0) {
			System.out.println("我在查询客户数量:" +counts.get(0));
			
			return counts.get(0).intValue();
		}else {
			return null;
		}
		 
	 
		
	}

	@Override
	public List getCustomerListByName(DetachedCriteria dc, PageBean pageBean) {
		// 查询客户列表
		System.out.println("我在查询客户列表了");
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, pageBean.getStartIndex(), pageBean.getPageCount());
		System.out.println("根据pageBean里的数据查询customer列表:"+list);
		return list;
	}

	@Override
	public Integer totalCount(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return null;
	}

}
