<%-- 
    Document   : adminSuaDonDH
    Created on : Dec 3, 2012, 12:10:47 PM
    Author     : Lucifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table width="100%">
    <tr>
	<th>Mã đơn ĐH</th>
	<th>Mã khách hàng</th>
	<th>Ngày đặt hàng</th>
	<th>Thành tiền</th>
	<th>Tình trạng</th>
    </tr>
    <tr>
	<td><%=session.getAttribute("MADH")%> </td>
	<td><%=session.getAttribute("MAKH")%> </td>
	<td><%=session.getAttribute("NGAYDH")%> </td>
	<td><%=session.getAttribute("THANHTIEN")%> </td>
	<form action="./AdminSuaDonDH.do" method="POST">
	    <td><input type="text" name="tinhtrang" value="<%=session.getAttribute("TINHTRANG")%>"/>
		<input type="hidden" name="madh" value="<%=session.getAttribute("MADH")%>"/>
		<input type="submit" name="btnSua" value="Sửa"/>
	    </td>
	</form>
    </tr>
</table>