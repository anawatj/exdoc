package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.witdown.Witdown;
import com.tao.exdoc.domain.witdown.WitdownQuery;

public interface IWitdownRepository extends Repository<Witdown,Integer> {

	Result<Witdown> findAll() throws Exception;
	Witdown findByKey(Integer key) throws Exception;
	void remove(Integer key) throws Exception;
	Witdown save(Witdown entity) throws Exception;
	
	Result<Witdown> findByQuery(WitdownQuery query) throws Exception;
}
