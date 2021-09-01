package com.reflexiones.textstoragewebapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
class TextStorageWebAppApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePage() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(content().string(containsString("Welcome to Reflexiones")));
    }

}
