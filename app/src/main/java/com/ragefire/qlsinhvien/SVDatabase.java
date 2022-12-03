package com.ragefire.qlsinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class SVDatabase extends SQLiteOpenHelper {
    //    Khai báo thành phần
    private static final String DATABASE_NAME = "SinhVien.db";
    private static final String TABLE_NAME = "dh9c4";
    private static final String ID = "masv";
    private static final String NAME = "hoten";
    private static final String GENDER = "gioitinh";
    private static final String EMAIL = "email";
    private static final String PHONE = "sdt";
    //    version
    public static final int Version = 3;
    public Context context;
    public SVDatabase(Context context) {
        super(context, DATABASE_NAME, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( " +
                ID + " TEXT primary key," +
                NAME + " TEXT," +
                GENDER + " INTEGER," +
                EMAIL + " TEXT," +
                PHONE + " INTEGER)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
