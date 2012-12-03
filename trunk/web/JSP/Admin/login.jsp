<%-- 
    Document   : login
    Created on : Dec 3, 2012, 11:08:02 AM
    Author     : Lucifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css">
        .style6
        {
            width: 512px;
            text-align: right;
        }
</style>
<table class="style1">
    <form action="./AdminLogin.do" method="POST" name="adminlogin">
        <tr>
            <td class="style6" style="text-align: right">
                ID</td>
            <td>
                <input type="text" name ="txtID" id="txtID" width="213px"/>
            </td>
        </tr>
        <tr>
            <td class="style6">
                Password</td>
            <td>
                <input type="password" name="txtPass" id="txtPass" width="213px" />
            </td>
        </tr>
        <tr>
            <td class="style6">
                <input type="submit" name="btnLogin" id="btnLogin" value="Đăng Nhập"/>
            </td>
	    <td>
            </td>
        </tr>
    </form>
    </table>
    <div style="text-align: center">

        <asp:Label ID="lblError" runat="server"></asp:Label>

    </div>