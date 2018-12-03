package com.spring.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.spring.dao.UserDao;
import com.spring.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	


	@Override
	public void save(User user) {
		getHibernateTemplate().save(user);
		
	}

	@Override
	public void deleteByName(String name) {

		
	}

	@Override
	public void updateWithName(String name, String NewName) {
		
		
	}

	@Override
	public User queryByName(String name) {
		// 利用hibernateDaoSupport提供的 getHibernateTemplate 方法进行查询
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				// 直接利用该session
				
				String sql = "from User where name = ?";
				
				Query query = session.createQuery(sql);
				
				query.setParameter(0, name);
				
				return (User) query.uniqueResult();
			}
			
		});
		
		
		
	}

	@Override
	public List<User> queryAll() {
		// findByCriteria  查询
		DetachedCriteria dc =  DetachedCriteria.forClass(User.class);
		//dc.add(Restrictions.eq("name", "username")); 离线查询传入参数
		List<User> user = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if(user != null && user.size() == 1) {
			return user;
		}
		return user;
	}

}
