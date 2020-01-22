package com.learning.designpattern;

/** It is used when we want to provide "controlled access" of a functionality.
 *  It provide a wrapper implementation for better performance. 
 */
interface CommandExecutor {
	void runCommand(String cmd) throws Exception;
}

class CommandExecutorImpl implements CommandExecutor {
	public void runCommand(String cmd) throws Exception {
		//Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.\n");
	}
}
class CommandExecutorProxy implements CommandExecutor {
	private boolean isAdmin = false;
	private CommandExecutor commandExecutor;

	public CommandExecutorProxy(String user, String pwd) {
		if ("admin".equals(user) && "password".equals(pwd)) {
			isAdmin = true;
		}
		commandExecutor = new CommandExecutorImpl();
	}

	public void runCommand(String cmd) throws Exception {
		if (isAdmin) {
			commandExecutor.runCommand(cmd);
		} else {
			if (cmd.trim().startsWith("rm")) {
				throw new Exception("rm command is not allowed for non-admin users.");
			} else {
				commandExecutor.runCommand(cmd);
			}
		}
	}
}

public class S03ProxyPattern {
	public static void main(String[] args) throws Exception {
		CommandExecutor commandExecutorProxy = new CommandExecutorProxy("admin", "password");
		commandExecutorProxy.runCommand("notepad");
		
		commandExecutorProxy = new CommandExecutorProxy("admin1", "password1");
		commandExecutorProxy.runCommand("MS Office");
		
		commandExecutorProxy = new CommandExecutorProxy("admin2", "password2");
		commandExecutorProxy.runCommand("rm scheduler");

	}
}
