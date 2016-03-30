package com.tao.exdoc.service;

import com.tao.exdoc.domain.borrow.Borrow;

public interface IBorrowService extends IService<Borrow> {
	

	Borrow approve(Borrow entity)throws Exception;
	Borrow save(Borrow entity)throws Exception;
    Borrow submit(Borrow entity)throws Exception;

}
