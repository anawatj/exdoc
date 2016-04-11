package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.container.Container;
import com.tao.exdoc.domain.container.ContainerQuery;

public interface IContainerRepository extends Repository<Container,Integer> {

			Result<Container> findAll() throws Exception;
			Container findByKey(Integer key) throws Exception;
			void remove(Integer key) throws Exception;
			Container save(Container entity) throws Exception;
			Result<Container> findByQuery(ContainerQuery query) throws Exception;
}
