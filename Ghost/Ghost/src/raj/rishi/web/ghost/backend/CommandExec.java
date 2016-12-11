package raj.rishi.web.ghost.backend;

import java.io.IOException;

import raj.rishi.web.ghost.utils.CommandExecException;

public class CommandExec {
	public static void runApp(String command) throws CommandExecException{
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			System.out.println("Error in carrying out command, Master");
			e.printStackTrace();
			throw new CommandExecException();
			}
	}
}
