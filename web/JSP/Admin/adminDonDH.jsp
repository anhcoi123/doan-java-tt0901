<%-- 
    Document   : adminDonDH
    Created on : Dec 3, 2012, 11:20:39 AM
    Author     : Lucifer
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div style="text-align: center">Đơn đặt hàng</div>
<table width="100%">
    <tr>
	<th>Mã đơn ĐH</th>
	<th>Mã khách hàng</th>
	<th>Ngày đặt hàng</th>
	<th>Thành tiền</th>
	<th>Tình trạng</th>
	<th>Sửa</th>
    </tr>
    <tr>
	<% ResultSet rs=BO.BO_DONDH.RSDanhSachDonDH();
	while(rs!=null && rs.next())
	{%>
	<td><%=rs.getString("MADH") %></td>
	<td><%=rs.getString("MAKH") %></td>
	<td><%=rs.getString("NGAYDH") %></td>
	<td><%=rs.getString("THANHTIEN") %></td>
	<td><%=rs.getString("TINHTRANG") %></td>
	<td><a href="AdminDonDH.do?method=sua&madh=<%=rs.getString("MADH") %>">Sửa</a> </td>
	<%}%>
    </tr>
</table>