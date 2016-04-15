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
import com.tao.exdoc.domain.witdown.Witdown;
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
