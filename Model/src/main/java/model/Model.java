package model;

import model.dao.SettingsReader;

public class Model implements IModel {
	private SettingsReader setReader;
	private String version;
	private String pseudo;
	private IPv4Adress currentIP;
	private boolean server;
	private IPv4Adress serverIP;
	private int id;

	public Model() {
		this.setReader = SettingsReader.getInstance();
	}

	@Override
	public void loadSettings() {
		this.version = this.setReader.getValue("APP-SETTINGS", "version");

		String tempPseudo = this.setReader.getValue("APP-SETTINGS", "pseudo");
		this.pseudo = (tempPseudo.equals("null")) ? null : tempPseudo;

		try {
			String ip = this.setReader.getValue("CLIENT", "ip");
			this.currentIP = (this.setReader.getValue("CLIENT", "ip").equals("null")) ? null : new IPv4Adress(ip);

			ip = this.setReader.getValue("CHAT-SETTINGS", "ip");
			this.serverIP = (this.setReader.getValue("CHAT-SETTINGS", "ip").equals("null")) ? null : new IPv4Adress(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.server = Boolean.parseBoolean(this.setReader.getValue("CHAT-SETTINGS", "server"));

		this.id = Integer.parseInt(this.setReader.getValue("CHAT-SETTINGS", "chatID"));
	}

	@Override
	public SettingsReader getSetReader() {
		return setReader;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public String getPseudo() {
		return pseudo;
	}

	@Override
	public boolean setPseudo(String pseudo) {
		this.pseudo = pseudo;
		return this.setReader.setValue("APP-SETTINGS", "pseudo", pseudo);
	}

	@Override
	public IPv4Adress getCurrentIP() {
		return currentIP;
	}

	@Override
	public boolean setCurrentIP() throws Exception {
		this.currentIP = new IPv4Adress();
		return this.setReader.setValue("CLIENT", "ip", this.currentIP.toString());
	}

	@Override
	public boolean isServer() {
		return server;
	}

	@Override
	public IPv4Adress getServerIP() {
		return serverIP;
	}

	@Override
	public int getId() {
		return id;
	}

}
