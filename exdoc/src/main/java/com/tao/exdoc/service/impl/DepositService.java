package com.tao.exdoc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.exdoc.domain.deposit.Deposit;
import com.tao.exdoc.domain.deposit.DepositItem;
import com.tao.exdoc.domain.document.Document;
import com.tao.exdoc.domain.enumurate.DocumentStatus;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.domain.security.User;
import com.tao.exdoc.repository.IDepositRepository;
import com.tao.exdoc.repository.IDocumentRepository;
import com.tao.exdoc.repository.IUserRepository;
import com.tao.exdoc.service.IDepositService;
@Service
public class DepositService implements IDepositService{
	
	
	@Autowired
	private IDepositRepository depositRepository;
	
	
	@Autowired
	private IDocumentRepository documentRepository;
	
	
	@Autowired
	private IUserRepository userRepository;

	public Deposit approve(Deposit entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Deposit save(Deposit entity) throws Exception {
		Deposit result = depositRepository.save(entity);
		User user = userRepository.findUserByUserName(entity.getUpdatedBy());
		if(result.getStatus()== Status.SP)
		{
			
			result.setReviewBy(user);
			result.setReviewDate(new Date());
		}
		if(result.getStatus()== Status.AP)
		{
			
			result.setApproveBy(user);
			result.setApproveDate(new Date());
			for(DepositItem item : result.getItems())
			{
				Document document = new Document();
				document.setId(0);
				document.setDocumentBy(result.getDepositBy());
				document.setDocumentCode(item.getDocumentCode());
				document.setDocumentDesc(item.getDocumentDesc());
				document.setDocumentMode(result.getDocumentMode());
				document.setDocumentGroup(result.getDocumentGroup());
				document.setDocumentType(item.getDocumentType());
				document.setDocumentStatus(DocumentStatus.D);
				document.setBranch(result.getBranch());
				document.setDepartment(result.getDepartment());
				document.setContainer(item.getContainer());
				document.setCreatedBy(result.getApproveBy().getUsername());
				document.setCreatedDate(result.getApproveDate());
				document.setUpdatedBy(result.getApproveBy().getUsername());
				document.setUpdatedDate(result.getUpdatedDate());
				
				documentRepository.save(document);
				
				
			}
		}
		return result;
	}

	public Deposit submit(Deposit entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
