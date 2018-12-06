package com.spring.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.spring.domain.BaseDict;
import com.spring.service.BaseDictService;
import com.spring.service.CustomerService;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport{

	private String code;
	private BaseDictService bs;
	
	




	public String execute() throws IOException {
		if(code==null || "".equals(code)) {
			return null;
		}
		HashMap<String,List> map = new HashMap<String,List>();
		String jsonList = null;
		try {
			// 1 调用service查询数据
			List<BaseDict> list = bs.getListByCode(code);
			map.put("success", list);
			
			
			// 2 把数据转换为json格式
			jsonList = JSONArray.fromObject(map).toString();
			// 3 返回数据，写入方式
			ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
			
			System.out.println(jsonList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("success",null );
			
		}
		ServletActionContext.getResponse().getWriter().write(jsonList);
		return null;
	}
	
	public String getBaseDictList() {
		List<BaseDict> list = bs.getListByCode();
		ActionContext.getContext().put("dicts", list);
		return "success";
	}
	
	public void setBs(BaseDictService bs) {
		this.bs = bs;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
}
