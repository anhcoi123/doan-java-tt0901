/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import net.sourceforge.jtds.jdbc.DateTime;

/**
 *
 * @author Lucifer
 */
public class BO_DONDH {
        static char[] table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        static String TaoMaDH()
        {
            String tmp = "";
            int n = MAPPER.MAPPER_DONDH.SoDongBangDonDH();
            int ntemp = n;
            while (ntemp != 0)
            {
                tmp += table[ntemp % 36];
                ntemp = ntemp / 36;
            }
            if (tmp.equals("")) tmp = "0";
            return tmp;
        }

        public static String ThemGioHangVaoDonDH(DTO.GioHang gh, String makh)
        {
            

            String madh = TaoMaDH();
            try
            {
		java.sql.Date abc=new java.sql.Date(System.currentTimeMillis());
                MAPPER.MAPPER_DONDH.AddDonDH(madh, makh, abc.toString(), gh.getThanhTien(), "0");

                for (int i=0;i<gh.getLinhKien().size();i++)
                {
                    MAPPER.MAPPER_DONDH.AddCTDonDH(madh, gh.getLinhKien().get(i).getMaLK(), gh.getLinhKien().get(i).getSoLuong(), gh.getLinhKien().get(i).getDonGia());
                }
                return "Đặt mua hàng thành công";
            }
            catch (Exception ex)
            {
                return "Lỗi";
            }
        }
	
	public static ResultSet RSDanhSachDonDH()
	{
	    return MAPPER.MAPPER_DONDH.RSDanhSachDonDH();
	}
	
        public static int InsertDonDH(String madh, String makh, String ngaydh, int thanhtien, String tinhtrang)
        {
            return MAPPER.MAPPER_DONDH.AddDonDH(madh, makh, ngaydh, thanhtien,tinhtrang);
        }
        public static int InsertCTDonDH(String madh, String malk, int soluong, int dongiaban)
        {
            return MAPPER.MAPPER_DONDH.AddCTDonDH(madh, malk, soluong, dongiaban);
        }
	
	public static int UpdateDonDH(String madh, String tinhtrang)
        {
            return MAPPER.MAPPER_DONDH.UpdateDonDH(madh,tinhtrang);
        }
	
	public static DTO.DonDH DonDH(String madh) throws SQLException
	{
	    DTO.DonDH dondh=new DTO.DonDH();
	    ResultSet rs=MAPPER.MAPPER_DONDH.RSDonDH_MaDH(madh);
	    while(rs!=null && rs.next())
	    {
		dondh.setMaDH(rs.getString("MADH"));
		dondh.setMaKH(rs.getString("MAKH"));
		dondh.setNgayDH(rs.getString("NGAYDH"));
		dondh.setThanhTien(rs.getInt("THANHTIEN"));
		dondh.setTinhtrang(rs.getString("TINHTRANG"));
	    }
	    return dondh;
	}
}
