/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPPER;

import java.sql.ResultSet;

/**
 *
 * @author Lucifer
 */
public class MAPPER_Admin {
        private static String sqlKTDangNhap="SELECT * FROM KHACHHANG WHERE TENDANGNHAP=@TENDANGNHAP AND MATKHAU=@MATKHAU AND ROLE='1'" ;
        private static String sqlLayTen = "SELECT TENKH FROM KHACHHANG WHERE TENDANGNHAP=@TENDANGNHAP AND ROLE='1'";

        public static ResultSet KTDangNhap(String TENDANGNHAP, String MATKHAU)
        {
            String sqlKTDangNhap="SELECT * FROM KHACHHANG WHERE TENDANGNHAP='"+TENDANGNHAP+"' AND MATKHAU='"+MATKHAU+"' AND ROLE='1'" ;
            return MAPPERDB.getResultSet(sqlKTDangNhap);
        }

        public static ResultSet LayTenAdmin(String TENDANGNHAP)
        {
	    String sqlLayTen = "SELECT TENKH FROM KHACHHANG WHERE TENDANGNHAP='" + TENDANGNHAP+ "' AND ROLE='1'";
            return MAPPERDB.getResultSet(sqlLayTen);
        }

}
