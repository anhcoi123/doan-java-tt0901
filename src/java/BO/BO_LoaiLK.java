/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;
import MAPPER.MAPPER_LOAILK;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Khoadd
 */
public class BO_LoaiLK {
    static char[] table={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    static String TaoMaLoaiLK()
    {
        String tmp="";
        int n= MAPPER_LOAILK.SoDongBangLoaiLK();
        int ntemp=n;
        while(ntemp!=0)
        {
            tmp+= table[ntemp%36];
            ntemp=ntemp/36;
        }
        return tmp;
    }
    public static String ThemLoaiLK(String tenloailk)
    {
        String maloailk=TaoMaLoaiLK();
        ResultSet dt= MAPPER_LOAILK.DTDanhSachLoaiLK();
        try{
            while(dt.next())
            {
                if(dt.getString("TENLOAILK").trim().equals(tenloailk)) {
                    return "Lỗi:Đã có tên loại linh kiện này";
                }
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(BO_LoaiLK.class.getName()).log(Level.SEVERE, null,ex);
        }
        return MAPPER_LOAILK.InsertLoaiLK(maloailk, tenloailk)==1?"Đã thêm thành công loại linh kiện":"Lỗi Không thể tạo loại linh kiện";
        }
    public static String UpdateLoaiLK(String maloailk,String tenloailk)
    {
        return MAPPER_LOAILK.UpdateLoaiLK(maloailk, tenloailk)==1?"Sửa thành công":"Sửa thất bại";
    }
}
