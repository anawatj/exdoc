package com.tao.exdoc.repository;

import java.io.Serializable;

import com.tao.exdoc.domain.IDomain;
import com.tao.exdoc.domain.Result;

public interface Repository<E extends IDomain<K> ,K extends Serializable> {
	
	public Result<E> findAll() throws Exception;
	public E findByKey(K key) throws Exception;
	public E save(E entity) throws Exception;
	public void remove(K key) throws Exception;

}
