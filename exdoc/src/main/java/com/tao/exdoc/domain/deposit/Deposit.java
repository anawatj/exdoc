package com.tao.exdoc.domain.deposit;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.domain.master.Branch;
import com.tao.exdoc.domain.master.Department;
import com.tao.exdoc.domain.master.DepositObjective;
import com.tao.exdoc.domain.master.DocumentGroup;
import com.tao.exdoc.domain.master.DocumentMode;
import com.tao.exdoc.domain.master.Position;
import com.tao.exdoc.domain.security.User;
@JsonInclude(Include.NON_NULL)
public class Deposit extends AbstractDomain<Integer>{
		
	public Deposit()
	{
		this.items=new HashSet<DepositItem>();
	}
	private String depositCode;
	private String depositDesc;
	private Date depositDate;
	private User depositBy;
	private Date reviewDate;
	private User reviewBy;
	private Date approveDate;
	private User approveBy;
	private DocumentGroup documentGroup;
	private DocumentMode documentMode;
	private Status status;
	private String remark;
	private Set<DepositItem> items;
	private DepositObjective objective;
	private Branch branch;
	private Department department;
	private Position position;
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public DepositObjective getObjective() {
		return objective;
	}
	public void setObjective(DepositObjective objective) {
		this.objective = objective;
	}
	public Set<DepositItem> getItems() {
		return items;
	}
	public void setItems(Set<DepositItem> items) {
		this.items = items;
	}
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
	public Date getDepositDate() {
		return depositDate;
	}
	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}
	public User getDepositBy() {
		return depositBy;
	}
	public void setDepositBy(User depositBy) {
		this.depositBy = depositBy;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public User getReviewBy() {
		return reviewBy;
	}
	public void setReviewBy(User reviewBy) {
		this.reviewBy = reviewBy;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public User getApproveBy() {
		return approveBy;
	}
	public void setApproveBy(User approveBy) {
		this.approveBy = approveBy;
	}
	public DocumentGroup getDocumentGroup() {
		return documentGroup;
	}
	public void setDocumentGroup(DocumentGroup documentGroup) {
		this.documentGroup = documentGroup;
	}
	public DocumentMode getDocumentMode() {
		return documentMode;
	}
	public void setDocumentMode(DocumentMode documentMode) {
		this.documentMode = documentMode;
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
	
	
	
}
