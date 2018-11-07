package controller.server;

import org.python.util.PythonInterpreter;

public class DataUpdater implements Runnable {
	private PythonInterpreter pythonInterpreter;

	public DataUpdater(PythonInterpreter pythonInterpreter) {
		this.pythonInterpreter = pythonInterpreter;
	}

	@Override
	public void run() {
		while (true) {

		}
	}
}
