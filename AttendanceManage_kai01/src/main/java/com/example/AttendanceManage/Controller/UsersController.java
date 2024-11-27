package com.example.AttendanceManage.Controller;

import com.example.AttendanceManage.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class UsersController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public String index(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "roleAdmin/users";
    }
}

