package com.nccsoft.BaitapTinhLuong;

import java.util.Scanner;

public abstract class NhanVien {

    protected   String maNhanVien ="";
    protected  String hoTen = "";
    protected  int luongHangThang = 0;

    public NhanVien() {

    }

    public NhanVien(String maNhanVien, String hoTen, int luongHangThang) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        if(luongHangThang > 0)
            this.luongHangThang = luongHangThang;

    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getLuongHangThang() {

        return  luongHangThang;

    }

    public void setLuongHangThang(int luongHangThang) {
        if(luongHangThang > 0)
            this.luongHangThang = luongHangThang;
        else
            System.out.println("luong phai > 0");
    }

    protected  void nhap(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao ma nhan vien  ");
        setMaNhanVien(scanner.nextLine());
        System.out.println("Nhap vao ho ten nhan vien ");
        setHoTen(scanner.nextLine());
        System.out.println("Nhap vao luong hang thang ");
        setLuongHangThang(scanner.nextInt());


    }

    public abstract double tinhLuong();

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", luongHangThang=" + luongHangThang + "]";
	}
    
    

}
