import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ShowIML implements IShow {

    @Override
    public Object show(List list) {
        if(list != null && list.size() > 0) {
            System.out.println("-------------" + new Date() + "----------------");
            int luachon  = -1;
            System.out.println("nhap -1 de out");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("nhap " + i + "de chon : " + list.get(i));
            }
            luachon = new Scanner(System.in).nextInt();
            if(luachon == -1 && luachon >= list.size())
                return null;
            return list.get(luachon);
        }
        return null;
    }
}
