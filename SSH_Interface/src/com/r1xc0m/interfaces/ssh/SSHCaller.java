package com.r1xc0m.interfaces.ssh;

import java.util.ArrayList;

import com.r1xc0m.interfaces.common.CommandPattern;
import com.r1xc0m.interfaces.common.CommandsBO;

public class SSHCaller 
{
	static public void main(String[] e)
	{
		SSHInstanceExecuter ssh = new SSHInstanceExecuter();
		ssh.setIpNumber("10.10.10.250");
		ssh.setUserName("rix");
		ssh.setPassWord("rix");
		
		CommandPattern commandPattern = new CommandPattern();
		
		ArrayList<CommandsBO> commandList = new ArrayList<CommandsBO>();
		CommandsBO command = new CommandsBO();
		command.setCommandName("List Interfaces");
		command.setCommandString("show interfaces");
		command.setCaptureString("\\n([^ ]+) is ([^,]+)");
		commandList.add(command);
		
		
		
		
		commandPattern.setCommandList(commandList);
		
		
		ssh.setCommandPattern(commandPattern);
		CommandPattern result = ssh.execute();
		
		ArrayList<CommandsBO> commandResults = result.getCommandList();
		for (CommandsBO commandResult: commandResults) 
		{
			ArrayList<ArrayList<String>> valuesList = commandResult.getCapturedList(); // per line
			for (ArrayList<String> captureResultList: valuesList)
			{
				ArrayList<String> captureList = captureResultList; // per capture value
				for(String myValue: captureList)
				{
					System.out.println(myValue);
				}
			}
			
		}
		
	}
}
