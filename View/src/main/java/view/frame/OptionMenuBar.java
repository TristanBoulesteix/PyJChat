package view.frame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class OptionMenuBar extends JMenuBar {
	private static final long serialVersionUID = 4882701602943607592L;

	private JMenu file, chatSettings, about;
	private JMenuItem pseudo;

	public OptionMenuBar() {
		this.file = new JMenu("Fichier");
		this.add(this.file);

		this.chatSettings = new JMenu("Paramètres du chat");
		this.add(this.chatSettings);

		this.about = new JMenu("A propos");
		this.add(this.about);

		this.createJMenuItemForFile();
		this.createJMenuItemForChat();
	}

	private void createJMenuItemForFile() {
		this.pseudo = new JMenuItem();
		this.pseudo.setEnabled(false);
		this.file.add(this.pseudo);

		JMenuItem changeServer = new JMenuItem("Changer de serveur");
		this.file.add(changeServer);

		JMenuItem disconnect = new JMenuItem("Déconnexion");
		this.file.add(disconnect);

		this.file.addSeparator();

		JMenuItem exit = new JMenuItem("Quitter");
		this.file.add(exit);
	}

	private void createJMenuItemForChat() {

	}

	void setPseudo(String pseudo) {
		this.pseudo.setText(pseudo);
	}
}
