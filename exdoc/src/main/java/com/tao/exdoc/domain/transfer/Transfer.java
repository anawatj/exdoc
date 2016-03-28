package com.tao.exdoc.domain.transfer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.domain.master.TransferObjective;
import com.tao.exdoc.domain.security.User;
@JsonInclude(Include.NON_NULL)
public class Transfer extends AbstractDomain<Integer>{
	
	public Transfer()
	{
		this.items = new HashSet<TransferItem>();
	}
	private String transferCode;
	private String transferDesc;
	private Date transferDate;
	private User transferBy;
	private Date reviewDate;
	private User reviewBy;
	private Date approveDate;
	private User approveBy;
	private TransferObjective objective;
	private Status status;
	private String remark;
	private Set<TransferItem> items;
	public String getTransferCode() {
		return transferCode;
	}
	public void setTransferCode(String transferCode) {
		this.transferCode = transferCode;
	}
	public String getTransferDesc() {
		return transferDesc;
	}
	public void setTransferDesc(String transferDesc) {
		this.transferDesc = transferDesc;
	}
	public Date getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	public User getTransferBy() {
		return transferBy;
	}
	public void setTransferBy(User transferBy) {
		this.transferBy = transferBy;
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
	public TransferObjective getObjective() {
		return objective;
	}
	public void setObjective(TransferObjective objective) {
		this.objective = objective;
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
	public Set<TransferItem> getItems() {
		return items;
	}
	public void setItems(Set<TransferItem> items) {
		this.items = items;
	}
	
}
