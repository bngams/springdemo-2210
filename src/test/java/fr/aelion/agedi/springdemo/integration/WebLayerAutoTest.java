package fr.aelion.agedi.springdemo.integration;

import fr.aelion.agedi.springdemo.intro.controllers.IntroController;
import fr.aelion.agedi.springdemo.intro.services.IntroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerAutoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloEndpointShouldReturnDefaultMessage() throws Exception {
        String url = "/intro/hello";
        String wantedMessage = "Hello world !!";
        this.mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string(containsString(wantedMessage)));
    }
}
