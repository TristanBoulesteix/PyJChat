package view;

import javax.swing.JFrame;

public interface IView {
	public String askForPseudo();

	public void showErrorPopup(Object message, String title);

	public void showUnknownErrorPopup();

	public JFrame getFrame();

	public void initNewChat();
}
