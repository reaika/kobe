package com.example.AttendanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class AttendanceManageApplication {
	public static void main(String[] args) {
		SpringApplication.run(AttendanceManageApplication.class, args);
	}
}
