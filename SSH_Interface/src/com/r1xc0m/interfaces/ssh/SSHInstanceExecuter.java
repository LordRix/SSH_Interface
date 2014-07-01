package com.r1xc0m.interfaces.ssh;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.r1xc0m.interfaces.common.CommandPattern;
import com.r1xc0m.interfaces.common.CommandsBO;

public class SSHInstanceExecuter 
{
	private String ipNumber = "";	
	private String userName = "";	
	private String passWord = "";
	private CommandPattern commandPattern = new CommandPattern();
	
	SSHInstanceExecuter()
	{
	}
	
	public String getIpNumber() {
		return ipNumber;
	}

	public void setIpNumber(String ipNumber) {
		this.ipNumber = ipNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public CommandPattern getCommandPattern() {
		return commandPattern;
	}

	public void setCommandPattern(CommandPattern commandPattern) {
		this.commandPattern = commandPattern;
	}

	public CommandPattern execute()
	{		
		
		ArrayList<CommandsBO> commandList = this.commandPattern.getCommandList();
		SSHManager instance = new SSHManager(this.userName, this.passWord, ipNumber,"");
		
		String errorMessage = instance.connect();
		this.commandPattern.setErrorMessage(errorMessage);
		
		for (CommandsBO commands : commandList ) 
		{
			String response = instance.sendCommand(commands.getCommandString());
			Pattern pattern = Pattern.compile(commands.getCaptureString());
		    Matcher matcher = pattern.matcher(response);
		    ArrayList<ArrayList<String>> cList = new ArrayList<ArrayList<String>>();
		    while (matcher.find()) 
		    {
		    	ArrayList<String> aList = new ArrayList<String>();
		    	int matchCount = matcher.groupCount();
		    	for(int valuesIndex = 1; valuesIndex<=matchCount;valuesIndex++)
		    	{
		    		aList.add(matcher.group(valuesIndex));
		    	}
		    	cList.add(aList);
		    }
			commands.setCapturedValues(cList);			
		}
		return this.commandPattern; 
	}
}
