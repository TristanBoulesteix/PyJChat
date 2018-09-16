package controller;

import contract.controller.IController;
import contract.model.IModel;
import contract.view.IView;

public class Controller implements IController {
	private IModel model;
	private IView view;

	public Controller(IModel model, IView view) {
		this.model = model;
		this.view = view;
		this.model.loadSettings();
		this.updateSettings();
	}

	@Override
	public void startChat() {

	}

	private void updateSettings() {
		if (this.model.getPseudo().equals(null)) {

		}
	}

}
