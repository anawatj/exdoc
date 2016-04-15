package com.tao.exdoc.domain.borrow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.document.Document;
import com.tao.exdoc.domain.enumurate.CheckStatus;
@JsonInclude(Include.NON_NULL)
public class BorrowItem extends AbstractDomain<Integer>{
	
	public BorrowItem()
	{
		
	}
	private Integer borrowId;
	private Document document;
	private String remark;
	private CheckStatus status;
	private boolean selected;
	public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Integer getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(Integer borrowId) {
		this.borrowId = borrowId;
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
