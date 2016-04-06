package com.tao.exdoc.web.view.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	@RequestMapping(value="/batch",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody String batch() throws Exception
	{
		List<Department> departments = new ArrayList<Department>();
		for(int index=1;index<=5;index++)
		{
			Department department = new Department();
			department.setId(0);
			department.setCode("DEP001");
			department.setDescription("½èÒÂäÍ·Õ");
			department.setCreatedBy("SYSTEM");
			department.setCreatedDate(new Date());
			department.setUpdatedBy("SYSTEM");
			department.setUpdatedDate(new Date());
			departments.add(department);
			
		}
		for(Department department : departments)
		{
			masterDataRepository.save(Department.class, department);
		}
		
		return "Complete";
		
	}

}
