package model;

import contract.model.IModel;
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
		this.pseudo = this.setReader.getValue("APP-SETTINGS", "pseudo");

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
}
