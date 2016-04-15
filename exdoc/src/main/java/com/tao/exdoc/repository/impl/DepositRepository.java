package com.tao.exdoc.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.deposit.Deposit;
import com.tao.exdoc.domain.deposit.DepositQuery;
import com.tao.exdoc.repository.IDepositRepository;
@Repository
public class DepositRepository implements IDepositRepository{
	
	
	@Autowired
	private SessionFactory factory;

	public DepositRepository() {
		// TODO Auto-generated constructor stub
	}

	public Result<Deposit> findAll() throws Exception {
			Criteria criteria = factory.getCurrentSession().createCriteria(Deposit.class);
			
			return new Result<Deposit>(factory,criteria,
					Deposit.class,
					"depositCode",
					"depositDesc");
	}

	public Deposit findByKey(Integer key) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Deposit.class);
		criteria.setFetchMode("department", FetchMode.JOIN);
		criteria.setFetchMode("branch",FetchMode.JOIN);
		criteria.setFetchMode("position", FetchMode.JOIN);
		criteria.setFetchMode("objective",FetchMode.JOIN);
		criteria.setFetchMode("documentGroup", FetchMode.JOIN);
		criteria.setFetchMode("documentMode", FetchMode.JOIN);
		criteria.setFetchMode("depositBy", FetchMode.JOIN);
		criteria.setFetchMode("reviewBy", FetchMode.JOIN);
		criteria.setFetchMode("approveBy",FetchMode.JOIN);
		criteria.setFetchMode("items", FetchMode.JOIN);
		criteria.setFetchMode("items.documentType",FetchMode.JOIN);
		criteria.setFetchMode("items.container", FetchMode.JOIN);
		criteria.setFetchMode("items.document", FetchMode.JOIN);
		
		criteria.add(Restrictions.eq("id", key));
		
		List<Deposit> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

	public void remove(Integer key) throws Exception {
		Deposit data = findByKey(key);
		factory.getCurrentSession().delete(data);
		
	}

	public Deposit save(Deposit entity) throws Exception {
			Deposit data = findByKey(entity.getId());
			Deposit result = (Deposit) factory.getCurrentSession().merge(entity);
			return result;
			
	}

	public Result<Deposit> findByQuery(DepositQuery query) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Deposit.class);
		criteria.setFetchMode("depositBy", FetchMode.JOIN);
		criteria.setFetchMode("department", FetchMode.JOIN);
		criteria.setFetchMode("branch", FetchMode.JOIN);
		
		
		return new Result<Deposit>(factory,criteria,Deposit.class,
				"id",
				"depositCode",
				"depositDesc",
				"depositDate",
				"depositBy",
				"department",
				"branch");
	}

}
