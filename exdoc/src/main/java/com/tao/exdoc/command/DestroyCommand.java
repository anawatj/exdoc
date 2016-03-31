package com.tao.exdoc.command;

import org.springframework.stereotype.Component;

import com.tao.exdoc.domain.destroy.Destroy;
@Component
public class DestroyCommand implements ICommand<Destroy>{

	public DestroyCommand() {
		// TODO Auto-generated constructor stub
	}

	public CommandResult execute(Destroy entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
