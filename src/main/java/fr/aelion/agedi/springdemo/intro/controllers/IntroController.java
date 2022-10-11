package fr.aelion.agedi.springdemo.intro.controllers;

import fr.aelion.agedi.springdemo.intro.services.IntroService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

// Lombok =>
@Log
// @Component => Bean
// servlet
@Controller
public class IntroController {
    // @Autowired => if attribute is private => @Autowired and DI in constructor
    private IntroService is;

    // Dependency Injection - Ioc (Inversion of control)
    // is = new IntroService();
    // Application.context.store(is);
    // ic = new IntroController(Application.context.get(IntroService.class))
    @Autowired
    IntroController(IntroService is) {
        log.info("IntroController constructor");
        // used only for DI (dependency injection)
        // and spring logic
        // use @PostConstruct() for object initialization
        this.is = is;
    }

    // hook
    @PostConstruct()
    void init() {
        log.info("IntroController init @PostConstruct");
        // replace init instructions from constructor
    }

    // servlet method
    @RequestMapping("/intro/hello")
    // return => HTTP body
    @ResponseBody
    public String hello() {
        return this.is.hello();
    }

    @RequestMapping("/intro/is/random")
    // return => HTTP body
    @ResponseBody
    public Double getRandom() {
        return this.is.getRandom();
    }

}
