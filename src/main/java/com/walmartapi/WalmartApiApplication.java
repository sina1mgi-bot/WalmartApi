package com.walmartapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WalmartApiApplication {
    //maven.clean: descarga las dependencias: valida que tengamos la version actual y descarga las dependencias
    //maven.compile: compila
    //maven nos ayuda a llevar el ciclo de vida de nuestra aplicación.



    public static void main(String[] args) {
        SpringApplication.run(WalmartApiApplication.class, args);
    }

}
