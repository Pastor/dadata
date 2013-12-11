package ru.dadata.rest.v1;

import org.apache.http.HttpResponse;
import ru.dadata.rest.EntityAddress;
import ru.dadata.rest.EntityName;
import ru.dadata.rest.EntityPhone;
import ru.dadata.rest.client.DaDataResult;
import ru.dadata.rest.impl.AbstractEntityFactory;

public final class EntityFactoryImpl extends AbstractEntityFactory {

    public EntityFactoryImpl(String queryPath) {
        super(queryPath);
    }

    @Override
    public EntityName createEntityName() {
        return new EntityImpl1v();
    }

    @Override
    public EntityAddress createEntityAddress() {
        return new EntityImpl1v();
    }

    @Override
    public EntityPhone createEntityPhone() {
        return new EntityImpl1v();
    }

    @Override
    public DaDataResult createResult(HttpResponse response) {
        return new DataResultImpl(response);
    }
}
