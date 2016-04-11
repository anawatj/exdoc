package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.returndoc.Return;
import com.tao.exdoc.domain.returndoc.ReturnQuery;

public interface IReturnRepository extends Repository<Return,Integer> {

	Result<Return> findAll() throws Exception;
	Return findByKey(Integer key) throws Exception;
	void remove(Integer key) throws Exception;
	Return save(Return entity) throws Exception;
	Result<Return> findByQuery(ReturnQuery query) throws Exception;
}
