package com.spring.utils;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class GetBeanWithName {

	// 获取bean 对象方法
	public static Object getObject(String beanIdOrName) {
		// 从spring容器中获得CustomerServiceImpl对像
				ServletContext sc = ServletActionContext.getServletContext();
				WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
				
				Object object = ac.getBean(beanIdOrName);
				return object;
	}
}
