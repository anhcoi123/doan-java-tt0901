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
public class MAPPER_KHACHHANG {
    private static String sqlKhachHang = "EXEC SP_KHACHHANG";
    private static String sqlInsert = "EXEC SP_THEMKHACHHANG @MAKH,@TENKH,@TENDANGNHAP,@MATKHAU,@DIACHI,@SODT,@CMND,@ROLE";
    private static String sqlUpdate = "UPDATE KHACHHANG SET TENKH=@TENKH,MATKHAU=@MATKHAU,DIACHI=@DIACHI,SODT=@SODT,CMND=@CMND,ROLE=@ROLE WHERE MAKH=@MAKH";
    private static String sqlSearchKH_MAKH = "EXEC SP_TIMKHACHHANG_MAKH @MAKH";
    private static String sqlDanhSachKH1 = "SELECT * FROM KHACHHANG";
    private static String sqlDanhSachKH = "SELECT * FROM KHACHHANG WHERE ROLE='0'";


    public static ResultSet DTDanhSachKH()
    {
	return MAPPERDB.getResultSet(sqlDanhSachKH);
    }
    public static int SoDongBangKH()
    {
	ResultSet rs = MAPPERDB.getResultSet(sqlDanhSachKH1);
	int totalRow=0;
	try
	{
	    while(rs.next())
	    {totalRow++;}
	}catch(Exception ex){
	}
	return totalRow;
    }

    public static ResultSet DTTatCaUser()
    {
	return MAPPERDB.getResultSet(sqlKhachHang);
    }

    public static int InsertKH(String makh, String tenkh, String tendn, String matkhau, String diachi, String sodt, String cmnd, String role)
    {
	String sqlInsert = "EXEC SP_THEMKHACHHANG '" +makh+"','"+ tenkh+"','"+ tendn+"','"+ matkhau+"','"+ diachi+"','"+ sodt+"','"+ cmnd+"','"+ role+"'";
	return MAPPERDB.ExecuteQueryString(sqlInsert);
    }
    public static int UpdateKH(String makh, String tenkh, String matkhau, String diachi, String sodt, String cmnd, String role)
    {
	String sqlUpdate = "UPDATE KHACHHANG SET TENKH='"+tenkh+"' MATKHAU='"+matkhau+"' DIACHI='"+diachi+"' SODT='"+sodt+"' CMND='"+cmnd+"',ROLE='"+role+"' WHERE MAKH='"+makh+"'";	
	return MAPPERDB.ExecuteQueryString(sqlUpdate);
    }

    public static DTO.KhachHang searchKH(String id) throws SQLException
    {
	String[] paraName = new String[] { "@MAKH" };
	String[] paraValue = new String[] { id };
	ResultSet dtKH = MAPPERDB.getResultSet(sqlSearchKH_MAKH);
	DTO.KhachHang kh = new DTO.KhachHang();
	kh.setTenKH(dtKH.getString("TENKH"));
	kh.setMatKhau(dtKH.getString("MATKHAU"));
	kh.setDiaChi(dtKH.getString("DIACHI"));
	kh.setSoDT(dtKH.getString("SODT"));
	kh.setCMND(dtKH.getString("CMND"));
	kh.setRole(dtKH.getString("ROLE"));
	return kh;
    }

    public static ResultSet TimKH_MaKH(String makh)
    {
	String sql="EXEC SP_TIMKHACHHANG_MAKH '"+makh+"'";
	return MAPPERDB.getResultSet(sql);
    }
}
