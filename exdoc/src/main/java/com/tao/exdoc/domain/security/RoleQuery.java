package com.tao.exdoc.domain.security;

import com.tao.exdoc.domain.AbstractQuery;

public class RoleQuery extends AbstractQuery {
	
	private String roleCode;
	private String roleDesc;
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	

}
