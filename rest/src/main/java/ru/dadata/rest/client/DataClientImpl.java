package ru.dadata.rest.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.BasicClientConnectionManager;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.log4j.Logger;
import ru.dadata.rest.api.DataClient;
import ru.dadata.rest.api.DataRequest;
import ru.dadata.rest.api.DataResult;
import ru.dadata.rest.api.EntityFactory;

import java.net.URISyntaxException;

final class DataClientImpl implements DataClient {
    private static final Logger LOGGER = Logger.getLogger(DataClientImpl.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final SchemeRegistry sr = SchemeRegistryFactory.createDefault();
    private final BasicClientConnectionManager ccm = new BasicClientConnectionManager(sr);
    private final DefaultHttpClient client = new DefaultHttpClient(ccm);
    private final String hostname;
    private final String apiKey;
    private final EntityFactory factory;

    DataClientImpl(String hostname, String apiKey, EntityFactory factory) {
        this.hostname = hostname;
        this.apiKey = apiKey;
        this.factory = factory;
    }

    protected HttpRequestBase createRequest(DataRequest request) throws URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http").setHost(hostname).setPath(factory.getQueryPath());
        HttpPost post = new HttpPost(builder.build());
        if (apiKey != null && !apiKey.isEmpty())
            post.addHeader("Authorization", "Token " + apiKey);
        String requestText = GSON.toJson(request);
        LOGGER.debug("Request text: " + requestText);
        post.setEntity(new StringEntity(requestText, ContentType.APPLICATION_JSON));
        return post;
    }

    @Override
    public DataResult execute(DataRequest request) {
        try {
            HttpRequestBase httpRequest = createRequest(request);
            HttpResponse response = client.execute(httpRequest);
            return factory.createResult(response);
        } catch (Exception ex) {
            LOGGER.error("Error execute request", ex);
            return null;
        }
    }
}
