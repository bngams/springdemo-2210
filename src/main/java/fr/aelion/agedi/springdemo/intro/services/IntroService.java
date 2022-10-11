package fr.aelion.agedi.springdemo.intro.services;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;

@Log
@Getter
// @Component
@Service
@RequestScope
// @Service(scope = WebApplicationContext.SCOPE_REQUEST)
// @Scope(WebApplicationContext.SCOPE_REQUEST)
// @Scope("request")
public class IntroService {

    private Double random;

    IntroService() {
        log.info("IntroService constructor");
    }

    // hook
    @PostConstruct()
    void init() {
        log.info("IntroService init @PostConstruct");
        // replace init instructions from constructor
        this.random = Math.random();
    }

    public String hello() {
        return "Hello world !!";
    }

}
