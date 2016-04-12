package com.tao.exdoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.exdoc.domain.deposit.Deposit;
import com.tao.exdoc.repository.IDepositRepository;
import com.tao.exdoc.service.IDepositService;
@Service
public class DepositService implements IDepositService{
	
	
	@Autowired
	private IDepositRepository depositRepository;

	public Deposit approve(Deposit entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Deposit save(Deposit entity) throws Exception {
		Deposit result = depositRepository.save(entity);
		return result;
	}

	public Deposit submit(Deposit entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
