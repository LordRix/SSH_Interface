package com.r1xc0m.interfaces.common;

import java.util.ArrayList;

public class CommandsBO 
{
	int commandOrder = 0;
	String commandString = "";
	String captureString = "";
	String commandName = "";
	ArrayList<ArrayList<String>> capturedList = new ArrayList<ArrayList<String>>();
	
	public String getCommandString() 
	{
		return commandString;
	}
	public void setCommandString(String commandString) 
	{
		this.commandString = commandString;
	}
	public String getCaptureString() 
	{
		return captureString;
	}
	public ArrayList<ArrayList<String>> getCapturedList() 
	{
		return this.capturedList;
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public void setCapturedValues(ArrayList<ArrayList<String>> capturedList) 
	{
		this.capturedList.addAll(capturedList);
	}
	public void setCaptureString(String captureString) {
		this.captureString = captureString;
	}
	
	
	
	
	
	

}
