package com.fourteen.piao.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2014/5/29.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    private String str_tmp = "";
    public DBOpenHelper(Context context) {
        super(context, "fourteen", null, 1);//修改表结构时，或其他改变数据库的动作时，把1 升级成2会触发onUpgrade方法执行
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //数据库第一次被创建时被调用时，创建数据库
        //适合创建数据库表
        str_tmp = "CREATE TABLE CONCERT(CONCERT_ID INTEGER PRIMARY AUTOINCREMENT, CONCERT_NAME VARCHAR(150))";

        sqLiteDatabase.execSQL(str_tmp);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        str_tmp = "ALTER TABLE CONCERT ADD PROMPTER_ID VARCHAR(20) NULL";

    }
}
