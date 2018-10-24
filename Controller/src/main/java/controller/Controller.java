package controller;

import contract.util.Observer;
import model.IModel;
import view.IView;

public class Controller implements IController, Observer {
	private IModel model;
	private IView view;

	public Controller(IModel model, IView view) {
		this.model = model;
		this.view = view;
		this.model.loadSettings();
		this.updateSettings();
	}

	private void updateSettings() {
		if (this.model.getPseudo() == null) {
			if (!this.model.setPseudo(this.getNewPseudo())) {
				this.view.showUnknownErrorPopup();
			}
		}

		if (this.model.getCurrentIP() == null) {
			try {
				if (!this.model.setCurrentIP()) {
					this.view.showUnknownErrorPopup();
				}
			} catch (Exception e) {
				e.printStackTrace();
				this.view.showUnknownErrorPopup();
			}
		}
	}

	private String getNewPseudo() {
		String pseudo = this.view.askForPseudo();

		if (pseudo == null) {
			System.exit(-2);
		} else if (!pseudo.matches("^[a-zA-Z0-9_]+$") || pseudo.isEmpty()) {
			this.view.showErrorPopup(
					"Désolé, votre pseudo ne peut contenir que les lettre de l'alphabet latin en majuscule et minuscule ainsi que des nombres et l'\"underscore\".",
					"Erreur - Mauvais format de pseudo");
			return this.getNewPseudo();
		} else if (pseudo.length() >= 10) {
			this.view.showErrorPopup("Désolé, un pseudo ne peut contenir plus de 10 caractères.",
					"Erreur - Mauvais format de pseudo");
			return this.getNewPseudo();
		}

		return pseudo;
	}

	@Override
	public void startChat() {
		this.view.getFrame().setVisible(true);

		if (this.model.isServer()) {
			this.startChatAsServer();
		} else if ((this.model.getServerIP()) != null) {
			String ipServer = this.model.getServerIP().toString();
		} else {
			this.view.initNewChat(this);
		}

		this.view.getFrame().revalidate();
	}

	private void startChatAsServer() {

	}

	@Override
	synchronized public void update(String command) {
		if (command.equals("new")) {
			this.startChatAsServer();
		}
	}

}
