package com.example.AttendanceManage;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Time;
import java.time.LocalTime;

/**
 * 勤怠情報のデータクラス
 * データの取得や登録・更新で使用します。
 */
@Entity
@Table(name="attendance")
public class Attendance {
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    private Time begin_time;
    private Time end_time;

}
