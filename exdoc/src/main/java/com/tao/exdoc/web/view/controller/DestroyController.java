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
import com.tao.exdoc.domain.destroy.Destroy;
import com.tao.exdoc.domain.destroy.DestroyQuery;
import com.tao.exdoc.repository.IDestroyRepository;
import com.tao.exdoc.service.IDestroyService;

@Controller
@RequestMapping("/destroy")
public class DestroyController {
	
	
	
	@Autowired
	private IDestroyRepository destroyRepository;
	
	@Autowired
	private IDestroyService destroyService;
	
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Destroy> getAll() throws Exception
	{
		Result<Destroy> result = destroyRepository.findAll();
		return result.getFullResult();
	}
	
	@RequestMapping(value="/getByKey",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Destroy getByKey(@RequestParam Integer key) throws Exception
	{
		Destroy result = destroyRepository.findByKey(key);
		return result;
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Destroy> search(@RequestBody DestroyQuery query) throws Exception
	{
		Result<Destroy> result = destroyRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Destroy save(@RequestBody Destroy entity) throws Exception
	{
		Destroy result = destroyService.save(entity);
		return result;
	}

}
