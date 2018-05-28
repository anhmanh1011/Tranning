package com.nccsoft.BaiTap2;

import java.util.*;
import java.util.function.BiConsumer;

public class KhoHang extends ThongTinLuuTru {

    private List<Container> containers;
    private Map<String, String> infor_container;
    private Map<String, Integer> InputItem;
    private Map<String, Integer> OutputItem;


    public int getNumberIn() {

        int numberIn = 0;
        if (InputItem.size() > 0) {

            Set<Map.Entry<String, Integer>> entries = InputItem.entrySet();
            for (Map.Entry<String,Integer> entry:entries){
                numberIn += entry.getValue();
            }


        }
        return numberIn;

    }


    public int getNumberOut(){

        int numberOut  = 0;
        if(OutputItem.size() > 0) {
            Set<Map.Entry<String, Integer>> entries = OutputItem.entrySet();
            for (Map.Entry<String,Integer> entry:entries){
                numberOut += entry.getValue();
            }
        }

        return numberOut;

    }


    public Map<String, String> getInfor_container() {
        return infor_container;
    }

    public void setInfor_container(Map<String, String> infor_container) {
        this.infor_container = infor_container;
    }

    public Map<String, Integer> getInputItem() {
        return InputItem;
    }

    public void setInputItem(Map<String, Integer> inputItem) {
        InputItem = inputItem;
    }

    public Map<String, Integer> getOutputItem() {
        return OutputItem;
    }

    public void setOutputItem(Map<String, Integer> outputItem) {
        OutputItem = outputItem;
    }

    @Override
    public int still_empty() {
        return number - infor_container.size();
    }

    public boolean checkAddContainer(String name) {

        if (infor_container.containsKey(name)) {
            System.out.println("ten da khu vuc da ton tai, yeu cau them khu vuc THAT BAI!");
            return false;
        }

        return true;
    }

    private double getHeghtforContainer() {

        return super.getHeght() / number;
    }


    public boolean addContainer(String name, String type_item, double size) {

        name = name.toLowerCase();
        type_item = type_item.toLowerCase();
        if (still_empty() > 0) {

            if (checkAddContainer(name)) {
                containers.add(new Container(name, heght, getHeghtforContainer(), type_item, size));
                infor_container.put(name, type_item);
                InputItem.put(type_item,0);
                OutputItem.put(type_item,0);

                System.out.println("them Container thanh cong");
                return true;

            } else {
                System.out.println("ten Containẻ da ton tai");
                return false;
            }
        }

        System.out.println("Kho Hang da day");
        return false;

    }

    public List<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public boolean addItem(String type_item, int number) {

        type_item = type_item.toLowerCase();

        Container container = chooseContainer(checkAddTypeitem(type_item , number));
        if(container != null){

            if(container.add(number)) {

                InputItem.put(type_item, InputItem.get(type_item) + number);
                return true;
            }

        }
        System.out.println("khong co khu vuc nao chua " + type_item);

        return  false;
    }

    public static Container chooseContainer(List<Container> list) {

        if (list != null) {
            int choose = 0;
            int n = list.size();
            do {
                System.out.println("Moi ban Nhap Vao Lua Chon ");
                System.out.println("Nhap -1  de huy ");


                for (int i = 0; i < n; i++) {
                    System.out.println("Nhap " + i + " de chon Container : " + list.get(i).getName());
                }

                choose = new Scanner(System.in).nextInt();

            } while (choose < 0 && choose >= n);

            if(choose > -1) {
                System.out.println("ban da lua chon CONTAINER : " + list.get(choose).getName());
                return list.get(choose);
            }
            else if(choose == -1)
                System.out.println("ban da lua chon huy Hanh Dong, OUT");
        }

        return null;

    }


    private List<Container> checkAddTypeitem(String type_item , int number) {

        List<Container> list;

        if (infor_container.containsValue(type_item)) {

            System.out.println("da tem thay cac Container chua " + type_item);
            list = new ArrayList<>();
            for (int i = 0; i < containers.size(); i++) {
                if (containers.get(i).getType_of_item().equals(type_item) && containers.get(i).still_empty() > number)
                    list.add(containers.get(i));
            }
            return list;

        }
        System.out.println("khong ton tai Container chua \"" + type_item + "\"");
        return null;


    }

    private  List<Container> checkOutTypeitem (String type_item , int number) {

        List<Container> list;

        if (infor_container.containsValue(type_item)) {

            System.out.println("da tem thay cac Container chua " + type_item);
            list = new ArrayList<>();
            for (int i = 0; i < containers.size(); i++) {
                if (containers.get(i).getType_of_item().equals(type_item) && containers.get(i).getNumber() > number)
                    list.add(containers.get(i));
            }
            return list;

        }
        System.out.println("khong ton tai Container chua \"" + type_item + "\"");
        return null;

    }

    public boolean OutItem(String type_item, int number){
        type_item = type_item.toLowerCase();

        Container  container = chooseContainer(checkOutTypeitem(type_item, number));
        if(container != null){
            container.Out(number);
            OutputItem.put(type_item,OutputItem.get(type_item) + number);
            return true;
        }
        return  false;

    }

    public KhoHang(String name, double width, double heght, int number) {
        super(name, width, heght, number);
        containers = new ArrayList<>();
        infor_container = new HashMap<>();
        InputItem = new HashMap<>();
        OutputItem = new HashMap<>();
    }

    public void getInfor_Input(){

        System.out.println("Thong tin  hàng đã nhập");

        if(InputItem.size() > 0){
            InputItem.forEach(new BiConsumer<String, Integer>() {
                @Override
                public void accept(String s, Integer integer) {

                    System.out.println(s + " :  " + integer);
                }
            });

        }else{

            System.out.println("chua co mat hang nao được nhập vào Kho");
        }


    }

    public void getInfor_Output(){

        System.out.println("Thong tin  hàng đã Xuất");

        if(OutputItem.size() > 0){
            OutputItem.forEach(new BiConsumer<String, Integer>() {
                @Override
                public void accept(String s, Integer integer) {

                    System.out.println(s + " :  " + integer);
                }
            });

        }else{

            System.out.println("Chua  co Mat Hang nao được Xuất ra Khỏi Kho");
        }

    }


    @Override
    public String toString() {
        return "KhoHang{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", heght=" + heght +
                ", so khu vuc = " + number +
                ", so khu vuc trong  = " + still_empty() +
                ",so luong nhap = " +getNumberIn() +
                ",so luong xuat = " + getNumberOut()+

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KhoHang)) return false;
        KhoHang khoHang = (KhoHang) o;
        return getName().equals(khoHang.getName().toLowerCase());
    }

    @Override
    public int hashCode() {

        return Objects.hash(containers, infor_container, InputItem, OutputItem);
    }
}
