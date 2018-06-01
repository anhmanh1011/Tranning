import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class KhuVuc {

    private String name;
    private double DienTich;
    private List<Hang> hangs = new ArrayList<>();
    private int soLuongHienCo;
    private Hang MatHang = null;

    public KhuVuc(String name, double dienTich) {
        this.name = name;
        DienTich = dienTich;
        soLuongHienCo = 0;

    }

    public int getSoLungSanPham(){
        int sol = 0;

        for (int i = 0; i < hangs.size(); i++) {
            sol += hangs.get(i).getSoLuong();
        }
        return sol ;
    }

    public boolean Xuat() throws IllegalAccessException, InstantiationException {
        Hang hang = (Hang) MatHang.getClass().newInstance();
        System.out.println("Nhap vao ten sn pham");
        hang.setName(new Scanner(System.in).nextLine());
        Hang htontai = checkHangTonTai(hang.getName());
        if(htontai == null) {
            System.out.println("khong tim thay mat hang");
            return false;
        }

        System.out.println("nhap vao so luong");
        if(htontai.Xuat(new Scanner(System.in).nextInt())){

            System.out.println("xuat thanh cong");
            return true;
        }
        return false;
    }

    public double getDienTichDaSuDung() {

        double s = 0;
        int size = hangs.size();
        for (int i = 0; i < size; i++) {
            s += hangs.get(i).getDienTichTongHang();
        }

        return s;

    }

    private boolean kiemTraNhap(double dienTichTieuTon) {

        if (DienTich - getDienTichDaSuDung() - dienTichTieuTon >= 0)
            return true;
        return false;
    }

    public Hang checkHangTonTai(String name) throws IllegalAccessException, InstantiationException {
        Hang hang = (Hang) MatHang.getClass().newInstance();
        hang.setName(name);

       int index = hangs.indexOf(hang);
       if(index != -1)
            return hangs.get(index);
       return  null;
    }



    public Boolean nhaphang() throws IllegalAccessException, InstantiationException {

        Hang hang = (Hang) MatHang.getClass().newInstance();
        System.out.println("Nhap vao ten ");
        hang.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhap vap so luong ban muon them ");
        hang.setSoLuong(new Scanner(System.in).nextInt());

        Hang htontai = checkHangTonTai(hang.getName());
        if(htontai != null){
            if(kiemTraNhap(hang.getSoLuong() * htontai.getDienTich())){
                htontai.addSoLuong(hang.getSoLuong());
                System.out.println("da them thanh cong " + hang.getSoLuong() + " san pham");
                return true;
            }
        }

        System.out.println("nhap vao dien tich moi mat hang");
        hang.setDienTich(new Scanner(System.in).nextDouble());
        hang.Nhap();
        if(kiemTraNhap(hang.getDienTichTongHang())){
            hangs.add(hang);
            soLuongHienCo += hang.getSoLuong();
            System.out.println("da them thanh cong " + hang.getSoLuong() + " san pham");
            return true;
        }
        System.out.println("khu vuc khong the chua them " + hang.getSoLuong() + "mat hang");
        return false;
    }

    public boolean addMatHang() {


        if (MatHang==null) {


            System.out.println("Nhap vao loai Mat Hang can them vao khu");
            System.out.println("0 : Đê Hủy");
            System.out.println("1 : CPU");
            System.out.println("2: Ban Phim");

            int luachon = 0;
            luachon = new Scanner(System.in).nextInt();

            switch (luachon) {
                case 1:
                    MatHang = new CPU();
                    return true;
                case 2:
                    MatHang = new BanPhim();
                    return  true;


                case 0:
                    return false;
            }
        }


            return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDienTich() {
        return DienTich;
    }

    public void setDienTich(double dienTich) {
        DienTich = dienTich;
    }

    public List<Hang> getHangs() {
        return hangs;
    }

    public void setHangs(List<Hang> hangs) {
        this.hangs = hangs;
    }

    public int getSoLuongHienCo() {
        return soLuongHienCo;
    }

    public void setSoLuongHienCo(int soLuongHienCo) {
        this.soLuongHienCo = soLuongHienCo;
    }

    public Object getMatHang() {
        return MatHang;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KhuVuc)) return false;
        KhuVuc khuVuc = (KhuVuc) o;
        return name.equals(khuVuc.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, DienTich, hangs, soLuongHienCo, MatHang);
    }

    @Override
    public String toString() {
        return "KhuVuc{" +
                "name='" + name + '\'' +
                ", DienTich=" + DienTich +
                ", soLuongHienCo=" + soLuongHienCo +

                '}';
    }
}
