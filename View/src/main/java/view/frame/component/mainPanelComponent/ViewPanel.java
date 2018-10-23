package view.frame.component.mainPanelComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

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

		private JPanel serverSelector;
		private JPanel serverSelectorContainer = null;

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

			this.serverSelector = new JPanel();
			this.serverSelector.setLayout(new BorderLayout());
			this.serverSelector.setBackground(Color.LIGHT_GRAY);
			this.serverSelector.setBorder(new TitledBorder("Rejoindre une conversation"));

			GridBagConstraints cServerSelector = new GridBagConstraints();
			cServerSelector.gridx = 0;
			cServerSelector.gridy = 1;
			cServerSelector.weightx = 1.0;
			cServerSelector.insets = new Insets(2, 10, 2, 10);
			cServerSelector.fill = GridBagConstraints.BOTH;
			this.add(this.serverSelector, cServerSelector);
			JTextArea explaination = new JTextArea(
					"Vous n'êtes connecté à aucun chat pour le moment. Vous pouvez créer un nouveau serveur ou en rejoindre un.");
			explaination.setEditable(false);
			explaination.setEnabled(false);
			explaination.setDisabledTextColor(Color.BLACK);
			this.serverSelector.add(explaination, BorderLayout.NORTH);

			ButtonGroup group = new ButtonGroup();
			JRadioButton newServer = new JRadioButton("Créer un nouveau serveur");
			JRadioButton joinServer = new JRadioButton("Rejoindre un serveur");
			newServer.setActionCommand("create");
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
			this.serverSelector.add(radioCountainer, BorderLayout.CENTER);
		}

		private void updatePanelContent() {
			this.invalidate();
			this.repaint();
			this.revalidate();
		}

		public void showCreate() {
			if (this.serverSelectorContainer != null) {
				this.serverSelector.remove(this.serverSelectorContainer);
				this.updatePanelContent();
			}

			GridLayout layout = new GridLayout(2, 0);
			layout.setVgap(10);

			this.serverSelectorContainer = new JPanel(layout);

			JTextArea area = new JTextArea(
					"Vous êtes sur le point de créer un serveur de PyJChat. Cela signifie que vous conserverez l'historique des conversations. Si vous supprimez les données ou que vous désactivez l'application, tous les participants perdront leurs données.");
			area.setLineWrap(true);
			area.setWrapStyleWord(true);
			area.setEditable(false);
			area.setEnabled(false);
			area.setDisabledTextColor(new Color(0, 0, 255));
			this.serverSelectorContainer.add(area);

			JButton createServer = new JButton("Créer un serveur et démarrer le chat");
			createServer.setCursor(new Cursor(Cursor.HAND_CURSOR));
			createServer.setFont(new Font("Arial", Font.PLAIN, 18));
			this.serverSelectorContainer.add(createServer);

			this.serverSelector.add(this.serverSelectorContainer, BorderLayout.SOUTH);

			this.updatePanelContent();
		}

		public void showJoin() {
			if (this.serverSelectorContainer != null) {
				this.serverSelector.remove(this.serverSelectorContainer);
				this.updatePanelContent();
			}

			GridLayout layout = new GridLayout(3, 0);
			layout.setVgap(10);

			this.serverSelectorContainer = new JPanel(layout);

			JTextArea area = new JTextArea(
					"Pour vous connecter à un nouveau serveur, veuillez entrer la clef de serveur.");
			area.setLineWrap(true);
			area.setWrapStyleWord(true);
			area.setEditable(false);
			area.setEnabled(false);
			area.setDisabledTextColor(new Color(0, 0, 255));
			this.serverSelectorContainer.add(area);

			JTextField recordId = new JTextField();
			((AbstractDocument) recordId.getDocument()).setDocumentFilter(new LimitDocumentFilter(16));
			this.serverSelectorContainer.add(recordId);

			JButton validId = new JButton("Se connecter au serveur");
			validId.setCursor(new Cursor(Cursor.HAND_CURSOR));
			validId.setFont(new Font("Arial", Font.PLAIN, 18));
			this.serverSelectorContainer.add(validId);

			this.serverSelector.add(this.serverSelectorContainer, BorderLayout.SOUTH);

			this.updatePanelContent();
		}

		private class LimitDocumentFilter extends DocumentFilter {
			private int limit;

			public LimitDocumentFilter(int limit) {
				if (limit <= 0) {
					throw new IllegalArgumentException("Limit can not be <= 0");
				}
				this.limit = limit;
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				int currentLength = fb.getDocument().getLength();
				int overLimit = (currentLength + text.length()) - this.limit - length;
				if (overLimit > 0) {
					text = text.substring(0, text.length() - overLimit);
				}
				if (text.length() > 0) {
					super.replace(fb, offset, length, text, attrs);
				}
			}

		}
	}
}
