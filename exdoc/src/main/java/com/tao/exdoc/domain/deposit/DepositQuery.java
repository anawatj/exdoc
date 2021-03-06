package com.tao.exdoc.domain.deposit;

import java.util.Date;

import com.tao.exdoc.domain.AbstractQuery;

public class DepositQuery extends AbstractQuery {

	
	public DepositQuery()
	{
		
	}
	private String depositCode;
	private String depositDesc;
	private Date depositDateStart;
	private Date depositDateEnd;
	private String depositBy;
	
	private Date reviewDateStart;
	private Date reviewDateEnd;
	private Integer reviewBy;
	private Integer objective;
	private Integer branch;
	private Integer department;
	private Integer position;


	public String getDepositCode() {
		return depositCode;
	}
	public void setDepositCode(String depositCode) {
		this.depositCode = depositCode;
	}
	public String getDepositDesc() {
		return depositDesc;
	}
	public void setDepositDesc(String depositDesc) {
		this.depositDesc = depositDesc;
	}
	public Date getDepositDateStart() {
		return depositDateStart;
	}
	public void setDepositDateStart(Date depositDateStart) {
		this.depositDateStart = depositDateStart;
	}
	public Date getDepositDateEnd() {
		return depositDateEnd;
	}
	public void setDepositDateEnd(Date depositDateEnd) {
		this.depositDateEnd = depositDateEnd;
	}
	public String getDepositBy() {
		return depositBy;
	}
	public void setDepositBy(String depositBy) {
		this.depositBy = depositBy;
	}
	public Date getReviewDateStart() {
		return reviewDateStart;
	}
	public void setReviewDateStart(Date reviewDateStart) {
		this.reviewDateStart = reviewDateStart;
	}
	public Date getReviewDateEnd() {
		return reviewDateEnd;
	}
	public void setReviewDateEnd(Date reviewDateEnd) {
		this.reviewDateEnd = reviewDateEnd;
	}
	public Integer getReviewBy() {
		return reviewBy;
	}
	public void setReviewBy(Integer reviewBy) {
		this.reviewBy = reviewBy;
	}
	public Integer getObjective() {
		return objective;
	}
	public void setObjective(Integer objective) {
		this.objective = objective;
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
