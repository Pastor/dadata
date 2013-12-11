package ru.dadata.rest.v1;

import org.apache.http.HttpResponse;
import ru.dadata.rest.api.DataResult;
import ru.dadata.rest.api.EntityAddress;
import ru.dadata.rest.api.EntityName;
import ru.dadata.rest.api.EntityPhone;
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
    public DataResult createResult(HttpResponse response) {
        return new DataResultImpl(response);
    }
}
