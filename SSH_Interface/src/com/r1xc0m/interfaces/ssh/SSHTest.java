package com.r1xc0m.interfaces.ssh;

public class SSHTest {
	/**
	 * Test of sendCommand method, of class SSHManager.
	 */
	static public void main(String[] a)
	{
		SSHTest d = new SSHTest();
		d.testSendCommand();
	}
	public void testSendCommand() {
		System.out.println("sendCommand");

		/**
		 * YOU MUST CHANGE THE FOLLOWING FILE_NAME: A FILE IN THE DIRECTORY
		 * USER: LOGIN USER NAME PASSWORD: PASSWORD FOR THAT USER HOST: IP
		 * ADDRESS OF THE SSH SERVER
		 **/
		String command = "show interfaces";
		String userName = "rix";
		String password = "rix";
		String connectionIP = "10.10.10.250";
		SSHManager instance = new SSHManager(userName, password, connectionIP,
				"");
		String errorMessage = instance.connect();

		if (errorMessage != null) 
		{
			System.out.println(errorMessage);
	
		}

		String expResult = "FILE_NAME\n";
		// call sendCommand for each command and the output
		// (without prompts) is returned
		String result = instance.sendCommand(command);
		System.out.println(result);
		// close only after all commands are sent
		instance.close();
	}
}
