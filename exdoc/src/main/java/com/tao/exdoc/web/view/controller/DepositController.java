package com.tao.exdoc.web.view.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.tao.exdoc.domain.deposit.DepositItem;
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
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(entity.getId()==0)
		{
			entity.setCreatedBy(userDetails.getUsername());
			entity.setCreatedDate(new Date());
			entity.setUpdatedBy(entity.getCreatedBy());
			entity.setUpdatedDate(entity.getCreatedDate());
			for(DepositItem item : entity.getItems())
			{
				item.setCreatedBy(entity.getCreatedBy());
				item.setCreatedDate(entity.getCreatedDate());
				item.setUpdatedBy(entity.getCreatedBy());
				item.setUpdatedDate(entity.getCreatedDate());
			}
		}else
		{
			entity.setUpdatedBy(userDetails.getUsername());
			entity.setUpdatedDate(new Date());
			for(DepositItem item : entity.getItems())
			{
				if(item.getId()==0)
				{
					item.setCreatedBy(entity.getUpdatedBy());
					item.setCreatedDate(entity.getUpdatedDate());
				}
				item.setUpdatedBy(entity.getUpdatedBy());
				item.setUpdatedDate(entity.getUpdatedDate());
			}
		}
		Deposit result = depositService.save(entity);
		return result;
	}
	

}
