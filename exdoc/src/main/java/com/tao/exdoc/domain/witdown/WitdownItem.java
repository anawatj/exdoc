package com.tao.exdoc.domain.witdown;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.document.Document;
import com.tao.exdoc.domain.enumurate.CheckStatus;
@JsonInclude(Include.NON_NULL)
public class WitdownItem extends AbstractDomain<Integer>{
		
	public WitdownItem()
	{
		
	}
	private Integer witdownId;
	private Document document;
	private CheckStatus status;
	private String remark;
	public Integer getWitdownId() {
		return witdownId;
	}
	public void setWitdownId(Integer witdownId) {
		this.witdownId = witdownId;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public CheckStatus getStatus() {
		return status;
	}
	public void setStatus(CheckStatus status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
