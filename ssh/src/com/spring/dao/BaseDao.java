package com.spring.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {

	void save(T t);
	void delete(T t);
	void delete(Integer id);
	void update(T t);
	Integer getTotalCount(DetachedCriteria dc);
	T getObjectById(Integer id);
	List<T> getObjectsList(DetachedCriteria dc,Integer start,Integer pageCount);
}
