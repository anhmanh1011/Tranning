package com.nccsoft.BaitapTinhLuong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Scanner;

public class Main {
	
	public static int  loiDuoi5(List<NhanVien> list) {
		
		int n = 0;
		for (NhanVien nhanVien : list) {
			if(nhanVien instanceof Programmer)
				if((((Programmer)nhanVien)).getBug() < 5) 
					n++;
		}
		
		return n;
	}
	
	
	public static NhanVien timeOTMax(List<NhanVien> list) {
		
		
		
		return (NhanVien) list.stream().max(new  Comparator<NhanVien>() {
			
			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				
				if(o1 instanceof Tester && o2 instanceof Tester) {
					
					if( ((Tester)o1).getTimeOT() > ((Tester)o2).getTimeOT()) 
						return 1;
					else if( ((Tester)o1).getTimeOT() == ((Tester)o2).getTimeOT())
						return 0;
					return -1;
						
				}
				else if(o1 instanceof Tester && o2 instanceof Programmer) {
					
					return 1;
				}
				else
					return -1;
				
			
		} 
		}).get();
	
	}
	
	
	public static void Menu() {
		
		List<NhanVien> list = new ArrayList<>();
		int luachon;
		do {
			System.out.println("--------------MENU--------");
			System.out.println("Nhap 0 de OUT ");
			System.out.println("Nhap 1 de them  1 programmer vao danh sach nhan vien");
			System.out.println("Nhap 2 de them 1  tester ");
			System.out.println("Nhap 3 de  xem Tong Luong cua nhan vien  ");
			System.out.println("Nhap 4 de  xem so luong programmer co loi bug < 5 ");
			System.out.println("Nhap 5 de  xem tester co time OT cao Nhat ");
			System.out.println("Moi Nhap vao Lua Chon");
			luachon = new Scanner(System.in).nextInt();
			switch (luachon) {
			case 1:
				
				Programmer programmer = new Programmer();
				programmer.nhap();
				list.add(programmer);
				break;
				
			case 2:
				Tester tester = new Tester();
				tester.nhap();
				list.add(tester);
				break;
				
				
			case 3:
				System.out.println("\nTong luong cua tat ca nhan vien  la : ");
				System.out.println(TongLuong(list));
				break;
				
			case 4:
				System.out.println("\nso luong programmer co loi bug < 5 la : ");
				System.out.println(loiDuoi5(list));
				break;
				
			case 5:
				System.out.println("\n thong tin nhan vien co time OT cao nhat  la : ");
				System.out.println(timeOTMax(list));
				
				break;				
				
			default:
				break;
			}
			
			
		}while(luachon != 0);
		
		
	}
	
	public static double TongLuong(List<NhanVien> list) {
		
		double  tongLuong  = 0;
		for(int i = 0; i < list.size(); i++) {
			
			tongLuong += list.get(i).tinhLuong();
			
		}
		
		return tongLuong;
		
	}

	public static void main(String[] args) {

		Menu();


	}

}
