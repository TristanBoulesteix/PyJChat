package controller.server;

import java.io.InputStream;

import org.python.core.PyInstance;
import org.python.util.PythonInterpreter;

public class ServerMaster implements Runnable {
	private static final String CLASS_NAME = "Server()";
	private static final String RUN_FUNCTION_NAME = "run";

	private final InputStream SERVER_PATH = this.getClass().getClassLoader().getResourceAsStream("Server.py");

	private PythonInterpreter pythonInterpreter;
	private PyInstance serverInstance;

	public ServerMaster(final String pathToData) {
		System.out.println(pathToData);
		String[] parameters = { pathToData };

		PythonInterpreter.initialize(System.getProperties(), System.getProperties(), parameters);
		this.pythonInterpreter = new PythonInterpreter();

		this.pythonInterpreter.execfile(this.SERVER_PATH);

	}

	@Override
	public void run() {
		this.serverInstance = (PyInstance) this.pythonInterpreter.eval(CLASS_NAME);

		this.serverInstance.invoke(RUN_FUNCTION_NAME);
	}
}
