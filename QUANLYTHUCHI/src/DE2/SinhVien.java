/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE2;

/**
 *
 * @author VanVanPhuong
 */
public class SinhVien {
    private String maNhanVien;
    private String tenNhanVien;
    private String ngaySinh;
    private String queQuan;

    public SinhVien(String maNhanVien, String tenNhanVien, String ngaySinh, String queQuan) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }

    public SinhVien() {
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    @Override
    public String toString() {
        return this.maNhanVien+";"+this.tenNhanVien+";"+this.ngaySinh+";"+this.queQuan;
    }
    
    
}
