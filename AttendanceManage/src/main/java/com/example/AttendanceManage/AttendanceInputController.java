package com.example.AttendanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.time.LocalTime;

@Controller
public class AttendanceInputController {

    @Autowired
    private AttendanceRepository attendancesRepository;

    @GetMapping("/AttendanceInput")
    public String input(Model model) {
        // 未退勤のデータがあれば出勤出来ないようにしたい
        Attendance attendance = attendancesRepository.getAtWorkData();
        model.addAttribute("isWorking",attendance!=null);

        //TODO:出勤後に休憩開始が使用可能になる
        //TODO:休憩開始後に休憩終了が使用可能になる
        //TODO:データベースの変更が必要になる
        return "AttendanceInput";
    }

    @PostMapping("AttendanceInput")
    public String input(@RequestParam("action") String action){
        Attendance attendance = null;
        //現在時刻の取得
        Time currentTime = Time.valueOf(LocalTime.now());
        switch (action){
            case "start":
                //リポジトリを使用してデータの登録
                attendance = new Attendance();
                //最新のIDを採番する
                int newId = attendancesRepository.getNewId();
                attendance.setId(newId);
                attendance.setBegin_time(currentTime);
                attendancesRepository.save(attendance);
                break;

            case "end":
                // 退勤していないデータを取得して退勤時刻を更新する
                int maxId = attendancesRepository.getMaxId();
                attendance = attendancesRepository.getReferenceById((long)maxId);
                attendance.setEnd_time(currentTime);
                attendancesRepository.save(attendance);
                break;

            default:
                break;
        }

        //勤務状況一覧へリダイレクト
        return "redirect:/condition";
    }


}

