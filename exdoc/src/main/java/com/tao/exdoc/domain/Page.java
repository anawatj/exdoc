package com.tao.exdoc.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Value;

import com.tao.exdoc.Config;

public final class Page<E> {
	

	
	private List<E> list;
	private Integer totalRecord;
	private Integer totalPage;
	
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	private Criteria criteria;
	private String []columns;
	public Page(Criteria criteria,Integer page)
	{
		this.getPaging(criteria, page,null, null);
		
	}

	public Page(Criteria criteria,Class clazz,Integer page,String... columns)
	{
		this.getPaging(criteria, page,clazz, columns);
	}
	
	private void getPaging(Criteria criteria,Integer page,Class clazz,String...columns)
	{
		this.criteria=criteria;
		this.columns= columns;
		this.criteria.setProjection(null);
		this.totalRecord=(Integer) this.criteria.setProjection(Projections.id()).uniqueResult();
		this.totalPage = this.totalRecord/Config.PAGE_SIZE;
		if((this.totalRecord%Config.PAGE_SIZE)>0)
		{
			this.totalPage++;
		}
		Integer start = (page-1)*Config.PAGE_SIZE;
		this.criteria.setProjection(null);
		if(this.columns!=null && this.columns.length>0)
		{
			ProjectionList projectionList = Projections.projectionList();
			for(String column : columns)
			{
				projectionList.add(Projections.property(column),column);
			}
			this.criteria.setProjection(projectionList);
			this.criteria.setResultTransformer(Transformers.aliasToBean(clazz));
		}else
		{
			this.criteria.setResultTransformer(Criteria.ROOT_ENTITY);
		}
		this.list = this.criteria
				.setFirstResult(start)
				.setMaxResults(Config.PAGE_SIZE)
				.list();
	}

}
