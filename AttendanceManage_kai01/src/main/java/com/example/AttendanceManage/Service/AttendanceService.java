package com.example.AttendanceManage.Service;

import com.example.AttendanceManage.Repository.AttendanceRepository;
import com.example.AttendanceManage.Model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public void checkIn() {
        Attendance attendance = new Attendance();
        attendance.setBegin_time(new Time(System.currentTimeMillis()));
        attendance.setId(generateNewId());
        attendanceRepository.save(attendance);
    }

    public void checkOut() {
        Attendance attendance = attendanceRepository.findTopByOrderByIdDesc();
        attendance.setEnd_time(new Time(System.currentTimeMillis()));
        attendanceRepository.save(attendance);
    }

    private int generateNewId() {
        Integer maxId = attendanceRepository.findMaxId();
        return (maxId != null ? maxId : 0) + 1;
    }
}
