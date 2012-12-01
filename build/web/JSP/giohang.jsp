<%-- 
    Document   : giohang
    Created on : Nov 26, 2012, 2:53:59 PM
    Author     : Lucifer
--%>

<%@page import="java.text.*"%>
<%@page import="DTO.GioHang"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("GioHang")==null)
	{
	    GioHang gh=new GioHang();
	    session.setAttribute("GioHang", gh);
	}
%>
<!-- Định dạng tiền -->
<%
    NumberFormat nf = new DecimalFormat("###,###,##0");
%>
<div id="Giohang">
    <% if (request.getParameter("MALK") == null && request.getParameter("Update") == null)
       {%>
       <script language="javascript" type="text/javascript">
           function capNhat(a) {
               var c = $("#soLuong" + a).val().toString();
               var request = $.ajax({
                   url: "GioHang.do",
                   type: "POST",
                   data: { MALK: a, SoLuong: c, method: 'update' },
                   success: function (response, textStatus, jqXHR) {
                       var result = "";
                       result = response.toString();
                       var n = result.split("|");
                       $("#thanhTienLK" + a).html(n[0]);
                       $("#Subtotal").text(n[1]);
                       $("#VAT").text(n[2]);
                       $("#Total").text(n[3]);
                       updateGH();
                   }
               });

               
           }
       </script>
    <table class="cart">
    <tr>
        <th>&nbsp;</th>
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
                    <td><img src="<%= gh.getLinhKien().get(i).getHinhAnh() %>" style="width:75px; height:75px"/></td>
                    <td><%=gh.getLinhKien().get(i).getTenLK() %></td>
                    <td align="right"><input type="text" id="soLuong<%=gh.getLinhKien().get(i).getMaLK()%>" value="<%=gh.getLinhKien().get(i).getSoLuong()%>"  onchange="capNhat('<%=gh.getLinhKien().get(i).getMaLK() %>')" style="text-align:right"/></td>
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
                    <br>
                </div>
            <%}%>
    
    <div class="buttons">
        <table>
            <tbody>
                <tr>
                    <td align="left">
                        <a class="button" href="./GioHang.do?method=deleteAll"><span>Xóa giỏ hàng</span></a>
                    </td>
                    <td align="center">
                        <a class="button" href="./"><span>Tiếp tục mua hàng</span></a>
                    </td>
                    <td align="right">
                        <a class="button" href="./ThanhToan.aspx"><span>Thanh toán</span></a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <%} %>
</div>
