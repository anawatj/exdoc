package com.tao.exdoc.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.Config;
import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.SimpleMasterObject;

@Repository
public class MasterDataRepository {

	
	@Autowired
	private SessionFactory factory;
	
	public Result<SimpleMasterObject> findAll(Class clazz)
	{
		Criteria criteria = factory.getCurrentSession().createCriteria(clazz);
		return new Result<SimpleMasterObject>(factory,
				criteria,
				clazz,
				"id",
				"code",
				"description");
	}
	public SimpleMasterObject save(Class clazz,SimpleMasterObject entity)
	{
		
		SimpleMasterObject data =(SimpleMasterObject) factory.getCurrentSession().get(clazz,entity.getId());
		SimpleMasterObject result = (SimpleMasterObject) factory.getCurrentSession().merge(entity);
		return result;

		
		
	}
}
