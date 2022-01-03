package com.haott2008110116.tieuluancuoiky;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

public class ThucPham extends HangHoa{
    private Date ngayHetHan;
    public ThucPham(String maHang, String tenHangHoa, long giaNhap, int soLuongTonKho,
    String ngayNhapKho , String ngayHetHan)throws ParseException {
        super("HTP-" + maHang, tenHangHoa, giaNhap, soLuongTonKho, ngayNhapKho);
        this.ngayHetHan = chuyenChuoiSangNgay(ngayHetHan);
    }
    public Date getNgayHetHan() {
        return ngayHetHan;
    }
    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
    DecimalFormat ft = new DecimalFormat("###,###,### VND");
    @Override
    public String toString() {
        String s ;
        s = super.toString() + String.format( "%-20s|%-20s|", 
        chuyenNgaySangChuoi(getNgayHetHan()) , ft.format(tinhTien()));
        return s;
    }
}
