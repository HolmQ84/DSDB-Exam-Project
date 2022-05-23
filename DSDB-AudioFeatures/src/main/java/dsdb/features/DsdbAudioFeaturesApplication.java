package dsdb.features;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DsdbAudioFeaturesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsdbAudioFeaturesApplication.class, args);
    }

}
