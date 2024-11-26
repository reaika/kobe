package com.example.AttendanceManage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class ConditionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testYourEndpoint() throws Exception{
        mockMvc.perform(get("/condition"))
                .andExpect(content().string(containsString("10:00:00")))
                .andExpect(content().string(containsString("13:15:28")));
    }
}
