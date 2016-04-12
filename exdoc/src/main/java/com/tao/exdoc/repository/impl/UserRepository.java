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
		// TODO Auto-generated method stub
		return null;
	}

}
