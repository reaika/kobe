package com.example.AttendanceManage.Model;

/* enshu 33 テスト用データベース作成について... create databaseのこと？？
postgres@MSI:~# psql
postgres=#
postgres=# \l (小文字のエル、で データベースの一覧表示)
postgres=# create database testDB (詳細は https://www.javadrive.jp/postgresql/database/index2.html )

削除したいときは drop database

 */

// enshu 35
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// enshu 34
@Getter
@Setter
@NoArgsConstructor
public class User{
    private int id;
    private String password;
    private String name;
    private String role;
    private int division_id;

    public User(int id,String password,String name,String role, int division_id){
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.division_id = division_id;
    }
}
