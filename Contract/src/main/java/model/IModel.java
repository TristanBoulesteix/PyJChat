package model;

public interface IModel {
	public void loadSettings();

	public Object getSetReader();

	public String getVersion();

	public String getPseudo();

	public Object getCurrentIP();

	public boolean isServer();

	public Object getServerIP();

	public int getId();
}