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
import com.tao.exdoc.domain.master.BorrowObjective;
import com.tao.exdoc.domain.master.Branch;
import com.tao.exdoc.domain.master.Department;
import com.tao.exdoc.domain.master.Position;
import com.tao.exdoc.repository.MasterDataRepository;

@Controller
@RequestMapping("/master")
public class MasterController {

	@Autowired
	private MasterDataRepository masterDataRepository;

	@RequestMapping(value = "/department/getAll", method = RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllDepartment() {
		Result<SimpleMasterObject> result = masterDataRepository.findAll(Department.class);
		return result.getFullResult();
	}
	
	@RequestMapping(value="/position/getAll",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllPosition()
	{
		Result<SimpleMasterObject> result = masterDataRepository.findAll(Position.class);
		return result.getFullResult();
	}
	@RequestMapping(value="/branch/getAll",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllBranch()
	{
		Result<SimpleMasterObject> result = masterDataRepository.findAll(Branch.class);
		return result.getFullResult();
	}
	@RequestMapping(value="/borrow/objective/getAll",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllBorrowObjective()
	{
		Result<SimpleMasterObject> result=  masterDataRepository.findAll(BorrowObjective.class);
		return result.getFullResult();
	}
	
	

	@RequestMapping(value = "/batch", method = RequestMethod.GET)
	@Transactional
	public @ResponseBody String batch() throws Exception {
		List<Department> departments = new ArrayList<Department>();

		Department department = new Department();
		department.setId(0);
		department.setCode("DEP001");
		department.setDescription("Accounting");
		department.setCreatedBy("SYSTEM");
		department.setCreatedDate(new Date());
		department.setUpdatedBy("SYSTEM");
		department.setUpdatedDate(new Date());
		departments.add(department);

		department = new Department();
		department.setId(0);
		department.setCode("DEP002");
		department.setDescription("Stock");
		department.setCreatedBy("SYSTEM");
		department.setCreatedDate(new Date());
		department.setUpdatedBy("SYSTEM");
		department.setUpdatedDate(new Date());
		departments.add(department);

		department = new Department();
		department.setId(0);
		department.setCode("DEP003");
		department.setDescription("Market");
		department.setCreatedBy("SYSTEM");
		department.setCreatedDate(new Date());
		department.setUpdatedBy("SYSTEM");
		department.setUpdatedDate(new Date());
		departments.add(department);

		department = new Department();
		department.setId(0);
		department.setCode("DEP004");
		department.setDescription("Credit");
		department.setCreatedBy("SYSTEM");
		department.setCreatedDate(new Date());
		department.setUpdatedBy("SYSTEM");
		department.setUpdatedDate(new Date());
		departments.add(department);

		department = new Department();
		department.setId(0);
		department.setCode("DEP005");
		department.setDescription("IT");
		department.setCreatedBy("SYSTEM");
		department.setCreatedDate(new Date());
		department.setUpdatedBy("SYSTEM");
		department.setUpdatedDate(new Date());
		departments.add(department);

		for (Department item : departments) {
			masterDataRepository.save(Department.class, item);
		}
		
		List<Branch> branches = new ArrayList<Branch>();
	
		Branch branch = new  Branch();
		branch.setCode("B001");
		branch.setDescription("Bangkok");
		branch.setCreatedBy("SYSTEM");
		branch.setCreatedDate(new Date());
		branch.setUpdatedBy("SYSTEM");
		branch.setUpdatedDate(new Date());
		branches.add(branch);
		
		for(Branch item : branches)
		{
			masterDataRepository.save(Branch.class, item);
		}

		return "Complete";

	}

}
