package com.example.AttendanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ConditionController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AttendanceRepository attendancesRepository;

    @GetMapping("/condition")
    public String index(Model model) {
        List<Attendance> attendances = attendancesRepository.findAll();
        String sql = "SELECT * FROM attendance";
        model.addAttribute("attendances", attendances);

        System.out.println(jdbcTemplate.queryForList(sql));
        return "condition";
    }
}