<%-- 
    Document   : login.jsp
    Created on : Dec 1, 2012, 2:14:45 PM
    Author     : Lucifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (request.getParameter("logout") != null)
     { %>
     Bạn đã đăng xuất khỏi hệ thống thành công!
     <%}
     else
     { %>
     <% if (session.getAttribute("success").toString().toLowerCase().contains("thành công"))
           { %>
        <div class="success"><%=session.getAttribute("success").toString()%></div>
        <%}
           else if (session.getAttribute("success").toString().toLowerCase().contains("lỗi"))
           { %>
        <div class="warning"><%=session.getAttribute("success").toString()%></div>
        <%} %>
        <div style="margin-bottom: 10px; display: inline-block; width: 100%;">
          <div style="float: left; display: inline-block; width: 49%;"><b style="margin-bottom: 2px; display: block;">Khách mới</b>
            <div style="background: #F7F7F7; border: 1px solid #DDDDDD; padding: 10px; min-height: 210px;">
                <p>Lựa chọn thanh toán</p>
                <label for="register" style="cursor: pointer;">
                  <input type="radio" name="account" value="register" id="register" checked="checked" />
                  <b>Đăng ký tài khoản</b></label>
                <br />
                <p>Tạo tài khoản sẽ giúp bạn được mua hàng dễ dàng, nhanh chóng cho những lần sau (Vì chỉ cần đăng nhập, và khi thanh toán bạn sẽ không cần phải nhập lại thông tin cá nhân của bạn)</p>
                <div style="text-align: right;"><a href="./Register.do" class="button"><span>Tiếp tục</span></a></div>

            </div>
          </div>
          <div style="float: right; display: inline-block; width: 49%;"><b style="margin-bottom: 2px; display: block;">Nếu bạn là khách cũ</b>
            <div style="background: #F7F7F7; border: 1px solid #DDDDDD; padding: 10px; min-height: 210px;">
                <form name="login" action="Login.do">
                Tôi là khách hàng cũ của shop<br />
                <br />
                <b>Tên đăng nhập</b><br />
                <input type="text" name="txtTenDN"/><br /><label><%=session.getAttribute("errorTenDN").toString()%></label>
                <br />
                <b>Mật khẩu</b><br />
                <input type="password" name="txtPassword" /><br /><label><%=session.getAttribute("errorMK").toString()%></label>
                <div style="text-align: right;"><a class="button"><span>Đăng nhập</span></a></div>
		<input type="hidden" name="method" value="login"/>
                </form>
            </div>
          </div>
        </div>
        <%} %>
<script type="text/javascript"><!--
    $('#login input').keydown(function (e) {
        if (e.keyCode == 13) {
            $('#login').submit();
        }
    });
//--></script>