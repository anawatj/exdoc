package com.tao.exdoc.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.security.Role;
import com.tao.exdoc.domain.security.RoleQuery;
import com.tao.exdoc.repository.IRoleRepository;
@Repository
public class RoleRepository implements IRoleRepository{

	@Autowired
	private SessionFactory factory;
	
	public Result<Role> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Role findByKey(Integer key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Integer key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Role save(Role entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Result<Role> findByQuery(RoleQuery query) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Role.class);
		
		if(query.getRoleCode()!=null && !query.getRoleCode().equals(""))
		{
			if(query.getRoleCode().contains("*") || query.getRoleCode().contains("?"))
			{
				criteria.add(Restrictions.like("roleCode",query.getRoleCode().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("roleCode",query.getRoleCode()));
			}
		}
		if(query.getRoleDesc()!=null && !query.getRoleDesc().equals(""))
		{
			if(query.getRoleDesc().contains("*") || query.getRoleDesc().contains("?"))
			{
				criteria.add(Restrictions.like("roleDesc",query.getRoleDesc().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("roleDesc",query.getRoleDesc()));
			}
		}
		return new Result<Role>(factory,criteria);
	}

}
