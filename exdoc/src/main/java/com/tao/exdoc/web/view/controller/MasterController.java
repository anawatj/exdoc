package com.tao.exdoc.web.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.SimpleMasterObject;
import com.tao.exdoc.domain.master.Department;
import com.tao.exdoc.repository.MasterDataRepository;

@Controller
@RequestMapping("/master")
public class MasterController {
	
	
	@Autowired
	private MasterDataRepository masterDataRepository;
	
	@RequestMapping(value="/department/getAll",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllDepartment()
	{
		Result<SimpleMasterObject> result = masterDataRepository.findAll(Department.class);
		return result.getFullResult();
	}

}
