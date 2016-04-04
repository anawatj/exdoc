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
	
		
		Borrow result= save(entity);
		borrowCommand.execute(entity);
		return result;
	}

	public Borrow save(Borrow entity) throws Exception {
		return borrowRepository.save(entity);
	}

	public Borrow submit(Borrow entity) throws Exception {
		entity.setStatus(Status.SP);
		return save(entity);
	}

}
