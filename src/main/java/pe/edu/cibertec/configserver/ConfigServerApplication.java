package pe.edu.cibertec.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Servidor de configuración centralizada (Spring Cloud Config).
 * Los cuatro microservicios le piden su configuración al arrancar,
 * en lugar de tener cada uno sus propios valores repetidos.
 */
@SpringBootApplication
@EnableConfigServer // convierte esta aplicación en un Config Server
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
