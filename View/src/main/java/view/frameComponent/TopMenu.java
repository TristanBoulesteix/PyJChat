package view.frameComponent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class TopMenu extends JMenuBar {
	private static final long serialVersionUID = 4882701602943607592L;

	private JMenu file, chatSettings, about;

	public TopMenu() {
		this.file = new JMenu("Fichier");
		this.add(this.file);

		this.chatSettings = new JMenu("Paramètres du chat");
		this.add(this.chatSettings);

		this.about = new JMenu("A propos");
		this.add(this.about);
	}
}
