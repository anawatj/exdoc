package com.tao.exdoc.command;

import org.springframework.stereotype.Component;

import com.tao.exdoc.domain.borrow.Borrow;
import com.tao.exdoc.domain.borrow.BorrowItem;
import com.tao.exdoc.domain.document.Document;
@Component
public class BorrowCommand implements ICommand<Borrow> {

	public BorrowCommand() {
		// TODO Auto-generated constructor stub
	}

	public CommandResult execute(Borrow entity) {
		
		return new CommandResult();
	}

	

}
