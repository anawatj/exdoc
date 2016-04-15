package com.tao.exdoc.domain.container;

import java.util.Date;

import com.tao.exdoc.domain.AbstractQuery;

public class ContainerQuery extends AbstractQuery
{
		
	
	private String containerCode;
	private String containerDesc;
	private Integer containerType;
	private Integer department;
	private Integer level;
	private Date containerDateStart;
	private Date containerDateEnd;
	private Integer branch;
	private String containerBy;

	public String getContainerBy() {
		return containerBy;
	}
	public void setContainerBy(String containerBy) {
		this.containerBy = containerBy;
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
	public Integer getContainerType() {
		return containerType;
	}
	public void setContainerType(Integer containerType) {
		this.containerType = containerType;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Date getContainerDateStart() {
		return containerDateStart;
	}
	public void setContainerDateStart(Date containerDateStart) {
		this.containerDateStart = containerDateStart;
	}
	public Date getContainerDateEnd() {
		return containerDateEnd;
	}
	public void setContainerDateEnd(Date containerDateEnd) {
		this.containerDateEnd = containerDateEnd;
	}
	public Integer getBranch() {
		return branch;
	}
	public void setBranch(Integer branch) {
		this.branch = branch;
	}


}
