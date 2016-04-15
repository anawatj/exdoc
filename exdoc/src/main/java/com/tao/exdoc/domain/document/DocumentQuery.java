package com.tao.exdoc.domain.document;

import com.tao.exdoc.domain.AbstractQuery;

public class DocumentQuery extends AbstractQuery {
	
	
	public DocumentQuery()
	{
		
	}
	
	private String documentCode;
	private String documentDesc;
	private Integer documentGroup;
	private Integer documentMode;
	private Integer documentType;
	private String containerCode;
	private Integer containerId;
	private String containerDesc;
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
	public Integer getDocumentGroup() {
		return documentGroup;
	}
	public void setDocumentGroup(Integer documentGroup) {
		this.documentGroup = documentGroup;
	}
	public Integer getDocumentMode() {
		return documentMode;
	}
	public void setDocumentMode(Integer documentMode) {
		this.documentMode = documentMode;
	}
	public Integer getDocumentType() {
		return documentType;
	}
	public void setDocumentType(Integer documentType) {
		this.documentType = documentType;
	}
	public String getContainerCode() {
		return containerCode;
	}
	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}
	public Integer getContainerId() {
		return containerId;
	}
	public void setContainerId(Integer containerId) {
		this.containerId = containerId;
	}
	public String getContainerDesc() {
		return containerDesc;
	}
	public void setContainerDesc(String containerDesc) {
		this.containerDesc = containerDesc;
	}

}
