<%--
    Document   : columnRight
    Created on : Nov 26, 2012, 1:49:48 PM
    Author     : Lucifer
--%>
<%@page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Định dạng tiền -->
<%
    NumberFormat nf = new DecimalFormat("###,###,##0");
%>
<script type="text/javascript" language="javascript">
    function xoaLK(malk) {
        var request = $.ajax({
            url: "GioHang.do",
            type: "POST",
            data: { MALK: malk, SoLuong: '1',method: 'delete' },
            success: function (response, textStatus, jqXHR) {
                $("#column_right").load("./JSP/columnRight.jsp");
            }
        });
    }
</script>
<script>
    function ScrollCart() {

        var msie6 = $.browser == 'msie' && $.browser.version < 7;

        if (!msie6) {
            var top = $('#comment').offset().top - parseFloat($('#comment').css('margin-top').replace(/auto/, 0));
            var y = $(window).scrollTop();

            // whether that's below the form
            if (y >= top) {
                // if so, ad the fixed class
                $('#comment').addClass('fixed');
            } else {
                // otherwise remove it
                $('#comment').removeClass('fixed');
            }

            $(window).scroll(function (event) {
                // what the y position of the scroll is
                var y = $(this).scrollTop();

                // whether that's below the form
                if (y >= top) {
                    // if so, ad the fixed class
                    $('#comment').addClass('fixed');
                } else {
                    // otherwise remove it
                    $('#comment').removeClass('fixed');
                }
            });
        }
    }
    $(function () { ScrollCart(); });
</script>
<div id="column_right">
    <div id="comment">
        <div class="box" id="module_cart">
            <div class="top"><img src="./image/basket.png" alt="" />Giỏ hàng</div>
            <div class="middle">
                <%
                if (session.getAttribute("GioHang")!=null && ((DTO.GioHang)session.getAttribute("GioHang")).getThanhTien()!=0)
                {%>
                <table cellspacing="0" cellpadding="2" style="width: 100%;">
		    <%      for (int i=0;i<((DTO.GioHang)session.getAttribute("GioHang")).getLinhKien().size();i++)
                            {
			    DTO.LinhKien lk=((DTO.GioHang)session.getAttribute("GioHang")).getLinhKien().get(i);
			    %>
                                <tr style="border-bottom:1px solid black">
                                    <td width="1" valign="top" align="left">
                                        <span id="remove_<%=lk.getMaLK() %>" class="cart_remove" onclick="xoaLK('<%=lk.getMaLK() %>')"> </span>
                                    </td>
                                    <td style="width:1"><%=lk.getSoLuong()%> x </td>
                                    <td><a href="./product.do?id=<%=lk.getMaLK()%>"><%=lk.getTenLK()%></a></td>
                                </tr>
                           <%}%>
                </table>
                <br>
                <table cellspacing="0" cellpadding="0" align="right" style="display:inline-block;">
                            <tr>
                                <td align="right">
                                    <span class="cart_module_total"><b>Chưa VAT:</b></span>
                                </td>
                                <td align="right"><span class="cart_module_total"><%=nf.format(((DTO.GioHang)session.getAttribute("GioHang")).getThanhTien() )%>,000 đ</span></td>
                            </tr>
                            <tr>
                                <td align="right">
                                    <span class="cart_module_total"><b>VAT 10%:</b></span>
                                </td>
                                <td align="right"><span class="cart_module_total"><%=nf.format(((DTO.GioHang)session.getAttribute("GioHang")).getThanhTien() * 0.1)%>,000 đ</span></td>
                            </tr>
                            <tr>
                                <td align="right">
                                    <span class="cart_module_total"><b>Tổng cộng:</b></span>
                                </td>
                                <td align="right"><span class="cart_module_total"><%=nf.format(((DTO.GioHang)session.getAttribute("GioHang")).getThanhTien() *1.1)%>,000 đ</span></td>
                            </tr>

                        </table>
                        <div style="padding-top:5px;text-align:center;clear:both;">
                            <a href="./GioHang.do">Giỏ</a>&nbsp;|&nbsp;<a href="./ThanhToan.do">Thanh toán</a>
                        </div>
                <% }else{%>
                    Giỏ hàng rỗng
                <%}%>
            </div>
      <div class="bottom">&nbsp;</div>
      </div>
    </div>
</div>