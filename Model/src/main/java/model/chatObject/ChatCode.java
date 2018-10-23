package model.chatObject;

public class ChatCode {
	private boolean valide = false;
	private IPv4Adress serverAdress;
	private int chatId;

	public ChatCode(String ip, String chatId) throws IllegalArgumentException, NumberFormatException {
		try {
			this.serverAdress = new IPv4Adress(ip);
		} catch (Exception e) {
			throw new IllegalArgumentException("Ivalid IP adress");
		}

		if (this.isInteger(chatId)) {
			this.chatId = Integer.parseInt(chatId);
		} else {
			throw new NumberFormatException("Invalid id");
		}

		this.valide = true;
	}

	public ChatCode(ChatCode chatCode) throws IllegalArgumentException, NumberFormatException {
		this(chatCode.getServerAdress().toString(), Integer.toString(chatCode.getChatId()));
	}

	private boolean isInteger(String str) {
		if (str == null || str.trim().isEmpty()) {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidity() {
		return this.valide;
	}

	public IPv4Adress getServerAdress() {
		return this.serverAdress;
	}

	public int getChatId() {
		return this.chatId;
	}
}
