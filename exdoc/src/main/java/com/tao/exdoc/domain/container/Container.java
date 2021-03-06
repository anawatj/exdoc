package com.tao.exdoc.domain.container;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.domain.master.Branch;
import com.tao.exdoc.domain.master.ContainerType;
import com.tao.exdoc.domain.master.Department;
import com.tao.exdoc.domain.master.Position;
import com.tao.exdoc.domain.security.User;
@JsonInclude(Include.NON_NULL)
public class Container extends AbstractDomain<Integer> {

	public Container()
	{
		this.items = new HashSet<Container>();
	}
	private String containerCode;
	private String containerDesc;
	private ContainerType containerType;
	private User containerBy;
	private Date containerDate;
	private Status status;
	private String remark;
	private Set<Container> items;
	private Branch branch;
	private Department department;
	private Integer parentId;
	private Integer level;
	
	private Integer maxDoc;
	private Integer numDoc;
	
	private boolean selected;
	

	
	public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Integer getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(Integer numDoc) {
		this.numDoc = numDoc;
	}
	public Integer getMaxDoc() {
		return maxDoc;
	}
	public void setMaxDoc(Integer maxDoc) {
		this.maxDoc = maxDoc;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Branch getBranch() {
		if(branch!=null)
		{
			if(branch.getId()==null || branch.getId()==0)
			{
				return null;
			}
		}
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Department getDepartment() {
		if(department!=null)
		{
			if(department.getId()==null || department.getId()==0)
			{
				return null;
			}
		}
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public String getContainerCode() {
		return containerCode;
	}
	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}
	public String getContainerDesc() {
		return containerDesc;
	}
	public void setContainerDesc(String containerDesc) {
		this.containerDesc = containerDesc;
	}
	public ContainerType getContainerType() {
		if(containerType!=null)
		{
			if(containerType.getId()==null || containerType.getId()==0)
			{
				return null;
			}
		}
		return containerType;
	}
	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}
	

	public User getContainerBy() {
		if(containerBy!=null)
		{
			if(containerBy.getId()==null || containerBy.getId()==0)
			{
				return null;
			}
		}
		return containerBy;
	}
	public void setContainerBy(User containerBy) {
		this.containerBy = containerBy;
	}
	public Date getContainerDate() {
		return containerDate;
	}
	public void setContainerDate(Date containerDate) {
		this.containerDate = containerDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<Container> getItems() {
		return items;
	}
	public void setItems(Set<Container> items) {
		this.items = items;
	}
	
}
