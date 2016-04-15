package com.tao.exdoc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.exdoc.domain.enumurate.DocumentStatus;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.domain.security.User;
import com.tao.exdoc.domain.witdown.Witdown;
import com.tao.exdoc.domain.witdown.WitdownItem;
import com.tao.exdoc.repository.IDocumentRepository;
import com.tao.exdoc.repository.IUserRepository;
import com.tao.exdoc.repository.IWitdownRepository;
import com.tao.exdoc.service.IWitdownService;
@Service
public class WitdownService implements IWitdownService {
	
	
	@Autowired
	private IWitdownRepository witdownRepository;
	
	
	@Autowired
	private IDocumentRepository documentRepository;
	
	@Autowired
	private IUserRepository userRepository;

	public Witdown approve(Witdown entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Witdown save(Witdown entity) throws Exception {
			Witdown result = witdownRepository.save(entity);
			User user = userRepository.findUserByUserName(entity.getUpdatedBy());
			if(result.getStatus()==Status.SP)
			{
				result.setReviewBy(user);
				result.setReviewDate(new Date());
			}
			if(result.getStatus()==Status.AP)
			{
				result.setApproveBy(user);
				result.setApproveDate(new Date());
				
				
				for(WitdownItem item : result.getItems())
				{
					item.getDocument().setDocumentStatus(DocumentStatus.W);
					item.getDocument().setUpdatedBy(result.getApproveBy().getUsername());
					item.getDocument().setUpdatedDate(result.getApproveDate());
				}
			}
			return result;
	}

	public Witdown submit(Witdown entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
