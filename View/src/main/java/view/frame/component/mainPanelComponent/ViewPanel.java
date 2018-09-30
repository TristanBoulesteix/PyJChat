package view.frame.component.mainPanelComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewPanel extends JPanel {
	private static final long serialVersionUID = -8995991585591533480L;

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
			cTitleInit.insets = new Insets(0, 5, 6, 5);
			this.add(titleInit, cTitleInit);

		}
	}
}
