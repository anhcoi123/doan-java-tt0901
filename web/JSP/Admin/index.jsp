<%-- 
    Document   : index
    Created on : Dec 3, 2012, 11:06:14 AM
    Author     : Lucifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert page="/JSP/Admin/AdminMaster.jsp" >
        <tiles:put name="title" value="Admin Shop Linh kiện" />
        <tiles:put name="adminMenu" value="/JSP/Admin/adminMenu.jsp" />
	<tiles:put name="body" value="/JSP/Admin/login.jsp" />
</tiles:insert>