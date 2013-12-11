package ru.dadata.rest.impl;

import ru.dadata.rest.api.EntityFactory;
import ru.dadata.rest.api.Version;

public final class EntityFactoryBuilder {

    private EntityFactoryBuilder() {
    }

    public EntityFactory createEntityFactory(Version version) {
        switch (version) {
            case VERSION_1:
                return new ru.dadata.rest.v1.EntityFactoryImpl(version.queryPath);
        }
        throw new IllegalArgumentException("Version " + version + " not supported yet");
    }

    public static EntityFactoryBuilder getInstance() {
        return new EntityFactoryBuilder();
    }
}
