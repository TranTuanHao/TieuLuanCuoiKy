package com.haott2008110116.tieuluancuoiky;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class DanhSachQuanLy {
    private ArrayList<HangHoa> list ;
    private Scanner input = new Scanner(System.in);
    DanhSachQuanLy(){
        list = new ArrayList<HangHoa>(30);
    }
    public ArrayList<HangHoa> getList() {
        return list;
    }
    public void setList(ArrayList<HangHoa> list) {
        this.list = list;
    }
    public void themHangHoa(HangHoa x) throws ParseException{
        int count = 0 ;
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa sp = list.get(i);
            if(sp.getMaHang().equalsIgnoreCase(x.getMaHang()) ||
            sp.getMaHang().equalsIgnoreCase("HTP-")||sp.getMaHang()
            .equalsIgnoreCase("HSS-") || sp.getMaHang().equalsIgnoreCase("HDM-") ){
                System.out.println("loi nhap sai hoac trung ma hang! vui long nhap lai");
                count++ ;
                themHangHoa();
                break;
            }
        }
        if(count == 0){
            list.add(x);
        }
    }
    public void themHangHoa() throws ParseException {
        System.out.println(" 1> Thuc pham ");
        System.out.println(" 2> Sanh su ");
        System.out.println(" 3> Dien may ");
		System.out.println(" 4> Quay lai ");
        System.out.print("Chon chuc nang: ");
    	int luaChon = input.nextInt();
        HangHoa x;
        switch(luaChon){
            case 1: {
                System.out.print("Nhap ma hang hoa: ");
				input.nextLine();
				String maHH = input.nextLine();
				System.out.print("Nhap ten hang hoa: ");
				String tenHH = input.nextLine();
				System.out.print("Nhap so luong ton kho: ");
				int soLuongTonKho = input.nextInt();
				System.out.print("Nhap don gia: ");
				int donGia = input.nextInt();
				System.out.print("Nhap ngay nhap kho: ");
                input.nextLine();
				String ngayNK = input.nextLine();
                System.out.print("Nhap ngay het han: ");
				String ngayHH = input.nextLine();
				x = new ThucPham( maHH, tenHH , donGia , soLuongTonKho , ngayNK , ngayHH );
				themHangHoa(x);
                break;
            }
			case 2: {
                System.out.print("Nhap ma hang hoa: ");
				input.nextLine();
				String maHH = input.nextLine();
				System.out.print("Nhap ten hang hoa: ");
				String tenHH = input.nextLine();
				System.out.print("Nhap so luong ton kho: ");
				int soLuongTonKho = input.nextInt();
				System.out.print("Nhap don gia: ");
				int donGia = input.nextInt();	
				System.out.print("Nhap ngay nhap kho: ");
                input.nextLine();
				String ngayNK = input.nextLine();
                System.out.print("Nhap nha cung cap: ");
                String nhaCC = input.nextLine();
				x = new SanhSu(maHH, tenHH, donGia , soLuongTonKho , ngayNK , nhaCC);
                themHangHoa(x);
                break;
			}
			case 3: {
                System.out.print("Nhap ma hang hoa: ");
				input.nextLine();
				String maHH = input.nextLine();
				System.out.print("Nhap ten hang hoa: ");
				String tenHH = input.nextLine();
				System.out.print("Nhap so luong ton kho: ");
				int soLuongTonKho = input.nextInt();
				System.out.print("Nhap don gia: ");
				int donGia = input.nextInt();	
				System.out.print("Nhap ngay nhap kho: ");
                input.nextLine();
				String ngayNK = input.nextLine();
                System.out.print("Nhap cong suat thiet bi: ");
                int congSuat =input.nextInt();
				x = new DienMay(maHH, tenHH , donGia , soLuongTonKho,ngayNK, congSuat) ;
				themHangHoa(x);
                break;
			}
            case 4: break;
			default: System.out.println("Chon sai chuc nang!!! Vui long chon lai");break;
        } 
	}
    public void suaHangHoa() throws ParseException{
        System.out.print("Nhap ma hang hoa cua hang can sua: ");
        String maHang = input.nextLine();
        for(int i = 0 ; i< list.size();i++){
            HangHoa x = list.get(i);
            if(x.getMaHang().equals(maHang)){
                if(x instanceof ThucPham){
                    String[] maHH = maHang.split("------------------------------",2);
                    System.out.print("Nhap ten hang hoa: ");
                    String tenHH = input.nextLine();
                    System.out.print("Nhap so luong ton kho: ");
                    int soLuongTonKho = input.nextInt();
                    System.out.print("Nhap don gia: ");
                    int donGia = input.nextInt();	
                    System.out.print("Nhap ngay nhap kho: ");
                    input.nextLine();
                    String ngayNK = input.nextLine();
                    System.out.print("Nhap ngay het han: ");
                    String ngayHH = input.nextLine();
                    HangHoa a = new ThucPham( maHH[1], tenHH , donGia , 
                    soLuongTonKho , ngayNK , ngayHH );
                    list.add(list.indexOf(x),a);
                    list.remove(x);
                }
                else if(x instanceof SanhSu){
                    String[] maHH = maHang.split("----------------------------------",2);
                    System.out.print("Nhap ten hang hoa: ");
                    String tenHH = input.nextLine();
                    System.out.print("Nhap so luong ton kho: ");
                    int soLuongTonKho = input.nextInt();
                    System.out.print("Nhap don gia: ");
                    int donGia = input.nextInt();				
                    System.out.print("Nhap ngay nhap kho: ");
                    input.nextLine();
                    String ngayNK = input.nextLine();
                    System.out.print("Nhap nha cung cap: ");
                    String nhaCC = input.nextLine();
                    HangHoa a = new SanhSu(maHH[1], tenHH, donGia , soLuongTonKho , 
                    ngayNK , nhaCC);
                    list.add(list.indexOf(x),a);
                    list.remove(x);
                }
                else if(x instanceof DienMay){
                    String[] maHH = maHang.split("-------------------------------",2);
                    System.out.print("Nhap ten hang hoa: ");
                    String tenHH = input.nextLine();
                    System.out.print("Nhap so luong ton kho: ");
                    int soLuongTonKho = input.nextInt();
                    System.out.print("Nhap don gia: ");
                    int donGia = input.nextInt();				
                    System.out.print("Nhap ngay nhap kho: ");
                    input.nextLine();
                    String ngayNK = input.nextLine();
                    System.out.print("Nhap cong suat thiet bi: ");
                    int congSuat =input.nextInt();
                    HangHoa a = new DienMay(maHH[1], tenHH , donGia , soLuongTonKho,
                    ngayNK, congSuat) ;
                    list.add(list.indexOf(x),a);
                    list.remove(x);
                }
            }
        }
    }
    public void xoaHangHoa(){
        System.out.print("Nhap ma hang hoa can xoa: ");
		String maHH = input.nextLine();
		for(int i = 0 ; i <list.size() ; i++){
            HangHoa x = list.get(i);
            if(x.getMaHang().equals(maHH)){
                list.remove(x);
                System.out.println("Da xoa thanh cong hang hoa nay");
            }
        }
    }
    public void xuatThucPham(){
		System.out.println("THUC PHAM");
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang",
        "Ten Hang Hoa","So Luong ton Kho",
        "Gia Nhap Kho","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof ThucPham){
                System.out.println(hangHoa);
            }
        }
        System.out.println();

    }
    public void xuatSanhSu(){
		System.out.println("SANH SU");
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang",
        "Ten Hang Hoa","So Luong ton Kho",
        "Gia Nhap Kho","Ngay Nhap Kho","Xuat xu","Tong gia tri");
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof SanhSu){
                System.out.println(hangHoa);
            }
        }
        System.out.println();
    }
    public void xuatDienMay(){
		System.out.println("DIEN MAY");
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang",
        "Ten Hang Hoa","So Luong ton Kho",
        "Gia Nhap Kho","Ngay Nhap Kho","Cong suat","Tong gia tri");
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof DienMay){
                System.out.println(hangHoa);
            }
        }
        System.out.println();
    }
    public void xuatThucPhamTrucTiep(HangHoa x){
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang",
        "Ten Hang Hoa","So Luong ton Kho",
        "Gia Nhap Kho","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        System.out.println(x);
        System.out.println();

    }
    public void xuatSanhSuTrucTiep(HangHoa x){
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang",
        "Ten Hang Hoa","So Luong ton Kho",
        "Gia Nhap Kho","Ngay Nhap Kho","Xuat xu","Tong gia tri");
        System.out.println(x);
        System.out.println();
    }
    public void xuatDienMayTrucTiep(HangHoa x){
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang",
        "Ten Hang Hoa","So Luong ton Kho",
        "Gia Nhap Kho","Ngay Nhap Kho","Cong suat","Tong gia tri");
        System.out.println(x);
        System.out.println();
    }
    public void xuatThucPhamTheoDanhSach(ArrayList<HangHoa> l){
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang",
        "Ten Hang Hoa","So Luong ton Kho",
        "Gia Nhap Kho","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        System.out.println();

    }
    public void xuatSanhSuTheoDanhSach(ArrayList<HangHoa> l){
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang",
        "Ten Hang Hoa","So Luong ton Kho",
        "Gia Nhap Kho","Ngay Nhap Kho","Xuat xu","Tong gia tri");
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        System.out.println();

    }
    public void xuatDienMayTheoDanhSach(ArrayList<HangHoa> l){
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang",
        "Ten Hang Hoa","So Luong ton Kho",
        "Gia Nhap Kho","Ngay Nhap Kho","Cong suat","Tong gia tri");
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        System.out.println();
    }
    public void xuatTatCa(){
        for(int i = 0 ; i < list.size() ; i++){
           HangHoa x = list.get(i);
            if(x instanceof ThucPham){
                xuatThucPhamTrucTiep(x);
            }
            else if(x instanceof SanhSu){
                xuatSanhSuTrucTiep(x);
            }
            else if(x instanceof DienMay){
                xuatDienMayTrucTiep(x);
            }
        }
    }
    public void sapXepHangHoaGiamDanTheoGia(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatTatCa();
    }
    public void sapXepHangHoaTangDanTheoGia(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatTatCa();
    }
    public void sapXepHangHoaTangDanTheoNgay(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) < 0){
                    return -1 ;
                }
                else {
                    if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatTatCa();
    }
    public void sapXepHangHoaGiamDanTheoNgay(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) < 0){
                    return 1 ;
                }
                else {
                    if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatTatCa();
    }
    public void SapXepTangDanTheoLoaiVaTheoNgayNhap(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x instanceof ThucPham){
                list1.add(x);
            }
            else if(x instanceof SanhSu){
                list2.add(x);
            }
            else if(x instanceof DienMay){
                list3.add(x);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) < 0){
                    return -1 ;
                }
                else {
                    if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatThucPhamTheoDanhSach(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) < 0){
                    return -1 ;
                }
                else {
                    if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatSanhSuTheoDanhSach(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) < 0){
                    return -1 ;
                }
                else {
                    if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatDienMayTheoDanhSach(list3);
    }
    public void SapXepGiamDanTheoLoaiVaTheoNgayNhap(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x instanceof ThucPham){
                list1.add(x);
            }
            else if(x instanceof SanhSu){
                list2.add(x);
            }
            else if(x instanceof DienMay){
                list3.add(x);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) < 0){
                    return 1 ;
                }
                else {
                    if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatThucPhamTheoDanhSach(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) < 0){
                    return 1 ;
                }
                else {
                    if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatSanhSuTheoDanhSach(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) < 0){
                    return 1 ;
                }
                else {
                    if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatDienMayTheoDanhSach(list3);
    }
    public void SapXepTangDanTheoLoaiVaTheoGia(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x instanceof ThucPham){
                list1.add(x);
            }
            else if(x instanceof SanhSu){
                list2.add(x);
            }
            else if(x instanceof DienMay){
                list3.add(x);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatThucPhamTheoDanhSach(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatSanhSuTheoDanhSach(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatDienMayTheoDanhSach(list3);
    }
    public void SapXepGiamDanTheoLoaiVaTheoGia(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x instanceof ThucPham){
                list1.add(x);
            }
            else if(x instanceof SanhSu){
                list2.add(x);
            }
            else if(x instanceof DienMay){
                list3.add(x);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatThucPhamTheoDanhSach(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatSanhSuTheoDanhSach(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return 1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatDienMayTheoDanhSach(list3);
    }
    public void timKiemTheoLoai(){
        int luaChon = 0;
		System.out.println(" 1> Thuc pham ");
		System.out.println(" 2> Sanh su ");
		System.out.println(" 3> Dien may ");
        System.out.println(" 4> Quay lai");
        System.out.print("Chon chuc nang: ");
		luaChon = input.nextInt();
		switch(luaChon){
			case 1: xuatThucPham();
                    break;
					
			case 2: xuatSanhSu();
					break;
					
			case 3: xuatDienMay();
					break;
					
            case 4: break;
            default: System.out.println("Chon sai chuc nang!!! Vui long chon lai");break;
		}
    }
    public void timKiemTheoNgay() throws ParseException{
        System.out.println("Thoi gian can tim kiem tu ngay: ");
		String ngayBatDau = input.nextLine();
		System.out.println("Den ngay : ");
		String ngayKetThuc = input.nextLine();
		System.out.println("Cac loai hang da nhap kho tu ngay " + ngayBatDau +
        " den ngay " + ngayKetThuc + ": ");
        for(int i = 0 ; i<list.size() ; i++){
            HangHoa x = list.get(i);
            if(x.getNgayNhapKho().compareTo(chuyenChuoiSangNgay(ngayBatDau)) >= 0 &&
            x.getNgayNhapKho()
            .compareTo(chuyenChuoiSangNgay(ngayKetThuc))<=0  ){
                if(x instanceof ThucPham){
                    xuatThucPhamTrucTiep(x);
                }
                else if(x instanceof SanhSu){
                    xuatSanhSuTrucTiep(x);
                }
                else if(x instanceof DienMay){
                    xuatDienMayTrucTiep(x);
                }
            }
        }
    }
    public void timKiemTheoGia(){
        System.out.println("Gia can tim kiem tu: ");
		long giaBatDau = input.nextLong();
		System.out.println("Den: ");
		long giaKetThuc = input.nextLong();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x.getGiaNhap() >= giaBatDau && x.getGiaNhap() <= giaKetThuc){
                if(x instanceof ThucPham){
                    xuatThucPhamTrucTiep(x);
                }
                else if(x instanceof SanhSu){
                    xuatSanhSuTrucTiep(x);
                }
                else if(x instanceof DienMay){
                    xuatDienMayTrucTiep(x);
                }
            }
        }
    }
    public static Date chuyenChuoiSangNgay(String chuoiNgay) throws ParseException{
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        date = simpleDateFormat.parse(chuoiNgay);
        return date;
    }
    DecimalFormat ft = new DecimalFormat("###,###,### VND");
    public void thongKeTongHangHoa(){
        long tongSoLuong = 0 ,tongChiPhi = 0;
        for (HangHoa hangHoa : list) {
            tongSoLuong += hangHoa.getSoLuongTonKho();
            tongChiPhi += hangHoa.tinhTien();
        }
		xuatThucPham();
        xuatSanhSu();
        xuatDienMay();
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-34s|%-112s|\n","Tong so luong hang trong kho",tongSoLuong);
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-34s|%-112s|\n","Tong chi phi hang trong kho",ft.format(tongChiPhi));
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
}
