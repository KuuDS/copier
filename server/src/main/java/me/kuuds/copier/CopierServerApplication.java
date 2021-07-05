package me.kuuds.copier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Spring Application Context
 *
 * @since 1.0.0
 */
@EntityScan("me.kuuds.copier.domain")
@SpringBootApplication
public class CopierServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CopierServerApplication.class, args);
    }
}
