<%-- 
    Document   : AdminMaster
    Created on : Dec 3, 2012, 11:00:58 AM
    Author     : Lucifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:getAsString name="title" ignore="true"/></title>
<style type="text/css">
        .style2
        {
            text-align: center;
            background-color: #FF0000;
        }
        .style3
        {
            font-size: larger;
        }
        .style4
        {
            font-size: xx-large;
        }
        .style5
        {
            font-size: xx-large;
            color: #FFFFFF;
        }
        .style7
        {
            width: 88%;
        }
        .style8
        {
            width: 12%;
            text-align: left;
        }
    </style>
</head>
<body>
   <div style="width:100%">
        <table width="100%">
            <tr>
                <td class="style2" colspan="3">               
                    <br class="style3" />
                    <span class="style5">ADMIN PAGE</span><br class="style4" />
                </td>
            </tr>
            <tr>
                <td style="vertical-align:top">
		    <tiles:insert attribute="adminMenu" ignore="true"/>
                </td>
                <td class="style7" >
                    <tiles:insert attribute="body"/>
                </td>
               <!-- <td width="25%"></td>-->
            </tr>
        </table>

   </div> 
</body>
</html>
