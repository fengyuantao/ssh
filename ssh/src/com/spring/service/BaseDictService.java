package com.spring.service;

import java.util.List;

import com.spring.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getListByCode(String code);
    void saveDict(BaseDict bd);
	List<BaseDict> getListByCode();
}
