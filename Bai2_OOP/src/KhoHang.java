import com.sun.org.apache.regexp.internal.RE;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KhoHang {

    private List<KhuVuc> khuVucs;
    private String name;
    private double chieuDai;
    private double chieuRong;
    private  int soLuongkV;
    private int soLuongHienCo;

    public Boolean nhap() throws InstantiationException, IllegalAccessException {

       IShow iShow = new ShowIML();
        Hang hang = (Hang) ListMatHang();
        KhuVuc show = (KhuVuc) iShow.show(lkhuv(hang));
        if(show!= null){

            if(show.nhaphang())
                return true;
        }
        return false;
    }


    public Boolean xuat() throws InstantiationException, IllegalAccessException {

        IShow iShow = new ShowIML();
        Hang hang = (Hang) ListMatHang();
        KhuVuc show = (KhuVuc) iShow.show(lkhuv(hang));
        if(show!= null){

            show.Xuat();
            return true;
        }
        return false;
    }



    public List<KhuVuc> lkhuv(Hang hang){

        if(hang == null)
            return null;

        List<KhuVuc> vucs = new ArrayList<>();

        for (int i = 0; i < khuVucs.size(); i++) {
            if(khuVucs.get(i).getMatHang().getClass().equals(hang.getClass()))
                vucs.add(khuVucs.get(i));
        }

        if (vucs.size()>0)
            return vucs;

        return  null;
    }

    public Object ListMatHang(){

        System.out.println("Nhap vao loai Mat Hang ");
        System.out.println("0 : Đê Hủy");
        System.out.println("1 : CPU");
        System.out.println("2: Ban Phim");

        int luachon = 0;
        luachon = new Scanner(System.in).nextInt();

        switch (luachon) {
            case 1:
                return new CPU();
            case 2:
                return new BanPhim();


            case 0:
                return null;
        }

        return null;

    }

    public boolean addMatHang(){
        IShow iShow = new ShowIML();
        KhuVuc khuVuc = (KhuVuc) iShow.show(khuVucs);
        if(khuVuc!= null){
           khuVuc.addMatHang();
            System.out.println("them khu vuc thanh cong");
            return true;
        }

        return  false;
    }




    public int getSoLuongHienCo() {
        return soLuongHienCo;
    }

    public void setSoLuongHienCo(int soLuongHienCo) {
        this.soLuongHienCo = soLuongHienCo;
    }

    public KhoHang() {

    }

    public KhoHang(String name, double chieuDai, double chieuRong, int soLuongkV) {
        this.name = name;
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
        this.soLuongkV = soLuongkV;
        khuVucs = new ArrayList<>();
    }



    public  boolean addKhuVuc(){
        if(soLuongHienCo < soLuongkV) {
            System.out.println("nhap vao ten Khu Vuc");
            String ten = new Scanner(System.in).nextLine();
            if(kiemTratonTaiKhuVuc(ten)){
                System.out.println("khu vuc da ton tai");
                return false;
            }

            KhuVuc khuVuc = new KhuVuc(ten,getDienTichKhuVuc());
            khuVucs.add(khuVuc);
            System.out.println("them thanh cong khu vuc");
            soLuongHienCo++;
            return true;
        }
        System.out.println("so luong khu vuc da day");
        return false;
    }

    public double getDienTich() {
        return  chieuDai * chieuRong;
    }
    public  double getDienTichKhuVuc(){

        return getDienTich()/soLuongkV;
    }

    private boolean kiemTratonTaiKhuVuc(String ten) {
        if(khuVucs.contains(new KhuVuc(ten,0)))
            return true;

        return false;
    }

    public int getSoLuongkV() {
        return soLuongkV;
    }

    public void setSoLuongkV(int soLuongkV) {
        this.soLuongkV = soLuongkV;
    }

    public List<KhuVuc> getKhuVucs() {
        return khuVucs;
    }

    public void setKhuVucs(List<KhuVuc> khuVucs) {
        this.khuVucs = khuVucs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(double chieuDai) {
        this.chieuDai = chieuDai;
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }

    @Override
    public String toString() {
        return "KhoHang{" +
                "name='" + name + '\'' +
                ", chieuDai=" + chieuDai +
                ", chieuRong=" + chieuRong +
                ", soLuongkV=" + soLuongkV +
                ", soLuongHienCo=" + soLuongHienCo +
                '}';
    }
}
