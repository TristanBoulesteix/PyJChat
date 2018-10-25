package controller.server;

import org.python.util.PythonInterpreter;

public class ServerMaster {
	private static final String SERVER_PATH = "/src/main/java/controller/server/Server.py";

	private PythonInterpreter pythonInterpreter;

	public ServerMaster() {
		PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
		this.pythonInterpreter = new PythonInterpreter();
		this.pythonInterpreter.execfile(SERVER_PATH);
	}
}
