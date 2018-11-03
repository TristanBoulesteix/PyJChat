package controller.server;

import java.io.File;

import org.python.util.PythonInterpreter;

public class ServerMaster {
	private static final String SERVER_PATH = "Controller/main/java/controller/server/server.py";

	private PythonInterpreter pythonInterpreter;

	public ServerMaster() {
		PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
		this.pythonInterpreter = new PythonInterpreter();

		File pyServer = new File(SERVER_PATH);
		System.out.println(pyServer.getAbsolutePath());

		this.pythonInterpreter.execfile(pyServer.getAbsolutePath());
	}
}
