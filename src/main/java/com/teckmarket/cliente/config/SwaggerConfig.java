package com.teckmarket.cliente.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("API Clientes - TechMarket")
                        .version("1.0.0")
                        .description("API REST para cadastro e consulta de clientes. Pratica de desafio Java com SpringBoot.")
                        .contact(new Contact()
                                .name("Danilo Henrique")
                                .email("hddanilosilva@gmail.com")
                                .url("https://devnutella.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")));
    }
}
