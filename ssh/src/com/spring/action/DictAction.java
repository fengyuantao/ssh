package com.spring.action;

import java.util.UUID;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.spring.domain.BaseDict;
import com.spring.service.BaseDictService;

public class DictAction extends ActionSupport implements ModelDriven{

	private BaseDictService bs;
	private BaseDict bd = new BaseDict();
	
	public String AddDict() {
		// 1 封装数据 dict_id
		bd.setDict_id(UUID.randomUUID().toString());
		// 2 调用bs 插入数据
		bs.saveDict(bd);
	
		
		return "success";
	}


	public void setBs(BaseDictService bs) {
		this.bs = bs;
	}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return bd;
	}
	
	
	
}
