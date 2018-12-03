package com.spring.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dao.UserDao;
import com.spring.dao.impl.UserDaoImpl;
import com.spring.domain.User;
import com.spring.service.impl.UserServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestHiber {
	
	@Resource(name="user")
	private User user;
	
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	
	@Resource(name="us")
	private UserServiceImpl us;

	@Test
	public void test1() {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		ts.begin();
		
		user.setName("jack");
		user.setPassword("123456");
		
		session.save(user);
		ts.commit();
		
		session.close();

	}
	
	
	@Test
	public void test2() {
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		ts.begin();
		
		user.setName("马云");
		user.setPassword("123456");
		
		session.save(user);
		ts.commit();
		
		session.close();

	}
	
	@Test
	public void test3() {

		us.saveUser();
	}
}
