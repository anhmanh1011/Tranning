package com.nccsoft.BaiTap2;

import java.util.Objects;

public class Container extends  ThongTinLuuTru {

    public String type_of_item;
    public double size_item;

    public String getType_of_item() {
        return type_of_item;
    }

    public void setType_of_item(String type_of_item) {
        this.type_of_item = type_of_item;
    }


    public double getSize_item() {
        return size_item;
    }

    public void setSize_item(double size_item) {
        this.size_item = size_item;
    }

    public  int getMaximum(){

        return (int) (super.getArea()/size_item);
    }

    @Override
    public int still_empty() {
        return getMaximum() - getNumber();
    }


    @Override
    public String toString() {
        return "Container{" +
                "type_of_item = '" + type_of_item + '\'' +
                ", name = '" + name + '\'' +
                ", width=" + width +
                ", heght=" + heght +
                ", number = " + number +
                '}';
    }

    public boolean add(int number){

        if(number < still_empty()){

            this.number += number;
            System.out.println("them " + number + " " + type_of_item + " thanh công");
            return  true;
        }

        System.out.println("Container chi co the chua them  " + still_empty());

        return  false;
    }

    public   boolean Out(int number){

        if(this.number > number){
            this.number -= number;
            System.out.println("da xuat thanh cong  " + number + " " + type_of_item);
            return  true;
        }
        System.out.println("Khong du mat hang de xuat " + " < " + this.number);
        return  false;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Container)) return false;
        Container container = (Container) o;
        return getName().equals(container.getName().toLowerCase());
    }

    @Override
    public int hashCode() {

        return Objects.hash(type_of_item, size_item);
    }

    public Container(String name, double width, double heght, String type_of_item, double size_item) {
        this.heght = heght;
        this.width = width;
        this.name = name;

        this.type_of_item = type_of_item;
        this.size_item = size_item;
    }
}
