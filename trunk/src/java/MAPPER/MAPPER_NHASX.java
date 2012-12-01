/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPPER;

import DTO.NhaSX;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Khoadd
 */
public class MAPPER_NHASX {
    private static String sqlNhaSX="EXEC SP_NHASX";
    private static String sqlSearchNhaSX_MaNSX="EXEC SP_NHASX_MANSX";
    private static String sqlInsert="EXEC SP_THEMNHASX @MANSX,@TENNSX";
    private static String sqlUpdate="UPDATE NHASX SET TENNSX=@TENNSX WHERE MANSX=@MANSX";
    private static String sqlDanhSachNSX="SELECT * FROM NHASX";
    
    public static ResultSet DTDanhSachNSX()
    {
        return MAPPERDB.getResultSet(sqlDanhSachNSX);
    }
    public static int SoDongBangNhaSX()
    {
        ResultSet rs=MAPPERDB.getResultSet(sqlDanhSachNSX);
        int totalRow=0;
        try
        {
            rs.last();;
            totalRow=rs.getRow();
        }
        catch(Exception ex)
        {
        }
        return totalRow;
    }
    public static ResultSet DTTatCaNhaSX()
    {
        return MAPPERDB.getResultSet(sqlNhaSX);
    }
    public static int InsertNSX(String mansx,String tennsx)
    {
        String sqlInsertNSX="EXEC SP_THEMNSX '"+mansx+"','"+tennsx+"'";
        return MAPPERDB.ExecuteQueryString(sqlInsertNSX);
    }
    public static int UpdateNSX(String mansx,String tennsx)
    {
        String sqlUpdateNSX="UPDATE NHASX SET TENNSX='"+tennsx+"' WHERE MANSX='"+tennsx+"'";
        return MAPPERDB.ExecuteQueryString(sqlUpdateNSX);
    }
    public static ResultSet TimNhaSX_MaNSX(String mansx)
    {
        String sql="EXEC SP_NHASX_MANSX '"+mansx+"'";
        return MAPPERDB.getResultSet(sql);
    }
    public static DTO.NhaSX searchNSX(String id) throws SQLException
    {
        String[] paraName= new String[]{"MANSX"};
        String[] paraValue= new String[] {id};
        ResultSet dtNSX= MAPPERDB.getResultSet(sqlSearchNhaSX_MaNSX);
        DTO.NhaSX nsx=new DTO.NhaSX();
        nsx.setTenNSX(dtNSX.getString("TENNSX"));
        return nsx;
    }
}   


