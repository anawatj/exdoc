package com.tao.exdoc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.exdoc.command.BorrowCommand;
import com.tao.exdoc.domain.borrow.Borrow;
import com.tao.exdoc.domain.borrow.BorrowItem;
import com.tao.exdoc.domain.enumurate.DocumentStatus;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.domain.security.User;
import com.tao.exdoc.repository.IBorrowRepository;
import com.tao.exdoc.repository.IDocumentRepository;
import com.tao.exdoc.repository.IUserRepository;
import com.tao.exdoc.service.IBorrowService;
@Service
public class BorrowService implements IBorrowService{

	@Autowired
	private IBorrowRepository borrowRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IDocumentRepository documentRepository;
	
	public Borrow approve(Borrow entity) throws Exception {
	
		
		return null;
	}

	public Borrow save(Borrow entity) throws Exception {
		Borrow result =  borrowRepository.save(entity);
		User user = userRepository.findUserByUserName(entity.getUpdatedBy());
		if(entity.getStatus()== Status.SP)
		{
			result.setReviewBy(user);
			result.setReviewDate(new Date());
		}else if(entity.getStatus()==Status.AP)
		{
			result.setApproveBy(user);
			result.setApproveDate(new Date());
			for(BorrowItem item : result.getItems())
			{
				item.getDocument().setDocumentStatus(DocumentStatus.B);
				item.getDocument().setUpdatedBy(result.getApproveBy().getUsername());
				item.getDocument().setUpdatedDate(result.getApproveDate());
				
				
			}
		}
		return result;
	}

	public Borrow submit(Borrow entity) throws Exception {
		entity.setStatus(Status.SP);
		return save(entity);
	}

}
