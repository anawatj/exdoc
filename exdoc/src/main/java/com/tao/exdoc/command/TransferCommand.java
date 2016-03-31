package com.tao.exdoc.command;

import org.springframework.stereotype.Component;

import com.tao.exdoc.domain.transfer.Transfer;
@Component
public class TransferCommand implements ICommand<Transfer> {

	public TransferCommand() {
		// TODO Auto-generated constructor stub
	}


	public CommandResult execute(Transfer entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
