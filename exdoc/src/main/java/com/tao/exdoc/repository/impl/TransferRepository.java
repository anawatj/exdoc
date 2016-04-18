package com.tao.exdoc.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.transfer.Transfer;
import com.tao.exdoc.domain.transfer.TransferQuery;
import com.tao.exdoc.repository.ITransferRepository;
@Repository
public class TransferRepository implements ITransferRepository{

	@Autowired
	private SessionFactory factory;
	
	public Result<Transfer> findAll() throws Exception {
			Criteria criteria = factory.getCurrentSession().createCriteria(Transfer.class);
			return new Result<Transfer>(factory,criteria,Transfer.class,"transferCode","transferDesc");
	}

	public Transfer findByKey(Integer key) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Transfer.class);
		criteria.setFetchMode("transferBy",FetchMode.JOIN);
		criteria.setFetchMode("reviewBy",FetchMode.JOIN);
		criteria.setFetchMode("approveBy",FetchMode.JOIN);
		criteria.setFetchMode("objective",FetchMode.JOIN);
		criteria.setFetchMode("branch", FetchMode.JOIN);
		criteria.setFetchMode("department",FetchMode.JOIN);
		criteria.setFetchMode("position",FetchMode.JOIN);
		criteria.setFetchMode("items", FetchMode.JOIN);
		criteria.setFetchMode("items.document",FetchMode.JOIN);
		criteria.setFetchMode("items.containerTo", FetchMode.JOIN);
		
		criteria.add(Restrictions.eq("id", key));
		
		List<Transfer> result =criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
		
		
		
	}

	public void remove(Integer key) throws Exception {
		Transfer data = findByKey(key);
		factory.getCurrentSession().delete(data);
		
	}

	public Transfer save(Transfer entity) throws Exception {
		Transfer data = findByKey(entity.getId());
		Transfer result = (Transfer) factory.getCurrentSession().merge(entity);
		return result;
	}

	public Result<Transfer> findByQuery(TransferQuery query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
