package ru.dadata.rest.client;

import org.junit.Before;
import org.junit.Test;
import ru.dadata.rest.api.DataRequest;
import ru.dadata.rest.api.DataRequestBuilder;
import ru.dadata.rest.api.QueryFieldType;

import static junit.framework.Assert.assertEquals;

public class DataRequestBuilderImplTest {
    private final DataRequestBuilder builder = new DataRequestBuilderImpl();

    @Before
    public void setUp() throws Exception {
        builder.reset();
    }

    @Test
    public void testReset() throws Exception {
        DataRequest request = builder.addRecord()
                .set(QueryFieldType.AS_IS, "1")
                .set(QueryFieldType.ADDRESS, "address").reset().create();
        assertEquals(request.structure.length, 0);
    }

    @Test
    public void testAddRecord() throws Exception {
        DataRequest request = builder.addRecord().set(QueryFieldType.AS_IS, "1").create();
        assertEquals(request.structure.length, 1);
        assertEquals(request.data.size(), 1);
    }
}
