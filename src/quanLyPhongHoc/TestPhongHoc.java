package quanLyPhongHoc;

import java.util.Scanner;

public class TestPhongHoc {
	public static DSPhongHoc ds = new DSPhongHoc();
	
	public static void main(String[] args) {
		int chon;
		do {
			menu();
			Scanner sc = new Scanner(System.in);
			chon = sc.nextInt();
			switch(chon)
			{
				case 1: 
					nhapCung();
					break;
				case 2: 
					timPH();
					break;
				case 3: 
					xuatDS();
					break;
				case 4: 
					xuatPhongDC();
					break;
				case 5: 
					xuatPhong60MT();
					break;
				case 6: 
					ds.sapXepTheoDayNha();
					System.out.println("Danh sách đã được sắp xếp theo dãy nhà.");
					System.out.println();
					break;
				case 7: 
					ds.sapXepTheoDienTich();
					System.out.println("Danh sách đã được sắp xếp theo diện tích.");
					System.out.println();
					break;
				case 8: 
					ds.sapXepTheoSoBongDen();
					System.out.println("Danh sách đã được sắp xếp theo số bóng đèn.");
					System.out.println();
					break;
				case 9: 
					suaPhongMT();
					break;
				case 10: 
					xoaPH();
					break;
				case 11: 
					System.out.println("Tổng số phòng học là: " + ds.tongPH());
					break;
				case 12: 
					System.out.println("Kết thúc chương trình.");
					break;
				default: 
					System.out.println("Lựa chọn của bạn không hợp lệ vui lòng nhập lại.");
					break;
			}
		}
		while(chon != 12);
	}
	
	public static void menu()
	{
		System.out.println("\t\t\t***MENU***\t\t\t");
		System.out.println("\t1. Nhập cứng.");
		System.out.println("\t2. Tìm phòng học");
		System.out.println("\t3. Xuất danh sách phòng học.");
		System.out.println("\t4. Xuất phòng học đạt chuẩn.");
		System.out.println("\t5. Xuất phòng máy tính có 60 máy tính.");
		System.out.println("\t6. Sắp xếp danh sách theo dãy nhà.");
		System.out.println("\t7. Sắp xếp danh sách theo diện tích.");
		System.out.println("\t8. Sắp xếp danh sách theo số bóng đèn.");
		System.out.println("\t9. Sửa số máy tính của phòng máy tính.");
		System.out.println("\t10. Xóa phòng học.");
		System.out.println("\t11. Tổng số phòng học.");
		System.out.println("\t12. Thoát.");
		System.out.println("\tNhập lựa chọn của bạn: ");
	}
	
	public static void nhapCung()
	{
		PhongHoc ph1 = new PhongLyThuet("B1.01", "Nhà B", 10, 2, true);
		PhongHoc ph2 = new PhongLyThuet("H1.01", "Nhà H", 30, 2, false);
		PhongHoc ph3 = new PhongMayTinh("H1.12", "Nhà H", 40, 8, 60);
		PhongHoc ph4 = new PhongMayTinh("H1.10", "Nhà H", 50, 4, 30);
		PhongHoc ph5 = new PhongThiNghiem("V1.12", "Nhà V", 40, 8, "Hóa học", 50, true);
		PhongHoc ph6 = new PhongThiNghiem("V2.12", "Nhà V", 50, 6, "Sinh học", 40, false);
		ds.themPH(ph1);
		ds.themPH(ph2);
		ds.themPH(ph3);
		ds.themPH(ph4);
		ds.themPH(ph5);
		ds.themPH(ph6);
		System.out.println("Thêm danh sách thành công.");
	}
	
	public static void timPH()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã phòng học cần tìm: ");
		String maPH = sc.nextLine();
		PhongHoc ph = ds.timPH(maPH);
		if(ph != null)
			System.out.println(ph);
		else
			System.out.println("Không tìm thấy phòng học có mã này.");
	}
	
	public static void xuatDS()
	{
		System.out.println("\t\t\t***DANH SÁCH PHÒNG LÝ THUYẾT***\t\t\t");
		for(PhongHoc phLT: ds.layPhongLyThuyet())
		{
			System.out.println(phLT);
		}
		System.out.println();
		
		System.out.println("\t\t\t***DANH SÁCH PHÒNG MÁY TÍNH***\t\t\t");
		for(PhongHoc phMT: ds.layPhongMayTinh())
		{
			System.out.println(phMT);
		}
		System.out.println();
		
		System.out.println("\t\t\t***DANH SÁCH PHÒNG THÍ NGHIỆM***\t\t\t");
		for(PhongHoc phTN: ds.layPhongThiNghiem())
		{
			System.out.println(phTN);
		}
		System.out.println();
	}
	
	public static void xuatPhongDC()
	{
		for(PhongHoc ph: ds.layPhongDatChuan())
			System.out.println(ph);
		System.out.println();
	}
	
	public static void xuatPhong60MT()
	{
		for(PhongHoc ph: ds.layPhong60MT())
			System.out.println(ph);
		System.out.println();
	}
	
	public static void suaPhongMT()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã phòng học máy tính cần sửa: ");
		String maPH = sc.nextLine();
		PhongHoc ph = ds.timPH(maPH);
		if(ph != null)
		{
			System.out.println("Nhập số lượng máy tính trong phòng.");
			int soMT = sc.nextInt();
			PhongMayTinh phSua = (PhongMayTinh) ph;
			phSua.setSoMayTinh(soMT);
			ds.suaPH(phSua);
			System.out.println("Đã sửa số máy tính trong phòng xong.");
		}
		else
			System.out.println("Không tìm thấy phòng máy tính có mã này.");
	}
	
	public static void xoaPH()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã phòng học cần xóa: ");
		String maPH = sc.nextLine();
		PhongHoc ph = ds.timPH(maPH);
		if(ph != null)
		{
			System.out.println("Bạn có chắc chắn muốn xóa phòng học này không[Y/N]: ");
			String chon = sc.nextLine();
			if(chon.equalsIgnoreCase("Y"))
			{
				ds.xoaPH(ph);
				System.out.println("Bạn đã xóa phòng học thành công.");
			}
			else
				System.out.println("Bạn đã giữ lại phòng học này.");
		}
		else
			System.out.println("Không tìm thấy phòng học có mã này.");
	}
}
