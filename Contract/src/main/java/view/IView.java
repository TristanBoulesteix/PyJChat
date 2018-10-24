package view;

import javax.swing.JFrame;

import contract.util.Observer;

public interface IView {
	public String askForPseudo();

	public void showErrorPopup(Object message, String title);

	public void showUnknownErrorPopup();

	public JFrame getFrame();

	public void initNewChat(Observer controller);
}
