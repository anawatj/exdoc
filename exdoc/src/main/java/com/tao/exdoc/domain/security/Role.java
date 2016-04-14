package com.tao.exdoc.domain.security;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.exdoc.domain.AbstractDomain;
@JsonInclude(Include.NON_NULL)
public class Role extends AbstractDomain<Integer>{

	public Role()
	{
		this.authorizes = new HashSet<Authorize>();
	}
	
	private String roleCode;
	private String roleDesc;
	
	private Set<Authorize> authorizes;
	
	private boolean selected;

	public boolean getSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

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

	public Set<Authorize> getAuthorizes() {
		return authorizes;
	}

	public void setAuthorizes(Set<Authorize> authorizes) {
		this.authorizes = authorizes;
	}
	
	
}
