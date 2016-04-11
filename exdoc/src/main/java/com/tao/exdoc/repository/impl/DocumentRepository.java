package com.tao.exdoc.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.document.Document;
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
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Integer key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Document save(Document entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
