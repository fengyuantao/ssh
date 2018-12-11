package com.spring.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.spring.dao.BaseDaoImpl;
import com.spring.dao.BaseDictDao;
import com.spring.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl implements BaseDictDao {
	@Override
	public List<BaseDict> getBaseDictList(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

	@Override
	public BaseDict getObjectById(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		if(list != null && list.size()>0) {
			return list.get(0);
		}
		else {
			return null;
		}
	}

}
