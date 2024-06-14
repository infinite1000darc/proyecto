package com.tuempresa.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class CompraServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompraServiceApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean jaxWsServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new com.sun.xml.ws.transport.http.servlet.WSServlet(), "/ws/*");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public Endpoint endpoint(CompraService compraService) {
        Endpoint endpoint = Endpoint.publish("/CompraService", new CompraServiceEndpoint(compraService));
        return endpoint;
    }
}

