package com.example.AttendanceManage.Repository;

import com.example.AttendanceManage.Model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    @Query("SELECT MAX(a.id) FROM Attendance a")
    Integer findMaxId();

    Attendance findTopByOrderByIdDesc();
}

