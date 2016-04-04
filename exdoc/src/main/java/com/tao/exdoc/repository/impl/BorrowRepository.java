package com.tao.exdoc.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.borrow.Borrow;
import com.tao.exdoc.domain.borrow.BorrowQuery;
import com.tao.exdoc.repository.IBorrowRepository;
@Repository
public class BorrowRepository implements IBorrowRepository{

	
	@Autowired
	private SessionFactory factory;
	
	public Result<Borrow> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Borrow findByKey(Integer key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Integer key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Borrow save(Borrow entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Result<Borrow> findByQuery(BorrowQuery query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
