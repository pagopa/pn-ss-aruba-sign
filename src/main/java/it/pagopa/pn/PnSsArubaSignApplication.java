package it.pagopa.pn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ConfigurationPropertiesScan

@PropertySource("classpath:pnssarubasign.properties")
public class PnSsArubaSignApplication {
    public static void main(String[] args) {
        SpringApplication.run(PnSsArubaSignApplication.class, args);
    }

}
