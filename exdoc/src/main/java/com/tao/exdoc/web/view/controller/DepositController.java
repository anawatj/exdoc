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
import com.tao.exdoc.domain.deposit.Deposit;
import com.tao.exdoc.domain.deposit.DepositQuery;
import com.tao.exdoc.repository.IDepositRepository;
import com.tao.exdoc.repository.IDestroyRepository;
import com.tao.exdoc.service.IDepositService;

@Controller
@RequestMapping("/deposit")
public class DepositController {
	
	@Autowired
	private IDepositRepository depositRepository;
	
	@Autowired
	private IDepositService depositService;
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Deposit> getAll() throws Exception
	{
		Result<Deposit> result = depositRepository.findAll();
		return result.getFullResult();
	}
	
	@RequestMapping(value="/getByKey",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Deposit getByKey(@RequestParam Integer key) throws Exception
	{
		Deposit result = depositRepository.findByKey(key);
		return result;
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Deposit> search(@RequestBody DepositQuery query) throws Exception
	{
		Result<Deposit> result = depositRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Deposit save(@RequestBody Deposit entity) throws Exception
	{
		Deposit result = depositService.save(entity);
		return result;
	}
	

}
