package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.borrow.Borrow;
import com.tao.exdoc.domain.borrow.BorrowQuery;

public interface IBorrowRepository extends Repository<Borrow,Integer> {
		
	Result<Borrow> findAll() throws Exception;
	Borrow findByKey(Integer key) throws Exception;
	void remove(Integer key) throws Exception;
	Borrow save(Borrow entity) throws Exception;
	Result<Borrow> findByQuery(BorrowQuery query) throws Exception;
}
