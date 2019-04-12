package org.jsmart.zerocode.zerocodejavaexec.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.jsmart.zerocode.core.httpclient.BasicHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CustomHttpClient extends BasicHttpClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomHttpClient.class);

    public CustomHttpClient() {
        super();
        LOGGER.info("###0 Initialized");
    }

    public CustomHttpClient(CloseableHttpClient httpclient) {
        super(httpclient);
        LOGGER.info("###1 Initialized");
    }

    /**
     * Overridden this method in case you want to handle the headers differently which were passed
     * from the test-case requests or you need to add any custom headers etc.
     * If not overridden, The framework will fall back to this default implementation to handle this.
     */
    @Override
    public Map<String, Object> amendRequestHeaders(Map<String, Object> headers) {
        // ----------------------------------------------------
        // Add your custom headers here(if any).
        // e.g. Your auth tokens, client_id or client_secret etc
        // ----------------------------------------------------
        if (headers != null) {
            addCustomHeaders(headers);
        } else {
            headers = new HashMap<>();
            addCustomHeaders(headers);
        }

        return headers;
    }

    private void addCustomHeaders(Map<String, Object> headers) {
        String my_value = UUID.randomUUID().toString();
        String x_token_value = "secret_value_001";

        headers.put("header_key1", "header_value1");
        headers.put("x_token", x_token_value);

        LOGGER.info("###Added custom headers my_key={}, x_token={} to headers", my_value, x_token_value);
    }
}

