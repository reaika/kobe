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
        attendance.setAtt_workstart(new Time(System.currentTimeMillis()));
        attendance.setEmpid(generateNewEmpid());
        attendanceRepository.save(attendance);
    }

    public void checkOut() {
        Attendance attendance = attendanceRepository.findTopByOrderByEmpidDesc();
        attendance.setAtt_workend(new Time(System.currentTimeMillis()));
        attendanceRepository.save(attendance);
    }

    private int generateNewEmpid() {
        Integer maxEmpid = attendanceRepository.findMaxEmpid();
        return (maxEmpid != null ? maxEmpid : 0) + 1;
    }
}
