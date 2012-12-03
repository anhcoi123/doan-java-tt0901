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
public class MAPPER_DONDH {
        private static String sqlThemDonDH = "EXECUTE SP_THEMDONDH @MADH,@MAKH,@NGAYDH,@THANHTIEN,@TINHTRANG";
        private static String sqlThemCTDonDH = "EXECUTE SP_THEMCTDONDH @MADH,@MALK,@SOLUONG,@DONGIABAN";
        private static String sqlDanhSachDonDH = "SELECT * FROM DONDH";

        public static int SoDongBangDonDH()
        {
	    int totalRow=0;
	    ResultSet rs=MAPPERDB.getResultSet(sqlDanhSachDonDH);
	    try
	    {
		while(rs.next())
		{totalRow++;}
	    }catch(Exception ex){
	    }
	    return totalRow;
        }

	public static ResultSet RSDanhSachDonDH()
	{
	    return MAPPERDB.getResultSet(sqlDanhSachDonDH);
	}
	
        public static int AddDonDH(String madh, String makh, String ngaydh, int thanhtien,String tinhtrang)
        {
            String sqlThemDonDH = "EXECUTE SP_THEMDONDH '"+madh+"','"+makh+"','"+ngaydh+"',"+thanhtien+",'"+tinhtrang+"'";
            return MAPPERDB.ExecuteQueryString(sqlThemDonDH);
        }
	
	public static int UpdateDonDH(String madh,String tinhtrang)
        {
            String sqlUpdateDonDH = "UPDATE DONDH SET TINHTRANG='"+tinhtrang+"' WHERE MADH='"+madh+"'";
            return MAPPERDB.ExecuteQueryString(sqlUpdateDonDH);
        }
	
        public static int AddCTDonDH(String madh, String malk, int soluong, int dongiaban)
        {
            String sqlThemCTDonDH = "EXECUTE SP_THEMCTDONDH '"+madh+"','"+malk+"',"+soluong+","+dongiaban;
            return MAPPERDB.ExecuteQueryString(sqlThemCTDonDH);
        }
	
	public static ResultSet RSDonDH_MaDH(String madh)
	{
	    String sqlDONDH_MADH="SELECT * FROM DONDH WHERE MADH='" + madh + "'";
	    return MAPPERDB.getResultSet(sqlDONDH_MADH);
	}
	

}
