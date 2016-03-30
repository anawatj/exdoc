package com.tao.exdoc.service;

import com.tao.exdoc.domain.container.Container;

public interface IContainerService extends IService<Container>{

	Container approve(Container entity)throws Exception;
	Container save(Container entity)throws Exception;
	Container submit(Container entity)throws Exception;
}
