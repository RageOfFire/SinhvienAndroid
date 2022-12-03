package com.ragefire.qlsinhvien;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String masv, hoten, email;
    private int gioitinh, sdt;

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public SinhVien() {
    }

    public SinhVien(String masv, String hoten, String email, int gioitinh, int sdt) {
        this.masv = masv;
        this.hoten = hoten;
        this.email = email;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
    }

    public SinhVien(String hoten, String email, int gioitinh, int sdt) {
        this.hoten = hoten;
        this.email = email;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "masv='" + masv + '\'' +
                ", hoten='" + hoten + '\'' +
                ", email='" + email + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", sdt=" + sdt +
                '}';
    }
}