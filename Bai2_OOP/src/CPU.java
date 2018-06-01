import java.util.Scanner;

public class CPU extends Hang {

    private int doi;
    private double tocDOXuLy;


    public CPU(){

    }

  //  public boolean out

    @Override
    public  void Nhap(){
        System.out.println("nhap vao doi ");
        setDoi(new Scanner(System.in).nextInt());
        System.out.println("Nhap vao Toc do xu ly  ");
        setTocDOXuLy(new Scanner(System.in).nextDouble());

    }

    public CPU(String name, double dienTich, int soLuong, int doi, double tocDOXuLy) {
        super(name, dienTich, soLuong);

        this.doi = doi;
        this.tocDOXuLy = tocDOXuLy;
    }

    public int getDoi() {
        return doi;
    }

    public void setDoi(int doi) {
        this.doi = doi;
    }

    public double getTocDOXuLy() {
        return tocDOXuLy;
    }

    public void setTocDOXuLy(double tocDOXuLy) {
        this.tocDOXuLy = tocDOXuLy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPU)) return false;
        CPU cpu = (CPU) o;
        return this.name.equals(cpu.getName());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "doi=" + doi +
                ", tocDOXuLy=" + tocDOXuLy +
                ", name='" + name + '\'' +
                ", dienTich=" + dienTich +
                ", soLuong=" + soLuong +
                '}';
    }
}
