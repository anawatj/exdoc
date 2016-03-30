package com.tao.exdoc.service;

import com.tao.exdoc.domain.security.User;

public interface IUserService extends IService<User> {

		User approve(User entity) throws Exception;
		User save(User entity) throws Exception;
		User submit(User entity) throws Exception;
}
