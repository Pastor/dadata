package ru.dadata.rest.client;

import ru.dadata.rest.EntityFactory;

final class DataClientFactoryImpl implements DaDataClientFactory {
    private final String hostname;
    private final String apiKey;
    private final EntityFactory factory;

    DataClientFactoryImpl(String hostname, String apiKey, EntityFactory factory) {
        this.hostname = hostname;
        this.apiKey = apiKey;
        this.factory = factory;
    }

    @Override
    public DataClient createClient() {
        return new DataClientImpl(hostname, apiKey, factory);
    }
}
