package com.nccsoft.BaitapTinhLuong;

import java.util.Scanner;


public class Programmer extends NhanVien {

    private  int  bug = 0;

    public Programmer(String maNhanVien, String hoTen, int luongHangThang, int bug) {
        super(maNhanVien, hoTen, luongHangThang);
        if(bug > 0)
            this.bug = bug;
    }

    public Programmer() {
    }

    public int getBug() {
        return bug;
    }

    public void setBug(int bug) {
        if(bug  > 0)
        this.bug = bug;
    }

	@Override
    public  void nhap(){

        super.nhap();
        System.out.println("Nhap vao so bug cua Programmer : ");
        Scanner scanner = new Scanner(System.in);
		setBug(scanner.nextInt());

    }

    @Override
     public  double tinhLuong() {
        if(bug < 20)
            return  luongHangThang + luongHangThang*0.1;
        return luongHangThang;
    }

	@Override
	public String toString() {
		return "Programmer [bug=" + bug + ", maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", luongHangThang="
				+ luongHangThang + "]";
	}


}
