package com.tao.exdoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.exdoc.command.BorrowCommand;
import com.tao.exdoc.domain.borrow.Borrow;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.repository.IBorrowRepository;
import com.tao.exdoc.service.IBorrowService;
@Service
public class BorrowService implements IBorrowService{

	@Autowired
	private IBorrowRepository borrowRepository;
	
	@Autowired
	private BorrowCommand borrowCommand;
	
	public Borrow approve(Borrow entity) throws Exception {
	
		
		
		borrowCommand.execute(entity);
		return entity;
	}

	public Borrow save(Borrow entity) throws Exception {
		Borrow result =  borrowRepository.save(entity);
		if(entity.getStatus()== Status.SP)
		{
			result = submit(result);
		}else if(entity.getStatus()==Status.AP)
		{
			result = approve(result);
		}
		return result;
	}

	public Borrow submit(Borrow entity) throws Exception {
		entity.setStatus(Status.SP);
		return save(entity);
	}

}
