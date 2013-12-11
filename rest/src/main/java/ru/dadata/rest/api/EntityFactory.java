package ru.dadata.rest.api;

import org.apache.http.HttpResponse;

public interface EntityFactory {

    public String getQueryPath();

    public EntityName createEntityName();

    public EntityAddress createEntityAddress();

    public EntityPhone createEntityPhone();

    public DataResult createResult(HttpResponse response);
}
