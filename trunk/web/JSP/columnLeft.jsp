<%-- 
    Document   : columnLeft
    Created on : Nov 26, 2012, 1:46:51 PM
    Author     : Lucifer
--%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="column_left">
    <div class="box">
      <div class="top"><img src="./image/category.png" alt="" />Loại sản phẩm</div>
      <div id="category" class="middle">
      <ul>  
      <%ResultSet LoaiLKS = BO.BO_LoaiLK.DTTatCaLoaiLK();
	while(LoaiLKS!=null && LoaiLKS.next())
	{%>
            <li>
                <a href="./Category.do?&maloailk=<%=LoaiLKS.getString("MALOAILK")%>"><%=LoaiLKS.getString("TENLOAILK")%></a>
            </li>
	<%}%>
        </ul>
      </div>
      <div class="bottom">&nbsp;</div>
    </div>
    <div class="box">
      <div class="top"><img src="./image/brands.png" alt="" />Nhà sản xuất</div>
      <div id="category" class="middle">
      <ul>
      <% ResultSet NSX=BO.BO_NhaSX.DTDanhSachNSX();
	while(NSX!=null && NSX.next())
	{%>
	    <li>
                <a href="./Manufacturer.do?&mansx=<%=NSX.getString("MANSX")%>"><%=NSX.getString("TENNSX")%></a>
            </li>
	<%}%>

        </ul>
      </div>
      <div class="bottom">&nbsp;</div>
    </div>
</div>

