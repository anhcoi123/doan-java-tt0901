<%-- 
    Document   : siteMaster
    Created on : Nov 26, 2012, 6:22:11 PM
    Author     : Lucifer
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.*"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title><tiles:getAsString name="title" ignore="true"/>
    </title>
    
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link href="Styles/stylesheet.css" rel="stylesheet" type="text/css" />
<!-- Định dạng tiền -->
<%
    NumberFormat nf = new DecimalFormat("###,###,##0");
%>
<script language="javascript" type="text/javascript">
    function clearText(field) {
        if (field.defaultValue == field.value) field.value = '';
        else if (field.value == '') field.value = field.defaultValue;
    }
</script>

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<link href="Scripts/thickbox/thickbox.css" type="text/css" rel="stylesheet"/>
<script src="Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="Scripts/thickbox/thickbox-compressed.js" type="text/javascript"></script>
<script src="Scripts/giohang.js" type="text/javascript"></script>

<script language="javascript" type="text/javascript">

    
    /*
    var i = 0;
    setTimeout(chay, 1000);
    window.onload = function () { $('#test').attr({ "width": "300", "height": "300" }); };
    function chay() {
    $('#test').fadeOut(500, function () {
    $('#test').attr("src",($('#SP img').eq(i).attr("src")));
    $('#test').fadeIn(2000,function(){
    i++;
    if (i >= $('#SP img').length) i = 0;
    setTimeout(chay, 1000);
    });
    });
    }
    */
    function enLarge(b) {
        $(".example").hover(function () {
            $(this).find('.imgzoom').addClass("hover").stop().animate({
                marginTop: '0px',
                marginLeft: '0px',
                width: '150px', /* Set new width */
                height: '150px',
                padding: '0px'
            }, 300);
        },
function () {
    $(this).find(".imgzoom").removeClass("hover").stop().animate({
        marginTop: '15px',
        marginLeft: '15px',
        width: '120px', /* Set width back to default */
        height: '120px',
        padding: '0px'
    }, 300);
});
        //$('#list' + a).animate({ 'font-size': $('#list' + a).attr('font-size').valueOf() + 50}, 'fast');
    }


    setTimeout(enLarge, 1000);
</script>

</head>

<body>
<div id="container">
    <tiles:insert attribute="header" />
    <tiles:insert attribute="columnLeft"/>
    <tiles:insert attribute="columnRight"/>
    <div id="content">
        <div class="ErrorMes"></div>

        <!-- Phần nội dung chính -->
        
	<tiles:insert attribute="body" ignore="true" />
        <div class="bottom">
            <div class="left"></div>
            <div class="right"></div>
            <div class="center"></div>
        </div>
        <div class="top">
            <div class="left"></div>
            <div class="right"></div>
            <div class="center">
                <h1>Sản phẩm ngẫu nhiên</h1>
            </div>
        </div>
        <div class="middle">
            <div id="SP" align="center">
		<table class="list">
		<%
		ResultSet rs=BO.BO_LINHKIEN.DTGet8();
		try
		{
		    while(rs!=null && !rs.isAfterLast())
		    {
			%>
			<tr>
			<%
			for (int i=0; i<4 && rs.next();i++)
			{%>
			    <td width="25%"><a href="product.do?id=<%=rs.getString("MALK") %>"><div class="example" style="width:150px; height:150px; overflow:visible"><img id="img<%=rs.getString("MALK") %>" src="<%=rs.getString("HINHANH") %>" class="imgzoom" style=" margin-left:15px;margin-top:15px; position:relative;float:left; width:120px; height:120px; cursor:pointer;overflow:visible;"/></div></a><br />
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
	    </div>
        </div>
        <div class="bottom">
            <div class="left"></div>
            <div class="right"></div>
            <div class="center"></div>
        </div>
    </div>
</div>
<tiles:insert attribute="footer"/>
</body>
</html>
