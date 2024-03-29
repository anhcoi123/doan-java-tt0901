/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;


import MAPPER.MAPPER_NHASX;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Khoadd
 */
public class BO_NhaSX {
    static char[] table = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        static String TaoMaNSX()
        {
            String tmp = "";
            int n = MAPPER_NHASX.SoDongBangNhaSX();
            int ntemp=n;
            while (ntemp != 0)
            {
                tmp += table[ntemp % 36];
                ntemp = ntemp / 36;
            }

            return tmp;
        }
        public static String ThemNSX(String tennsx)
        {
            String mansx=TaoMaNSX();
            ResultSet dt = MAPPER_NHASX.DTDanhSachNSX();
            try {
                while (dt.next())
                {
                    if (dt.getString("TENNSX").trim().equals(tennsx))
                        return "Lỗi: Đã có nhà sản xuất";
                   
                }
            } 
            catch (SQLException ex) {
	    Logger.getLogger(BO_NhaSX.class.getName()).log(Level.SEVERE, null, ex);
            }
            return MAPPER_NHASX.InsertNSX(mansx, tennsx)==1?"Đã tạo thành công nhà sản xuất":"Lỗi: Không thể tạo nhà sản xuất";
        }
        public static int UpdateNSX(String mansx,String tennsx)
        {
            return MAPPER_NHASX.UpdateNSX(mansx, tennsx);
        }
        
        public static ArrayList<DTO.NhaSX> DanhSachNSX() throws SQLException
        {
            ResultSet tb = MAPPER_NHASX.DTDanhSachNSX();
            ArrayList<DTO.NhaSX> DB = new ArrayList<DTO.NhaSX>();
            while(tb!=null && tb.next())
	    {
		DTO.NhaSX a= new DTO.NhaSX();
                a.setMaNSX(tb.getString("MANSX"));
                a.setTenNSX(tb.getString("TENNHASX"));
		DB.add(a);
            }
            return DB;
        }

        public static ResultSet DTDanhSachNSX()
        {
            return MAPPER_NHASX.DTDanhSachNSX();
        }

        public static DTO.NhaSX NhaSX(String mansx) throws SQLException
        {
            DTO.NhaSX nsx = new DTO.NhaSX();
            ResultSet dt = MAPPER_NHASX.TimNhaSX_MaNSX(mansx);
            if (dt!=null && dt.next())
            {
                nsx.setMaNSX(dt.getString("MaNSX"));
                nsx.setTenNSX(dt.getString("TenNSX"));
            }
            return nsx;
        }

        public static String TenNhaSX(String mansx) throws SQLException
        {
            DTO.NhaSX nsx = new DTO.NhaSX();
            ResultSet dt = MAPPER_NHASX.TimNhaSX_MaNSX(mansx);
            if (dt!=null && dt.next())
            {
                nsx.setTenNSX(dt.getString("TenNSX"));
                return nsx.getTenNSX();
            }
            return "Không tìm thấy nhà sản xuất";
        }	
	
}
