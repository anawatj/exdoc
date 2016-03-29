package com.tao.exdoc.domain.service;

import com.tao.exdoc.domain.transfer.Transfer;

public interface ITransferService extends IService<Transfer> {
		Transfer approve(Transfer entity)throws Exception;
		Transfer save(Transfer entity)throws Exception;
		Transfer submit(Transfer entity)throws Exception;
}
