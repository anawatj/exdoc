package com.tao.exdoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.exdoc.domain.destroy.Destroy;
import com.tao.exdoc.repository.IDestroyRepository;
import com.tao.exdoc.service.IDestroyService;
@Service
public class DestroyService implements IDestroyService {
	
	
	@Autowired
	private IDestroyRepository destroyRepository;

	public Destroy approve(Destroy entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Destroy save(Destroy entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Destroy submit(Destroy entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
