package com.spring.tennisV2.controller;

import com.spring.tennisV2.exception.IllegalScorerException;
import com.spring.tennisV2.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TennisController.class)
public class TennisControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private PlayerService players;

    @ParameterizedTest
    @ValueSource(strings = {"playerOne", "playerTwo"})
    public void updateScore(String scorer) throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/tennis/updateScore?scorer=" + scorer);
        mockmvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void ScorerException() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/tennis/updateScore?scorer=two");
        mockmvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalScorerException));
    }

}
