package com.tao.exdoc.domain;

import java.util.List;

import javassist.convert.Transformer;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public final class Result<E> {
	

	
	private List<E> list;
	
	private SessionFactory factory;
	private Criteria criteria;
	private String[] columns;
	private Class clazz;
	
	
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
	public Result(SessionFactory factory,Criteria criteria,Class clazz,String...columns)
	{
		this.factory= factory;
		this.criteria=criteria;
		this.columns=columns;
		this.clazz= clazz;
	}
	@JsonIgnore
	public Result<E> getFullResult()
	{

		if(this.columns!=null && this.columns.length>0)
		{
			ProjectionList projectionList= Projections.projectionList();
			for(String column : columns)
			{
				projectionList.add(Projections.property(column),column);
			}
			criteria.setProjection(projectionList);
			criteria.setResultTransformer(Transformers.aliasToBean(clazz));
		}else
		{
			criteria.setResultTransformer(Criteria.ROOT_ENTITY);
		}
	
		
		this.list= this.criteria.list();
		return this;
		
	}
	public Page<E> getPage(Integer page)
	{
		return new Page<E>(criteria,clazz,page,columns);
	}

}
