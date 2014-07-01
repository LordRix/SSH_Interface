package com.r1xc0m.interfaces.common;

import java.util.ArrayList;

public class CommandPattern 
{
	private ArrayList<CommandsBO> commandList = new ArrayList<CommandsBO>();
	private String patternName = "";
	private String errorMessage = "";
	
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ArrayList<CommandsBO> getCommandList() {
		return commandList;
	}
	public void setCommandList(ArrayList<CommandsBO> commandList) {
		this.commandList = commandList;
	}
	public String getPatternName() {
		return patternName;
	}
	public void setPatternName(String patternName) {
		this.patternName = patternName;
	}
	public CommandPattern()
	{
		CommandsBO command = new CommandsBO();
		command.setCommandString("show interfaces");
		
	}

}
