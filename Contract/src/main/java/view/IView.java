package view;

public interface IView {
	public String askForPseudo();

	public void showErrorPopup(Object message, String title);

	public void showUnknownErrorPopup();
}
