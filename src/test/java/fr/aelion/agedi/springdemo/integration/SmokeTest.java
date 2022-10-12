package fr.aelion.agedi.springdemo.integration;

import fr.aelion.agedi.springdemo.intro.controllers.IntroController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private IntroController introController;

    @Test
    public void contextLoads() {
        assertThat(this.introController).isNotNull();
    }

    @Test
    public void introControllerHasInitialState() {
        assertTrue(this.introController.getInitialized());
    }
}
