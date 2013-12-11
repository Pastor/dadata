package ru.dadata.rest.client;

import org.junit.Before;
import org.junit.Test;
import ru.dadata.rest.TestConfig;
import ru.dadata.rest.api.*;

import static junit.framework.Assert.assertEquals;

public class DaDataClientImplTest {
    private DataClient client;
    private final DataClientFactoryBuilder clientBuilder = DataClientFactoryBuilder.getDefault();
    private final TestConfig config = TestConfig.getDefault();
    private final DataRequestBuilder requestBuilder = new DataRequestBuilderImpl();

    @Before
    public void setUp() throws Exception {
        clientBuilder.setApiKey(config.getApiKey());
        clientBuilder.setHostname(config.getHostname());
        clientBuilder.setVersion(config.getVersion());
        client = clientBuilder.create().createClient();
    }

    @Test
    public void testExecuteIllegalRequest() throws Exception {
        DataResult result = client.execute(requestBuilder.create());
        assertEquals(result.getResultCode(), DataResultCode.ILLEGAL_REQUEST);
    }

    @Test
    public void testExecuteIllegalApiKey() throws Exception {
        clientBuilder.setApiKey(null);
        DataClient client = clientBuilder.create().createClient();
        DataResult result = client.execute(requestBuilder.create());
        assertEquals(result.getResultCode(), DataResultCode.ILLEGAL_API_KEY);
    }

    @Test
    public void testFull() throws Exception {
        requestBuilder.reset();
        requestBuilder.addRecord().set(QueryFieldType.AS_IS, "AsIs");
        DataResult result = client.execute(requestBuilder.create());
        assertEquals(result.getResultCode(), DataResultCode.SUCCESS);
    }
}
