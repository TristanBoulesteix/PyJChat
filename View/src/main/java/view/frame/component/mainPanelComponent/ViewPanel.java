package view.frame.component.mainPanelComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ViewPanel extends JPanel {
	private static final long serialVersionUID = -8995991585591533480L;

	private final ActionListener checkRadio = new LaunchRadioAction();

	private InitPanel init;

	public ViewPanel() {
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.BLACK));
		this.setLayout(new BorderLayout());
	}

	public InitPanel getInitPanel() {
		return (this.init == null) ? this.init = new InitPanel() : this.init;
	}

	public void showInitPanel() {
		this.init = new InitPanel();

		this.add(this.init, BorderLayout.CENTER);
	}

	private class LaunchRadioAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();

			if (action.equals("create")) {
				ViewPanel.this.init.showCreate();
			} else if (action.equals("join")) {
				ViewPanel.this.init.showJoin();
			}
		}
	}

	private class InitPanel extends JPanel {
		private static final long serialVersionUID = -572210260355410467L;

		public InitPanel() {
			this.setLayout(new GridBagLayout());

			JTextField titleInit = new JTextField("Création ou connexion à un serveur");
			titleInit.setEditable(false);
			titleInit.setEnabled(false);
			titleInit.setHorizontalAlignment(JTextField.CENTER);
			titleInit.setDisabledTextColor(Color.WHITE);
			titleInit.setBackground(Color.BLACK);
			titleInit.setFont(new Font("SansSerif", Font.BOLD, 35));

			GridBagConstraints cTitleInit = new GridBagConstraints();
			cTitleInit.gridx = 0;
			cTitleInit.gridy = 0;
			cTitleInit.weightx = 1.0;
			cTitleInit.fill = GridBagConstraints.BOTH;
			cTitleInit.insets = new Insets(2, 10, 2, 10);
			this.add(titleInit, cTitleInit);

			JPanel serverSelector = new JPanel();
			serverSelector.setLayout(new BorderLayout());
			serverSelector.setBackground(Color.LIGHT_GRAY);
			serverSelector.setBorder(new TitledBorder("Rejoindre une conversation"));

			GridBagConstraints cServerSelector = new GridBagConstraints();
			cServerSelector.gridx = 0;
			cServerSelector.gridy = 1;
			cServerSelector.weightx = 1.0;
			cServerSelector.insets = new Insets(2, 10, 2, 10);
			cServerSelector.fill = GridBagConstraints.BOTH;
			this.add(serverSelector, cServerSelector);
			JTextArea explaination = new JTextArea(
					"Vous n'êtes connecté à aucun chat pour le moment. Vous pouvez créer un nouveau serveur ou en rejoindre un.");
			explaination.setEditable(false);
			explaination.setEnabled(false);
			explaination.setDisabledTextColor(Color.BLACK);
			serverSelector.add(explaination, BorderLayout.NORTH);

			ButtonGroup group = new ButtonGroup();
			JRadioButton newServer = new JRadioButton("Créer un nouveau serveur");
			JRadioButton joinServer = new JRadioButton("Rejoindre un serveur");
			newServer.setActionCommand("new");
			joinServer.setActionCommand("join");
			newServer.addActionListener(ViewPanel.this.checkRadio);
			joinServer.addActionListener(ViewPanel.this.checkRadio);
			group.add(newServer);
			group.add(joinServer);

			JPanel radioCountainer = new JPanel(new GridBagLayout());
			GridBagConstraints cRadio = new GridBagConstraints();
			cRadio.ipadx = 200;
			radioCountainer.add(newServer, cRadio);
			radioCountainer.add(joinServer, cRadio);
			serverSelector.add(radioCountainer, BorderLayout.SOUTH);
		}

		public void showCreate() {

		}

		public void showJoin() {

		}
	}
}
