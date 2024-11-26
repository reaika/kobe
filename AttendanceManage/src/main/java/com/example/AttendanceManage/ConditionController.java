package com.example.AttendanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * コントローラークラス
 * HTTPリクエストを受けて処理を行うビジネスロジック
 * 勤怠データの一覧を表示
 */
@Controller
public class ConditionController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * データベース操作のクラスをインスタンス化
     * Repository(リポジトリ)＝保管場所
     * この場合、データの保管場所（DBのattendeanceテーブル）
     */
    @Autowired
    private AttendanceRepository attendancesRepository;

    @GetMapping("/condition")
    public String index(Model model) {
        // attendanceテーブルから全データを取得
        // データをAttendanceクラスのインスタンスに格納する
        // インスタンスはListクラスによりリスト化
        List<Attendance> attendances = attendancesRepository.findAll();

        //HTTPレスポンスのテンプレートファイルへモデルを渡す
        //テンプレートではattendancesでデータを取得出来る
        model.addAttribute("attendances",attendances);

        //テンプレートを呼び出しThymeleafでビューを生成する
        return "condition";
    }
}