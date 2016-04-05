package com.tao.exdoc.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.deposit.Deposit;
import com.tao.exdoc.domain.deposit.DepositQuery;
import com.tao.exdoc.repository.IDepositRepository;
@Repository
public class DepositRepository implements IDepositRepository{
	
	
	@Autowired
	private SessionFactory factory;

	public DepositRepository() {
		// TODO Auto-generated constructor stub
	}

	public Result<Deposit> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Deposit findByKey(Integer key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Integer key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Deposit save(Deposit entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Result<Deposit> findByQuery(DepositQuery query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
