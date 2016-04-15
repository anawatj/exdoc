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
import com.tao.exdoc.domain.enumurate.Status;
import com.tao.exdoc.domain.witdown.Witdown;
import com.tao.exdoc.domain.witdown.WitdownQuery;
import com.tao.exdoc.repository.IWitdownRepository;
@Repository
public class WitdownRepository implements IWitdownRepository {
	
	@Autowired
	private SessionFactory factory;

	public Result<Witdown> findAll() throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Witdown.class);
		return new Result(factory,criteria,Witdown.class,"witdownCode","witdownDesc");
	}

	public Witdown findByKey(Integer key) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Witdown.class);
		criteria.setFetchMode("witdownBy", FetchMode.JOIN);
		criteria.setFetchMode("reviewBy", FetchMode.JOIN);
		criteria.setFetchMode("approveBy", FetchMode.JOIN);
		criteria.setFetchMode("objective", FetchMode.JOIN);
		criteria.setFetchMode("branch", FetchMode.JOIN);
		criteria.setFetchMode("department", FetchMode.JOIN);
		criteria.setFetchMode("position", FetchMode.JOIN);
		criteria.setFetchMode("items", FetchMode.JOIN);
		criteria.setFetchMode("items.document", FetchMode.JOIN);
		
		criteria.add(Restrictions.eq("id", key));
		List<Witdown> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

	public Witdown save(Witdown entity) throws Exception {
		Witdown data = findByKey(entity.getId());
		Witdown result = (Witdown) factory.getCurrentSession().merge(entity);
		if(result.getStatus()==Status.S)
		{
			DecimalFormat format = new DecimalFormat("000000000000000000");
			result.setWitdownCode("WD"+format.format(result.getId()));
		
		}
		return result;
	}

	public void remove(Integer key) throws Exception {
		Witdown data = findByKey(key);
		factory.getCurrentSession().delete(data);
		
		
	}

	public Result<Witdown> findByQuery(WitdownQuery query) throws Exception {
		Criteria criteria = factory.getCurrentSession().createCriteria(Witdown.class);
		criteria.setFetchMode("witdownBy", FetchMode.JOIN);
		criteria.setFetchMode("reviewBy", FetchMode.JOIN);
		criteria.setFetchMode("approveBy", FetchMode.JOIN);
		criteria.setFetchMode("objective", FetchMode.JOIN);
		criteria.setFetchMode("branch", FetchMode.JOIN);
		criteria.setFetchMode("department", FetchMode.JOIN);
		criteria.setFetchMode("position", FetchMode.JOIN);
		if(query.getWitdownCode()!=null && !query.getWitdownCode().equals(""))
		{
			if(query.getWitdownCode().contains("*") || query.getWitdownCode().contains("?"))
			{
				criteria.add(Restrictions.like("witdownCode",query.getWitdownCode().replace("*", "%").replace("?", "_")));
				
			}else
			{
				criteria.add(Restrictions.eq("witdownCode",query.getWitdownCode()));
			}
		}
		if(query.getWitdownDesc()!=null && !query.getWitdownDesc().equals(""))
		{
			if(query.getWitdownDesc().contains("*") || query.getWitdownDesc().contains("?"))
			{
				criteria.add(Restrictions.like("witdownDesc", query.getWitdownDesc().replace("*", "%").replace("?", "_")));
			}else
			{
				criteria.add(Restrictions.eq("witdownDesc", query.getWitdownDesc()));
			}
		}
		if(query.getWitdownBy()!=null && !query.getWitdownBy().equals(""))
		{
			criteria.createAlias("witdownBy", "wb",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("wb.username",query.getWitdownBy()));
			
		}
		if(query.getWitdownDateStart()!=null)
		{
			criteria.add(Restrictions.ge("witdownDate", query.getWitdownDateStart()));
		}
		if(query.getWitdownDateEnd()!=null)
		{
			criteria.add(Restrictions.le("witdownDate", query.getWitdownDateEnd()));
		}
		if(query.getReviewBy()!=null && !query.getReviewBy().equals(""))
		{
			criteria.createAlias("reviewBy", "vb",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("vb.username", query.getReviewBy()));
		}
		if(query.getReviewDateStart()!=null)
		{
			criteria.add(Restrictions.ge("reviewDate", query.getReviewDateStart()));
		}
		if(query.getReviewDateEnd()!=null)
		{
			criteria.add(Restrictions.le("reviewDate", query.getReviewDateEnd()));
		}
		if(query.getApproveBy()!=null && !query.getApproveBy().equals(""))
		{
			criteria.createAlias("approveBy", "ab",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("ab.username", query.getApproveBy()));
		}
		if(query.getApproveDateStart()!=null)
		{
			criteria.add(Restrictions.ge("approveDate", query.getApproveDateStart()));
		}
		if(query.getApproveDateEnd()!=null)
		{
			criteria.add(Restrictions.le("approveDate", query.getApproveDateEnd()));
		}
		if(query.getDepartment()!=null && query.getDepartment()!=0)
		{
			criteria.createAlias("department", "d",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("d.id", query.getDepartment()));
		}
		if(query.getBranch()!=null && query.getBranch()!=0)
		{
			criteria.createAlias("branch", "b",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("b.id", query.getBranch()));
		}
		if(query.getPosition()!=null && query.getPosition()!=0)
		{
			criteria.createAlias("position", "p",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("p.id", query.getPosition()));
		}
		return new Result<Witdown>(factory,criteria,Witdown.class,"id","witdownCode","witdownDesc","witdownBy","witdownDate","reviewBy","reviewDate","approveBy","approveDate","objective","branch","department","position");
		
	}

}
