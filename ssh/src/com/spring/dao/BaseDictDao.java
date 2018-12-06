package com.spring.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.spring.domain.BaseDict;

public interface BaseDictDao extends BaseDao{

	List<BaseDict> getBaseDictList(DetachedCriteria dc);
}
