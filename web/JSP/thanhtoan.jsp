<%-- 
    Document   : thanhtoan
    Created on : Dec 3, 2012, 9:41:10 AM
    Author     : Lucifer
--%>

<%@page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="top">
    <div class="left"></div>
    <div class="right"></div>
    <div class="center">
      <h1>Thanh toán</h1>
    </div>
  </div>
<!-- Định dạng tiền -->
<%
    NumberFormat nf = new DecimalFormat("###,###,##0");
%>
<%
    String success=(String)session.getAttribute("success");
%>
  <div class="middle">
            <% if (success.toLowerCase().contains("thành công"))
           { %>
        <div class="success"><%=success%></div>
        <%}
           else if (success.toLowerCase().contains("lỗi"))
           { %>
        <div class="warning"><%=success%></div>
        <%} %>

    <div class="content">
    
      <table width="100%">
        <tr>
          <td width="33.3%" valign="top">
            <b>Phương thức thanh toán</b><br />
            Giao hàng tận nhà rồi trả tiền<br />
            <br />
          <td width="33.3%" valign="top">
            <b>Địa chỉ giao hàng</b><br />
            <label><%=((DTO.KhachHang)session.getAttribute("KhachHang")).getDiaChi() %></label><br />
              <a ID="btnDoiDiaChi" class="button" onclick="btnDoiDiaChi()"><span>Đổi địa chỉ khác</span></a>
          </td>
        </tr>
      </table>
    </div>
    <div class="content">
      <table width="100%">
        <tr>
                <th>Tên LK</th>
                <th align="right">Số lượng</th>
                <th align="right">Đơn giá (x1,000)</th>
                <th align="right">Thành tiền (x1,000)</th>
                <th>&nbsp;</th>
            </tr>
<%       if (session.getAttribute("GioHang") != null)
             {
		DTO.GioHang gh=(DTO.GioHang)session.getAttribute("GioHang");
                 for(int i=0; i<gh.getLinhKien().size();i++)
                 {%>
                <tr>
                    <td><a href="./Product.do?id=<%=gh.getLinhKien().get(i).getMaLK()%>"><img src="<%= gh.getLinhKien().get(i).getHinhAnh() %>" style="width:75px; height:75px"/></a></td>
                    <td><a href="./Product.do?id=<%=gh.getLinhKien().get(i).getMaLK()%>"><%=gh.getLinhKien().get(i).getTenLK() %></a></td>
                    <td align="right"><%=gh.getLinhKien().get(i).getSoLuong()%></td>
                    <td align="right"><label id="donGiaLK<%=gh.getLinhKien().get(i).getMaLK() %>"><%=nf.format(gh.getLinhKien().get(i).getDonGia())%></label></td>
                    <td align="right"><label id="thanhTienLK<%=gh.getLinhKien().get(i).getMaLK() %>"><%=nf.format(gh.getLinhKien().get(i).getDonGia() * gh.getLinhKien().get(i).getSoLuong())%></label></td>
                    <td></td>
                </tr>
                <%}
             }%>
            </table>
<%       if (session.getAttribute("GioHang") != null)
             {%>
                <div style="width: 100%; display: inline-block;">
                    <table style="float: right; display: inline-block;">
                        <tr>
                            <td align="right">
                                <b>Tổng cộng(chưa VAT):</b>
                            </td>
                            <td align="right"><label id="Subtotal"><%=nf.format(((DTO.GioHang)session.getAttribute("GioHang")).getThanhTien() / 1.1)%>,000 VNĐ</label></td>
                        </tr>
                        <tr>
                            <td align="right">
                                <b>VAT 10%:</b>
                            </td>
                            <td align="right"><label id="VAT"><%=nf.format(((DTO.GioHang)session.getAttribute("GioHang")).getThanhTien()/1.1 * 0.1)%>,000 VNĐ</label></td>
                        </tr>
                        <tr>
                            <td align="right">
                                <b>TỔNG CỘNG:</b>
                            </td>
                            <td align="right"><label id="Total"><%=nf.format(((DTO.GioHang)session.getAttribute("GioHang")).getThanhTien())%>,000 VNĐ</label></td>
                        </tr>

                    </table>
                   <br/>
                    </div>
                <%}%>
      <br />
    </div>
    <div id="payment">
        <div class="buttons">
            <table>
            <tbody>
            <tr>
            <td align="left">
            <a class="button" onclick="location = 'GioHang.do'">
            <span>Back</span>
            </a>
            </td>
            <td align="right">
		<form action="ThanhToan.do" method="POST" id="ConfirmThanhToan">
		    <input type="hidden" value="done" name="ConfirmThanhToan"/>
		</form>
		<a ID="btnConfirmThanhToan" class="button" onclick="$('#ConfirmThanhToan').submit()">
            <span>Confirm Order</span>
            </a>
            </td>
            </tr>
            </tbody>
            </table>
        </div>
    </div>
  </div>