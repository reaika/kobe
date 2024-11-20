package com.example.AttendanceManage.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Time;

@Entity
@Table(name="attendance")
public class Attendance {

    @Id
    private int empid;

    private Time att_workstart;

    private Time att_workend;

    // getter setter
    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public Time getAtt_workstart() {
        return att_workstart;
    }
    public void setAtt_workstart(Time att_workstart) {
        this.att_workstart = att_workstart;
    }

    public Time getAtt_workend() {
        return att_workend;
    }
    public void setAtt_workend(Time att_workend) {
        this.att_workend = att_workend;
    }

}
