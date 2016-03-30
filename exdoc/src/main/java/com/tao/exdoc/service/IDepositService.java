package com.tao.exdoc.service;

import com.tao.exdoc.domain.deposit.Deposit;

public interface IDepositService extends IService<Deposit>{
		Deposit approve(Deposit entity)throws Exception;
		Deposit save(Deposit entity)throws Exception;
		Deposit submit(Deposit entity)throws Exception;
}
