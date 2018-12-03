package com.spring.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.action.UserAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpring {
	
	@Resource(name="userAction")
	private UserAction userAction;
	
	



	@Test
	public void testSpring() {
		System.out.println(userAction);
	}

}
