package com.nccsoft.BaiTap2;

public abstract class ThongTinLuuTru {

    protected  String name;
    protected double width;
    protected  double heght;
    protected  int number;



    public  abstract  int still_empty();

    public  double  getArea(){

        return  width * heght;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeght() {
        return heght;
    }

    public void setHeght(double heght) {
        this.heght = heght;
    }

    public int getNumber() {
        return number;
    }

    private void setNumber(int number) {
        this.number = number;
    }



    public ThongTinLuuTru(String name, double width, double heght, int number) {
        this.name = name;
        this.width = width;
        this.heght = heght;
        this.number = number;
    }

    public ThongTinLuuTru() {
    }
}
