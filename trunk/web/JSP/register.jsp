<%-- 
    Document   : register
    Created on : Dec 2, 2012, 10:53:23 PM
    Author     : Lucifer
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="top">
    <div class="left"></div>
    <div class="right"></div>
    <div class="center">
      <h1>Tạo tài khoản</h1>
    </div>
  </div>
  <div class="middle">
    <% if (session.getAttribute("message")!=null && session.getAttribute("message").toString().toLowerCase().contains("lỗi")){ %>
    <div class="warning"><%=session.getAttribute("message") %></div>
    <%} %>
    <form id="Register" action="Register.do" method="POST" accept-charset="UTF-8">
      <p>Nếu bạn đã có tài khoản, vui lòng đăng nhập <a href="./Login.do">Tại đây</a></p>
      <b style="margin-bottom: 2px; display: block;">Thông tin cá nhân</b>
      <div style="background: #F7F7F7; border: 1px solid #DDDDDD; padding: 10px; margin-bottom: 10px;">
        <table>
          <tr>
            <td width="150"><span class="required">*</span> Họ tên</td>
            <td><input type="text" name="txtTenKH" id="txtTenKH" />
              <span class="error"><%=session.getAttribute("errorTenKH") %></span>
              </td>
          </tr>
          <tr>
            <td width="150"><span class="required">*</span> Tên đăng nhập</td>
            <td><input type="text" name="txtTenDN" id="txtTenDN"/>
              <span class="error"><%=session.getAttribute("errorTenDN") %></span>
              </td>
          </tr>
        </table>
      </div>
      <b style="margin-bottom: 2px; display: block;">Thông tin liên lạc</b>
      <div style="background: #F7F7F7; border: 1px solid #DDDDDD; padding: 10px; margin-bottom: 10px;">
        <table>
          <tr>
            <td width="150"><span class="required">*</span> Địa chỉ</td>
            <td><input type="text" name="txtDiaChi" id="txtDiaChi"/>
              <span class="error"><%=session.getAttribute("errorDC") %></span>
              </td>
          </tr>
          <tr>
            <td width="150">Số Điện thoại</td>
            <td><input type="text" name="txtSoDT" id="txtSoDT"/>
              </td>
          </tr>
          <tr>
            <td width="150"><span class="required">*</span> CMND</td>
            <td><input type="text" name="txtCMND" id="txtCMND"/>
              <span class="error"><%=session.getAttribute("errorCMND") %></span>
              </td>
          </tr>
        </table>
      </div>
      <b style="margin-bottom: 2px; display: block;">Mật khẩu của bạn</b>
      <div style="background: #F7F7F7; border: 1px solid #DDDDDD; padding: 10px; margin-bottom: 10px;">
        <table>
          <tr>
            <td width="150"><span class="required">*</span> Mật khẩu</td>
            <td><input type="password" name="txtPass" id="txtPass" />
              <span class="error"><%=session.getAttribute("errorMK") %></span>
              </td>
          </tr>
          <tr>
            <td><span class="required">*</span> Nhập lại mật khẩu</td>
            <td><input type="password" ID="txtConfirmPass" name="txtConfirmPass"/>
              <span class="error"><%=session.getAttribute("errorNhaplaiMK") %></span>
            </td>
          </tr>
        </table>
      </div>

      <div class="buttons">
        <table>
          <tr>
            <td align="right" style="padding-right: 5px;">Tôi đã đọc và chấp nhận thực hiện các chính sách trong <a href="tos.html">Điều lệ</a></td>
            <td width="5" style="padding-right: 10px;">
		<input type="checkbox" name="agree" value="agree" />
    <td align="right"><a name="btnRegister" id="btnRegister" class="button" onclick="$('#Register').submit()"><span>Đăng ký</span></a></td>
          </tr>
        </table>
      </div>
    </form>
  </div>