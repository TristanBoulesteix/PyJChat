package view.frame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import view.frame.component.ChatPanel;

public class ChatFrame extends JFrame {
	private static final long serialVersionUID = -3726360955592751689L;

	private JPanel chatPanel;
	private JMenuBar menuBar;

	public ChatFrame() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setPreferredSize(new Dimension(1200, 1000));
		this.setTitle("PyJChat - Chargement...");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.chatPanel = new ChatPanel();
		this.menuBar = new OptionMenuBar();

		this.setContentPane(this.chatPanel);
		this.setJMenuBar(this.menuBar);

		this.pack();
	}
}
