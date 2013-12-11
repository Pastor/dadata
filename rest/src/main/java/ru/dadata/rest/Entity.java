package ru.dadata.rest;

import java.io.Serializable;

public interface Entity extends Serializable {

    public String getSource();

    public QualityCode getGC();

    public QualityCodeComplete getGCComplete();

    public QueryFieldType getEntityType();
}
