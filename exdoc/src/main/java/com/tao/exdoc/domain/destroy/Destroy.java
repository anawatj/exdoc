package com.tao.exdoc.domain.destroy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.domain.security.User;
@JsonInclude(Include.NON_NULL)
public class Destroy extends AbstractDomain<Integer> {
		
	public Destroy()
	{
		this.items = new HashSet<DestroyItem>();
	}
	private String destroyCode;
	private String destroyDesc;
	private Date destroyDate;
	private User destroyBy;
	private Date reviewDate;
	private User reviewBy;
	private Date approveDate;
	private User approveBy;
	private Status status;
	private String remark;
	private Set<DestroyItem> items;
	public Set<DestroyItem> getItems() {
		return items;
	}
	public void setItems(Set<DestroyItem> items) {
		this.items = items;
	}
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
	public Date getDestroyDate() {
		return destroyDate;
	}
	public void setDestroyDate(Date destroyDate) {
		this.destroyDate = destroyDate;
	}
	public User getDestroyBy() {
		return destroyBy;
	}
	public void setDestroyBy(User destroyBy) {
		this.destroyBy = destroyBy;
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
