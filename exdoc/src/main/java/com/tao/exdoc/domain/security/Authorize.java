package com.tao.exdoc.domain.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
@JsonInclude(Include.NON_NULL)
public class Authorize extends AbstractDomain<Integer> {
		
	public Authorize()
	{
		
	}
	private String authorizeCode;
	private String authorizeDesc;
	public String getAuthorizeCode() {
		return authorizeCode;
	}
	public void setAuthorizeCode(String authorizeCode) {
		this.authorizeCode = authorizeCode;
	}
	public String getAuthorizeDesc() {
		return authorizeDesc;
	}
	public void setAuthorizeDesc(String authorizeDesc) {
		this.authorizeDesc = authorizeDesc;
	}
	
}
