package com.tao.exdoc.domain.returndoc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
import com.tao.exdoc.domain.borrow.Borrow;
import com.tao.exdoc.domain.enumurate.CheckStatus;
@JsonInclude(Include.NON_NULL)
public class ReturnItem extends AbstractDomain<Integer>{

	
	public ReturnItem()
	{
		
	}
	private Integer returnId;
	private Borrow borrow;
	private String remark;
	private CheckStatus checkStatus;
	public Integer getReturnId() {
		return returnId;
	}
	public void setReturnId(Integer returnId) {
		this.returnId = returnId;
	}
	public Borrow getBorrow() {
		return borrow;
	}
	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public CheckStatus getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(CheckStatus checkStatus) {
		this.checkStatus = checkStatus;
	}
}
