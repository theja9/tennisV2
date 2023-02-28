package com.spring.tennisV2.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TennisController.class)
public class TennisControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void testIncrement(int expected) throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/tennis/updateScore?scorer=playerOne");
        MvcResult mvcResult = mockmvc.perform(request)
                .andExpect(status().isOk()).andReturn();
        int actual = Integer.parseInt(mvcResult.getResponse().getContentAsString());
        assertEquals(expected, actual);
    }

}
