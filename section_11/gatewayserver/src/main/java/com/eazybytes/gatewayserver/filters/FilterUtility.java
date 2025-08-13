package com.eazybytes.gatewayserver.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtility {

    public static final String CORRELATION_ID = "eazybank-correlation-id";

    public String getCorrelationId(HttpHeaders requestHeaders) {
        if (requestHeaders != null) {
            List<String> requestHeaderList = requestHeaders.get(CORRELATION_ID);
            if (requestHeaderList != null && !requestHeaderList.isEmpty()) {
                return requestHeaderList.stream().findFirst().orElse(null);
            }
        }
        return null;
    }

    public ServerWebExchange setCorrelationHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return setCorrelationHeader(exchange, CORRELATION_ID, correlationId);
    }
}
