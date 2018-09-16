package view;

import javax.swing.JOptionPane;

public class ViewManager implements IView {
	public ViewManager() {

	}

	@Override
	public String askForPseudo() {
		String pseudo = JOptionPane.showInputDialog(null,
				"Il semble que c'est la premi�re fois que vous utilisez l'application. Veuiller entrer votre pseudo.",
				"Initialisation", JOptionPane.OK_CANCEL_OPTION);

		return pseudo;
	}

	@Override
	public void showErrorPopup(Object message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void showUnknownErrorPopup() {
		this.showErrorPopup("Une erreur s'est produite. Si le problème persiste, essayez de redémarrer l'application.",
				"Erreur inconnue");
		System.exit(-4);
	}

}
