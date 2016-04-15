package com.tao.exdoc.domain.deposit;

import java.util.Date;

import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.container.Container;
import com.tao.exdoc.domain.master.DocumentType;

public class DepositItem extends AbstractDomain<Integer>{

	
	public DepositItem()
	{
		
	}
	private Integer depositId;
	private DocumentType documentType;
	
	private String remark;
	private boolean selected;
	private String documentCode;
	private String documentDesc;
	private Date documentDate;
	
	private Container container;
	
	public Container getContainer() {
		if(container!=null)
		{
			if(container.getId()==null && container.getId()==0)
			{
				return null;
			}
		}
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
	public Date getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}
	public String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	public String getDocumentDesc() {
		return documentDesc;
	}
	public void setDocumentDesc(String documentDesc) {
		this.documentDesc = documentDesc;
	}
	public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
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

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
	
	
}
