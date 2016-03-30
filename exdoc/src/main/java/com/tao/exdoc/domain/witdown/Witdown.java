package com.tao.exdoc.domain.witdown;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.domain.master.WitdownObjective;
import com.tao.exdoc.domain.security.User;
@JsonInclude(Include.NON_NULL)
public class Witdown extends AbstractDomain<Integer>{
		
	public Witdown()
	{
		this.items = new HashSet<WitdownItem>();
	}
	private String witdownCode;
	private String witdownDesc;
	private Date witdownDate;
	private User witdownBy;
	private Date reviewDate;
	private User reviewBy;
	private Date approveDate;
	private User approveBy;
	private WitdownObjective objective;
	private String remark;
	private Status status;
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	private Set<WitdownItem> items;
	public Set<WitdownItem> getItems() {
		return items;
	}
	public void setItems(Set<WitdownItem> items) {
		this.items = items;
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
	public Date getWitdownDate() {
		return witdownDate;
	}
	public void setWitdownDate(Date witdownDate) {
		this.witdownDate = witdownDate;
	}
	public User getWitdownBy() {
		return witdownBy;
	}
	public void setWitdownBy(User witdownBy) {
		this.witdownBy = witdownBy;
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
	public WitdownObjective getObjective() {
		return objective;
	}
	public void setObjective(WitdownObjective objective) {
		this.objective = objective;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
