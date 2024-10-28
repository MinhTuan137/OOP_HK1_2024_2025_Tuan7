package tuan3_SinhVien;

import java.util.Scanner;

public class TestSinhVien {
	public static DSSinhVien dssv;	

	//----------------------------tiêu đề-----------------------------------
	public static void tieuDe() {
		String title = String.format("|%-15s|%-20s|%-30s|%-15s|", "MSSV", "Họ tên", "Địa chỉ", "Số diện thoại" );
		System.out.println(title);
	}

	//----------------------------nhập thông tin-----------------------------
	public static int nhapMssv(String thongbao)
	{
		int mssv;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		mssv = sc.nextInt();
		return mssv;
	}

	public static String nhapHoTen(String thongbao) {
		String hoTen;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		hoTen = sc.nextLine();
		return hoTen;
	}

	public static String nhapDiaChi(String thongbao) {
		String diaChi;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		diaChi = sc.nextLine();
		return diaChi;
	}

	public static String nhapSoDienThoai(String thongbao) {
		String soDienThoai;
		System.out.println(thongbao);
		Scanner sc = new Scanner(System.in);
		soDienThoai = sc.nextLine();
		return soDienThoai;
	}

	//----------------------------nhập đối tượng-----------------------------
	public static SinhVien nhapDoiTuong() throws Exception
	{
		int mssv;
		String hoTen;
		String diaChi;
		String soDienThoai;
		SinhVien sv;
		mssv = nhapMssv("Nhập mã số sinh viên: ");
		while(dssv.timViTri(mssv) != -1)
		{
			System.out.println("Mã số sinh viên đã tồn tại.");
			mssv = nhapMssv("Nhập mã số sinh viên: ");
		}
		hoTen = nhapHoTen("Nhập họ tên: ");
		diaChi = nhapDiaChi("Nhập địa chỉ: ");
		do
		{
			soDienThoai = nhapSoDienThoai("Nhập số điện thoại: ");
			if(soDienThoai.length() != 7)
				System.out.println("Số điện thoại phải có 7 chữ số.");
		} while(soDienThoai.length() != 7);
		sv = new SinhVien(mssv, hoTen, diaChi, soDienThoai);
		return sv;
	}

	//----------------------------nhập danh sách sinh viên-------------------
	public static void nhapDanhSachSV() throws Exception
	{
		SinhVien sv1 = new SinhVien(23010911, "Nguyễn Văn An", "Quận Bình Tân, Tp. HCM", "0917817");
		SinhVien sv2 = new SinhVien(23045986, "Đỗ Quốc Tiến", "Quận Bình Thạnh, Tp. HCM", "0919876");
		SinhVien sv3 = new SinhVien(23198910, "Nguyễn Hoàng Dũng", "Quận 12, Tp. HCM", "0589562");
		SinhVien sv4 = new SinhVien(23908612, "Lê Tiến Quân", "Quận 1, Tp. HCM", "0674872");
		dssv.them(sv1);
		dssv.them(sv2);
		dssv.them(sv3);
		dssv.them(sv4);
		System.out.println("Thêm danh sách thành công.");
	}

	//----------------------------xuất danh sách sinh viên-------------------
	public static void xuatDanhSachSV()
	{
		SinhVien[] ds = dssv.xuatSV();
		System.out.println("\t\t\t***DANH SÁCH SINH VIÊN***\t\t\t");
		tieuDe();
		System.out.println("*************************************************************************************");
		for(int i = 0; i < dssv.soLuongHT; i++)
		{
			System.out.println(ds[i]);
		}
		System.out.println("*************************************************************************************");
		System.out.println();
	}

	//----------------------------thêm sinh viên-----------------------------
	public static void themSV() throws Exception
	{
		SinhVien sv = nhapDoiTuong();
		if(dssv.them(sv) == true)
			System.out.println("Thêm sinh viên thành công.");
		else
			System.out.println("Thêm sinh viên không thành công.");
		System.out.println();
	}

	//----------------------------sửa sinh viên-------------------------------
	public static void suaSV() throws Exception
	{
		int maSV = nhapMssv("Nhập mã sinh viên cần sửa: ");
		SinhVien sv = dssv.timSV(maSV);
		int daSua = 0, chon;
		if(sv != null)
		{
			System.out.println("\t\t\t***SINH VIÊN TRƯỚC KHI SỬA***\t\t\t");
			tieuDe();
			System.out.println("*************************************************************************************");
			System.out.println(sv);
			System.out.println("*************************************************************************************");
			System.out.println();

			do
			{
				menuSua();
				Scanner sc = new Scanner(System.in);
				System.out.println("Nhập lựa chọn của bạn: ");
				chon = sc.nextInt(); 
				daSua ++;
				switch(chon) 
				{
				case 1: 
					String hoTen = nhapHoTen("Nhập họ tên sinh viên: ");
					sv.setHoTen(hoTen);
					break;
				case 2: 
					String diaChi = nhapDiaChi("Nhập địa chỉ của sinh viên: ");
					sv.setDiaChi(diaChi);
					break;
				case 3: 
					String sdt = nhapSoDienThoai("Nhập số điện thoại: ");
					sv.setSoDienThoai(sdt);
					break;
				case 4: 
					if(daSua >= 1)
						dssv.suaSV(sv);
					System.out.println("Đã sửa sinh viên thành công.");
					break;
				}
			}
			while(chon < 4);
		}
		else
			System.out.println("Không tìm thấy sinh viên cần sửa.");
	}

	//----------------------------xóa sinh viên-----------------------------
	public static void xoaSV() throws Exception
	{
		int maSV = nhapMssv("Nhập mã sinh viên cần sửa: ");
		SinhVien sv = dssv.timSV(maSV);
		if(sv != null)
		{
			tieuDe();
			System.out.println("*************************************************************************************");
			System.out.println(sv);
			System.out.println("*************************************************************************************");
			System.out.println();
			System.out.println("Bạn có chắc muốn xoá sinh viên này không?(Y/N): ");
			Scanner sc = new Scanner(System.in);
			String xacNhan = sc.nextLine();
			if(xacNhan.equalsIgnoreCase("Y"))
			{
				dssv.xoaSV(maSV);
				System.out.println("Xóa sinh viên này thành công.");
			}
			else
				System.out.println("Bạn đã giữ lại sinh viên này.");
		}
		else
			System.out.println("Không tìm thấy sinh viên cần xóa.");
	}

	//----------------------------tìm sinh viên-----------------------------
	public static void timSV()
	{
		int maSV = nhapMssv("Nhập mã sinh viên cần tìm: ");
		SinhVien sv = dssv.timSV(maSV);
		if(sv != null)
		{
			tieuDe();
			System.out.println("*************************************************************************************");
			System.out.println(sv);
			System.out.println("*************************************************************************************");
			System.out.println();
		}
		else
			System.out.println("Không tìm thấy sinh viên này.");
	}

	//----------------------------sắp xếp danh sách sinh viên----------------
	public static void sapXepMSSV() throws Exception
	{
		SinhVien[] svsx = dssv.sapXepMSSV();
		System.out.println("Sắp xếp sinh viên theo mã sinh viên thành công");
		System.out.println();
	}

	//------------------------------menu chính--------------------------------
	public static void menu()
	{
		System.out.println("\t\t\t***QUẢN LÝ SINH VIÊN***\t\t\t");
		System.out.println("*************************************************************************************");
		System.out.println("\t1. Nhập danh sách sinh viên.");
		System.out.println("\t2. Xuất danh sách sinh viên");
		System.out.println("\t3. Thêm sinh viên.");
		System.out.println("\t4. Sửa sinh viên.");
		System.out.println("\t5. Xóa sinh viên");
		System.out.println("\t6. Tìm kiếm sinh viên");
		System.out.println("\t7. Sắp xếp danh sách sinh viên");
		System.out.println("\t8. Thoát");
		System.out.println("*************************************************************************************");
	}

	//------------------------------menu sửa--------------------------------
	public static void menuSua()
	{
		System.out.println("\t\t\t***MENU SỬA SINH VIÊN***\t\t\t");
		System.out.println("*************************************************************************************");
		System.out.println("\t1. Tên sinh viên.");
		System.out.println("\t2. Địa chỉ.");
		System.out.println("\t3. Số điện thoại.");
		System.out.println("\t4. Trở về menu chính.");
		System.out.println("*************************************************************************************");
	}

	//----------------------------main--------------------------------------
	public static void main(String[] args) throws Exception {
		dssv = new DSSinhVien();
		int chon;
		Scanner sc = new Scanner(System.in);
		do {
			menu();
			System.out.println("Nhập lựa chọn: ");
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				nhapDanhSachSV();
				break;
			case 2:
				xuatDanhSachSV();
				break;
			case 3:
				themSV();
				break;
			case 4:
				suaSV();
				break;
			case 5:
				xoaSV();
				break;
			case 6:
				timSV();
				break;
			case 7:
				sapXepMSSV();
				break;
			case 8:
				System.out.println("Kết thúc chương trình.");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
				break;
			}
		} while (chon != 8);
	}
}
