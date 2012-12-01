/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPPER;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Khoadd
 */
public class MAPPER_NHACC {
    private static String sqlNhaCC="EXEC SP_NHACC";
    private static String sqlSearchNhaCC_MaNCC="EXEC SP_NHACC_MANCC";
    private static String sqlThemNhaCC="EXEC SP_THEMNCC @MANCC,@TENNCC,@DIACHI,@SODT";
    private static String sqlUpdateNhaCC="UPDATE NHACC SET TENNCC=@TENNCC,DIACHI=@DIACHI,SODT=@SODT WHERE MANCC=@MANCC";
    private static String sqlDanhSachNCC="SELECT * FROM NHACC";
    
    public static ResultSet DTDanhSachNhaCC()
    {
        return MAPPERDB.getResultSet(sqlNhaCC);
    }
    public static  int SoDongBangNhaCC()
    {
        ResultSet rs= MAPPERDB.getResultSet(sqlDanhSachNCC);
        int totalRow=0;
        try
        {
            rs.last();
            totalRow=rs.getRow();
        }
        catch(Exception ex)
        {}
        return totalRow;
    }
    public static int InsertNCC(String mancc,String tenncc,String diachi,String sodt)
    {
        String sqlInsert="EXEC SP_THEMNCC '"+mancc+"','"+tenncc+"','"+diachi+"','"+sodt+"'";
        return MAPPERDB.ExecuteQueryString(sqlInsert);
    }
    public static int UpdateNCC(String mancc,String tencc,String diachi,String sodt)
    {
        String sqlUpdate="UPDATE NHACC SET TENNCC='"+tencc+"',DIACHI='"+diachi+"',SODT='"+sodt+"' WHERE MANCC='"+mancc+"'";
        return MAPPERDB.ExecuteQueryString(sqlUpdate);    
    }
    public static ResultSet TimNhaCC_MaNCC(String mancc)
    {
        String sql="EXEC SP_NHACC_MANCC '"+mancc+"'";
        return MAPPERDB.getResultSet(sql);
    }
    public static DTO.NhaCC searchNCC(String id) throws SQLException
    {
        String[] paraName= new String[] {"@MANCC"};
        String[] paraValue= new String[] {id};
        ResultSet dtNCC=MAPPERDB.getResultSet(sqlSearchNhaCC_MaNCC);
        DTO.NhaCC ncc= new DTO.NhaCC();
        ncc.setTenNCC(dtNCC.getString("TENNCC"));
        ncc.setDiaChi(dtNCC.getString("DIACHI"));
        ncc.setSoDT(dtNCC.getString("SODT"));
        return ncc;
    }
}
