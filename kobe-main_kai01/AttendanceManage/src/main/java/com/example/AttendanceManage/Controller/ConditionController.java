package com.example.AttendanceManage.Controller;

import com.example.AttendanceManage.Repository.AttendanceRepository;
import com.example.AttendanceManage.Service.AttendanceService;
import com.example.AttendanceManage.Model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ConditionController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AttendanceRepository attendancesRepository;
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/condition")
    public String index(Model model) {
        List<Attendance> attendances = attendancesRepository.findAll();
        String sql = "SELECT * FROM attendance";
        model.addAttribute("attendances", attendances);

        System.out.println(jdbcTemplate.queryForList(sql));
        return "condition";
    }


    @PostMapping("/checkin")
    public String checkIn() {
        attendanceService.checkIn();

        return "redirect:/AttendanceInput";
    }

    @PostMapping("/checkout")
    public String checkOut() {
        attendanceService.checkOut();
        return "redirect:/AttendanceInput";
    }

}