package ru.dadata.rest.api;

public interface DataRequestBuilder {

    public DataRequest create();

    public DataRequestBuilder set(QueryFieldType type, String data);

    public DataRequestBuilder addRecord();

    public DataRequestBuilder reset();

}
