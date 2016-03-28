package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.container.Container;

public interface IContainerRepository extends Repository<Container,Integer> {

			Result<Container> findAll() throws Exception;
			Container findByKey(Integer key) throws Exception;
			void remove(Integer key) throws Exception;
			Container save(Container entity) throws Exception;
}
