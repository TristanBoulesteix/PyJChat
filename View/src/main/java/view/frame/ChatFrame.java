package view.frame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import view.frame.component.MainPanel;

public class ChatFrame extends JFrame {
	private static final long serialVersionUID = -3726360955592751689L;

	private MainPanel mainPanel;
	private JMenuBar menuBar;

	public ChatFrame() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setPreferredSize(new Dimension(1200, 1000));
		this.setTitle("PyJChat - Chargement...");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.mainPanel = new MainPanel();
		this.menuBar = new OptionMenuBar();

		this.setContentPane(this.mainPanel);
		this.setJMenuBar(this.menuBar);

		this.revalidate();
		this.pack();
	}

	public void setSubtitle(String title) {
		this.setTitle("PyJChat - " + title);
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}
}
