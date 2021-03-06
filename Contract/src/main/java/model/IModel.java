package model;

public interface IModel {
	public void loadSettings();

	public Object getSettingsReader();

	public void initializeServerDatas();

	public String getVersion();

	public String getPseudo();

	public boolean setPseudo(String pseudo);

	public Object getCurrentIP();

	public boolean setCurrentIP() throws Exception;

	public boolean isServer();

	public Object getServerIP();

	public int getId();

	public String getAPP_DATA_PATH();
}