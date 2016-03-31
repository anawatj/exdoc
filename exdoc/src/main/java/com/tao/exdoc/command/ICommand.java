package com.tao.exdoc.command;

public interface ICommand<E> {
	
	public CommandResult execute(E entity);

}
