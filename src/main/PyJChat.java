package main;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.ServerSocket;
import java.util.Set;

import javax.swing.JOptionPane;

import contract.controller.IController;
import contract.model.IModel;
import contract.view.IView;
import controller.Controller;
import model.Model;
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
        }
	}
}
