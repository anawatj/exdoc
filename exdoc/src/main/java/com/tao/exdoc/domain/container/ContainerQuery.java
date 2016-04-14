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
	private Integer containerById;
	private String containerByCode;
	private String containerByDesc;
	public Integer getContainerById() {
		return containerById;
	}
	public void setContainerById(Integer containerById) {
		this.containerById = containerById;
	}
	public String getContainerByCode() {
		return containerByCode;
	}
	public void setContainerByCode(String containerByCode) {
		this.containerByCode = containerByCode;
	}
	public String getContainerByDesc() {
		return containerByDesc;
	}
	public void setContainerByDesc(String containerByDesc) {
		this.containerByDesc = containerByDesc;
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
