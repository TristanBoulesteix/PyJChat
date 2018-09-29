import java.io.IOException;
import java.net.ServerSocket;

import controller.Controller;
import controller.IController;
import model.IModel;
import model.Model;
import view.IView;
import view.ViewManager;

public class PyJChat {
	private static ServerSocket SERVER_SOCKET;

	public static void main(String[] args) {
		PyJChat.checkForOtherInstance();

		IModel model = new Model();
		IView view = new ViewManager();
		IController controller = new Controller(model, view);
		controller.startChat();
	}

	private static void checkForOtherInstance() {
		try {
			SERVER_SOCKET = new ServerSocket(1334);

		} catch (IOException x) {
			System.out.println("Another instance already running... exit.");
			System.exit(0);
		}
	}
}
