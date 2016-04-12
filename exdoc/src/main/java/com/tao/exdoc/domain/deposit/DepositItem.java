package com.tao.exdoc.domain.deposit;

import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.container.Container;
import com.tao.exdoc.domain.document.Document;
import com.tao.exdoc.domain.enumurate.CheckStatus;
import com.tao.exdoc.domain.master.DocumentType;

public class DepositItem extends AbstractDomain<Integer>{

	
	public DepositItem()
	{
		
	}
	private Integer depositId;
	private DocumentType documentType;
	private String description;
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
	public CheckStatus getStatus() {
		return status;
	}
	public void setStatus(CheckStatus status) {
		this.status = status;
	}
	private Container container;
	public Container getContainer() {
		if(container!=null)
		{
			if(container.getId()==null || container.getId()==0)
			{
				return null;
			}
		}
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
	public Integer getDepositId() {
		return depositId;
	}
	public void setDepositId(Integer depositId) {
		this.depositId = depositId;
	}
	public DocumentType getDocumentType() {
		if(documentType!=null)
		{
			if(documentType.getId()==null || documentType.getId()==0)
			{
				return null;
			}
		}
		return documentType;
	}
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Document getDocument() {
		if(document!=null)
		{
			if(document.getId()==null || document.getId()==0)
			{
				return null;
			}
		}
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

	
	
	
	
}
