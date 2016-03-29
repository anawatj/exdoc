package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.document.Document;

public interface IDocumentRepository extends Repository<Document,Integer> {

		Result<Document> findAll() throws Exception;
		Document findByKey(Integer key) throws Exception;
		void remove(Integer key) throws Exception;
		Document save(Document entity) throws Exception;
}
