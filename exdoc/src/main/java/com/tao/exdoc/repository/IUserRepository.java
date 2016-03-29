package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.security.User;

public interface IUserRepository extends Repository<User,Integer>{

	Result<User> findAll() throws Exception;
	User findByKey(Integer key) throws Exception;
	void remove(Integer key) throws Exception;
	User save(User entity) throws Exception;
}
