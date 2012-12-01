/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import MAPPER.MAPPER_NHACC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Khoadd
 */
public class BO_NhaCC {
    static char[] table={ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    static String TaoMaNCC()
    {
        String tmp="";
        int n= MAPPER_NHACC.SoDongBangNhaCC();
        int ntemp=n;
        while(ntemp!=0)
        {
            tmp+=table[ntemp%36];
            ntemp= ntemp/36;
        }
        return tmp;
    }
    public static String ThemNCC(String tenncc, String diachi,String sodt)
    {
        String mancc=TaoMaNCC();
        ResultSet dt= MAPPER_NHACC.DTDanhSachNhaCC();
        try{
            while(dt.next())
            {
                if(dt.getString("TENNCC").trim().equals(tenncc))
                  return "Lỗi:Đã có nhà cung cấp này";
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(BO_KhachHang.class.getName()).log(Level.SEVERE, null,ex);
        }
        return MAPPER_NHACC.InsertNCC(mancc, tenncc, diachi, sodt)==1?"Đã tạo thành công nhà cung cấp":"Lỗi: Không thể tạo nhà cung cấp";
    }
    public static String UpdateNCC(String mancc,String tenncc,String diachi,String sodt)
    {
        return MAPPER_NHACC.UpdateNCC(mancc, tenncc, diachi, sodt)==1?"Sửa thành công":"Sửa thất bại";
    }
    
}
