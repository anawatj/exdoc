package com.tao.exdoc.domain.service;

import com.tao.exdoc.domain.returndoc.Return;

public interface IReturnService extends IService<Return> {
		Return approve(Return entity)throws Exception;
		public Return save(Return entity)throws Exception;
		public Return submit(Return entity)throws Exception;
}
