package com.tao.exdoc.domain.transfer;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.container.Container;
import com.tao.exdoc.domain.document.Document;
import com.tao.exdoc.domain.enumurate.CheckStatus;
@JsonInclude(Include.NON_NULL)
public class TransferItem extends AbstractDomain<Integer>{
	
	public TransferItem()
	{
		
	}
	private Integer transferId;
	private Document document;
	private Container containerTo;
	private CheckStatus status;
	private String remark;
	public Integer getTransferId() {
		return transferId;
	}
	public void setTransferId(Integer transferId) {
		this.transferId = transferId;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public Container getContainerTo() {
		return containerTo;
	}
	public void setContainerTo(Container containerTo) {
		this.containerTo = containerTo;
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
