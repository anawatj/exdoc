package com.tao.exdoc.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.document.Document;
import com.tao.exdoc.domain.document.DocumentQuery;
import com.tao.exdoc.repository.IDocumentRepository;
@Repository
public class DocumentRepository implements IDocumentRepository{
	
	
	@Autowired
	private SessionFactory factory;

	public Result<Document> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Document findByKey(Integer key) throws Exception {
		Criteria criteria =factory.getCurrentSession().createCriteria(Document.class);
		criteria.setFetchMode("documentGroup", FetchMode.JOIN);
		criteria.setFetchMode("documentMode",FetchMode.JOIN);
		criteria.setFetchMode("documentType", FetchMode.JOIN);
		criteria.setFetchMode("container", FetchMode.JOIN);
		criteria.setFetchMode("branch", FetchMode.JOIN);
		criteria.setFetchMode("department", FetchMode.JOIN);
		
		criteria.add(Restrictions.eq("id", key));
		
		List<Document> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
		
	}

	public void remove(Integer key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Document save(Document entity) throws Exception {
				Document data = findByKey(entity.getId());
				Document result = (Document) factory.getCurrentSession().merge(entity);
				return result;
	}

	public Result<Document> findByQuery(DocumentQuery query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
