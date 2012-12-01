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
public class MAPPER_KHACHHANG {
    private static String sqlKhachHang = "EXEC SP_KHACHHANG";
    private static String sqlInsert = "EXEC SP_THEMKHACHHANG @MAKH,@TENKH,@TENDANGNHAP,@MATKHAU,@DIACHI,@SODT,@CMND,@ROLE";
    private static String sqlUpdate = "UPDATE KHACHHANG SET TENKH=@TENKH,MATKHAU=@MATKHAU,DIACHI=@DIACHI,SODT=@SODT,CMND=@CMND,ROLE=@ROLE WHERE MAKH=@MAKH";
    private static String sqlSearchKH_MAKH = "EXEC SP_TIMKHACHHANG_MAKH @MAKH";
    private static String sqlDanhSachKH1 = "SELECT * FROM KHACHHANG";
    private static String sqlDanhSachKH = "SELECT * FROM KHACHHANG WHERE ROLE='0'";


    public static ResultSet DTDanhSachKH()
    {
	return MAPPERDB.GetResultSet(sqlDanhSachKH);
    }
    public static int SoDongBangKH()
    {
	return MAPPERDB.GetResultSet(sqlDanhSachKH1).Rows.Count;
    }

    public static ResultSet DTTatCaUser()
    {
	return MAPPERDB.GetResultSet(sqlKhachHang);
    }

    public static int InsertKH(String makh, String tenkh, String tendn, String matkhau, String diachi, String sodt, String cmnd, String role)
    {
	String[] paraName = new String[] { "@MAKH", "@TENKH", "@TENDANGNHAP", "@MATKHAU", "@DIACHI", "@SODT", "@CMND", "@ROLE" };
	object[] paraValue = new object[] { makh, tenkh, tendn, matkhau, diachi, sodt, cmnd, role };
	return MAPPERDB.ExecNonQuery(sqlInsert, paraName, paraValue);
    }
    public static int UpdateKH(String makh, String tenkh, String matkhau, String diachi, String sodt, String cmnd, String role)
    {
	String[] paraName = new String[] { "@MAKH", "@TENKH", "@MATKHAU", "@DIACHI", "@SODT", "@CMND", "@ROLE" };
	object[] paraValue = new object[] { makh, tenkh, matkhau, diachi, sodt, cmnd, role };
	return MAPPERDB.ExecNonQuery(sqlUpdate, paraName, paraValue);
    }

    public static DAO.KhachHang searchKH(String id)
    {
	String[] paraName = new String[] { "@MAKH" };
	String[] paraValue = new String[] { id };
	ResultSet dtKH = MAPPERDB.GetResultSet(sqlSearchKH_MAKH, paraName, paraValue);
	DAO.KhachHang kh = new DAO.KhachHang();
	kh.TenKH = dtKH.Rows[0]["TENKH"].ToString();
	kh.MatKhau = dtKH.Rows[0]["MATKHAU"].ToString();
	kh.DiaChi = dtKH.Rows[0]["DIACHI"].ToString();
	kh.SoDT = dtKH.Rows[0]["SODT"].ToString();
	kh.CMND = dtKH.Rows[0]["CMND"].ToString();
	kh.Role = dtKH.Rows[0]["ROLE"].ToString();
	return kh;
    }

    public static ResultSet TimKH_MaKH(String makh)
    {
	String[] paraName = new String[] { "@MAKH" };
	object[] paraValue = new object[] { makh };
	return MAPPERDB.GetResultSet(sqlSearchKH_MAKH, paraName, paraValue);
    }
}
