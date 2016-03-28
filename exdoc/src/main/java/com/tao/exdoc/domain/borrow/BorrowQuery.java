package com.tao.exdoc.domain.borrow;

import java.util.Date;

import com.tao.exdoc.domain.AbstractQuery;

public class BorrowQuery extends AbstractQuery{
		
	public BorrowQuery()
	{
		
	}
	private String borrowCode;
	private String status;
	private String borrowDesc;
	private Integer objective;
	private Date borrowDateStart;
	private Date borrowDateEnd;
	private Date reviewDateStart;
	private Date reviewDateEnd;
	private Date approveDateStart;
	private Date approveDateEnd;
	public String getBorrowCode() {
		return borrowCode;
	}
	public void setBorrowCode(String borrowCode) {
		this.borrowCode = borrowCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBorrowDesc() {
		return borrowDesc;
	}
	public void setBorrowDesc(String borrowDesc) {
		this.borrowDesc = borrowDesc;
	}
	public Integer getObjective() {
		return objective;
	}
	public void setObjective(Integer objective) {
		this.objective = objective;
	}
	public Date getBorrowDateStart() {
		return borrowDateStart;
	}
	public void setBorrowDateStart(Date borrowDateStart) {
		this.borrowDateStart = borrowDateStart;
	}
	public Date getBorrowDateEnd() {
		return borrowDateEnd;
	}
	public void setBorrowDateEnd(Date borrowDateEnd) {
		this.borrowDateEnd = borrowDateEnd;
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
}
