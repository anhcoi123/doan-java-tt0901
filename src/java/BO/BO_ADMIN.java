/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lucifer
 */
public class BO_ADMIN {
        public static Boolean KiemTraDN(String tendangnhap, String matkhau) throws SQLException
        {
            ResultSet tb = MAPPER.MAPPER_Admin.KTDangNhap(tendangnhap, matkhau);
            if (tb==null || !tb.next())
            {
                return false;
            }
            return true;
        }
        public static String LayTen(String tendangnhap) throws SQLException
        {
            String a = null;
            ResultSet tb = null;
            tb = MAPPER.MAPPER_Admin.LayTenAdmin(tendangnhap);
	    if (tb.next())
	    {
		a = tb.getString("TENKH");
	    }
            return a;
        }
}
