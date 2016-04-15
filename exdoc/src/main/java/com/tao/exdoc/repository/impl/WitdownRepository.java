package com.tao.exdoc.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.witdown.Witdown;
import com.tao.exdoc.domain.witdown.WitdownQuery;
import com.tao.exdoc.repository.IWitdownRepository;
@Repository
public class WitdownRepository implements IWitdownRepository {
	
	@Autowired
	private SessionFactory factory;

	public Result<Witdown> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Witdown findByKey(Integer key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Witdown save(Witdown entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Integer key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Result<Witdown> findByQuery(WitdownQuery query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
