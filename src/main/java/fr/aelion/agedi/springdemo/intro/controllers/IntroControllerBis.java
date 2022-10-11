package fr.aelion.agedi.springdemo.intro.controllers;

import fr.aelion.agedi.springdemo.config.IntroConfig;
import fr.aelion.agedi.springdemo.intro.services.IntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller + @ResponseBody
@RestController
@RequestMapping("/introbis")
public class IntroControllerBis {

    // @RequestMapping
    // complete url /introbis/is/random
    @GetMapping("/is/random")
    public Double getRandom() {
        return this.is.getRandom();
    }

    @Autowired // @Autowired on attribute => attribute not private
    IntroService is;

    @Autowired // @Autowired on attribute => attribute not private
    IntroConfig conf;
}
