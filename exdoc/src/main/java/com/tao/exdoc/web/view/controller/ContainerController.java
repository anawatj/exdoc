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
import com.tao.exdoc.domain.container.Container;
import com.tao.exdoc.domain.container.ContainerQuery;
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
