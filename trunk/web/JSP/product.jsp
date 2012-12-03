<%--
    Document   : product
    Created on : Dec 3, 2012, 9:09:54 AM
    Author     : Lucifer
--%>

<%@page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="top">
    <div class="left"></div>
    <div class="right"></div>
    <div class="center">
	<h1><%=session.getAttribute("title") %></h1>
    </div>
  </div>
    
<!-- Định dạng tiền -->
<%
    NumberFormat nf = new DecimalFormat("###,###,##0");
%>
  <div class="middle">
      <% 
      DTO.LinhKien lk=new DTO.LinhKien();
      DTO.NhaSX nhasx=new DTO.NhaSX();
      if (session.getAttribute("lk")!=null)
	  lk=(DTO.LinhKien)session.getAttribute("lk");
      if (session.getAttribute("nhasx")!=null)
	  nhasx=(DTO.NhaSX)session.getAttribute("nhasx");
      if (!lk.getMaLK().equals(""))
     { %>
    <div style="width: 100%; margin-bottom: 30px;">
      <table style="width: 100%; border-collapse: collapse;">
      
        <tr>
	    <td style="text-align: center; width: 250px; vertical-align: top;"><a href="./<%=lk.getHinhAnh() %>" title="<%=lk.getTenLK() %>" class="thickbox" rel="gallery"><img src="<%=lk.getHinhAnh() %>" title="<%=session.getAttribute("title") %>" alt="<%=session.getAttribute("title") %>" id="img<%=lk.getMaLK() %>" style="margin-bottom: 3px; width:250px;height:250px" /></a><br />
            <span style="font-size: 11px;">Bấm vào để phóng to</span></td>
          <td style="padding-left: 15px; width: 296px; vertical-align: top;"><table width="100%">
              <tr>
                <td><b>Giá: </b></td>
                <td>
                  <span style="color: #F00;"><%=nf.format(lk.getDonGia()) %>,000 VNĐ</span>
                </td>
              </tr>
              <tr>
                <td><b>Còn hàng? :</b></td>
                <td><%if (lk.getSoLuong() > 0)
                         {
                              %>Còn hàng<%}else{ %> Hết hàng <%} %>
                </td>
              </tr>
              <tr>
                <td><b>Nhà sản xuất:</b></td>
                <td><a href="./Manufacturer.do?mansx=<%=nhasx.getMaNSX() %>"><%=nhasx.getTenNSX() %></a></td>
              </tr>
			  <tr>
                <td><b>Đánh giá trung bình: </b></td>
                <td>Chưa có đánh giá</td>
              </tr>
            </table>
            <br />
              <div class="content">
                Số lượng:
                <input type="text" name="quantity" size="3" value="1" id="quantity"/>
                <a onclick="themVaoGH('<%=lk.getMaLK() %>',$('#quantity').val().toString())" id="add_to_cart" class="button"><span>Thêm vào giỏ</span></a>
              </div>
        </tr>
      </table>
    </div>
    <div class="tabs">
      <a tab="#tab_description">Mô tả</a>
      <a tab="#tab_image">Hình ảnh(0)</a>
      <a tab="#tab_related">Sản phẩm tương tự (0)</a>
    </div>
    <div id="tab_description" class="tab_page"><%=lk.getThongTin() %></div>
    <div id="tab_image" class="tab_page">
      <div style="background: #F7F7F7; border: 1px solid #DDDDDD; padding: 10px; margin-bottom: 10px;">Không có hình nào khác</div>
    </div>
    <div id="tab_related" class="tab_page">
      <div style="background: #F7F7F7; border: 1px solid #DDDDDD; padding: 10px; margin-bottom: 10px;">Không có sản phẩm tương tự</div>
    </div>
    <%}%>
    <label> <%=session.getAttribute("txtNoData") %></label>
  </div>
  <script src="Scripts/tab.js" type="text/javascript"></script>
<script type="text/javascript"><!--
    $('#review .pagination a').live('click', function () {
        $('#review').slideUp('slow');

        $('#review').load(this.href);

        $('#review').slideDown('slow');

        return false;
    });

//--></script>
<script type="text/javascript"><!--
    $.tabs('.tabs a'); 
//--></script>