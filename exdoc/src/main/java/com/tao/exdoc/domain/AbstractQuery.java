package com.tao.exdoc.domain;

public abstract class AbstractQuery {
	public AbstractQuery()
	{
		
	}
	private Integer page;
	private String orderBy;
	private String orderType;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
}
