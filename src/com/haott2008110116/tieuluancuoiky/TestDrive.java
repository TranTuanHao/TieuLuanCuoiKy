package com.haott2008110116.tieuluancuoiky;

import java.text.ParseException;
import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) throws ParseException {
        int luaChon = 0;
        Scanner input = new Scanner(System.in);
        DanhSachQuanLy l = new DanhSachQuanLy();
        HangHoa sp1 = new ThucPham("01", "Xoai", 50000 ,150, "1/1/2021","15/1/2021");
        HangHoa sp2 = new ThucPham("02", "Buoi", 100000 ,350, "2/1/2021","16/1/2021");
        HangHoa sp3 = new ThucPham("03", "Nho", 80000 ,300, "6/1/2021","20/1/2021");
        HangHoa sp4 = new ThucPham("04", "Chuoi", 200000 ,50, "3/02/2021","17/02/2021");
        HangHoa sp5 = new ThucPham("05", "Hanh la", 2000 ,10, "3/05/2021","17/05/2021");
        HangHoa sp6 = new ThucPham("06", "Rau cai", 5000 ,200, "13/08/2021","27/08/2021");
 
        HangHoa sp7 = new SanhSu("01", "Binh su", 300000, 150, "30/05/2021", "Dong Nai");
        HangHoa sp8 = new SanhSu("02", "Tach tra su", 25000, 240, "21/10/2021", "Quang Nam");
        HangHoa sp9 = new SanhSu("03", "Dia su", 150000, 350, "20/02/2020", "Binh Dinh");
        HangHoa sp10 = new SanhSu("04", "Tranh treo tuong su", 500000, 250, "28/01/2020", "Thua Thien Hue");
        HangHoa sp11 = new SanhSu("05", "Am tra su ", 100000, 400, "29/12/2020", "Ha Noi");
        HangHoa sp12 = new SanhSu("06", "Ly su", 50000, 300, "30/04/2021", "TP HCM");
        HangHoa sp13 = new SanhSu("07", "Chen su", 30000, 200, "20/10/2021", "Da Nang");

        HangHoa sp14 = new DienMay("01", "May Lanh", 10000000, 100,"15/06/2021", 300);
        HangHoa sp15 = new DienMay("02", "Tu lanh", 30000000, 150,"18/09/2021", 400);
        HangHoa sp16 = new DienMay("03", "Lo vi song", 3500000, 200,"25/12/2021", 250);
        HangHoa sp17 = new DienMay("04", "May hut bui", 2500000, 250,"04/1/2021", 800);
        HangHoa sp18 = new DienMay("05", "May say toc", 650000, 300,"01/07/2021", 600);
        HangHoa sp19 = new DienMay("06", "Ti vi", 3000000, 350,"14/09/2021", 250);
        HangHoa sp20 = new DienMay("07", "May Loc Nuoc", 5000000, 400,"23/07/2021", 500);
        l.themHangHoa(sp1);
        l.themHangHoa(sp2);
        l.themHangHoa(sp3);
        l.themHangHoa(sp4);
        l.themHangHoa(sp5);
        l.themHangHoa(sp6);
        l.themHangHoa(sp7);
        l.themHangHoa(sp8);
        l.themHangHoa(sp9);
        l.themHangHoa(sp10);
        l.themHangHoa(sp11);
        l.themHangHoa(sp12);
        l.themHangHoa(sp13);
        l.themHangHoa(sp14);
        l.themHangHoa(sp15);
        l.themHangHoa(sp16);
        l.themHangHoa(sp17);
        l.themHangHoa(sp18);
        l.themHangHoa(sp19);
        l.themHangHoa(sp20);
        
		while (luaChon != 6){
            System.out.println("-----------------MENU------------------");
            System.out.println("*   1> Hang hoa                       *");
            System.out.println("*   2> Tim kiem                       *");
            System.out.println("*   3> Sap xep tang dan               *");
            System.out.println("*   4> Sap xep giam dan               *");
            System.out.println("*   5> Thong ke                       *");
            System.out.println("*   6> Thoat chuong trinh             *");
            System.out.println("---------------------------------------");
            System.out.print("Chon chuc nang: ");
            luaChon = input.nextInt();
            switch(luaChon){
                case 1: {
                    System.out.println("-----Hang hoa-----");
                    System.out.println("1> Them hang hoa ");
                    System.out.println("2> Sua hang hoa ");
                    System.out.println("3> Xoa hang hoa ");
                    System.out.println("4> Quay lai");
                    System.out.println("------------------");
                    System.out.print("Chon chuc nang: ");
                    luaChon = input.nextInt();
                    switch(luaChon){
                        case 1: l.themHangHoa();break;
                        case 2: l.suaHangHoa();break;
                        case 3: l.xoaHangHoa();break;
                        case 4: break;
                        default:  System.out.println("Chon sai chuc nang!!! Vui long chon lai");break;
                    }
                    break;
                }
                case 2: {
                    System.out.println("----------Tim kiem----------");
                    System.out.println("1> Tim kiem theo loai ");
                    System.out.println("2> Tim kiem theo ngay nhap ");
                    System.out.println("3> Tim kiem theo gia ");
                    System.out.println("4> Quay lai");
                    System.out.println("----------------------------");
                    System.out.print("Chon chuc nang: ");
                    luaChon = input.nextInt();
                    switch(luaChon){
                        case 1: l.timKiemTheoLoai();break;
                        case 2: l.timKiemTheoNgay();break;
                        case 3: l.timKiemTheoGia();break;
                        case 4: break;
                        default:  System.out.println("Chon sai chuc nang!!! Vui long chon lai");break;
                    }
                    break;
                }
                case 3: {
                    System.out.println("-----Sap xep tang dan-----");
                    System.out.println("1> Gia nhap ");
                    System.out.println("2> Ngay nhap ");
                    System.out.println("3> Loai va ngay nhap ");
                    System.out.println("4> Loai va gia nhap ");
                    System.out.println("5> Quay lai");
                    System.out.println("--------------------------");
                    System.out.print("Chon chuc nang: ");
                    luaChon = input.nextInt();
                    switch(luaChon){
                        case 1: l.sapXepHangHoaTangDanTheoGia();break;
                        case 2: l.sapXepHangHoaTangDanTheoNgay();break;
                        case 3: l.SapXepTangDanTheoLoaiVaTheoNgayNhap();break;
                        case 4: l.SapXepTangDanTheoLoaiVaTheoGia();break;
                        case 5: break;
                        default:  System.out.println("Chon sai chuc nang!!! Vui long chon lai");break;
                    }
                    break;
                }
                case 4: {
                    System.out.println("-----Sap xep giam dan-----");
                    System.out.println("1> Gia nhap ");
                    System.out.println("2> Ngay nhap ");
                    System.out.println("3> Loai va ngay nhap ");
                    System.out.println("4> Loai va gia nhap ");
                    System.out.println("5> Quay lai");
                    System.out.println("--------------------------");
                    System.out.print("Chon chuc nang: ");
                    luaChon = input.nextInt();
                    switch(luaChon){
                        case 1: l.sapXepHangHoaGiamDanTheoGia();break;
                        case 2: l.sapXepHangHoaGiamDanTheoNgay();break;
                        case 3: l.SapXepGiamDanTheoLoaiVaTheoNgayNhap();break;
                        case 4: l.SapXepGiamDanTheoLoaiVaTheoGia();break;
                        case 5: break;
                        default:  System.out.println("Chon sai chuc nang!!! Vui long chon lai");break;
                    }
                    break;
                }
                case 5: l.thongKeTongHangHoa();break;
                case 6:  System.out.println("Da thoat khoi chuong trinh");break;
                default: System.out.println("Chon sai chuc nang!!! Vui long chon lai");break;
                
            }
            
        }
    }
}
