package ru.dadata.rest.impl;

import ru.dadata.rest.EntityFactory;

public abstract class AbstractEntityFactory implements EntityFactory {
    private final String queryPath;

    public AbstractEntityFactory(String queryPath) {
        this.queryPath = queryPath;
    }

    @Override
    public String getQueryPath() {
        return queryPath;
    }
}
