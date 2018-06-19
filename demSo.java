package dem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class demSo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Nhap so co toi da 9 chu so, doc ra chu:
		int so;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Nhap vao so co toi da 9 chu so:"); // <1.000.000.000
			so = sc.nextInt();

			if (so < 0 || so > 999999999) {
				System.out.println("So khong hop le");
				return;
			}

			int tram_trieu = so / 100000000;
			int chuc_trieu = (so % 100000000) / 10000000;
			int trieu = (so % 10000000) / 1000000;
			int tram_nghin = (so % 1000000) / 100000;
			int chuc_nghin = (so % 100000) / 10000;
			int nghin = (so % 10000) / 1000; // so = 2345 so/1000 = 2
			int tram = (so % 1000) / 100; // so = 2345 so%1000 = 345 (lay du), 345/100 = 3(lay nguyen)
			int chuc = (so % 100) / 10;
			int donvi = so % 10;
			
			switch (tram_trieu) {
			case 1:
				if(chuc_trieu ==0 && trieu ==0)
				System.out.print(" Mot tram trieu");
				break;
			case 2:
				System.out.print(" Hai tram");
				break;
			case 3:
				System.out.print(" Ba tram");
				break;
			case 4:
				System.out.print(" Bon tram");
				break;
			case 5:
				System.out.print(" Nam tram");
				break;
			case 6:
				System.out.print(" Sau tram");
				break;
			case 7:
				System.out.print(" Bay tram");
				break;
			case 8:
				System.out.print(" Tam tram");
				break;
			case 9:
				System.out.print(" Chin tram");
				break;
			}
			switch (chuc_trieu) {
			case 0:
				if(tram_trieu !=0 && trieu !=0)
				System.out.print(" linh");
				break;
			case 1:
				System.out.print(" Muoi trieu");
				break;
			case 2:
				System.out.print(" Hai muoi");
				break;
			case 3:
				System.out.print(" Ba muoi");
				break;
			case 4:
				System.out.print(" Bon muoi");
				break;
			case 5:
				System.out.print(" Nam muoi");
				break;
			case 6:
				System.out.print(" Sau muoi");
				break;
			case 7:
				System.out.print(" Bay muoi");
				break;
			case 8:
				System.out.print(" Tam muoi");
				break;
			case 9:
				System.out.print(" Chin muoi");
				break;
			}
			switch (trieu) {
			case 0:
				if(chuc_trieu !=0 && tram_trieu !=0)
				System.out.print(" trieu");
				break;
			case 1:
				System.out.print(" Mot trieu");
				break;
			case 2:
				System.out.print(" Hai trieu");
				break;
			case 3:
				System.out.print(" Ba trieu");
				break;
			case 4:
				System.out.print(" Bon trieu");
				break;
			case 5:
				System.out.print(" Nam trieu");
				break;
			case 6:
				System.out.print(" Sau trieu");
				break;
			case 7:
				System.out.print(" Bay trieu");
				break;
			case 8:
				System.out.print(" Tam trieu");
				break;
			case 9:
				System.out.print(" Chin trieu");
				break;
			}
			switch (tram_nghin) {
			case 0:
				if(trieu !=0 &&(chuc_nghin !=0 || nghin !=0))
				System.out.print(" Khong tram");
				break;
			case 1:
				System.out.print(" Mot tram");
				break;
			case 2:
				System.out.print(" Hai tram");
				break;
			case 3:
				System.out.print(" Ba tram");
				break;
			case 4:
				System.out.print(" Bon tram");
				break;
			case 5:
				System.out.print(" Nam tram");
				break;
			case 6:
				System.out.print(" Sau tram");
				break;
			case 7:
				System.out.print(" Bay tram");
				break;
			case 8:
				System.out.print(" Tam tram");
				break;
			case 9:
				System.out.print(" Chin tram");
				break;
			}
			switch (chuc_nghin) {
			case 0:
				if(tram_nghin !=0 && nghin !=0)
					System.out.print(" linh");
				break;
			case 1:
					System.out.print(" Muoi");
				break;
			case 2:
				System.out.print(" Hai muoi");
				break;
			case 3:
				System.out.print(" Ba muoi");
				break;
			case 4:
				System.out.print(" Bon muoi");
				break;
			case 5:
				System.out.print(" Nam muoi");
				break;
			case 6:
				System.out.print(" Sau muoi");
				break;
			case 7:
				System.out.print(" Bay muoi");
				break;
			case 8:
				System.out.print(" Tam muoi");
				break;
			case 9:
				System.out.print(" Chin muoi");
				break;
			}
			switch (nghin) {
			case 0:
				if((chuc_nghin !=0 || tram_nghin !=0))
				System.out.print(" nghìn");
				break;
			case 1:
				if(chuc_nghin <2) {
					System.out.print(" Một nghìn");
				}else{
					System.out.print(" Mốt nghìn");
				}
				break;
			case 2:
				System.out.print("Hai nghin");
				break;
			case 3:
				System.out.print("Ba nghin");
				break;
			case 4:
				System.out.print("Bon nghin");
				break;
			case 5:
				System.out.print("Nam nghin");
				break;
			case 6:
				System.out.print("Sau nghin");
				break;
			case 7:
				System.out.print("Bay nghin");
				break;
			case 8:
				System.out.print("Tam nghin");
				break;
			case 9:
				System.out.print("Chin nghin");
				break;
			}

			switch (tram) {
			case 0:
				if ((chuc_nghin !=0||nghin!=0) && (chuc!=0 || donvi!=0))
					System.out.print(" Khong tram");
				break;
			case 1:
				System.out.print(" Mot tram");
				break;
			case 2:
				System.out.print(" Hai tram");
				break;
			case 3:
				System.out.print(" Ba tram");
				break;
			case 4:
				System.out.print(" Bon tram");
				break;
			case 5:
				System.out.print(" Nam tram");
				break;
			case 6:
				System.out.print(" Sau tram");
				break;
			case 7:
				System.out.print(" Bay tram");
				break;
			case 8:
				System.out.print(" Tam tram");
				break;
			case 9:
				System.out.print(" Chin tram");
				break;
			}

			switch (chuc) {
			case 0:
				if (donvi != 0 && (tram !=0 || nghin !=0 || chuc_nghin !=0))
					System.out.print(" linh");
				break;
			case 1:
				System.out.print(" Muoi");
				break;
			case 2:
				System.out.print(" Hai muoi");
				break;
			case 3:
				System.out.print(" Ba muoi");
				break;
			case 4:
				System.out.print(" Bon muoi");
				break;
			case 5:
				System.out.print(" Nam muoi");
				break;
			case 6:
				System.out.print(" Sau muoi");
				break;
			case 7:
				System.out.print(" Bay muoi");
				break;
			case 8:
				System.out.print(" Tam muoi");
				break;
			case 9:
				System.out.print(" Chin muoi");
				break;
			}

			switch (donvi) {
			case 0:
				if (tram_trieu==0 && chuc_trieu ==0 && trieu ==0 && tram_nghin==0 && chuc_nghin==0 && nghin == 0 && tram == 0 && chuc == 0)
					System.out.print("Khong");
				break;
			case 1:
				if(chuc <2) {
					System.out.print(" Một");
				}else{
					System.out.print(" Mốt");
				}
				break;
			case 2:
				System.out.print(" Hai");
				break;
			case 3:
				System.out.print(" Ba");
				break;
			case 4:
				System.out.print(" Bon");
				break;
			case 5:
				if (chuc != 0)
					System.out.print(" lam");
				else
					System.out.print(" Nam");
				break;
			case 6:
				System.out.print(" Sau");
				break;
			case 7:
				System.out.print(" Bay");
				break;
			case 8:
				System.out.print(" Tam");
				break;
			case 9:
				System.out.print(" Chin");
				break;
			}
			
			System.out.println("");
		}
	}
}
