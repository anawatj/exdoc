package com.tao.exdoc.repository.impl;

import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.security.User;
import com.tao.exdoc.repository.IUserRepository;
@Repository
public class UserRepository implements IUserRepository {

	public Result<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByKey(Integer key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Integer key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public User save(User entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
