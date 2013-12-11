package ru.dadata.rest.client;

import ru.dadata.rest.api.DataClientFactory;
import ru.dadata.rest.api.EntityFactory;
import ru.dadata.rest.api.Version;
import ru.dadata.rest.impl.EntityFactoryBuilder;

public final class DataClientFactoryBuilder {
    private final EntityFactoryBuilder efb = EntityFactoryBuilder.getInstance();
    private String hostname = "dadata.ru";
    private String apiKey = null;
    private Version version = Version.VERSION_1;

    private DataClientFactoryBuilder() {
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public DataClientFactory create() {
        EntityFactory factory = efb.createEntityFactory(version);
        return new DataClientFactoryImpl(hostname, apiKey, factory);
    }

    public static DataClientFactoryBuilder getDefault() {
        if (defaultInstance == null) {
            synchronized (DataClientFactoryBuilder.class) {
                if (defaultInstance == null) {
                    defaultInstance = new DataClientFactoryBuilder();
                }
            }
        }
        return defaultInstance;
    }

    private static DataClientFactoryBuilder defaultInstance;
}
