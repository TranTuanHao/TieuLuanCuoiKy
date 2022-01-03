package com.haott2008110116.tieuluancuoiky;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangHoa {
    private String maHang;
    private String tenHangHoa;
    private Long giaNhap;
    private int soLuongTonKho;
    private Date ngayNhapKho;

    public HangHoa(String maHang , String tenHangHoa , long giaNhap , int soLuongTonKho , 
    String ngayNhapKho) throws ParseException {
        this.maHang = maHang;
        this.tenHangHoa = tenHangHoa ;
        this.giaNhap = giaNhap ;
        this.soLuongTonKho = soLuongTonKho;
        this.ngayNhapKho = chuyenChuoiSangNgay(ngayNhapKho);
        
    }
    public String getMaHang() {
        return maHang;
    }
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    public String getTenHangHoa() {
        return tenHangHoa;
    }
    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }
    public Long getGiaNhap() {
        return giaNhap;
    }
    public void setGiaNhap(Long giaNhap) {
        this.giaNhap = giaNhap;
    }
    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }
    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }
    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }
    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }
    public static Date chuyenChuoiSangNgay(String chuoiNgay) throws ParseException{
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        date = simpleDateFormat.parse(chuoiNgay);
        return date;
    }
	public static String chuyenNgaySangChuoi(Date date){
        String chuoiNgayViet = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        chuoiNgayViet =  simpleDateFormat.format(date);
        return chuoiNgayViet;

    }
    public long tinhTien(){
        return (long)(getSoLuongTonKho()*getGiaNhap());
    }
    DecimalFormat ft = new DecimalFormat("###,###,### VND");
    public String toString() {
		String s = "";
		s+=String.format("|%-8s|%-25s|%-25s|%-23s|%-20s|", getMaHang(),getTenHangHoa(),
        getSoLuongTonKho(), ft.format(getGiaNhap()),chuyenNgaySangChuoi(getNgayNhapKho()));
		return s;
	}
}
