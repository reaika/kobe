package com.example.AttendanceManage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

/* Copilotさんによると perform(get())、 status()、 content()、 containsString()、 not()*/
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@SpringBootTest
@AutoConfigureMockMvc
public class AttendanceInputControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testIndex() throws Exception{
        mockMvc.perform(get("/AttendanceInput"))
                // status=200 ==成功  https://qiita.com/ryo2132/items/ec10116238e1e1f333a1
                .andExpect(status().is(200))
                .andExpect(content().string(containsString("出勤")) )
                .andExpect(content().string(not(containsString("出勤出勤") )));
    }
}
