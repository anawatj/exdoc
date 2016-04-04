package com.tao.exdoc.domain;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

import com.tao.exdoc.Config;

public final class Page<E> {
	
	private List<E> list;
	private Long totalRecord;
	private Long totalPage;
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Long getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	private Criteria criteria;
	public Page(Criteria criteria,Integer page)
	{
		this.criteria=criteria;
		this.criteria.setProjection(null);
		this.totalRecord= (Long) this.criteria.setProjection(Projections.id()).uniqueResult();
		this.totalPage = this.totalRecord/Config.PAGE_SIZE;
		if((this.totalRecord%Config.PAGE_SIZE)>0)
		{
			this.totalPage++;
		}
		Integer start = (page-1)*Config.PAGE_SIZE;
		this.list = this.criteria
				.setFirstResult(start)
				.setMaxResults(Config.PAGE_SIZE)
				.list();
		
	}

}
