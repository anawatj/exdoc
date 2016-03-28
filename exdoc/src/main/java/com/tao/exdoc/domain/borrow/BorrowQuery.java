package com.tao.exdoc.domain.borrow;

import com.tao.exdoc.domain.AbstractQuery;

public class BorrowQuery extends AbstractQuery{
		
	public BorrowQuery()
	{
		
	}
	private String borrowCode;
	private String status;
	private String borrowDesc;
	private Integer objective;
}
