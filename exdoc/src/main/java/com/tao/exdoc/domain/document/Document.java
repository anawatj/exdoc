package com.tao.exdoc.domain.document;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.container.Container;
import com.tao.exdoc.domain.enumurate.DocumentStatus;
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.domain.master.DocumentGroup;
import com.tao.exdoc.domain.master.DocumentMode;
import com.tao.exdoc.domain.master.DocumentType;
import com.tao.exdoc.domain.security.User;
@JsonInclude(Include.NON_NULL)
public class Document extends AbstractDomain<Integer> {
	
	public Document()
	{
		
	}
	private String documentCode;
	private String documentDesc;
	private DocumentType documentType;
	private DocumentGroup documentGroup;
	private DocumentMode documentMode;
	private DocumentStatus documentStatus;
	private Container container;
	private Date documentDate;
	private User documentBy;
	private String remark;
	private Status status;
	private Integer numDoc;
	private Integer maxNumDoc;
	public Integer getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(Integer numDoc) {
		this.numDoc = numDoc;
	}
	public Integer getMaxNumDoc() {
		return maxNumDoc;
	}
	public void setMaxNumDoc(Integer maxNumDoc) {
		this.maxNumDoc = maxNumDoc;
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
	public DocumentType getDocumentType() {
		return documentType;
	}
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	public DocumentGroup getDocumentGroup() {
		return documentGroup;
	}
	public void setDocumentGroup(DocumentGroup documentGroup) {
		this.documentGroup = documentGroup;
	}
	public DocumentMode getDocumentMode() {
		return documentMode;
	}
	public void setDocumentMode(DocumentMode documentMode) {
		this.documentMode = documentMode;
	}
	public DocumentStatus getDocumentStatus() {
		return documentStatus;
	}
	public void setDocumentStatus(DocumentStatus documentStatus) {
		this.documentStatus = documentStatus;
	}
	public Container getContainer() {
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
	public User getDocumentBy() {
		return documentBy;
	}
	public void setDocumentBy(User documentBy) {
		this.documentBy = documentBy;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
