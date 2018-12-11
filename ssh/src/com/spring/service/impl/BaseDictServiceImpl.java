package com.spring.service.impl;

import java.util.ArrayList;
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

	@Override
	public Integer getCOunt() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		
		return baseDictDao.getTotalCount(dc);
	}

	@Override
	public BaseDict updateDict(String dict_id) {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		dc.add(Restrictions.eq("dict_id", dict_id));
		
		return baseDictDao.getObjectById(dc);
	}

	@Override
	public BaseDict updateDict(BaseDict baseDict) {
		baseDictDao.update(baseDict);
		return null;
	}

	@Override
	public void deleteDicts(String[] dict_ids) {
		//删除一组数据
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		if(dict_ids == null && dict_ids.length<=0) {
			throw new RuntimeException("请勾选删除数据");
		}
		//List<BaseDict> dicts = new ArrayList<BaseDict>();
	/*	for(String dict_id:dict_ids) {
			//dc.add(Restrictions.eq("dict_id", dict_id));
			BaseDict dict = new BaseDict();
			dict.setDict_id(dict_id);
			//dicts.add(dict);
			baseDictDao.delete(dict);
		}*/
		
	}


}
