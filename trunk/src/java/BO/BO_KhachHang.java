/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucifer
 */
public class BO_KhachHang {
	static char[] table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        static String TaoMaKH()
        {
            String tmp = "";
            int n = MAPPER_KHACHHANG.SoDongBangKH();
            int ntemp=n;
            while (ntemp != 0)
            {
                tmp += table[ntemp % 36];
                ntemp = ntemp / 36;
            }

            return tmp;
        }

        public static DTO.KhachHang KTraDangNhap(String tendangnhap, String matkhau)
        {
            ResultSet dt = DAL_KHACHHANG.DTDanhSachKH();
            DTO.KhachHang kh=new DTO.KhachHang();
	try {
	    while (dt.next())
	    {
		if (dt.getString("TENDANGNHAP").trim().equals(tendangnhap) && dt.getString("MATKHAU").trim().equals(matkhau))
		{
		    kh.setCMND(dt.getString("CMND").trim());
		    kh.setDiaChi(dt.getString("DIACHI").trim());
		    kh.setMaKH(dt.getString("MAKH").trim());
		    kh.setMatKhau(dt.getString("MATKHAU").trim());
		    kh.setSoDT(dt.getString("SODT").trim());
		    kh.setTenDangNhap(tendangnhap);
		    kh.setTenKH(dt.getString("TENKH").trim());
		    return kh;
		}
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(BO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
	}
            return null;
        }

        public static String ThemKH(String tenkh, String tendn, String matkhau, String diachi, String sodt, String cmnd)
        {
            String makh=TaoMaKH();
            ResultSet dt = MAPPER_KHACHHANG.DTDanhSachKH();
	try {
	    while (dt.next())
	    {
		if (dt.getString("TENDANGNHAP").trim().equals(tendn))
		    return "Lỗi: Đã có người sử dụng tên đăng nhập này, vui lòng chọn tên đăng nhập khác";
		if (dt.getString("CMND").trim().equals(cmnd))
		    return "Lỗi: Đã có người sử dụng số CMND này, vui lòng kiểm tra lại";
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(BO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
	}
            return MAPPER_KHACHHANG.InsertKH(makh, tenkh, tendn, matkhau, diachi, sodt, cmnd, "0")==1?"Đã tạo thành công tài khoản":"Lỗi: Không thể tạo tài khoản";
        }
}
