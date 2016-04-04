package com.tao.exdoc.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public final class Result<E> {
	
	private List<E> list;
	
	private SessionFactory factory;
	private Criteria criteria;
	private Projection[] projections;
	
	
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
	public Result(SessionFactory factory,Criteria criteria,Projection...projections)
	{
		this.factory= factory;
		this.criteria=criteria;
		this.projections= projections;
	}
	@JsonIgnore
	public Result<E> getFullResult()
	{
		if(this.projections!=null || this.projections.length>0)
		{
			for(Projection projection : projections)
			{
				this.criteria.setProjection(Projections.projectionList().add(projection));
			}
		}
		this.list= this.criteria.list();
		return this;
		
	}
	public Page<E> getPage(Integer page)
	{
		return new Page<E>(criteria,page);
	}

}
