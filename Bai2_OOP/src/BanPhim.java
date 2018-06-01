import java.util.Objects;
import java.util.Scanner;

public class BanPhim extends  Hang{
    private String Loai;
    private  String mau;

    public BanPhim(String name, double dienTich, int soLuong, String loai, String mau) {
        super(name, dienTich, soLuong);
        Loai = loai;
        this.mau = mau;
    }

    public BanPhim() {

    }

    @Override
    public void Nhap() {
        System.out.println("nhap vao loai ban phim ");
        setLoai(new Scanner(System.in).nextLine());
        System.out.println("Nhap vao mau cua ban phim");
        setMau(new Scanner(System.in).nextLine());
    }

    @Override
    public String toString() {
        return "BanPhim{" +
                "Loai='" + Loai + '\'' +
                ", mau='" + mau + '\'' +
                ", name='" + name + '\'' +
                ", dienTich=" + dienTich +
                ", soLuong=" + soLuong +
                '}';
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BanPhim)) return false;
        if (!super.equals(o)) return false;
        BanPhim banPhim = (BanPhim) o;
        return this.name.equals(banPhim.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), Loai, mau);
    }
}
