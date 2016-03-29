package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.returndoc.Return;

public interface IReturnRepository extends Repository<Return,Integer> {

	Result<Return> findAll() throws Exception;
	Return findByKey(Integer key) throws Exception;
	void remove(Integer key) throws Exception;
	Return save(Return entity) throws Exception;
}
