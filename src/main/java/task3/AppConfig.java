package task3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Plane getgetThePlane(){
        Plane plane = new Plane();
        plane.setModel("B380");
        return plane;
    }
}
