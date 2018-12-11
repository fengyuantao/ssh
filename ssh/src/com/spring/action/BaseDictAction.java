package com.spring.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.spring.domain.BaseDict;
import com.spring.service.BaseDictService;
import com.spring.service.CustomerService;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport implements ModelDriven{

	private String rows;
	private String page;
	private String cust_id;
	private String dicts;
	
	private BaseDict baseDict = new BaseDict();
	
	private BaseDictService bs;
	
	




	public String execute() throws IOException {
	/*	if(code==null || "".equals(code)) {
			return null;
		}*/
		Map map = new HashMap();
		String jsonList = null;
		try {
			// 1 调用service查询数据
			List<BaseDict> list = bs.getListByCode();
			//map.put("success", list);
			Integer count = bs.getCOunt();
			map.put("total", count);
			map.put("rows", list);
			// 2 把数据转换为json格式
			jsonList = JSON.toJSONString(map);
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
	
	public String updateDict() throws IOException {
		BaseDict dict = bs.updateDict(cust_id);
		System.out.println("vvvvv:"+cust_id+"vvvvv:"+dict);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		if(dict==null) {
			ServletActionContext.getResponse().getWriter().write("{\"success\":false,\"message\":\"数据不存在\"}");
			
		}else {
			String jsonReturn = JSON.toJSONString(dict);
			ServletActionContext.getResponse().getWriter().write(jsonReturn);
		}
		
		return null;
	}
	
	
	
	public String updateWithId() throws IOException {
		System.out.println(baseDict);
		BaseDict dict = bs.updateDict(baseDict);
		
		return null;
	}
	
	public String deleteDicts() throws IOException {
		
		try {
			String[] dict_ids = dicts.split(":");
			System.out.print(dict_ids);
			bs.deleteDicts(dict_ids);
			ServletActionContext.getResponse().getWriter().write("{\"success\":true,\"message\":\"删除成功\"}");
		} catch (Exception e) {
			ServletActionContext.getResponse().getWriter().write("{\"success\":false,\"message\":\"数据不存在\"}");
			e.printStackTrace();
		}
		return null;
	}
	
	public void setBs(BaseDictService bs) {
		this.bs = bs;
	}

	

	public void setRows(String rows) {
		this.rows = rows;
	}



	public void setPage(String page) {
		this.page = page;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return baseDict;
	}

	public void setDicts(String dicts) {
		this.dicts = dicts;
	}
	

	
}
