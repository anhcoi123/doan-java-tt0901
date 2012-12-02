/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lucifer
 */
public class BO_LINHKIEN {
public static ResultSet DTGetAll()
       {
            return MAPPER.MAPPER_LINHKIEN.GetallProducts();
       }

       public static ResultSet DTGet8()
       {
           return MAPPER.MAPPER_LINHKIEN.Get8Products();
       }

       public static ArrayList<DTO.LinhKien> DBLK() throws SQLException
       {
           ResultSet rs=DTGetAll();
           ArrayList<DTO.LinhKien> DB = new ArrayList<DTO.LinhKien>();
           while(rs.next())
           {
               DTO.LinhKien a=new DTO.LinhKien();
                   a.setMaLK(rs.getString("MALK"));
                   a.setTenLK (rs.getString("TENLK"));
                   a.setdVTinh(rs.getString("DVTINH"));
                   a.setSoLuong (rs.getInt("SOLUONG"));
                   a.setDonGia (rs.getInt("DONGIA"));
                   a.setThongTin(rs.getString("THONGTIN"));
                   a.setHinhAnh(rs.getString("HINHANH"));
                   a.setMaloailk(rs.getString("MALOAILK"));
                   a.setMansx(rs.getString("MANSX"));
	       DB.add(a);

           }
           return DB;
       }
        public static int InsertLK(String malk,String tenlk, String dvtinh,int soluong,int dongia,String thongtin,String hinhanh,String maloailk,String mansx )
        {
            return MAPPER.MAPPER_LINHKIEN.AddLK(malk,tenlk,dvtinh,soluong,dongia,thongtin,hinhanh,maloailk,mansx);
        }

        public static int UpdateLK(String malk, String tenlk, int dongia)
        {
            return MAPPER.MAPPER_LINHKIEN.UpdateLK(malk, tenlk,dongia);
        }

        public static int DeleteLK(String malk)
        {
            return MAPPER.MAPPER_LINHKIEN.XoaLK(malk);
        }

        public static DTO.LinhKien searchLK(String id) throws SQLException
        {
            return MAPPER.MAPPER_LINHKIEN.searchLK(id);
        }

        public static ResultSet DTSearchLK_MALK(String malk)
        {
            return MAPPER.MAPPER_LINHKIEN.TimLK_Malk(malk);
        }

        public static ResultSet DTSearchLK_TENLK(String tenlk)
        {
            return MAPPER.MAPPER_LINHKIEN.TimLK_TenLK(tenlk);
        }

        public static DTO.LinhKien SearchLK_TENLK(String tenlk) throws SQLException
        {
            DTO.LinhKien lk = new DTO.LinhKien();
            ResultSet dtLK=DTSearchLK_TENLK(tenlk);
            lk.setDonGia(dtLK.getInt("DONGIA"));
            lk.setdVTinh (dtLK.getString("DVTinh"));
            lk.setHinhAnh (dtLK.getString("HINHANH"));
            lk.setMaLK (dtLK.getString("MALK"));
            lk.setSoLuong(dtLK.getInt("SOLUONG"));
            lk.setTenLK (dtLK.getString("TENLK"));
            lk.setThongTin (dtLK.getString("THONGTIN"));
            return lk;

        }
        public static ResultSet SearchLK_TENNSX(String tennsx)
        {
            return MAPPER.MAPPER_LINHKIEN.TimLK_TenNSX(tennsx);
        }

	public static ResultSet SearchLK_TENNSXSort(String tennsx,String sort)
        {
            return MAPPER.MAPPER_LINHKIEN.TimLK_TenNSXSort(tennsx,sort);
        }
	
        public static ResultSet DTTatCaLK_MaLoaiLK(String maloailk)
        {
            return MAPPER.MAPPER_LINHKIEN.DTTatCaLK_MaLoaiLK(maloailk);
        }
	
	public static ResultSet DTTatCaLK_MaLoaiLKSort(String maloailk,String sort)
        {
            return MAPPER.MAPPER_LINHKIEN.DTTatCaLK_MaLoaiLKSort(maloailk,sort);
        }
	
}
