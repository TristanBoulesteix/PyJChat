package model.chatObject;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class IPv4Adress {
	private final String PART1, PART2, PART3, PART4;

	public IPv4Adress(String ip) throws Exception {
		if (!isValidIPv4(ip)) {
			throw new Exception("Wrong ip format");
		}

		String[] ipInArray = ip.split("\\.");

		this.PART1 = ipInArray[0];
		this.PART2 = ipInArray[1];
		this.PART3 = ipInArray[2];
		this.PART4 = ipInArray[3];
	}

	public IPv4Adress() throws Exception {
		this(getCurrentIP());
	}

	private static String getCurrentIP() {
		try (final DatagramSocket socket = new DatagramSocket()) {
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			return socket.getLocalAddress().getHostAddress();

		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean isValidIPv4(String ip) {
		if (ip == null || ip.isEmpty())
			return false;
		ip = ip.trim();
		if ((ip.length() < 6) & (ip.length() > 15))
			return false;

		try {
			Pattern pattern = Pattern.compile(
					"^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
			Matcher matcher = pattern.matcher(ip);
			return matcher.matches();
		} catch (PatternSyntaxException ex) {
			return false;
		}
	}

	@Override
	public String toString() {
		return PART1 + "." + PART2 + "." + PART3 + "." + PART4;
	}
}
