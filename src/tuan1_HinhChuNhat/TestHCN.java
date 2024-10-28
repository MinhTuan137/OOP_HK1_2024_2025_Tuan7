package tuan1_HinhChuNhat;

import java.util.Scanner;

public class TestHCN {
	//-----------------------------tiêu đề-----------------------------
	public static String tieuDe()
	{
		return String.format("%-15s %-15s %-15s %-15s", "Chiều Dài", "Chiều Rộng", "Diện Tích", "Chu Vi");
	}

	//-----------------------------nhập thông tin-----------------------
	public static int nhapSoNguyen(String thongbao) {
		int a;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		return a;
	}

	//-----------------------------nhập đối tượng-----------------------
	public static HinhChuNhat nhapDoiTuong () {
		int cd, cr;
		HinhChuNhat cn;
		cd = nhapSoNguyen("Nhập chiều dài: ");
		cr = nhapSoNguyen("Nhập chiều rộng: ");
		cn = new HinhChuNhat(cd, cr);
		return cn;
	}

	//-------------------nhập từ trong chương trình-----------------------
	public static void nhapCung()
	{
		HinhChuNhat cn1, cn2;
		cn1 = new HinhChuNhat(10, 6);
		cn2 = new HinhChuNhat(25, 7);
		System.out.println(cn1);
		System.out.println(cn2);
	}

	//-----------------------------main-------------------------------------
	public static void main( String[] args) {
		HinhChuNhat cn1, cn2, cn3;
		cn3 = nhapDoiTuong();
		System.out.println(tieuDe());
		nhapCung();
		System.out.println(cn3);
	}
}
