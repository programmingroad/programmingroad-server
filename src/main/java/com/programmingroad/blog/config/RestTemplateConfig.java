package com.programmingroad.blog.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author: programmingroad
 * @create: 2019/10/06 11:43
 * @description:
 **/

@Configuration
public class RestTemplateConfig {

    @Value("${httpclient.soTimeout}")
    private int soTimeout;

    @Value("${httpclient.conTimeout}")
    private int conTimeout;

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }

    private HttpClient httpClient() {
        //不使用连接池，后续根据性能情况再考虑
        BasicHttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager();

        RequestConfig requestConfig = RequestConfig.custom()
                // 服务器返回数据(response)的时间，超过该时间抛出read timeout
                .setSocketTimeout(soTimeout)
                // 连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
                .setConnectTimeout(conTimeout)
                .setCookieSpec(CookieSpecs.STANDARD)
                .build();

        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();
    }
}
