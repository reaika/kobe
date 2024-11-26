package com.example.AttendanceManage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * 演習問題３２
 * 単体テスト（UnitTest）のプログラム
 * ブラウザを立ち上げずにページ内の状態をテストすることが出来る
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AttendanceInputControllerTest {
    @Autowired
    private MockMvc mokMvc;

    /**
     * AttendanceInputのGetをテストします
     * 合格条件
     * HTTPレスポンスのステータスが２００であること
     * ページ内に文字列「出勤」が含まれていること
     * ページ内に文字列「出勤出勤」が含まれていないこと
     * @throws Exception
     */
    @Test
    public void testAttendanceInput() throws Exception {
        mokMvc.perform(get("/AttendanceInput"))
                .andExpect(status().is(200))
                .andExpect(content().string(containsString("出勤")))
                .andExpect(content().string(not(containsString("出勤出勤"))));
    }

}
