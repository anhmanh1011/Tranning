package com.nccsoft.BaiTap2;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    static  boolean addItem(List<KhoHang> list){

        KhoHang khoHang = showList(list);
        if(khoHang == null) {
            System.out.println("khong tim thay kho hang");
            return false;
        }

        System.out.println("Nhap vao ten mat hang ban muon them : ");
        String type_item = new Scanner(System.in).nextLine();
        System.out.println("nhap vao so luong : ");
        int number = new Scanner(System.in).nextInt();
        return khoHang.addItem(type_item,number);

    }
    static boolean addContainer(List<KhoHang> list){
        KhoHang khoHang = showList(list);
        if(khoHang == null ) {
            return false;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao ten Container ");
        String ten = scanner.nextLine();
        System.out.println("Nhap vao loai mat hang Container ");
        String type = scanner.nextLine();
        System.out.println("Nhap vao kich thuoc  mat hang ");
        double size = scanner.nextDouble();

        return  khoHang.addContainer(ten,type,size);


    }
    static  boolean addKhoHang(List<KhoHang> list){

          Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao ten kho hang ");
        String ten = scanner.nextLine();
        if(list.contains(new KhoHang(ten,0,0,0))) {
            System.out.println("ten kho hang da ton tai");
            return false;
        }

        System.out.println("nhap vao chieu dai : ");
        double dai = scanner.nextDouble();
        System.out.println("nhap vao chieu rong : ");
        double rong = scanner.nextDouble();
        System.out.println("nhap vao so luong khu vuc");
        int soKhuvuc = scanner.nextInt();

        list.add(new KhoHang(ten,rong,dai,soKhuvuc));
        System.out.println("da them thanh cong kho hang");
        return  true;



    }

    static void MENU(List<KhoHang> list){



        int luaChon = 0;

        do{
            System.out.println("moi ban nhap vao 1 trong cac lua chon sau : ");
            System.out.println("nhap 0 : de OUT ");
            System.out.println("nhap 1 : kiem tra thong tin Kho Hang ");
            System.out.println("nhap 2 : them Kho hang ");
            System.out.println("nhap 3 : them Khu vuc ");
            System.out.println("nhap 4 : them san pham vao kho ");
            System.out.println("nhap 5 : xuat san pham vao kho ");
            System.out.println("nhap 6 : xem chi tiết nhập xuất sản phẩm ");

            luaChon = new Scanner(System.in).nextInt();

            switch (luaChon){
                case 1:
                    System.out.println("ban da chon kiem tra thong tin ");
                    ShowInFor(list);
                    break;
                case 2:
                    System.out.println("ban da chon them kho hang ");
                    if(addKhoHang(list))
                        System.out.println("thao tac them kho hang thanh cong");
                    else
                        System.out.println("thao tac that bai");
                    break;
                case 3:
                    System.out.println("ban da lua chon them khu vuc ");

                    if(addContainer(list))
                        System.out.println("thao tac them Khu vuc thanh cong");
                    else
                        System.out.println("thao tac that bai");
                    break;
                case 4:
                    System.out.println("ban da lua chon them san pham");
                    if(addItem(list))
                        System.out.println("thao tac them san pham thanh cong");
                    else
                        System.out.println("thao tac that bai");
                    break;
                case 5:
                    System.out.println("ban da lua chon Xuất san pham");
                    if(outItem(list))
                        System.out.println("thao tac Xuat san pham thanh cong");
                    else
                        System.out.println("thao tac that bai");
                    break;
                case 6:
                    System.out.println("ban da lua chon xem thông tin chi tiết  nhập xuất san pham");
                    infor_input_output(list);

                    break;





            }




        }while (luaChon != 0);



    }

    static KhoHang showList(List<KhoHang> list){
        if (list != null) {
            int choose = 0;
            int n = list.size();
            do {
                System.out.println("Moi ban Nhap Vao Lua Chon ");
                System.out.println("Nhap -1  de OUT ");


                for (int i = 0; i < n; i++) {
                    System.out.println("Nhap " + i + " de chon KHO : " + list.get(i).getName());
                }

                choose = new Scanner(System.in).nextInt();

            } while (choose <= -1 && choose >= n);

            if(choose > -1 && choose < n) {
                System.out.println("ban da lua chon KHO : " + list.get(choose).getName());
                return list.get(choose);
            }
            else if(choose == -1)
                System.out.println("ban da lua chon huy Hanh Dong, OUT");
        }

        return null;

    }
    static boolean outItem(List<KhoHang> list){
        KhoHang khoHang = showList(list);
        if(khoHang == null) {
            System.out.println("khong tim thay kho hang");
            return false;
        }

        System.out.println("Nhap vao ten mat hang ban muon Xuat : ");
        String type_item = new Scanner(System.in).nextLine();
        System.out.println("nhap vao so luong : ");
        int number = new Scanner(System.in).nextInt();
        return khoHang.OutItem(type_item,number);
    }

    static   void ShowInFor(List<KhoHang> list){

        KhoHang khoHang = showList(list);
        if(khoHang != null){

            System.out.println(khoHang);
            Container container = KhoHang.chooseContainer(khoHang.getContainers());
           if(container != null)
            System.out.println(container);

        }

    }

    static  void  infor_input_output(List<KhoHang> list){

        KhoHang khoHang = showList(list);
        if(khoHang!= null){

            khoHang.getInfor_Input();
            khoHang.getInfor_Output();

        }

    }



    public static void main(String[] args) {

       List<KhoHang> list = new ArrayList<>();
       MENU(list);

    }
}
