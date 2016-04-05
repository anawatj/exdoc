package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.deposit.Deposit;
import com.tao.exdoc.domain.deposit.DepositQuery;

public interface IDepositRepository extends Repository<Deposit,Integer>{

	Result<Deposit> findAll() throws Exception;
	Deposit findByKey(Integer key) throws Exception;
	void remove(Integer key) throws Exception;
	Deposit save(Deposit entity) throws Exception;
	Result<Deposit> findByQuery(DepositQuery query) throws Exception;
}
