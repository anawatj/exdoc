package com.tao.exdoc.domain.destroy;

import java.util.Date;

import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.AbstractQuery;

public class DestroyQuery extends AbstractQuery{

	private String destroyCode;
	private String destroyDesc;
	private Date destroyDateStart;
	private Date destroyDateEnd;
	private Integer destroyBy;
	private Integer branch;
	private Integer department;
	private Integer position;
	public String getDestroyCode() {
		return destroyCode;
	}
	public void setDestroyCode(String destroyCode) {
		this.destroyCode = destroyCode;
	}
	public String getDestroyDesc() {
		return destroyDesc;
	}
	public void setDestroyDesc(String destroyDesc) {
		this.destroyDesc = destroyDesc;
	}
	public Date getDestroyDateStart() {
		return destroyDateStart;
	}
	public void setDestroyDateStart(Date destroyDateStart) {
		this.destroyDateStart = destroyDateStart;
	}
	public Date getDestroyDateEnd() {
		return destroyDateEnd;
	}
	public void setDestroyDateEnd(Date destroyDateEnd) {
		this.destroyDateEnd = destroyDateEnd;
	}
	public Integer getDestroyBy() {
		return destroyBy;
	}
	public void setDestroyBy(Integer destroyBy) {
		this.destroyBy = destroyBy;
	}
	public Integer getBranch() {
		return branch;
	}
	public void setBranch(Integer branch) {
		this.branch = branch;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
}
