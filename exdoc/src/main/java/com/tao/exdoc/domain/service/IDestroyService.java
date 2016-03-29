package com.tao.exdoc.domain.service;

import com.tao.exdoc.domain.destroy.Destroy;

public interface IDestroyService extends IService<Destroy> {

	Destroy approve(Destroy entity)throws Exception;
	public Destroy save(Destroy entity)throws Exception;
	public Destroy submit(Destroy entity)throws Exception;
}
