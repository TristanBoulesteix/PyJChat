package view.frame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class OptionMenuBar extends JMenuBar {
	private static final long serialVersionUID = 4882701602943607592L;

	private JMenu file, chatSettings, about;
	private JMenuItem pseudo, ip, version;

	public OptionMenuBar() {
		this.file = new JMenu("Fichier");
		this.add(this.file);

		this.chatSettings = new JMenu("Paramètres du chat");
		this.add(this.chatSettings);

		this.about = new JMenu("A propos");
		this.add(this.about);

		this.createJMenuItemForFile();
		this.createJMenuItemForChat();
		this.createJMenuItemForAbout();
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
		JMenuItem reload = new JMenuItem("Actualiser");
		this.chatSettings.add(reload);

		this.chatSettings.addSeparator();

		this.ip = new JMenuItem();
		this.ip.setEnabled(false);
		this.chatSettings.add(ip);
	}

	private void createJMenuItemForAbout() {
		JMenuItem aboutMe = new JMenuItem("Á propos du développeur");
		this.about.add(aboutMe);

		JMenuItem change = new JMenuItem("Changelog");
		this.about.add(change);

		this.about.addSeparator();

		this.version = new JMenuItem();
		this.version.setEnabled(false);
		this.about.add(this.version);
	}

	void setPseudo(String pseudo) {
		this.pseudo.setText(pseudo);
	}

	void setIP(String ip) {
		this.ip.setText(ip);
	}

	void setVersion(String version) {
		this.version.setText(version);
	}
}
