<%-- 
    Document   : manufacturer
    Created on : Dec 2, 2012, 9:47:04 PM
    Author     : Lucifer
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div class="top">
    <div class="left"></div>
    <div class="right"></div>
    <div class="center">
      <h1>
	  <%=session.getAttribute("title") %>
      </h1>
    </div>
  </div>
<!-- Định dạng tiền -->
<%
    NumberFormat nf = new DecimalFormat("###,###,##0");
%>
    <div class="middle">
        <div class="sort">
            <div class="div1">
		<form id="formSort" action="Manufacturer.do" method="GET">
		    <select name="sortList" ID="sortList" onchange="$('#formSort').submit()">
			<option selected="true" value="default">Mặc định</option>
			<option value="TENLK ASC">Theo tên A-Z</option>
			<option value="TENLK DESC">Theo tên Z-A</option>
			<option value="DONGIA ASC">Theo giá Thấp-Cao</option>
			<option value="DONGIA DESC">Theo tên Cao-Thấp</option>
		    </select>
		    <input type="hidden" value="<%=session.getAttribute("mansx") %>" name="mansx"/>
                </form>
            </div>
            <div class="div2">Sắp xếp theo: </div>
        </div>
    
              <table class="list">
		<%
		try
		{
		    ResultSet rs=(ResultSet)session.getAttribute("manufacturer");
		    while(rs!=null && !rs.isAfterLast())
		    {
			%>
			<tr>
			<%
			for (int i=0; i<4 && rs.next();i++)
			{%>
			    <td width="25%"><a href="Product.do?id=<%=rs.getString("MALK") %>"><div class="example" style="width:150px; height:150px; overflow:visible"><img id="img<%=rs.getString("MALK") %>" src="<%=rs.getString("HINHANH") %>" class="imgzoom" style=" margin-left:15px;margin-top:15px; position:relative;float:left; width:120px; height:120px; cursor:pointer;overflow:visible;"/></div></a><br />
				    <a href="Product.do?id=<%=rs.getString("MALK") %>"><%=rs.getString("TENLK") %></a><br />
				    <span style="color: #900; font-weight: bold;"><%=nf.format(rs.getInt("DONGIA"))%>,000 VNĐ</span><br />
				    <a class="button_add_small" title="Thêm vào giỏ hàng" onclick="themVaoGH('<%=rs.getString("MALK") %>','1')">&nbsp;&nbsp;Thêm</a></td>
			    <%
			}
			%></tr><%
		    }
		}catch(Exception ex){}
		%>
		</table>

            <div class="pagination"></div>
	    <label id="txtNoData"> <%=session.getAttribute("txtNoData") %> </label>
	
  </div>
