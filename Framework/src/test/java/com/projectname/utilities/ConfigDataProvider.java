package com.projectname.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;

	public ConfigDataProvider() {
		try {
			FileInputStream fis = new FileInputStream("Configs/Config.properties");
			prop = new Properties();

			prop.load(fis);

		} catch (Exception e) {
			System.out.println("Unable to load config file>> " + e.getMessage());
		}
	}

	public String getDataFromConfig(String keyToSearch) {
		return prop.getProperty(keyToSearch);
	}
}
