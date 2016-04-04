package com.tao.exdoc.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
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
			Criteria criteria = factory.getCurrentSession().createCriteria(Borrow.class);
			return new Result<Borrow>(factory,criteria);
	}

	public Borrow findByKey(Integer key) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Borrow.class);
		criteria.add(Restrictions.eq("id",key));
		criteria.setFetchMode("borrowBy", FetchMode.JOIN);
		criteria.setFetchMode("reviewBy", FetchMode.JOIN);
		criteria.setFetchMode("approveBy",FetchMode.JOIN);
		criteria.setFetchMode("objective",FetchMode.JOIN);
		criteria.setFetchMode("branch",FetchMode.JOIN);
		criteria.setFetchMode("department",FetchMode.JOIN);
		criteria.setFetchMode("position", FetchMode.JOIN);
		criteria.setFetchMode("items", FetchMode.JOIN);
		
		List<Borrow> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
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
