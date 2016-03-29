package com.tao.exdoc.domain.service;

public interface IService<E> {

		public E save(E entity) throws Exception;
		public E submit(E entity)throws Exception;
		public E approve(E entity)throws Exception;
		
	
}
