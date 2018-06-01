import java.util.Objects;
import java.util.Scanner;

public abstract class Hang {

    protected String name;
    protected double dienTich;
    protected int soLuong;

    public void addSoLuong(int soLuongThem){
        soLuong+= soLuongThem;
    }

    public boolean outSoLuong(int soLuongXuat){

        if(soLuong >= soLuongXuat){
            System.out.println("xuat thanh cong");
            return  true;
        }
        System.out.println("khong du so luong de xuat");
        return  false;
    }

    public Hang(){

    }





    public  Hang(String name, double dienTich, int soLuong) {
        this.name = name;
        this.dienTich = dienTich;
        this.soLuong = soLuong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDienTichTongHang(){

        return  soLuong*dienTich;
    }

    public  abstract  void Nhap();

    public  boolean Xuat(int soLuong){
        if(soLuong>0 && soLuong <= this.soLuong) {
            this.soLuong -= soLuong;
            return true;
        }
        System.out.println(" Xuaat that bai , so luong qua lon");
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hang)) return false;
        Hang hang = (Hang) o;
        return this.name.equals(hang.name);
    }




    @Override
    public int hashCode() {

        return Objects.hash(name, dienTich, soLuong);
    }

    @Override
    public String toString() {
        return "Hang{" +
                "name='" + name + '\'' +
                ", dienTich=" + dienTich +
                ", soLuong=" + soLuong +
                '}';
    }
}
