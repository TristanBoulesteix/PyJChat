package model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

public class SettingsReader {
	private final static String SETTINGS_NAME = "PyJChat/settings.ini";

	private static SettingsReader instance;
	private static String osName;

	private Wini settingINI;

	private SettingsReader() {
		SettingsReader.osName = (System.getProperty("os.name")).toUpperCase();

		try {
			this.initINIFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValue(String parent, String child) {
		return this.settingINI.get(parent, child);
	}

	public boolean setValue(String parent, String child, String data) {
		this.settingINI.put(parent, child, data);
		try {
			this.settingINI.store();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void initINIFiles() throws InvalidFileFormatException, IOException {
		File settingFile = new File(this.getEnvToStoreSettings(), SETTINGS_NAME);

		if (settingFile.exists() && !settingFile.isDirectory()) {
			this.settingINI = new Wini(settingFile);
		} else {
			File file = createINIFile(settingFile);
			this.settingINI = new Wini(file);
		}
	}

	private String getEnvToStoreSettings() {
		if (osName.contains("WIN")) {
			return System.getenv("APPDATA");

		} else {
			String workingDirectory = System.getProperty("user.home");
			workingDirectory += "/Library/Application Support";

			return workingDirectory;
		}
	}

	private File createINIFile(File settingFile) throws IOException {
		File settingModel = new File(getClass().getClassLoader().getResource("settingsModel.ini").getFile());
		settingFile.getParentFile().mkdirs();
		settingFile.createNewFile();

		BufferedReader bufferR = new BufferedReader(new FileReader(settingModel));
		BufferedWriter bufferW = new BufferedWriter(new FileWriter(settingFile));

		String line;

		while ((line = bufferR.readLine()) != null) {
			bufferW.write(line);
			bufferW.newLine();
		}

		bufferR.close();
		bufferW.close();

		return settingFile;
	}

	public static SettingsReader getInstance() {
		return (instance == null) ? instance = new SettingsReader() : instance;
	}
}
