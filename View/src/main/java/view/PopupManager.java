package view;

import javax.swing.JOptionPane;

public class PopupManager {
	public static String askForPseudo() {
		String pseudo = JOptionPane.showInputDialog(null,
				"Il semble que c'est la première fois que vous utilisez l'application. Veuiller entrer votre pseudo.",
				"Initialisation", JOptionPane.OK_CANCEL_OPTION);

		return pseudo;
	}
}
