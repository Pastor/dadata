package ru.dadata.rest.client;

import org.apache.http.client.methods.HttpRequestBase;
import org.junit.Before;
import org.junit.Test;
import ru.dadata.rest.DataRequestBuilder;
import ru.dadata.rest.EntityFactory;
import ru.dadata.rest.QueryFieldType;
import ru.dadata.rest.TestConfig;
import ru.dadata.rest.impl.EntityFactoryBuilder;

import static junit.framework.Assert.assertEquals;

public class DaDataClientImplTest {
    private DataClientImpl clientImpl;
    private EntityFactory factory;
    private final EntityFactoryBuilder buider = EntityFactoryBuilder.getInstance();
    private final TestConfig config = TestConfig.getDefault();
    private final DataRequestBuilder requestBuilder = new DataRequestBuilderImpl();

    @Before
    public void setUp() throws Exception {
        factory = buider.createEntityFactory(config.getVersion());
        clientImpl = new DataClientImpl(config.getHostname(), config.getApiKey(), factory);
    }

    @Test
    public void testCreateRequest() throws Exception {
        HttpRequestBase request = clientImpl.createRequest(requestBuilder.create());
        System.out.println(request);
    }

    @Test
    public void testExecuteIllegalRequest() throws Exception {
        DaDataResult result = clientImpl.execute(requestBuilder.create());
        assertEquals(result.getResultCode(), ResultCode.ILLEGAL_REQUEST);
    }

    @Test
    public void testExecuteIllegalApiKey() throws Exception {
        clientImpl = new DataClientImpl(config.getHostname(), null, factory);
        DaDataResult result = clientImpl.execute(requestBuilder.create());
        assertEquals(result.getResultCode(), ResultCode.ILLEGAL_API_KEY);
    }

    @Test
    public void testFull() throws Exception {
        requestBuilder.reset();
        clientImpl = new DataClientImpl(config.getHostname(), config.getApiKey(), factory);
        requestBuilder.addRecord().set(QueryFieldType.AS_IS, "AsIs");
        DaDataResult result = clientImpl.execute(requestBuilder.create());
        assertEquals(result.getResultCode(), ResultCode.SUCCESS);
    }
}
