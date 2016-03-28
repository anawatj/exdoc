package com.tao.exdoc.domain.container;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.domain.master.ContainerType;
import com.tao.exdoc.domain.security.User;
@JsonInclude(Include.NON_NULL)
public class Container extends AbstractDomain<Integer> {

	public Container()
	{
		this.items = new HashSet<Container>();
	}
	private String containerCode;
	private String containerDesc;
	private ContainerType containerType;
	/*private String documentStart;
	private String documentEnd;
	private Integer documentNum;
	private Integer documentCancel;*/
	private User containerBy;
	private Date containerDate;
	private Status status;
	private String remark;
	private Set<Container> items;
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
	public ContainerType getContainerType() {
		return containerType;
	}
	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}
	

	public User getContainerBy() {
		return containerBy;
	}
	public void setContainerBy(User containerBy) {
		this.containerBy = containerBy;
	}
	public Date getContainerDate() {
		return containerDate;
	}
	public void setContainerDate(Date containerDate) {
		this.containerDate = containerDate;
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
	public Set<Container> getItems() {
		return items;
	}
	public void setItems(Set<Container> items) {
		this.items = items;
	}
	
}
