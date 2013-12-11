package ru.dadata.rest.client;

import ru.dadata.rest.EntityFactory;
import ru.dadata.rest.Version;
import ru.dadata.rest.impl.EntityFactoryBuilder;

public final class DataClientFactoryBuilder {
    private final EntityFactoryBuilder efb = new EntityFactoryBuilder();
    private String hostname = "dadata.ru";
    private String apiKey = null;
    private Version version = Version.VERSION_1;


    public DaDataClientFactory create() {
        EntityFactory factory = efb.createEntityFactory(version);
        return new DataClientFactoryImpl(hostname, apiKey, factory);
    }
}
