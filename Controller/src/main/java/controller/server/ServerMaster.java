package controller.server;

import java.io.InputStream;

import org.python.core.PyInstance;
import org.python.util.PythonInterpreter;

public class ServerMaster {
	private static final String CLASS_NAME = "Server()";
	private static final String RUN_FUNCTION_NAME = "run";

	private final InputStream SERVER_PATH = this.getClass().getClassLoader().getResourceAsStream("Server.py");

	private PythonInterpreter pythonInterpreter;
	private PyInstance serverInstance;

	public ServerMaster() {
		PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
		this.pythonInterpreter = new PythonInterpreter();

		this.pythonInterpreter.execfile(this.SERVER_PATH);
		this.serverInstance = (PyInstance) this.pythonInterpreter.eval(CLASS_NAME);

		this.serverInstance.invoke(RUN_FUNCTION_NAME);
	}
}
