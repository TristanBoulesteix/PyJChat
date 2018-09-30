package view.frame.component.mainPanelComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

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
		}
	}
}
