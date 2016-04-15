package com.tao.exdoc.web.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tao.exdoc.domain.Page;
import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.document.Document;
import com.tao.exdoc.domain.document.DocumentQuery;
import com.tao.exdoc.repository.IDocumentRepository;

@Controller
@RequestMapping("/document")
public class DocumentController {
	
	
	@Autowired
	private IDocumentRepository documentRepository;
	
	@RequestMapping(value="/search" ,method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Document> search(@RequestBody DocumentQuery query) throws Exception
	{
		Result<Document> result = documentRepository.findByQuery(query);
		
		return result.getPage(query.getPage());
		
		
		
	}

}
