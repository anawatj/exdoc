package com.tao.exdoc.web.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.exdoc.domain.Page;
import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.security.Role;
import com.tao.exdoc.domain.security.RoleQuery;
import com.tao.exdoc.repository.IRoleRepository;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private IRoleRepository roleRepository;
	
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Role> search(@RequestBody RoleQuery query) throws Exception
	{
		Result<Role> result = roleRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
	

}
