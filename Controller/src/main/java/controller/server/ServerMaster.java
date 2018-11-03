package controller.server;

import java.io.InputStream;

import org.python.util.PythonInterpreter;

public class ServerMaster {
	private final InputStream SERVER_PATH = this.getClass().getClassLoader().getResourceAsStream("Server.py");

	private PythonInterpreter pythonInterpreter;

	public ServerMaster() {
		PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
		this.pythonInterpreter = new PythonInterpreter();

		System.out.println(this.SERVER_PATH);

		this.pythonInterpreter.execfile(this.SERVER_PATH);
	}
}
