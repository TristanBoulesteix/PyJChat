package view.frame.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ParticipantPanel extends JPanel {
	private static final long serialVersionUID = -6477239056444259015L;
	private static final Dimension DEFAULT_DIMENSION = new Dimension(400, 100);

	private JTextField label;
	private JScrollPane participantList;

	public ParticipantPanel() {
		this.setLayout(new BorderLayout(0, 0));
		this.setPreferredSize(DEFAULT_DIMENSION);
		this.setMinimumSize(DEFAULT_DIMENSION);

		this.label = new JTextField();
		this.label.setHorizontalAlignment(SwingConstants.CENTER);
		this.label.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.label.setDisabledTextColor(Color.WHITE);
		this.label.setBackground(Color.BLACK);
		this.label.setEnabled(false);
		this.label.setEditable(false);
		this.label.setText("Participants");
		this.add(this.label, BorderLayout.NORTH);
		this.label.setColumns(10);

		this.participantList = new JScrollPane();
		this.add(this.participantList, BorderLayout.CENTER);
	}

}
