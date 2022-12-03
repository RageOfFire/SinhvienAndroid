package com.ragefire.qlsinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SV_DAO {
    private SVDatabase database;
    private static final String TABLE_NAME = "dh9c4";
    private static final String ID = "masv";
    private static final String NAME = "hoten";
    private static final String GENDER = "gioitinh";
    private static final String EMAIL = "email";
    private static final String PHONE = "sdt";
//Contructor
    public SV_DAO(Context context) {
        database = new SVDatabase(context);
    }
    //    Thêm sinh viên
    public void AddSV(SinhVien sv) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, sv.getMasv());
        values.put(NAME, sv.getHoten());
        values.put(GENDER, sv.getGioitinh());
        values.put(EMAIL, sv.getEmail());
        values.put(PHONE, sv.getSdt());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    //    Cập nhật sinh viên
    public int UpdateSV (SinhVien sv) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, sv.getHoten());
        values.put(GENDER, sv.getGioitinh());
        values.put(EMAIL, sv.getEmail());
        values.put(PHONE, sv.getSdt());
        int a = db.update(TABLE_NAME, values, ID + "=?", new String[]{sv.getMasv()});
        db.close();
        return a;
    }
    //    Xóa sinh viên
    public int DeleteSV (String id) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        int kq = db.delete(TABLE_NAME, ID + "=?", new String[]{id});
        db.close();
        return kq;
    }
    //    Lấy toàn bộ sinh thông tin
    public List<SinhVien> InfoSV() {
        List<SinhVien> SVList=new ArrayList<SinhVien>();
        String sql="SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db=database.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String masv=cursor.getString(0);
            String hoten=cursor.getString(1);
            int gioitinh=cursor.getInt(2);
            String email=cursor.getString(3);
            int sdt=cursor.getInt(4);
            SinhVien sv=new SinhVien(masv,hoten,email,gioitinh,sdt);
            SVList.add(sv);
            cursor.moveToNext();
        }
        return SVList;
    }
//    Tìm kiếm
    public List<SinhVien> SearchSV(String s) {
        List<SinhVien> ListSV = new ArrayList<SinhVien>();
        SQLiteDatabase db = database.getReadableDatabase();
        String sql = "SELECT * FROM "+ TABLE_NAME +" WHERE " + ID + "LIKE '%" + s + "%' OR " + NAME + "LIKE '%" + s + "%'";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String masv = cursor.getString(0);
            String hoten = cursor.getString(1);
            int gioitinh = cursor.getInt(2);
            String email = cursor.getString(3);
            int sdt = cursor.getInt(4);
            SinhVien sv = new SinhVien(masv, hoten, email, gioitinh, sdt);
            ListSV.add(sv);
            cursor.moveToNext();
        }
        return ListSV;
    }
}
