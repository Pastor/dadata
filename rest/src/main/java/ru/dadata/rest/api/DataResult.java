package ru.dadata.rest.api;

import java.io.Serializable;
import java.util.List;

public interface DataResult extends Serializable {

    public DataResultCode getResultCode();

    public String getErrorDetail();

    public String getSource();

    public QueryFieldType[] getStructure();

    public List<Entity[]> getData();
}
