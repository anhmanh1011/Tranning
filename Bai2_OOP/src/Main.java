import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static boolean checkAddKhoHang(String ten,List<KhoHang> list){

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(ten))
                return true;
        }

        return false;
    }

    public static void addKhoHang(List<KhoHang> list){

        System.out.println("nhap tap ten kho hang : ");
        String ten = new Scanner(System.in).nextLine();
        if(checkAddKhoHang(ten,list)){
            System.out.println("ten Kho da Ton tai ");
            return;
        }
        System.out.println("nhap vao chieu dai kho hang  : ");
        double chieuDai = new Scanner(System.in).nextDouble();
        System.out.println("nhap vao chieu rong kho hang ; ");
        double chieuRong = new Scanner(System.in).nextDouble();
        System.out.println("Nhap vao so khu vuc : ");
        int soKV = new Scanner(System.in).nextInt();

        KhoHang khoHang = new KhoHang(ten,chieuDai,chieuRong,soKV);
        list.add(khoHang);
        System.out.println("them kho hang thanh cong");


    }

    public static void viewInfor(List<KhoHang>  list){

        IShow iShow = new ShowIML();
        KhoHang khoHang = (KhoHang) iShow.show(list);
        if(khoHang != null){
            KhuVuc khuVuc = (KhuVuc) iShow.show(khoHang.getKhuVucs());
            if(khuVuc != null) {
               iShow.show(khuVuc.getHangs());
            }
        }


    }

    public static void addKhuVuc(List<KhoHang> list){

        IShow iShow = new ShowIML();
        KhoHang khoHang = (KhoHang) iShow.show(list);
        if(khoHang!= null){
            if(khoHang.addKhuVuc()){
                System.out.println("them khu vuc thanh cong ");
            }else {
                System.out.println("them khu vuc that bai");
            }
        }

    }

    public static void addSanPham(List<KhoHang> list) throws InstantiationException, IllegalAccessException {

        IShow iShow = new ShowIML();
        KhoHang khoHang = (KhoHang) iShow.show(list);
        if(khoHang != null){
            if(khoHang.nhap())
                System.out.println("them san pham thanh cong");
            else
                System.out.println("them san pham that bai");
        }

    }

    public static void  outSanPham(List<KhoHang>  list) throws InstantiationException, IllegalAccessException {

        IShow iShow = new ShowIML();
        KhoHang khoHang = (KhoHang) iShow.show(list);
        if(khoHang != null){
            if(khoHang.xuat())
                System.out.println("Xuat san pham thanh cong");
            else
                System.out.println("xuat san pham that bai");
        }

    }

    public static void MENU() throws IllegalAccessException, InstantiationException {

        List<KhoHang> list  = new ArrayList<>();
        int luachon  = 0;
        do{
            System.out.println("Nhap vao lua chon cua ban" );
            System.out.println("Nhap 0 de OUT");
            System.out.println("Nhap vao 1 de xem thong tin");
            System.out.println("Nhap vao 2 de them kho hang");
            System.out.println("Nhap vao 3 de them  Khu vuc");
            System.out.println("Nhap vao 4 de them  mat hang");
            System.out.println("Nhap vao 5 de them  san Pham");
            System.out.println("Nhap vao 6 de xuat  san Pham");

            luachon = new Scanner(System.in).nextInt();
            switch (luachon){

                case 1:
                    viewInfor(list);
                    break;
                case 2:
                    addKhoHang(list);
                    break;
                case 3:
                    addKhuVuc(list);
                    break;
                case  4:
                    addMatHang(list);
                    break;
                case 5:
                    addSanPham(list);
                    break;
                case  6:
                    outSanPham(list);
                    break;
            }

        }while (luachon != 0);






    }

    private static void addMatHang(List<KhoHang> list) {

        IShow iShow = new ShowIML();
        KhoHang khoHang = (KhoHang) iShow.show(list);
        if(khoHang != null){
           if(khoHang.addMatHang()){
               System.out.println("them mat hang thanh cong");
           }else {
               System.out.println("thao tac them that bai");
           }
        }


    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        MENU();

    }
}

