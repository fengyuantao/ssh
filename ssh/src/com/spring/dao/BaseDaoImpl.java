package com.spring.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Parameter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.spring.utils.GenricsUtils;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	
	private Class clazz;
	
	
	public BaseDaoImpl() {
		// 获得当前运行时带有泛型的父类
		//ParameterizedType pt=  (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获得运行期的泛型类型
		//clazz = (Class) pt.getActualTypeArguments()[0];
		clazz = GenricsUtils.getSuperClassGenricType(this.getClass());
	}

	@Override
	public void save(T t) {
		//新增对象
		getHibernateTemplate().save(t);
		
	}

	@Override
	public void delete(T t) {
		// 删除一个对象
		getHibernateTemplate().delete(t);
		
	}

	@Override
	public void delete(Integer id) {
		// 根据ID删除对象
		T object = this.getObjectById(id);
		getHibernateTemplate().delete(object);
		
	}

	@Override
	public void update(T t) {
		// 修改一个对象
		getHibernateTemplate().update(t);
		
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		// 查询对象数量
		dc.setProjection(Projections.rowCount());
		List<Long> counts = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		dc.setProjection(null);
		if(counts != null && counts.size() > 0) {
			return counts.get(0).intValue();
		}
		return null;
	}

	@Override
	public T getObjectById(Integer id) {
		// 根据ID查询对象
		
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> getObjectsList(DetachedCriteria dc, Integer start, Integer pageCount) {
		List<T> lists = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageCount);

		return lists;
	}

}
