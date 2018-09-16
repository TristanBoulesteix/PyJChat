package model;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import contract.model.IModel;
import model.dao.SettingsReader;

public class Model implements IModel {
	private SettingsReader setReader;
	private String currentIP;
	private String serverIP;

	public Model() {
		try (final DatagramSocket socket = new DatagramSocket()) {
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			this.currentIP = socket.getLocalAddress().getHostAddress();
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}

		this.setReader = SettingsReader.getInstance();
	}

	@Override
	public void loadSettings() {

	}
}
