package tuan7_PhongHoc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestPhongHoc {
	public static DSPhongHoc ds = new DSPhongHoc();

	//---------------------------Main-----------------------------
	public static void main(String[] args) throws Exception {
		int chon;
		Scanner sc = new Scanner(System.in);
		do
		{
			menu();
			chon = sc.nextInt();
			switch(chon)
			{
			case 1:
				nhapCung();
				System.out.println();
				break;
			case 2:
				themDS();
				System.out.println();
				break;
			case 3:
				suaPH();
				System.out.println();
				break;
			case 4:
				xoaPhong();
				System.out.println();
				break;
			case 5:
				timKiemPH();
				System.out.println();
				break;
			case 6:
				xuatPH();
				System.out.println();
				break;
			case 7:
				System.out.println("\t\t\t***DANH SÁCH PHÒNG ĐẠT CHUẨN***\t\t\t");
				xuatPDC();
				System.out.println();
				break;
			case 8:
				System.out.println("\t\t\t***DANH SÁCH PHÒNG MÁY TÍNH CÓ 60 MÁY TÍNH***\t\t\t");
				System.out.println(tieuDePMT());
				System.out.println("*****************************************************************************************************************************************");
				xuatP60MT();
				System.out.println("*****************************************************************************************************************************************");
				System.out.println();
				break;
			case 9:
				sapXepTheoDayNha();
				System.out.println();
				break;
			case 10:
				sapXepTheoDienTich();
				System.out.println();
				break;
			case 11:
				sapXepTheoBongDen();
				System.out.println();
				break;
			case 12:
				System.out.println("Tổng số phòng học là: " + ds.tongSoPhong());
				System.out.println();
				break;
			case 13:
				System.out.println("Kết thúc chương trình.");
				System.out.println();
				break;
			default:
				System.out.println("Lựa chọn của bạn không hợp lệ. Vui lòng nhập lại.");
			}
		}
		while(chon != 13);
	}

	//--------------------------Menu chính---------------------------
	public static void menu()
	{
		System.out.println("\t\t\t***QUẢN LÝ PHÒNG HỌC***\t\t\t");
		System.out.println("*****************************************************************************************************************************************");
		System.out.println("\t1. Nhập cứng.");
		System.out.println("\t2. Thêm phòng học.");
		System.out.println("\t3. Sửa phòng học.");
		System.out.println("\t4. Xóa phòng học.");
		System.out.println("\t5. Tìm kiếm phòng học.");
		System.out.println("\t6. Xuất danh sách phòng học.");
		System.out.println("\t7. Xuất danh sách các phòng đạt chuẩn.");
		System.out.println("\t8. Xuất danh sách các phòng máy tính có 60 máy.");
		System.out.println("\t9. Sắp xếp các phòng học theo dãy nhà.");
		System.out.println("\t10. Sắp xếp các phòng học theo diện tích.");
		System.out.println("\t11. Sắp xếp các phòng học theo số bóng đèn.");
		System.out.println("\t12. Tổng số phòng học.");
		System.out.println("\t13. Thoát");
		System.out.println("*****************************************************************************************************************************************");
		System.out.println("Nhập lựa chọn của bạn: ");
	}

	//----------------Menu sửa phòng lý thuyết----------------------
	public static void menuSuaPLT()
	{
		System.out.println("\t\t\t***MENU SỬA PHÒNG LÝ THUYẾT**\t\t\t");
		System.out.println("*****************************************************************************************************************************************");
		System.out.println("\t1. Dãy nhà.");
		System.out.println("\t2. Diện tích");
		System.out.println("\t3. Số bóng đèn.");
		System.out.println("\t4. Máy chiếu.");
		System.out.println("\t5. Trở lại menu chính.");
		System.out.println("*****************************************************************************************************************************************");
	}

	//----------------Menu sửa phòng máy tình-----------------------
	public static void menuSuaPMT()
	{
		System.out.println("\t\t\t***MENU SỬA PHÒNG MÁY TÍNH**\t\t\t");
		System.out.println("*****************************************************************************************************************************************");
		System.out.println("\t1. Dãy nhà.");
		System.out.println("\t2. Diện tích");
		System.out.println("\t3. Số bóng đèn.");
		System.out.println("\t4. Số máy tính.");
		System.out.println("\t5. Trở lại menu chính.");
		System.out.println("*****************************************************************************************************************************************");
	}

	//----------------Menu sửa phòng thí nghiệm--------------------
	public static void menuSuaPTN()
	{
		System.out.println("\t\t\t***MENU SỬA PHÒNG THÍ NGHIỆM**\t\t\t");
		System.out.println("*****************************************************************************************************************************************");
		System.out.println("\t1. Dãy nhà.");
		System.out.println("\t2. Diện tích");
		System.out.println("\t3. Số bóng đèn.");
		System.out.println("\t4. Thông tin chuyên ngành.");
		System.out.println("\t5. Sức chứa.");
		System.out.println("\t6. Bồn rửa.");
		System.out.println("\t7. Trở lại menu chính.");
		System.out.println("*****************************************************************************************************************************************");
	}

	//----------------------------tiêu đề--------------------------
	public static String tieuDePLT()
	{
		return String.format("|%-20s|%-20s|%-20s|%-20s|%-25s|%-25s|", "Mã phòng", "Dãy nhà", "Diện tích", "Số bóng đèn", "Máy chiếu", "Đánh giá");
	}

	public static String tieuDePMT()
	{
		return String.format("|%-20s|%-20s|%-20s|%-20s|%-25s|%-25s|", "Mã phòng", "Dãy nhà", "Diện tích", "Số bóng đèn", "Số máy tính", "Đánh giá");
	}

	public static String tieuDePTN()
	{
		return String.format("|%-20s|%-20s|%-20s|%-20s|%-25s|%-25s|%-25s|%-25s|", "Mã phòng", "Dãy nhà", "Diện tích", "Số bóng đèn", "Chuyên ngành", "Sức chứa", "Bồn rửa", "Đánh giá");
	}

	//-------------------------Nhập dữ liệu-------------------------
	public static String nhapChuoi(String thongbao)
	{
		String chuoi;
		Scanner sc = new Scanner(System.in);
		System.out.println(thongbao);
		chuoi = sc.nextLine();
		return chuoi;
	}

	public static int nhapSoNguyen(String thongbao)
	{
		int soNguyen;
		Scanner sc = new Scanner(System.in);
		System.out.println(thongbao);
		soNguyen = sc.nextInt();
		return soNguyen;
	}

	public static float nhapSoThuc(String thongbao)
	{
		float soThuc;
		Scanner sc = new Scanner(System.in);
		System.out.println(thongbao);
		soThuc = sc.nextFloat();
		return soThuc;
	}

	//---------------------Nhập cứng danh sách-----------------------
	public static void nhapCung() throws Exception 
	{
		PhongHoc ph1 = new PhongLyThuyet("A1.01", "Dãy nhà A", 30, 3, true);
		PhongHoc ph2 = new PhongLyThuyet("H1.07", "Dãy nhà H", 40, 3, false);
		PhongHoc ph3 = new PhongMayTinh("H5.01", "Dãy nhà H", 20, 3, 15);
		PhongHoc ph4 = new PhongMayTinh("A6.03", "Dãy nhà A", 50, 8, 60);
		PhongHoc ph5 = new PhongThiNghiem("B7.06", "Dãy nhà B", 40, 3, "Hóa Học", 45, true);
		PhongHoc ph6 = new PhongThiNghiem("A6.04", "Dãy nhà B", 20, 4, "Vật Lý", 90, false);
		ds.themPH(ph1);
		ds.themPH(ph2);
		ds.themPH(ph3);
		ds.themPH(ph4);
		ds.themPH(ph5);
		ds.themPH(ph6);
		System.out.println("Nhập danh sách thành công.");
	}

	//-------------------------Thêm phòng học-------------------------
	public static PhongHoc themPhongHoc() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PhongHoc ph = null;
		try
		{
			int chon;
			String maPH = nhapChuoi("Nhập mã phòng học: ");
			int viTri = ds.timViTriPhongHoc(maPH);
			if(viTri != -1)
			{
				System.out.println("Trùng mã.");
				return null;
			}
			else
			{
				String dayNha = nhapChuoi("Nhập dãy nhà: ");
				float dienTich = nhapSoThuc("Nhập diện tích phòng: ");
				int soBongDen = nhapSoNguyen("Nhập số lượng bóng đèn: ");
				System.out.println("Nhập 1 nếu là phòng lý thuyết, 2 nếu là phòng máy tính, 3 nếu là phòng thí nghiệm.");
				chon = sc.nextInt();
				if(chon == 1)
				{
					boolean mayChieu;
					String strMayChieu = nhapChuoi("Chọn [Y] nếu phòng có máy chiếu, [N] nếu phòng không có máy chiếu: ");
					while(!strMayChieu.equalsIgnoreCase("Y")  && !strMayChieu.equalsIgnoreCase("N"))
					{
						System.out.println("Bạn nhập không đúng vui lòng nhập lại: ");
						strMayChieu = sc.nextLine();
					}
					if(strMayChieu == "Y")
						mayChieu = true;
					mayChieu = false;
					ph = new PhongLyThuyet(maPH, dayNha, dienTich, soBongDen, mayChieu);
				}
				if(chon == 2)
				{
					int soMayTinh = nhapSoNguyen("Nhập số lượng máy tính: ");
					ph = new PhongMayTinh(maPH, dayNha, dienTich, soBongDen, soMayTinh);
				}
				if(chon == 3)
				{
					String chuyenNganh = nhapChuoi("Nhập thông tin chuyên ngành của phòng: ");
					int sucChua = nhapSoNguyen("Nhập sức chứa của phòng: ");
					boolean bonRua;
					String strBonRua = nhapChuoi("Nhọn [Y] nếu phòng có bồn rửa, [N] nếu phòng không có bồn rửa: ");
					while(!strBonRua.equalsIgnoreCase("Y")  && !strBonRua.equalsIgnoreCase("N"))
					{
						System.out.println("Bạn nhập không đúng vui lòng nhập lại: ");
						strBonRua = sc.nextLine();
					}
					if(strBonRua == "Y")
						bonRua = true;
					bonRua = false;
					ph = new PhongThiNghiem(maPH, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, bonRua);
				}
				System.out.println("Thêm phòng học thành công.");
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ph;
	}

	//-----------------------Thêm phòng học vào ds----------------------
	public static void themDS() throws Exception
	{
		PhongHoc ph = themPhongHoc();
		ds.themPH(ph);
	}

	//-------------------------Xuất phòng học-------------------------
	public static void xuatPH()
	{
		System.out.println("\t\t\t***DANH SÁCH PHÒNG LÝ THUYẾT**\t\t\t");
		System.out.println(tieuDePLT());
		System.out.println("*****************************************************************************************************************************************");
		for(PhongHoc ph : ds.layPhongLyThuyet())
		{
			System.out.println(ph);
		}
		System.out.println("*****************************************************************************************************************************************");
		System.out.println();
		System.out.println("\t\t\t***DANH SÁCH PHÒNG MÁY TÍNH***\t\t\t");
		System.out.println(tieuDePMT());
		System.out.println("*****************************************************************************************************************************************");
		for(PhongHoc hh : ds.layPhongMayTinh())
		{
			System.out.println(hh);
		}
		System.out.println("*****************************************************************************************************************************************");
		System.out.println();
		System.out.println("\t\t\t***DANH SÁCH PHÒNG THÍ NGHIỆM***\t\t\t");
		System.out.println(tieuDePTN());
		System.out.println("*********************************************************************************************************************************************************************************************");
		for(PhongHoc ph : ds.layPhongThiNghiem())
		{
			System.out.println(ph);
		}
		System.out.println("*********************************************************************************************************************************************************************************************");
	}

	//-------------------------Xuất phòng đạt chuẩn-------------------------
	public static void xuatPDC()
	{
		for(PhongHoc ph : ds.layPhongDatChuan())
		{
			System.out.println(ph);
		}
	}

	//-------------------------Xuất phòng 60 máy tính-------------------------
	public static void xuatP60MT()
	{
		for(PhongHoc ph: ds.layPhong60MayTinh())
			System.out.println(ph);
	}

	//-----------------Sửa thông tin chung của phòng học--------------------
	public static void menuThucHienSua(int chon, PhongHoc ph) throws Exception
	{
		switch(chon)
		{
		case 1:
			String dayNha = nhapChuoi("Nhập dãy nhà: ");
			ph.setDayNha(dayNha);
			break;
		case 2:
			float dienTich = nhapSoThuc("Nhập diện tích phòng: ");
			ph.setDienTich(dienTich);
			break;
		case 3:
			int soBongDen = nhapSoNguyen("Nhập số lượng bóng đèn: ");
			ph.setSoBongDen(soBongDen);;
			break;
		}
	}

	//-------------------------Sửa phòng học-------------------------
	public static void suaPH() throws Exception
	{
		int chon, daSua = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã phòng cần sửa: ");
		String maPH = sc.nextLine();
		PhongHoc ph = ds.timKiemPhongHoc(maPH);
		if(ph != null)
		{
			System.out.println("Thông tin của phòng học trước khi sửa.");
			if(ph instanceof PhongLyThuyet)
			{
				System.out.println(tieuDePLT());
				System.out.println("*****************************************************************************************************************************************");
				System.out.println(ph);
				System.out.println("*****************************************************************************************************************************************");
				PhongLyThuyet phSua = (PhongLyThuyet) ph;
				do
				{
					menuSuaPLT();
					System.out.println("Nhập lựa chọn của bạn: ");
					chon = sc.nextInt();
					daSua++;
					menuThucHienSua(chon, phSua);
					if(chon == 4)
					{
						boolean mayChieu;
						String strMayChieu = nhapChuoi("Chọn [Y] nếu phòng có máy chiếu, [N] nếu phòng không có máy chiếu: ");
						while(!strMayChieu.equalsIgnoreCase("Y")  || !strMayChieu.equalsIgnoreCase("N"))
						{
							System.out.println("Bạn nhập không đúng vui lòng nhập lại: ");
							strMayChieu = sc.nextLine();
						}
						if(strMayChieu == "Y")
							mayChieu = true;
						mayChieu = false;
						phSua.setMayChieu(mayChieu);
					}
					if(chon == 5)
					{
						if(daSua >= 1)
							ds.suaPhongHoc(phSua);
						System.out.println("Đã sửa phòng lý thuyết này thành công.");
					}
				}
				while(chon < 5);
			}

			if(ph instanceof PhongMayTinh)
			{
				System.out.println(tieuDePMT());
				System.out.println("*****************************************************************************************************************************************");
				System.out.println(ph);
				System.out.println("*****************************************************************************************************************************************");
				PhongMayTinh phSua = (PhongMayTinh) ph;
				do
				{
					menuSuaPMT();
					System.out.println("Nhập lựa chọn của bạn: ");
					chon = sc.nextInt();
					daSua++;
					menuThucHienSua(chon, phSua);
					if(chon == 4)
					{
						int soMayTinh = nhapSoNguyen("Nhập số lượng máy tính: ");
						phSua.setSoMayTinh(soMayTinh);
					}
					if(chon == 5)
					{
						if(daSua >= 1)
							ds.suaPhongHoc(phSua);
						System.out.println("Đã sửa phòng máy tính này thành công.");
					}
				}
				while(chon < 5);
			}

			if(ph instanceof PhongThiNghiem)
			{
				System.out.println(tieuDePTN());
				System.out.println("*********************************************************************************************************************************************************************************************");
				System.out.println(ph);
				System.out.println("*********************************************************************************************************************************************************************************************");
				PhongThiNghiem phSua = (PhongThiNghiem) ph;
				do
				{
					menuSuaPTN();
					System.out.println("Nhập lựa chọn của bạn: ");
					chon = sc.nextInt();
					daSua++;
					menuThucHienSua(chon, phSua);
					if(chon == 4)
					{
						String chuyenNganh = nhapChuoi("Nhập thông tin chuyên ngành của phòng: ");
						phSua.setChuyenNganh(chuyenNganh);
					}
					if(chon == 5)
					{
						int sucChua = nhapSoNguyen("Nhập sức chứa của phòng: ");
						phSua.setSucChua(sucChua);
					}
					if(chon == 6)
					{
						boolean bonRua;
						String strBonRua = nhapChuoi("Chọn [Y] nếu phòng có bồn rửa, [N] nếu phòng không có bồn rửa: ");
						while(!strBonRua.equalsIgnoreCase("Y")  && !strBonRua.equalsIgnoreCase("N"))
						{
							System.out.println("Bạn nhập không đúng vui lòng nhập lại: ");
							strBonRua = sc.nextLine();
						}
						if(strBonRua == "Y")
							bonRua = true;
						bonRua = false;
						phSua.setBonRua(bonRua);
					}
					if(chon == 7)
					{
						if(daSua >= 1)
							ds.suaPhongHoc(phSua);;
							System.out.println("Đã sửa phòng thí nghiệm này thành công.");
					}
				}
				while(chon < 7);
			}
		}
		else
		{
			System.out.println("Phòng học này không tồn tại.");
		}
	}

	//-------------------------Tìm phòng học-------------------------
	public static void timKiemPH()
	{
		String maPH;
		int chon;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã phòng học cần tìm: ");
		maPH = sc.nextLine();
		PhongHoc ph = ds.timKiemPhongHoc(maPH);

		if(ph != null)
		{
			if(ph instanceof PhongLyThuyet)
			{
				System.out.println(tieuDePLT());
				System.out.println("*****************************************************************************************************************************************");
				System.out.println(ph);
				System.out.println("*****************************************************************************************************************************************");
			}

			if(ph instanceof PhongMayTinh)
			{
				System.out.println(tieuDePMT());
				System.out.println("*****************************************************************************************************************************************");
				System.out.println(ph);
				System.out.println("*****************************************************************************************************************************************");
			}
			else
			{
				System.out.println(tieuDePTN());
				System.out.println("*********************************************************************************************************************************************************************************************");
				System.out.println(ph);
				System.out.println("*********************************************************************************************************************************************************************************************");
			}
		}
		else
		{
			System.out.println("Không tìm thấy phòng học này.");
		}
	}

	//----------------------------Xóa phòng học----------------------------
	static void xoaPhong()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã phòng cần xóa: ");
		String maPH = sc.nextLine();
		PhongHoc ph = ds.timKiemPhongHoc(maPH);
		if(ph != null)
		{
			String chon;
			System.out.println("Bạn có xác nhận xóa phòng học này không [Y/N]: ");
			chon = sc.nextLine();
			if(chon.equalsIgnoreCase("Y"))
			{
				ds.xoaPhongHoc(ph);
				System.out.println("Xóa phòng học thành công.");
			}
			else
			{
				System.out.println("Bạn đã chọn giữ lại phòng học này.");
			}
		}
		else
			System.out.println("Phòng học bạn chọn không tồn tại.");
	}

	//-------------------------Sắp xếp theo dãy nhà-------------------------
	public static void sapXepTheoDayNha()
	{
		ds.sapXepTheoDayNha();
		System.out.println("Các phòng học đã được sắp xếp theo dãy nhà thành công.");
	}

	//-----------------------Sắp xếp theo diện tích-------------------------
	public static void sapXepTheoDienTich()
	{
		ds.sapXepTheoDienTich();;
		System.out.println("Các phòng học đã được sắp xếp theo diện tích thành công.");
	}

	//---------------------Sắp xếp theo số bóng đèn-------------------------
	public static void sapXepTheoBongDen()
	{
		ds.sapXepTheoSoBongDen();
		System.out.println("Các phòng học đã được sắp xếp theo số bóng đèn thành công.");
	}
}
