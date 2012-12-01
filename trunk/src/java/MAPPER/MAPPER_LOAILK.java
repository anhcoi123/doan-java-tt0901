/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MAPPER;
import  java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Khoadd
 */
public class MAPPER_LOAILK {
    private static String sqlLoaiLK="EXEC SP_TATCALOAILK";
    private static String sqlSearchLoaiLK_MaLoaiLK="EXEC SP_TATCALOAILK_MALOAILK";
    private static String sqlUpdateLoaiLK="UPDATE LOAILK SET TENLOAILK=@TENLOAILK WHERE MALOAILK=@MALOAILK";
    private static String sqlInsertLoaiLK="EXEC SP_THEMLOAILK @MALOAILK,@TENLOAILK";
    private static String sqlDanhSachLoaiLK="SELECT * FROM LOAILK";
    public static ResultSet DTDanhSachLoaiLK()
    {
        return MAPPERDB.getResultSet(sqlLoaiLK);
    }
    public static int SoDongBangLoaiLK()
    {
        ResultSet rs= MAPPERDB.getResultSet(sqlDanhSachLoaiLK);
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
    public static int InsertLoaiLK(String maloailk,String tenloailk)
    {
        String sqlInsert="EXEC SP_THEMLOAILK '"+maloailk+"','"+tenloailk+"'";
        return MAPPERDB.ExecuteQueryString(sqlInsert);
    }
    public static int UpdateLoaiLK(String maloailk,String tenloailk)
    {
        String sqlUpdate="UPDATE LOAILK SET TENLOAILK='"+tenloailk+"' WHERE MALOAILK='"+maloailk+"'";
        return MAPPERDB.ExecuteQueryString(sqlUpdate);
    } 
    public static ResultSet TimLoaiLK_MaLoaiLK(String maloailk)
    {
        String sql="EXEC SP_TATCALOAILK_MALOAILK '"+maloailk+"'";
        return MAPPERDB.getResultSet(sql);
    }
    public static DTO.LoaiLK searchLoaiLK(String id) throws SQLException 
    {
        String[] paraName= new String[] {"@MALOAILK"};
        String[] paraValue= new String[] {id};
        ResultSet dtLLK= MAPPERDB.getResultSet(sqlSearchLoaiLK_MaLoaiLK);
        DTO.LoaiLK llk= new DTO.LoaiLK();
        llk.setTenLoaiLK(dtLLK.getString("TENLOAILK"));
        return llk;
    }
}
