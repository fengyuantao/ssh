package com.spring.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.spring.dao.BaseDictDao;
import com.spring.domain.BaseDict;
import com.spring.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService{

	private BaseDictDao baseDictDao;
	
	
	@Override
	public List<BaseDict> getListByCode(String code) {
		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		dc.add(Restrictions.eq("dict_type_code", code));
		dc.add(Restrictions.eq("dict_enable", "1"));
		
		
		List<BaseDict> list = baseDictDao.getBaseDictList(dc);
		
		
		return list;
	}
	
	@Override
	public void saveDict(BaseDict bd) {
		// TODO Auto-generated method stub
		baseDictDao.save(bd);
	}
	
	
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	@Override
	public List<BaseDict> getListByCode() {
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		
		return baseDictDao.getBaseDictList(dc);
	}


}
