package raj.rishi.web.ghost.backend;

import java.io.IOException;

import raj.rishi.web.ghost.utils.CommandExecException;

/**
 * This class is used to execute a command on the server computer.
 * @author Raj
 *
 */
public class CommandExec {
	/**
	 * This method is used to run a command
	 * @param command The command to be ran
	 * @throws CommandExecException An exception thrown when command unable to run
	 */
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
