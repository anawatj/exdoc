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
import com.tao.exdoc.domain.borrow.Borrow;
import com.tao.exdoc.domain.borrow.BorrowQuery;
import com.tao.exdoc.repository.IBorrowRepository;
import com.tao.exdoc.service.IBorrowService;

@Controller
@RequestMapping("/borrow")
public class BorrowController {
	
	
	@Autowired
	private IBorrowService borrowService;
	
	@Autowired
	private IBorrowRepository borrowRepository;
	
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Transactional
	public Result<Borrow> getAll() throws Exception
	{
		Result<Borrow> result =borrowRepository.findAll();
		return result.getFullResult();
	}
	
	
	@RequestMapping(value="/getByKey",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Borrow getByKey(@RequestParam Integer key) throws Exception
	{
		Borrow result =borrowRepository.findByKey(key);
		return result;
		
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Borrow> search(@RequestBody BorrowQuery query) throws Exception
	{
		Result<Borrow> result = borrowRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Borrow save(@RequestBody Borrow entity) throws Exception
	{
		Borrow result = borrowService.save(entity);
		return result;
		
	}

}
