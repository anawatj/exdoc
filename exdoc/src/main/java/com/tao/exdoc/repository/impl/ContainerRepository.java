package com.tao.exdoc.repository.impl;

import java.text.DecimalFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.container.Container;
import com.tao.exdoc.domain.container.ContainerQuery;
import com.tao.exdoc.repository.IContainerRepository;
@Repository
public class ContainerRepository implements IContainerRepository {
	
	
	@Autowired
	private SessionFactory factory;

	public ContainerRepository() {
		// TODO Auto-generated constructor stub
	}

	public Result<Container> findAll() throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Container.class);
		return new Result<Container>(factory,criteria,Container.class,"id","containerCode","containerDesc");
	}

	public Container findByKey(Integer key) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Container.class);
		criteria.setFetchMode("containerType", FetchMode.JOIN);
		criteria.setFetchMode("department", FetchMode.JOIN);
		criteria.setFetchMode("branch", FetchMode.JOIN);
		criteria.setFetchMode("containerBy", FetchMode.JOIN);
		criteria.setFetchMode("items",FetchMode.JOIN);
		criteria.add(Restrictions.eq("id",key));
		
		List<Container> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

	public void remove(Integer key) throws Exception {
		Container data = findByKey(key);
		factory.getCurrentSession().delete(data);
		
	}

	public Container save(Container entity) throws Exception {
		for(Container item :entity.getItems())
		{
			item= setItems(item);
		}
		Container data = findByKey(entity.getId());
		Container result = (Container) factory.getCurrentSession().merge(entity);
		return  result;
	}
	public Container setItems(Container item) throws Exception
	{
		
		Container data  = findByKey(item.getId());
		if(data==null)
		{
			return item;
		}
		if(data.getItems()!=null && data.getItems().size()>0)
		{
			for(Container sitem:data.getItems())
			{
					setItems(sitem);
			}
			item.setItems(data.getItems());
		
		}
		
		return item;
	}
	

	public Result<Container> findByQuery(ContainerQuery query) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Container.class);
		criteria.setFetchMode("containerType",FetchMode.JOIN);
		criteria.setFetchMode("department",FetchMode.JOIN);
		criteria.setFetchMode("branch", FetchMode.JOIN);
		criteria.setFetchMode("containerBy",FetchMode.JOIN);
		
		if(query.getContainerCode()!=null && !query.getContainerCode().equals(""))
		{
			if(query.getContainerCode().contains("*") || query.getContainerCode().contains("?"))
			{
				criteria.add(Restrictions.like("containerCode",query.getContainerCode().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("containerCode",query.getContainerCode()));
			}
		}
		if(query.getContainerDesc()!=null && !query.getContainerDesc().equals(""))
		{
			if(query.getContainerDesc().contains("*")|| query.getContainerDesc().contains("?"))
			{
				criteria.add(Restrictions.like("containerDesc",query.getContainerDesc().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("containerDesc",query.getContainerDesc()));
			}
		}
		if(query.getContainerType()!=null && query.getContainerType()!=0)
		{
			criteria.createAlias("containerType","ct",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("ct.id", query.getContainerType()));
		}
		if(query.getContainerDateStart()!=null)
		{
			criteria.add(Restrictions.ge("containerDate",query.getContainerDateStart()));
		}
		if(query.getContainerDateEnd()!=null)
		{
			criteria.add(Restrictions.le("containerDate", query.getContainerDateEnd()));
		}
		if(query.getLevel()!=null && query.getLevel()!=0)
		{
			criteria.add(Restrictions.eq("level", query.getLevel()));
		}
		if(query.getBranch()!=null && query.getBranch()!=0)
		{
			criteria.createAlias("branch", "b",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("b.id",query.getBranch()));
		}
		if(query.getDepartment()!=null && query.getDepartment()!=0)
		{
			criteria.createAlias("department","d",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("d.id",query.getDepartment()));
		}
		if(query.getContainerBy()!=null && !query.getContainerBy().equals(""))
		{
			criteria.createAlias("containerBy", "cb",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("cb.username", query.getContainerBy()));
		}
		
		return new Result<Container>(factory,criteria,Container.class,"id","containerCode","containerDesc","containerType","containerDate","level","department","branch","containerBy");
		
	}

}
