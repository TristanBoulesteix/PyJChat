package view.frameComponent;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatPanel extends JPanel {
	private static final long serialVersionUID = 186327137878714376L;

	private JTextField keyZone;
	private JTextArea textArea;

	public ChatPanel() {
		this.setLayout(new GridBagLayout());

		this.textArea = new JTextArea();
		GridBagConstraints cTextArea = new GridBagConstraints();
		cTextArea.gridx = 0;
		cTextArea.gridy = 0;
		cTextArea.fill = GridBagConstraints.BOTH;
		this.add(this.textArea, cTextArea);

		this.keyZone = new JTextField();
		GridBagConstraints cKeyZone = new GridBagConstraints();
		cKeyZone.gridx = 0;
		cKeyZone.gridy = 1;
		this.add(this.keyZone, cKeyZone);
	}
}
