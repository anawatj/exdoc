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
		System.out.println(Config.PAGE_SIZE);
		Criteria criteria = factory.getCurrentSession().createCriteria(clazz);
		return new Result<SimpleMasterObject>(factory,criteria,Projections.property("code"),
				Projections.property("description"));
	}
}
