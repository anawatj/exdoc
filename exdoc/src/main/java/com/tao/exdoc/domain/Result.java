package com.tao.exdoc.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public final class Result<E> {
	
	private List<E> list;
	
	private SessionFactory factory;
	private Criteria criteria;
	
	
	public List<E> getList() {
		return list;
	}


	public void setList(List<E> list) {
		this.list = list;
	}


	public Result(SessionFactory factory,Criteria criteria)
	{
		this.factory= factory;
		this.criteria=criteria;
	}
	@JsonIgnore
	public Result<E> getFullResult()
	{
		this.list= this.criteria.list();
		return this;
		
	}
	public Page<E> getPage(Integer page)
	{
		return new Page<E>(criteria,page);
	}

}
