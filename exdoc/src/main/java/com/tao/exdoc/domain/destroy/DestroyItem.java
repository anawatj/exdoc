package com.tao.exdoc.domain.destroy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.document.Document;
import com.tao.exdoc.domain.enumurate.CheckStatus;
@JsonInclude(Include.NON_NULL)
public class DestroyItem extends AbstractDomain<Integer>{

	public DestroyItem()
	{
		
	}
	private Integer destroyId;
	private Document document;
	private String remark;
	private CheckStatus status;
	public Integer getDestroyId() {
		return destroyId;
	}
	public void setDestroyId(Integer destroyId) {
		this.destroyId = destroyId;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public CheckStatus getStatus() {
		return status;
	}
	public void setStatus(CheckStatus status) {
		this.status = status;
	}
}
