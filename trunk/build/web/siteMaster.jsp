<%-- 
    Document   : siteMaster
    Created on : Nov 26, 2012, 6:22:11 PM
    Author     : Lucifer
--%>

<%@page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title><tiles:getAsString name="title" ignore="true"/>
    </title>
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
        <div class="top">
            <div class="left"></div>
            <div class="right"></div>
            <div class="center">
               <h1>
		   <tiles:getAsString name="headerTitle" />
                </h1>
            </div>
        </div>
        <div class="middle">
	    <tiles:insert attribute="body" ignore="true" />
        </div>
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
		<a class="button_add_small" onclick="themVaoGH('M004')" title="Thêm vào giỏ hàng">  Thêm</a>
<!--                <asp:DataList ID="load" runat="server" RepeatDirection="Vertical" RepeatColumns="4" CssClass="list">
                    <ItemTemplate>
                        <table style="vertical-align:bottom; text-align:center;">
                            </td></tr>
                        </table>
                    </ItemTemplate>
                </asp:DataList>-->
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
