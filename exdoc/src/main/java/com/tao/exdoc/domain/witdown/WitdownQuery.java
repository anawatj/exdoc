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
	private String witdownBy;
	private Integer department;
	private Integer branch;
	private Integer position;
	private String reviewBy;
	private Date reviewDateStart;
	private Date reviewDateEnd;
	private String approveBy;
	private Date approveDateStart;
	private Date approveDateEnd;
	
	public String getReviewBy() {
		return reviewBy;
	}
	public void setReviewBy(String reviewBy) {
		this.reviewBy = reviewBy;
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
	public String getApproveBy() {
		return approveBy;
	}
	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}
	public Date getApproveDateStart() {
		return approveDateStart;
	}
	public void setApproveDateStart(Date approveDateStart) {
		this.approveDateStart = approveDateStart;
	}
	public Date getApproveDateEnd() {
		return approveDateEnd;
	}
	public void setApproveDateEnd(Date approveDateEnd) {
		this.approveDateEnd = approveDateEnd;
	}
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
	public String getWitdownBy() {
		return witdownBy;
	}
	public void setWitdownBy(String witdownBy) {
		this.witdownBy = witdownBy;
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
