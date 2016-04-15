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
import com.tao.exdoc.domain.borrow.BorrowItem;
import com.tao.exdoc.domain.witdown.Witdown;
import com.tao.exdoc.domain.witdown.WitdownItem;
import com.tao.exdoc.domain.witdown.WitdownQuery;
import com.tao.exdoc.repository.IWitdownRepository;
import com.tao.exdoc.service.IWitdownService;

@Controller
@RequestMapping("/witdown")
public class WitdownController {
	
	
	@Autowired
	private IWitdownRepository witdownRepository;
	
	
	@Autowired
	private IWitdownService witdownService;
	
	
	
	
	@RequestMapping(value="/getByKey",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Witdown getByKey(@RequestParam Integer key) throws Exception
	{
		Witdown result = witdownRepository.findByKey(key);
		return result;
		
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Witdown save(@RequestBody Witdown entity) throws Exception
	{
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(entity.getId()==0)
		{
			entity.setCreatedBy(userDetails.getUsername());
			entity.setCreatedDate(new Date());
			entity.setUpdatedBy(entity.getCreatedBy());
			entity.setUpdatedDate(entity.getCreatedDate());
			for(WitdownItem item : entity.getItems())
			{
				item.setCreatedBy(entity.getCreatedBy());
				item.setCreatedDate(entity.getCreatedDate());
			}
			
			
		}else
		{
			entity.setUpdatedBy(userDetails.getUsername());
			entity.setUpdatedDate(new Date());
			for(WitdownItem item : entity.getItems())
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
		Witdown result = witdownService.save(entity);
		return result;
		
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Witdown> search(@RequestBody WitdownQuery query) throws Exception
	{
		Result<Witdown> result = witdownRepository.findByQuery(query);
		return result.getPage(query.getPage());
		
	}

}
