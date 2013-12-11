package ru.dadata.rest;

import ru.dadata.rest.api.Version;

import java.io.InputStream;
import java.util.Properties;

public final class TestConfig {
    private String apiKey;
    private String hostname = "dadata.ru";
    private String version = Version.VERSION_1.bref;

    public String getApiKey() {
        return apiKey;
    }

    public String getHostname() {
        return hostname;
    }

    public Version getVersion() {
        return Version.fromBref(version);
    }

    private TestConfig(InputStream stream) {
        load(stream);
    }

    private void load(InputStream stream) {
        Properties prop = new Properties();
        try {
            prop.load(stream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        apiKey = prop.getProperty("api_key");
        hostname = prop.getProperty("hostname", hostname);
        version = prop.getProperty("version", version);
    }

    public static TestConfig getDefault() {
        if (defaultInstance == null) {
            synchronized (TestConfig.class) {
                if (defaultInstance == null) {
                    defaultInstance = new TestConfig(TestConfig.class.getResourceAsStream("/dadata.properties"));
                }
            }
        }
        return defaultInstance;
    }


    private static TestConfig defaultInstance;
}
