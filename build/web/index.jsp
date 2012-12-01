<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert page="/siteMaster.jsp" >
        <tiles:put name="title" value="Anh Khoa SHOP - Trang Chủ" />
	<tiles:put name="headerTitle" value="Chào mừng bạn đến với shop linh kiện Anh Khoa" />
        <tiles:put name="header" value="/JSP/header.jsp" />
        <tiles:put name="columnLeft" value="/JSP/columnLeft.jsp" />
	<tiles:put name="columnRight" value="/JSP/columnRight.jsp" />
        <tiles:put name="footer" value="/JSP/footer.jsp" />
</tiles:insert>