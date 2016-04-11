package com.tao.exdoc.repository.impl;

import org.springframework.stereotype.Repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.container.Container;
import com.tao.exdoc.domain.container.ContainerQuery;
import com.tao.exdoc.repository.IContainerRepository;
@Repository
public class ContainerRepository implements IContainerRepository {

	public ContainerRepository() {
		// TODO Auto-generated constructor stub
	}

	public Result<Container> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Container findByKey(Integer key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Integer key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public Container save(Container entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Result<Container> findByQuery(ContainerQuery query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
