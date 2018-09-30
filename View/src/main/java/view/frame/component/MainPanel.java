package view.frame.component;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.frame.component.mainPanelComponent.ViewPanel;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 6339287783087067958L;

	private ViewPanel viewPanel;
	private JTextField keyZone;
	private JButton sendButton;

	public MainPanel() {
		this.setLayout(new GridBagLayout());

		this.viewPanel = new ViewPanel();
		GridBagConstraints cViewPanel = new GridBagConstraints();
		cViewPanel.gridx = 0;
		cViewPanel.gridy = 0;
		cViewPanel.weightx = 1.0;
		cViewPanel.weighty = 1.0;
		cViewPanel.fill = GridBagConstraints.BOTH;
		this.add(this.viewPanel, cViewPanel);

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

	public ViewPanel getViewPanel() {
		return this.viewPanel;
	}
}
