/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSINHVIEN;

/**
 *
 * @author VanVanPhuong
 */
public class SinhVien implements Comparable<SinhVien>{

    private String maSinhVien;
    private String hoTenSinhVien;
    private double dTB;

    public SinhVien() {
    }

    public SinhVien(String maSinhVien, String hoTenSinhVien, double dTB) {
        this.maSinhVien = maSinhVien;
        this.hoTenSinhVien = hoTenSinhVien;
        this.dTB = dTB;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTenSinhVien() {
        return hoTenSinhVien;
    }

    public void setHoTenSinhVien(String hoTenSinhVien) {
        this.hoTenSinhVien = hoTenSinhVien;
    }

    public double getdTB() {
        return dTB;
    }

    public void setdTB(double dTB) {
        this.dTB = dTB;
    }

    @Override
    public String toString() {
        return this.maSinhVien + "," + this.hoTenSinhVien + "," + this.dTB;
    }

    @Override
    public int compareTo(SinhVien o) {
        return (int) (this.dTB - o.getdTB());
    }

}
