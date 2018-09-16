package controller;

import model.IModel;
import view.IView;

public class Controller implements IController {
	private IModel model;
	private IView view;

	public Controller(IModel model, IView view) {
		this.model = model;
		this.view = view;
		this.model.loadSettings();
		this.updateSettings();
	}

	private void updateSettings() {
		if (this.model.getPseudo().equals(null)) {
			// PopupManager.askForPseudo();
		}
	}

	public void startChat() {

	}

}
