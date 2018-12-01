package by.training.nc.sd2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
public class BackendApplication
{
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);

    }
}
