package model;

import java.util.concurrent.ThreadLocalRandom;

import model.chatObject.IPv4Adress;
import model.dao.SQLiteJDBC;
import model.dao.SettingsReader;

public class Model implements IModel {
	private final SettingsReader SETTINGS_READER;
	private final SQLiteJDBC DATABASE_READER;
	private final String APP_DATA_PATH;

	private String version;
	private String pseudo;
	private IPv4Adress currentIP;
	private boolean server;
	private IPv4Adress serverIP;
	private int id;

	public Model() {
		this.SETTINGS_READER = SettingsReader.getInstance();
		this.DATABASE_READER = SQLiteJDBC.getInstance();
		this.APP_DATA_PATH = this.SETTINGS_READER.getSettingINI().getFile().getAbsolutePath();
	}

	@Override
	public void loadSettings() {
		this.version = this.SETTINGS_READER.getValue("APP-SETTINGS", "version");

		String tempPseudo = this.SETTINGS_READER.getValue("APP-SETTINGS", "pseudo");
		this.pseudo = (tempPseudo.equals("null")) ? null : tempPseudo;

		try {
			String ip = this.SETTINGS_READER.getValue("CLIENT", "ip");
			this.currentIP = (this.SETTINGS_READER.getValue("CLIENT", "ip").equals("null")) ? null : new IPv4Adress(ip);

			ip = this.SETTINGS_READER.getValue("CHAT-SETTINGS", "ip");
			this.serverIP = (this.SETTINGS_READER.getValue("CHAT-SETTINGS", "ip").equals("null")) ? null
					: new IPv4Adress(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.server = Boolean.parseBoolean(this.SETTINGS_READER.getValue("CHAT-SETTINGS", "server"));

		this.id = Integer.parseInt(this.SETTINGS_READER.getValue("CHAT-SETTINGS", "chatID"));
	}

	@Override
	public void initializeServerDatas() {
		this.setChatId(ThreadLocalRandom.current().nextInt(0, 99 + 1));
		this.SETTINGS_READER.setValue("CHAT-SETTINGS", "server", Boolean.toString(true));
		this.SETTINGS_READER.setValue("CHAT-SETTINGS", "ip", this.currentIP.toString());
	}

	@Override
	public SettingsReader getSettingsReader() {
		return this.SETTINGS_READER;
	}

	@Override
	public String getVersion() {
		return this.version;
	}

	@Override
	public String getPseudo() {
		return this.pseudo;
	}

	@Override
	public boolean setPseudo(String pseudo) {
		this.pseudo = pseudo;
		return this.SETTINGS_READER.setValue("APP-SETTINGS", "pseudo", pseudo);
	}

	@Override
	public IPv4Adress getCurrentIP() {
		return this.currentIP;
	}

	@Override
	public boolean setCurrentIP() throws Exception {
		this.currentIP = new IPv4Adress();
		return this.SETTINGS_READER.setValue("CLIENT", "ip", this.currentIP.toString());
	}

	@Override
	public boolean isServer() {
		return this.server;
	}

	@Override
	public IPv4Adress getServerIP() {
		return this.serverIP;
	}

	@Override
	public int getId() {
		return this.id;
	}

	private void setChatId(int id) {
		this.SETTINGS_READER.setValue("CHAT-SETTINGS", "chatID", Integer.toString(id));
	}

	@Override
	public String getAPP_DATA_PATH() {
		return this.APP_DATA_PATH;
	}
}
