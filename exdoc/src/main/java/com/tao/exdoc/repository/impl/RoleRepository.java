package com.tao.exdoc.repository.impl;

import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.security.Role;
import com.tao.exdoc.repository.IRoleRepository;
@Repository
public class RoleRepository implements IRoleRepository{

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

}
