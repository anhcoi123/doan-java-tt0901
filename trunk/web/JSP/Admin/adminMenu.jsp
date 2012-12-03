<%-- 
    Document   : adminMenu
    Created on : Dec 3, 2012, 11:14:56 AM
    Author     : Lucifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css">
    .style2
    {
        height: 21px;
        text-align: center;
    }
    .style3
    {
        text-align: center;
    }
</style>
<table width="100%" style="vertical-align:top">
    <tr>
        <td class="style2">
            <a href="./AdminLinhKien.do">Linh Kiện</a>
        </td>
    </tr>
    <tr>
        <td class="style3">
            <a href="./AdminDonDH.do">Đơn Đặt Hàng</a>
        </td>
    </tr>
    <tr>
        <td class="style3">
	    <a href="./AdminKH.do">Khách hàng</a>
        </td>
    </tr>
    <% if (session.getAttribute("admin")!=null)
	{%>
    <tr>
        <td class="style3">
            <a href="./AdminLogin.do?logout=true">Đăng thoát</a>
        </td>
    </tr><%}%>
</table>
