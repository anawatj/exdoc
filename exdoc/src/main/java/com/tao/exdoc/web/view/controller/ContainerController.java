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
import com.tao.exdoc.domain.container.Container;
import com.tao.exdoc.domain.container.ContainerQuery;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.repository.IContainerRepository;

@Controller
@RequestMapping("/container")
public class ContainerController {

	
		@Autowired
		private IContainerRepository containerRepository;
		
		
		@RequestMapping(value="/getAll",method=RequestMethod.GET)
		@Transactional
		public @ResponseBody Result<Container> getAll() throws Exception
		{
			Result<Container> result = containerRepository.findAll();
			return result.getFullResult();
		}
		
		@RequestMapping(value="/getByKey",method=RequestMethod.GET)
		@Transactional
		public @ResponseBody Container getByKey(@RequestParam Integer key) throws Exception
		{
			Container result = containerRepository.findByKey(key);
			return result;
		}
		
		@RequestMapping(value="/save",method=RequestMethod.POST)
		@Transactional
		public @ResponseBody Container save(@RequestBody Container entity) throws Exception
		{
			   UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			   if(entity.getId()==0)
			   {
				   entity.setCreatedBy(userDetails.getUsername());
				   entity.setCreatedDate(new Date());
				   entity.setUpdatedBy(entity.getCreatedBy());
				   entity.setUpdatedDate(entity.getCreatedDate());
				   for(Container item : entity.getItems())
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
				   for(Container item : entity.getItems())
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
			  
			Container result = containerRepository.save(entity);
			return result;
			
		}
		@RequestMapping(value="/search",method=RequestMethod.POST)
		@Transactional
		public @ResponseBody Page<Container> search(@RequestBody ContainerQuery query)  throws Exception
		{
			Result<Container> result = containerRepository.findByQuery(query);
			return result.getPage(query.getPage());
		}
}
