package com.tao.exdoc.repository;

import com.tao.exdoc.domain.Result;
import com.tao.exdoc.domain.transfer.Transfer;
import com.tao.exdoc.domain.transfer.TransferQuery;

public interface ITransferRepository extends Repository<Transfer,Integer>{

	Result<Transfer> findAll() throws Exception;
	Transfer findByKey(Integer key) throws Exception;
	void remove(Integer key) throws Exception;
	Transfer save(Transfer entity) throws Exception;
	
	Result<Transfer> findByQuery(TransferQuery query) throws Exception;
	
}
