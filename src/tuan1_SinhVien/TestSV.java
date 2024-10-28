package tuan1_SinhVien;

import java.util.Scanner;

public class TestSV {
	//---------------------------tiêu đề---------------------------
	static String tieuDe() {
		return String.format("%-10s \t%-15s %-15s \t%-15s \t%-15s", "MSSV", "Họ Tên", "Điểm lý thuyết", "Điểm thực hành", "Điểm trung bình");
	}

	//---------------------------nhập thông tin---------------------------
	public static int nhapMSSV(String thongbao) {
		int mSSV;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		mSSV = sc.nextInt();
		return mSSV;
	}

	public static String nhapHoTen(String thongbao) {
		String hoTen;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		hoTen = sc.nextLine();
		return hoTen;
	}

	public static float nhapDiemLT(String thongbao) {
		float diemLT;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		diemLT = sc.nextFloat();
		return diemLT;
	}

	public static float nhapDiemTH(String thongbao) {
		float diemTH;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		diemTH = sc.nextFloat();
		return diemTH;
	}

	//---------------------------nhập đối tượng---------------------------
	public static SinhVien nhapDoiTuong() {
		int mSSV;
		String hoTen;
		float diemLT, diemTH;
		SinhVien sv;
		mSSV = nhapMSSV("Nhập mssv: ");
		hoTen = nhapHoTen("Nhập họ tên:  ");
		diemLT = nhapDiemLT("Nhập điểm lý thuyết: ");
		diemTH = nhapDiemTH("Nhập điểm thực hành: ");
		sv = new SinhVien(mSSV, hoTen, diemLT, diemTH);
		return sv;
	}

	//---------------------------nhập trong chương trình------------------
	public static void nhapCung() {
		SinhVien sv1, sv2;
		sv1 = new SinhVien(23717111, "Đỗ Minh Tuấn", 8.0f, 8.5f);
		sv2 = new SinhVien(23717771, "Phan Chi Toàn", 9.0f, 9.5f);
		System.out.println(sv1);
		System.out.println(sv2);
	}

	//---------------------------------main--------------------------------
	public static void main(String[] args) {
		SinhVien sv1, sv2, sv3;
		sv3 = nhapDoiTuong();
		System.out.println(tieuDe());
		nhapCung();
		System.out.println(sv3);
	}
}
