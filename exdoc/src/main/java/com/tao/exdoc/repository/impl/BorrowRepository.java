package com.tao.exdoc.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
			return new Result<Borrow>(factory,criteria,Borrow.class,"borrowCode","borrowDesc");
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
		Borrow data= findByKey(key);
		factory.getCurrentSession().delete(data);
		
	}

	public Borrow save(Borrow entity) throws Exception {
		Borrow data = findByKey(entity.getId());
		Borrow result = (Borrow) factory.getCurrentSession().merge(entity);
		return result;
	}

	public Result<Borrow> findByQuery(BorrowQuery query) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Borrow.class);
		
		criteria.setFetchMode("borrowBy",FetchMode.JOIN);
		criteria.setFetchMode("objective",FetchMode.JOIN);
		
		if(query.getBorrowCode()!=null && !query.getBorrowCode().equals(""))
		{
			if(query.getBorrowCode().contains("*")||query.getBorrowCode().contains("?"))
			{
				criteria.add(Restrictions.like("borrowCode",query.getBorrowCode().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("borrowCode",query.getBorrowCode()));
			}
		}
		
		if(query.getOrderBy()!=null && !query.getOrderBy().equals(""))
		{
			if(query.getOrderType().equals("desc"))
			{
				criteria.addOrder(Order.desc(query.getOrderBy()));
			}else
			{
				criteria.addOrder(Order.asc(query.getOrderBy()));
			}
		}else
		{
			criteria.addOrder(Order.desc("borrowCode"));
		}
		
	
		return new Result<Borrow>(factory,criteria,
				Borrow.class,
				"borrowCode",
				"borrowDesc",
				"borrowBy",
				"borrowDate",
				"objective"
				);
	}

}
