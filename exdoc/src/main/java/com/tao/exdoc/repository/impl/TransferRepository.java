package com.tao.exdoc.repository.impl;

import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.transfer.Transfer;
import com.tao.exdoc.repository.ITransferRepository;
@Repository
public class TransferRepository implements ITransferRepository{

	public Result<Transfer> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Transfer findByKey(Integer key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Integer key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Transfer save(Transfer entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
