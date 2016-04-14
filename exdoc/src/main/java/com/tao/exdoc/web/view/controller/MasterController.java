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
import com.tao.exdoc.domain.master.ContainerType;
import com.tao.exdoc.domain.master.Department;
import com.tao.exdoc.domain.master.DepositObjective;
import com.tao.exdoc.domain.master.DocumentGroup;
import com.tao.exdoc.domain.master.DocumentMode;
import com.tao.exdoc.domain.master.DocumentType;
import com.tao.exdoc.domain.master.Position;
import com.tao.exdoc.domain.security.Role;
import com.tao.exdoc.domain.security.User;
import com.tao.exdoc.repository.IRoleRepository;
import com.tao.exdoc.repository.IUserRepository;
import com.tao.exdoc.repository.MasterDataRepository;

@Controller
@RequestMapping("/master")
public class MasterController {

	@Autowired
	private MasterDataRepository masterDataRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	
	@Autowired
	private IRoleRepository roleRepository;

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
	@RequestMapping(value="/deposit/objective/getAll",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllDepositObjective()
	{
		Result<SimpleMasterObject> result = masterDataRepository.findAll(DepositObjective.class);
		return result.getFullResult();
	}
	
	@RequestMapping(value="/documentGroup/getAll",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllDocumentGroup()
	{
		Result<SimpleMasterObject> result = masterDataRepository.findAll(DocumentGroup.class);
		return result.getFullResult();
	}
	
	@RequestMapping(value="/documentMode/getAll",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllDocumentMode()
	{
		Result<SimpleMasterObject> result = masterDataRepository.findAll(DocumentMode.class);
		return result.getFullResult();
	}
	@RequestMapping(value="/documentType/getAll",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllDocumentType()
	{
		Result<SimpleMasterObject> result = masterDataRepository.findAll(DocumentType.class);
		return result.getFullResult();
	}
	
	@RequestMapping(value="/containerType/getAll",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllContainerType()	
	{
		Result<SimpleMasterObject> result = masterDataRepository.findAll(ContainerType.class);
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
		branch.setId(0);
		branch.setCode("B001");
		branch.setDescription("Bangkok");
		branch.setCreatedBy("SYSTEM");
		branch.setCreatedDate(new Date());
		branch.setUpdatedBy("SYSTEM");
		branch.setUpdatedDate(new Date());
		branches.add(branch);
		
		branch = new  Branch();
		branch.setId(0);
		branch.setCode("B002");
		branch.setDescription("Chiangmai");
		branch.setCreatedBy("SYSTEM");
		branch.setCreatedDate(new Date());
		branch.setUpdatedBy("SYSTEM");
		branch.setUpdatedDate(new Date());
		branches.add(branch);
		for(Branch item : branches)
		{
			masterDataRepository.save(Branch.class, item);
		}
		
		
		List<DocumentGroup> groups = new ArrayList<DocumentGroup>();
		DocumentGroup group = new DocumentGroup();
		group.setId(0);
		group.setCode("G001");
		group.setDescription("ลูกค้า");
		group.setCreatedBy("SYSTEM");
		group.setCreatedDate(new Date());
		group.setUpdatedBy("SYSTEM");
		group.setUpdatedDate(new Date());
		groups.add(group);
		
		group = new DocumentGroup();
		group.setId(0);
		group.setCode("G002");
		group.setDescription("ภายใน");
		group.setCreatedBy("SYSTEM");
		group.setCreatedDate(new Date());
		group.setUpdatedBy("SYSTEM");
		group.setUpdatedDate(new Date());
		groups.add(group);
		
		
		List<DocumentMode> modes = new ArrayList<DocumentMode>();
		
		DocumentMode mode = new DocumentMode();
		mode.setId(0);
		mode.setCode("M001");
		mode.setDescription("HPA");
		mode.setCreatedBy("SYSTEM");
		mode.setCreatedDate(new Date());
		mode.setUpdatedBy("SYSTEM");
		mode.setUpdatedDate(new Date());
		modes.add(mode);
		
		mode = new DocumentMode();
		mode.setId(0);
		mode.setCode("M002");
		mode.setDescription("PGA");
		mode.setCreatedBy("SYSTEM");
		mode.setCreatedDate(new Date());
		mode.setUpdatedBy("SYSTEM");
		mode.setUpdatedDate(new Date());
		modes.add(mode);
		
		mode = new DocumentMode();
		mode.setId(0);
		mode.setCode("M003");
		mode.setDescription("MBA");
		mode.setCreatedBy("SYSTEM");
		mode.setCreatedDate(new Date());
		mode.setUpdatedBy("SYSTEM");
		mode.setUpdatedDate(new Date());
		modes.add(mode);
		
		mode = new DocumentMode();
		mode.setId(0);
		mode.setCode("M004");
		mode.setDescription("POLICY");
		mode.setCreatedBy("SYSTEM");
		mode.setCreatedDate(new Date());
		mode.setUpdatedBy("SYSTEM");
		mode.setUpdatedDate(new Date());
		modes.add(mode);
		
		
		mode = new DocumentMode();
		mode.setId(0);
		mode.setCode("M005");
		mode.setDescription("Internal");
		mode.setCreatedBy("SYSTEM");
		mode.setCreatedDate(new Date());
		mode.setUpdatedBy("SYSTEM");
		mode.setUpdatedDate(new Date());
		modes.add(mode);
		
		
		List<DocumentType> types =new ArrayList<DocumentType>();
		DocumentType type = new DocumentType();
		type.setId(0);
		type.setCode("DT001");
		type.setDescription("ใบสำคัญจ่าย");
		type.setCreatedBy("SYSTEM");
		type.setCreatedDate(new Date());
		type.setUpdatedBy("SYSTEM");
		type.setUpdatedDate(new Date());
		types.add(type);
		
		type = new DocumentType();
		type.setId(0);
		type.setCode("DT002");
		type.setDescription("ใบสมัครงาน");
		type.setCreatedBy("SYSTEM");
		type.setCreatedDate(new Date());
		type.setUpdatedBy("SYSTEM");
		type.setUpdatedDate(new Date());
		types.add(type);
		
		type = new DocumentType();
		type.setId(0);
		type.setCode("DT003");
		type.setDescription("สำเนาบัตรประชาชน");
		type.setCreatedBy("SYSTEM");
		type.setCreatedDate(new Date());
		type.setUpdatedBy("SYSTEM");
		type.setUpdatedDate(new Date());
		types.add(type);

		
		type = new DocumentType();
		type.setId(0);
		type.setCode("DT004");
		type.setDescription("ใบแจ้งเงินเดือน");
		type.setCreatedBy("SYSTEM");
		type.setCreatedDate(new Date());
		type.setUpdatedBy("SYSTEM");
		type.setUpdatedDate(new Date());
		types.add(type);
		
		for(DocumentGroup item : groups)
		{
			masterDataRepository.save(DocumentGroup.class,item);
		}
		for(DocumentMode item : modes)
		{
			masterDataRepository.save(DocumentMode.class,item);
		}
		for(DocumentType item : types)
		{
			masterDataRepository.save(DocumentType.class,item);
			
		}
		
		List<BorrowObjective> borrows = new ArrayList<BorrowObjective>();
	    BorrowObjective borrow = new BorrowObjective();
	    borrow.setId(0);
	    borrow.setCode("BO0001");
	    borrow.setDescription("Objective 01");
	    borrow.setCreatedBy("SYSTEM");
	    borrow.setCreatedDate(new Date());
	    borrow.setUpdatedBy("SYSTEM");
	    borrow.setUpdatedDate(new Date());
	    
	    borrows.add(borrow);
	    
	    borrow = new BorrowObjective();
	    borrow.setId(0);
	    borrow.setCode("BO0002");
	    borrow.setDescription("Objective 02");
	    borrow.setCreatedBy("SYSTEM");
	    borrow.setCreatedDate(new Date());
	    borrow.setUpdatedBy("SYSTEM");
	    borrow.setUpdatedDate(new Date());
	    
	    borrows.add(borrow);
	    
	    
	    borrow = new BorrowObjective();
	    borrow.setId(0);
	    borrow.setCode("BO0003");
	    borrow.setDescription("Objective 03");
	    borrow.setCreatedBy("SYSTEM");
	    borrow.setCreatedDate(new Date());
	    borrow.setUpdatedBy("SYSTEM");
	    borrow.setUpdatedDate(new Date());
	    
	    borrows.add(borrow);
	    
	    
	    borrow = new BorrowObjective();
	    borrow.setId(0);
	    borrow.setCode("BO0004");
	    borrow.setDescription("Objective 04");
	    borrow.setCreatedBy("SYSTEM");
	    borrow.setCreatedDate(new Date());
	    borrow.setUpdatedBy("SYSTEM");
	    borrow.setUpdatedDate(new Date());
	    
	    borrows.add(borrow);
	    
	    
	    
	    borrow = new BorrowObjective();
	    borrow.setId(0);
	    borrow.setCode("BO0005");
	    borrow.setDescription("Objective 05");
	    borrow.setCreatedBy("SYSTEM");
	    borrow.setCreatedDate(new Date());
	    borrow.setUpdatedBy("SYSTEM");
	    borrow.setUpdatedDate(new Date());
	    
	    borrows.add(borrow);
	    
	    
	    
	    
	    List<Position> positions = new ArrayList<Position>();
	    
	    
	    Position position = new Position();
	    position.setId(0);
	    position.setCode("POS001");
	    position.setDescription("Accounting");
	    position.setCreatedBy("SYSTEM");
	    position.setCreatedDate(new Date());
	    position.setUpdatedBy("SYSTEM");
	    position.setUpdatedDate(new Date());
	    positions.add(position);
	    
	    position = new Position();
	    position.setId(0);
	    position.setCode("POS002");
	    position.setDescription("Programmer");
	    position.setCreatedBy("SYSTEM");
	    position.setCreatedDate(new Date());
	    position.setUpdatedBy("SYSTEM");
	    position.setUpdatedDate(new Date());
	    positions.add(position);
	    
	    
	    for(BorrowObjective item : borrows)
	    {
	    	masterDataRepository.save(BorrowObjective.class,item);
	    }
	    for(Position item : positions)
	    {
	    	masterDataRepository.save(Position.class,item);
	    }
	    
	    
	    
		List<DepositObjective> deposits = new ArrayList<DepositObjective>();
		DepositObjective deposit = new DepositObjective();
		deposit.setId(0);
		deposit.setCode("DEPO0001");
		deposit.setDescription("Objective 01");
		deposit.setCreatedBy("SYSTEM");
		deposit.setCreatedDate(new Date());
		deposit.setUpdatedBy("SYSTEM");
		deposit.setUpdatedDate(new Date());
	    
		deposits.add(deposit);
	    
	    deposit = new DepositObjective();
	    deposit.setId(0);
	    deposit.setCode("DEPO0002");
	    deposit.setDescription("Objective 02");
	    deposit.setCreatedBy("SYSTEM");
	    deposit.setCreatedDate(new Date());
	    deposit.setUpdatedBy("SYSTEM");
	    deposit.setUpdatedDate(new Date());
	    
	    deposits.add(deposit);
	    
	    
	    deposit = new DepositObjective();
	    deposit.setId(0);
	    deposit.setCode("DEPO0003");
	    deposit.setDescription("Objective 03");
	    deposit.setCreatedBy("SYSTEM");
	    deposit.setCreatedDate(new Date());
	    deposit.setUpdatedBy("SYSTEM");
	    deposit.setUpdatedDate(new Date());
	    
	    deposits.add(deposit);
	    
	    
	    deposit = new DepositObjective();
	    deposit.setId(0);
	    deposit.setCode("DEPO0004");
	    deposit.setDescription("Objective 04");
	    deposit.setCreatedBy("SYSTEM");
	    deposit.setCreatedDate(new Date());
	    deposit.setUpdatedBy("SYSTEM");
	    deposit.setUpdatedDate(new Date());
	    
	    deposits.add(deposit);
	    
	    
	    
	    deposit = new DepositObjective();
	    deposit.setId(0);
	    deposit.setCode("DEPO0005");
	    deposit.setDescription("Objective 05");
	    deposit.setCreatedBy("SYSTEM");
	    deposit.setCreatedDate(new Date());
	    deposit.setUpdatedBy("SYSTEM");
	    deposit.setUpdatedDate(new Date());
	    
	    deposits.add(deposit);
	    for(DepositObjective item:deposits)
	    {
	    	masterDataRepository.save(DepositObjective.class, item);
	    }
	    
	    List<User> users = new ArrayList<User>();
	    User user= new User();
	    user.setUsername("Admin");;
	    user.setPassword("1234");
	    user.setFirstName("Admin");
	    user.setLastName("Admin");
	    user.setEmail("ajarusiripot@gmail.com");
	    user.setCreatedBy("SYSTEM");;
	    user.setCreatedDate(new Date());
	    user.setUpdatedBy("SYSTEM");
	    user.setUpdatedDate(new Date());
	    users.add(user);
	    for(User item : users)
	    {
	    	userRepository.save(item);
	    }
	    
	    List<Role> roles = new ArrayList<Role>();
	    Role role = new Role();
	    role.setId(0);
	    role.setRoleCode("ROLE0001");
	    role.setRoleDesc("SuperAdmin");
	    role.setCreatedBy("SYSTEM");
	    role.setCreatedDate(new Date());
	    role.setUpdatedBy("SYSTEM");
	    role.setUpdatedDate(new Date());
	    roles.add(role);
	    
	    role = new Role();
	    role.setId(0);
	    role.setRoleCode("ROLE0002");
	    role.setRoleDesc("Admin");
	    role.setCreatedBy("SYSTEM");
	    role.setCreatedDate(new Date());
	    role.setUpdatedBy("SYSTEM");
	    role.setUpdatedDate(new Date());
	    roles.add(role);
	    
	    role = new Role();
	    role.setId(0);
	    role.setRoleCode("ROLE0003");
	    role.setRoleDesc("User");
	    role.setCreatedBy("SYSTEM");
	    role.setCreatedDate(new Date());
	    role.setUpdatedBy("SYSTEM");
	    role.setUpdatedDate(new Date());
	    roles.add(role);
	    
	    
	    role = new Role();
	    role.setId(0);
	    role.setRoleCode("ROLE0004");
	    role.setRoleDesc("Guest");
	    role.setCreatedBy("SYSTEM");
	    role.setCreatedDate(new Date());
	    role.setUpdatedBy("SYSTEM");
	    role.setUpdatedDate(new Date());
	    roles.add(role);
	    
	    
	    for(Role item : roles)
	    {
	    	roleRepository.save(item);
	    }
	    List<ContainerType> containerTypes = new ArrayList<ContainerType>();
	    ContainerType containerType = new ContainerType();
	    containerType.setId(0);
	    containerType.setCode("CT00001");
	    containerType.setDescription("ContainerType1");
	    containerType.setCreatedBy("SYSTEM");
	    containerType.setCreatedDate(new Date());
	    containerType.setUpdatedBy("SYSTEM");
	    containerType.setUpdatedDate(new Date());
	    containerTypes.add(containerType);
	    
	    containerType = new ContainerType();
	    containerType.setId(0);
	    containerType.setCode("CT00002");
	    containerType.setDescription("ContainerType2");
	    containerType.setCreatedBy("SYSTEM");
	    containerType.setCreatedDate(new Date());
	    containerType.setUpdatedBy("SYSTEM");
	    containerType.setUpdatedDate(new Date());
	    containerTypes.add(containerType);
	
	    
	    containerType = new ContainerType();
	    containerType.setId(0);
	    containerType.setCode("CT00003");
	    containerType.setDescription("ContainerType3");
	    containerType.setCreatedBy("SYSTEM");
	    containerType.setCreatedDate(new Date());
	    containerType.setUpdatedBy("SYSTEM");
	    containerType.setUpdatedDate(new Date());
	    containerTypes.add(containerType);
	    
	    containerType = new ContainerType();
	    containerType.setId(0);
	    containerType.setCode("CT00004");
	    containerType.setDescription("ContainerType4");
	    containerType.setCreatedBy("SYSTEM");
	    containerType.setCreatedDate(new Date());
	    containerType.setUpdatedBy("SYSTEM");
	    containerType.setUpdatedDate(new Date());
	    containerTypes.add(containerType);
	    
	    containerType = new ContainerType();
	    containerType.setId(0);
	    containerType.setCode("CT00005");
	    containerType.setDescription("ContainerType5");
	    containerType.setCreatedBy("SYSTEM");
	    containerType.setCreatedDate(new Date());
	    containerType.setUpdatedBy("SYSTEM");
	    containerType.setUpdatedDate(new Date());
	    containerTypes.add(containerType);
	    
	    for(ContainerType item : containerTypes)
	    {
	    	masterDataRepository.save(ContainerType.class, containerType);
	    }
		return "Complete";

	}

}
