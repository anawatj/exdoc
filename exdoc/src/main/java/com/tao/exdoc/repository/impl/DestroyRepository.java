package com.tao.exdoc.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.destroy.Destroy;
import com.tao.exdoc.domain.destroy.DestroyQuery;
import com.tao.exdoc.repository.IDestroyRepository;
@Repository
public class DestroyRepository implements IDestroyRepository{
	
	
	@Autowired
	private SessionFactory factory;

	public Result<Destroy> findAll() throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Destroy.class);
		return new Result<Destroy>(factory,criteria,
				Projections.property("destroyCode"),
				Projections.property("destroyDesc"));
	}

	public Destroy findByKey(Integer key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Integer key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Destroy save(Destroy entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Result<Destroy> findByQuery(DestroyQuery query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
