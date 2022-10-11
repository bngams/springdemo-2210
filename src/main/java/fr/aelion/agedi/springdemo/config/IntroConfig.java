package fr.aelion.agedi.springdemo.config;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log
// <=> @Component
@Configuration
public class IntroConfig {

    // <=> Autowired
    // SpEL (Spring Expression Language)
    @Value("${app.name}")
    private String appName;

    @Autowired
    Environment env;

    @PostConstruct
    private void init() {
        log.info("Component IntroConfig is ready "
                + this.appName + ", "
                + this.env.getProperty("app.name"));
    }
}
