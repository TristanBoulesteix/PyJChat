package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import view.frameComponent.ChatPanel;
import view.frameComponent.TopMenu;

public class ChatFrame extends JFrame {
	private static final long serialVersionUID = -3726360955592751689L;

	private JPanel chatPanel;
	private JMenuBar menuBar;

	public ChatFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width, screenSize.height);
		this.setTitle("PyJChat");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.chatPanel = new ChatPanel();
		this.menuBar = new TopMenu();
	}
}
