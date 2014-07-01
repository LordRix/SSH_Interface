package com.r1xc0m.interfaces.ssh;

import java.util.ArrayList;

import com.r1xc0m.interfaces.common.CommandPattern;
import com.r1xc0m.interfaces.common.CommandsBO;

public class SSHCallerJSON 
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
		
		
		String jsonString = "";
		jsonString = "{\"Pattern Name\":\"" + result.getPatternName() + "\",";
		ArrayList<CommandsBO> commandResults = result.getCommandList();
		int pos2 = 0;
		for (CommandsBO commandResult: commandResults) 
		{
			int pos1 = 0;	
			jsonString += "\"" + commandResult.getCommandName() + "\":[";
			if(pos2>0) jsonString +=",";
			pos2++;
			ArrayList<ArrayList<String>> valuesList = commandResult.getCapturedList(); // per line
			for (ArrayList<String> captureResultList: valuesList)
			{
				if(pos1>0) jsonString +=",";
				pos1++;
				int pos = 0;
				jsonString += "{";
				ArrayList<String> captureList = captureResultList; // per capture value
				for(String myValue: captureList)
				{
					if(pos>0) jsonString +=",";
					jsonString += "\"value" + ++pos + "\":\"" + myValue + "\"";
				}
				jsonString += "}";
			}
			
			jsonString += "]";
		}
		jsonString += "}";
		System.out.println(jsonString);
		
	}
	
}
