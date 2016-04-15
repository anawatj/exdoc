package com.tao.exdoc.domain.witdown;

import java.util.Date;

import com.tao.exdoc.domain.AbstractQuery;

public class WitdownQuery extends AbstractQuery{

	
	public WitdownQuery()
	{
		
	}
	private String witdownCode;
	private String witdownDesc;
	private Date witdownDateStart;
	private Date witdownDateEnd;
	private Integer witdownBy;
	private String username;
	private Integer department;
	private Integer branch;
	private Integer position;
	public String getWitdownCode() {
		return witdownCode;
	}
	public void setWitdownCode(String witdownCode) {
		this.witdownCode = witdownCode;
	}
	public String getWitdownDesc() {
		return witdownDesc;
	}
	public void setWitdownDesc(String witdownDesc) {
		this.witdownDesc = witdownDesc;
	}
	public Date getWitdownDateStart() {
		return witdownDateStart;
	}
	public void setWitdownDateStart(Date witdownDateStart) {
		this.witdownDateStart = witdownDateStart;
	}
	public Date getWitdownDateEnd() {
		return witdownDateEnd;
	}
	public void setWitdownDateEnd(Date witdownDateEnd) {
		this.witdownDateEnd = witdownDateEnd;
	}
	public Integer getWitdownBy() {
		return witdownBy;
	}
	public void setWitdownBy(Integer witdownBy) {
		this.witdownBy = witdownBy;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	public Integer getBranch() {
		return branch;
	}
	public void setBranch(Integer branch) {
		this.branch = branch;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
}
