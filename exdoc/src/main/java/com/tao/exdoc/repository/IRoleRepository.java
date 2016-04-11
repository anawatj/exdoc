package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.security.Role;
import com.tao.exdoc.domain.security.RoleQuery;

public interface IRoleRepository extends Repository<Role,Integer>{
		
	Result<Role> findAll() throws Exception;
	Role findByKey(Integer key) throws Exception;
	void remove(Integer key) throws Exception;
	Role save(Role entity) throws Exception;
	Result<Role> findByQuery(RoleQuery query) throws Exception;
}
