/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPPER;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lucifer
 */
public class MAPPER_LINHKIEN {
	private static String sqlTatCaLinhKien = "EXECUTE SP_TATCALK";
        
        private static String sqlDonGia = "SELECT DONGIA FROM LINHKIEN WHERE MALK=@MALK";
        private static String sqlAdd = "EXECUTE SP_THEMLK @MALK,@TENLK,@DVTINH,@SOLUONG,@DONGIA,@THONGTIN,@HINHANH,@MALOAILK,@MANSX";
        //private static String sqlUpdate = "UPDATE LINHKIEN SET TENLK=@TENLK,DVTINH=@DVTINH,SOLUONG=@SOLUONG,DONGIA=@DONGIA,THONGTIN=@THONGTIN,HINHANH=@HINHANH,MALOAILK=@MALOAILK WHERE MALK=@MALK";
        private static String sqlDelete = "DELETE FROM LINHKIEN WHERE MALK=@MALK";
        private static String sqlTimKiemMaLK = "EXECUTE SP_TIMLK_MALK @MALK";
        private static String sqlTimKiemMaLoaiLK = "SELECT * FROM LINHKIEN WHERE MALOAILK=@MALOAILK";
        
        private static String sqlTimKiemTenLK = "EXECUTE SP_TIMLK_TENLK @TENLK";
        private static String sqlTimKiemTenNSX = "EXECUTE SP_TIMLK_NHASX @TENNSX";
        private static String sql8LinhKienNgauNhien = "SELECT TOP 8 * FROM LINHKIEN ORDER BY NEWID()";
        private static String sqlUpdate = "UPDATE LINHKIEN SET TENLK=@TENLK,DONGIA=@DONGIA WHERE MALK=@MALK";

        
        

        public static ResultSet DTTatCaLK_MaLoaiLK(String maloailk)
        {
	    String sqlTimKiemMaLoaiLK = "SELECT * FROM LINHKIEN WHERE MALOAILK='"+maloailk+"'";
            return MAPPERDB.getResultSet(sqlTimKiemMaLoaiLK);
        }
        

        public static ResultSet Get8Products()
        {
            return MAPPERDB.getResultSet(sql8LinhKienNgauNhien);
        }

        public static ResultSet GetallProducts()
        {
            return MAPPERDB.getResultSet(sqlTatCaLinhKien);
        }

        public static ResultSet GetPrice(String maloailk)
        {
	    String sqlDonGia = "SELECT DONGIA FROM LINHKIEN WHERE MALK='"+maloailk+"'";
            return MAPPERDB.getResultSet(sqlDonGia);
        }

        

        public static DTO.LinhKien searchLK(String id) throws SQLException
        {
            String[] paraName = new String[] { "@MaLK" };
            String[] paraValue = new String[] { id };
            ResultSet dtLK = MAPPERDB.getResultSet(sqlTimKiemMaLK);
            DTO.LinhKien lk = new DTO.LinhKien();
            lk.setDonGia(dtLK.getInt("DONGIA"));
            lk.setdVTinh (dtLK.getString("DVTinh"));
            lk.setHinhAnh (dtLK.getString("HINHANH"));
            lk.setMaLK (dtLK.getString("MALK"));
            lk.setSoLuong (dtLK.getInt("SOLUONG"));
            lk.setTenLK (dtLK.getString("TENLK"));
            lk.setMansx (dtLK.getString("MANSX"));
            lk.setThongTin (dtLK.getString("THONGTIN"));
            return lk;
        }

        public static int AddLK(String malk, String tenlk, String dvtinh, int soluong, int dongia, String thongtin, String hinhanh, String maloailk, String mansx)
        {
	    String sqlAdd = "EXECUTE SP_THEMLK '"+malk+"','"+tenlk+"',@DVTINH,@SOLUONG,@DONGIA,@THONGTIN,@HINHANH,@MALOAILK,@MANSX";
            object[] paraValue = new object[] { malk, tenlk, dvtinh, soluong, dongia, thongtin, hinhanh, maloailk, mansx };
            return MAPPERDB.ExecuteQueryString(sqlAdd);
        }

        public static int UpdateLK(String malk,String tenlk, int dongia)
        {
            String[] paraName = new String[] {"@MALK", "@TENLK", "@DONGIA"};
            object[] paraValue = new object[] {malk, tenlk, dongia};
            return MAPPERDB.ExecuteQueryString(sqlUpdate);
        }

        public static int XoaLK(String malk)
        {
            String[] paraName = new String[] { "@MALK" };
            object[] paraValue = new object[] { malk };
            return MAPPERDB.ExecuteQueryString(sqlDelete);
        }

        public static ResultSet TimLK_Malk(String malk)
        {
            String[] paraName = new String[] { "@MALK" };
            object[] paraValue = new object[] { malk };
            return MAPPERDB.getResultSet(sqlTimKiemMaLK);
        }

        public static ResultSet TimLK_TenLK(String tenlk)
        {
            String[] paraName = new String[] { "@TENLK" };
            object[] paraValue = new object[] { tenlk };
            return MAPPERDB.getResultSet(sqlTimKiemTenLK);
        }
        public static ResultSet TimLK_TenNSX(String tennsx)
        {
            String[] paraName = new String[] { "@TENNSX" };
            object[] paraValue = new object[] { tennsx };
            return MAPPERDB.getResultSet(sqlTimKiemTenNSX);
        }
}