package ru.dadata.rest;

import org.apache.http.HttpResponse;
import ru.dadata.rest.client.DaDataResult;

public interface EntityFactory {

    public String getQueryPath();

    public EntityName createEntityName();

    public EntityAddress createEntityAddress();

    public EntityPhone createEntityPhone();

    public DaDataResult createResult(HttpResponse response);
}
