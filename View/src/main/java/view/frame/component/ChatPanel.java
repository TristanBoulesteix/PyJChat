package view.frame.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatPanel extends JPanel {
	private static final long serialVersionUID = 6339287783087067958L;

	private JPanel textArea;
	private JTextField keyZone;
	private JButton sendButton;

	public ChatPanel() {
		this.setLayout(new GridBagLayout());

		this.textArea = new JPanel();
		this.textArea.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.BLACK));
		GridBagConstraints cTextArea = new GridBagConstraints();
		cTextArea.gridx = 0;
		cTextArea.gridy = 0;
		cTextArea.weightx = 1.0;
		cTextArea.weighty = 1.0;
		cTextArea.fill = GridBagConstraints.BOTH;
		this.add(this.textArea, cTextArea);

		ParticipantPanel participant = new ParticipantPanel();
		GridBagConstraints cParticipant = new GridBagConstraints();
		cParticipant.gridx = 1;
		cParticipant.gridy = 0;
		cParticipant.fill = GridBagConstraints.VERTICAL;
		this.add(participant, cParticipant);

		JPanel pKeyZone = new JPanel();
		pKeyZone.setLayout(new BorderLayout());
		GridBagConstraints cPKeyZone = new GridBagConstraints();
		cPKeyZone.gridx = 0;
		cPKeyZone.gridy = 1;
		cPKeyZone.weightx = 1.0;
		cPKeyZone.gridwidth = 2;
		cPKeyZone.insets = new Insets(5, 3, 5, 3);
		cPKeyZone.fill = GridBagConstraints.BOTH;
		this.add(pKeyZone, cPKeyZone);

		this.keyZone = new JTextField();
		this.keyZone.setEnabled(false);
		pKeyZone.add(this.keyZone, BorderLayout.CENTER);

		this.sendButton = new JButton("Envoyer");
		this.sendButton.setEnabled(false);
		pKeyZone.add(this.sendButton, BorderLayout.EAST);
	}

}
