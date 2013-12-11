package ru.dadata.rest.client;

import ru.dadata.rest.Entity;
import ru.dadata.rest.QueryFieldType;

import java.io.Serializable;
import java.util.List;

public interface DaDataResult extends Serializable {

    public ResultCode getResultCode();

    public String getErrorDetail();

    public String getSource();

    public QueryFieldType[] getStructure();

    public List<Entity[]> getData();
}
