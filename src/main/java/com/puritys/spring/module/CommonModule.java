package com.puritys.spring.module;

import com.google.inject.AbstractModule;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.util.Timeout;

public class CommonModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(CloseableHttpAsyncClient.class).toInstance(this.getClient());
    }

    private CloseableHttpAsyncClient getClient() {
        final IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
                .setSoTimeout(Timeout.ofSeconds(5))
                .build();

        CloseableHttpAsyncClient client = HttpAsyncClients.custom()
                .setIOReactorConfig(ioReactorConfig)
                .build();

        client.start();
        return client;
    }


}
