package com.spring.tennisV2.controller;

import com.spring.tennisV2.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TennisController.class)
public class TennisControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private PlayerService players;

    @Test
    public void updateScore() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/tennis/updateScore?scorer=playerOne");
        mockmvc.perform(request)
                .andExpect(status().isOk());
    }
}
