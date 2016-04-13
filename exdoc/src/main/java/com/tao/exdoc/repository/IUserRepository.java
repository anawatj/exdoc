package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.security.User;
import com.tao.exdoc.domain.security.UserQuery;

public interface IUserRepository extends Repository<User,Integer>{

	Result<User> findAll() throws Exception;
	User findByKey(Integer key) throws Exception;
	void remove(Integer key) throws Exception;
	User save(User entity) throws Exception;
	
	Result<User> findByQuery(UserQuery query) throws Exception;
	
	User findUserByUserName(String username);
}
