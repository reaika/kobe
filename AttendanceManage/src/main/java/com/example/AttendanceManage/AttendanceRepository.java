package com.example.AttendanceManage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    /**
     * 新しいIDを取得します。
     * （既存のIDの最大値＋１を新しいIDとします）
     * coalesceは処理結果がNullの場合、第二引数の値を返す関数
     * ->attendanceテーブルのデータが0件の場合、MAX関数の結果がNULLになることを考慮する
     * @return 新しいID
     */
    @Query(value="SELECT coalesce(MAX(id),0) + 1 FROM attendance", nativeQuery = true)
    int getNewId();

    /**
     * IDの最大値を取得します。
     * @return IDの最大値
     */
    @Query(value="SELECT MAX(id) FROM attendance", nativeQuery = true)
    int getMaxId();

    @Query(value="SELECT * FROM attendance WHERE end_time IS NULL", nativeQuery = true)
    Attendance getAtWorkData();
}
