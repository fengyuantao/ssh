package com.spring.service;

import java.util.List;

import com.spring.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getListByCode(String code);
    void saveDict(BaseDict bd);
    Integer getCOunt();
	List<BaseDict> getListByCode();
	BaseDict updateDict(String dict_id);
	BaseDict updateDict(BaseDict baseDict);
	void deleteDicts(String[] dict_ids);
}
