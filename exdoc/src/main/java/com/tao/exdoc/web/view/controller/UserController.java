package com.tao.exdoc.web.view.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.exdoc.domain.Page;
import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.security.User;
import com.tao.exdoc.domain.security.UserQuery;
import com.tao.exdoc.repository.IUserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserRepository userRepository;
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<User> getAll() throws Exception
	{
		Result<User> result = userRepository.findAll();
		return result.getFullResult();
	}
	
	@RequestMapping(value="/getByKey",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody User getByKey(@RequestParam Integer key) throws Exception
	{
		User result = userRepository.findByKey(key);
		return result;
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody User save(@RequestBody User entity) throws Exception
	{
		User result = userRepository.save(entity);
		return result;
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<User> search(@RequestBody UserQuery query) throws Exception
	{
		Result<User> result = userRepository.findByQuery(query);
		return result.getPage(query.getPage());
		
	}
	


}
