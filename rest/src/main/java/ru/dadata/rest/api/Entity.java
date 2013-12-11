package ru.dadata.rest.api;

import java.io.Serializable;

public interface Entity extends Serializable {

    public String getSource();

    public QualityCode getQC();

    public QualityCodeComplete getQCComplete();

    public QueryFieldType getEntityType();
}
