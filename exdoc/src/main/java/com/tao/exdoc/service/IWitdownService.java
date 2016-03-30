package com.tao.exdoc.service;

import com.tao.exdoc.domain.witdown.Witdown;

public interface IWitdownService extends IService<Witdown>{

	Witdown approve(Witdown entity) throws Exception;
	Witdown save(Witdown entity) throws Exception;
	Witdown submit(Witdown entity) throws Exception;
}
