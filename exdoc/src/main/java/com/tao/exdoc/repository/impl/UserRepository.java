package com.tao.exdoc.repository.impl;



import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.security.User;
import com.tao.exdoc.domain.security.UserQuery;
import com.tao.exdoc.repository.IUserRepository;
import java.util.*;
@Repository
public class UserRepository implements IUserRepository {

	@Autowired
	private SessionFactory factory;
	
	public Result<User> findAll() throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(User.class);
		
		return new Result<User>(factory,criteria);
	}

	public User findByKey(Integer key) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(User.class);
		criteria.setFetchMode("roles",FetchMode.JOIN);
		criteria.add(Restrictions.eq("id",key));
		
		List<User> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
		
	}

	public void remove(Integer key) throws Exception {
		User data = findByKey(key);
		factory.getCurrentSession().delete(data);
		
	}

	public User save(User entity) throws Exception {
		User data = findByKey(entity.getId());
		User result = (User) factory.getCurrentSession().merge(entity);
		return result;
	}

	public Result<User> findByQuery(UserQuery query) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(User.class);
		if(query.getUsername()!=null && !query.getUsername().equals(""))
		{
			if(query.getUsername().contains("*")|| query.getUsername().contains("?"))
			{
				criteria.add(Restrictions.like("username",query.getUsername().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("username",query.getUsername()));
			}
		}
		if(query.getFirstName()!=null && !query.getFirstName().equals(""))
		{
			if(query.getFirstName().contains("*") || query.getFirstName().contains("?"))
			{
				criteria.add(Restrictions.like("firstName", query.getFirstName().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("firstName",query.getFirstName()));
			}
		}
		if(query.getLastName()!=null && !query.getLastName().equals(""))
		{
			if(query.getLastName().contains("*") || query.getLastName().contains("?"))
			{
				criteria.add(Restrictions.like("lastName",query.getLastName().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("lastName",query.getLastName()));
			}
		}
		return new Result<User>(factory,criteria,User.class,"id","username","firstName","lastName");
	}

	public User findUserByUserName(String username) {
		Criteria criteria = factory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username",username));
		List<User> result = criteria.list();
		if(result!=null || result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

}
