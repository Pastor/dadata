package ru.dadata.rest;

import ru.dadata.rest.client.DataRequest;

public interface DataRequestBuilder {

    public DataRequest create();

    public DataRequestBuilder set(QueryFieldType type, String data);

    public DataRequestBuilder addRecord();

    public DataRequestBuilder reset();

}
