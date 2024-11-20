package com.example.AttendanceManage.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Time;

@Entity
@Table(name="attendance")
public class Attendance {

    @Id
    private int id;

    private Time begin_time;

    private Time end_time;

    // getter setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Time getBegin_time() {
        return begin_time;
    }
    public void setBegin_time(Time begin_time) {
        this.begin_time = begin_time;
    }

    public Time getEnd_time() {
        return end_time;
    }
    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

}
