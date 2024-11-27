package com.example.AttendanceManage.Repository;
import com.example.AttendanceManage.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<User> findAll(){
        String sql = "select * from users";
        List<User> list = new ArrayList<>();
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);

        for(int i=0; i< mapList.size(); i++){
            Map<String,Object> map = mapList.get(i);
        }
        return list;
    }
}
