package fr.aelion.agedi.springdemo.intro.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntroServiceTest {

    private IntroService introSrv;

    @BeforeEach
    public void init() {
        this.introSrv = new IntroService();
        this.introSrv.init(); // can access this method from same package
    }

    @Test
    public void someTest() {
        assertTrue(true);
    }

    @Test
    public void hasRandomValue() {
        assertThat(this.introSrv.getRandom()).isNotNull();
    }

    @Test
    public void hello() {
        assertEquals("Hello world !!", this.introSrv.hello());
    }

}
