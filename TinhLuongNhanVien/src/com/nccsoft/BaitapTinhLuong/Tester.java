package com.nccsoft.BaitapTinhLuong;

import java.util.Scanner;

public class Tester extends NhanVien {

	private int timeOT = 0;
	public static final  int moneyOT = 200000;
	
	public Tester() {
		// TODO Auto-generated constructor stub 
	}
	
	public Tester(String maNhanVien, String hoTen, int luongHangThang , int timeOT) {
		super(maNhanVien, hoTen, luongHangThang);
		if(timeOT > 0)
			this.timeOT = timeOT;
	}

	public int getTimeOT() {
		return timeOT;
	}

	public void setTimeOT(int timeOT) {
		if(timeOT > 0)
			this.timeOT = timeOT;
	}

	public void nhap() {
		super.nhap();
		System.out.println("Nhap vao so gio OT : ");
		setTimeOT(new Scanner(System.in).nextInt());
	}
	
	@Override
	public double tinhLuong() {
	
		return luongHangThang + timeOT * moneyOT;
	}

	@Override
	public String toString() {
		return "Tester [timeOT=" + timeOT + ", maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", luongHangThang="
				+ luongHangThang + "]";
	}
	

}
