package contract.model;

import model.IPv4Adress;
import model.dao.SettingsReader;

public interface IModel {
	public void loadSettings();

	public SettingsReader getSetReader();

	public String getVersion();

	public String getPseudo();

	public IPv4Adress getCurrentIP();

	public boolean isServer();

	public IPv4Adress getServerIP();

	public int getId();
}