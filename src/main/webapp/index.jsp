<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录评审系统</title>
</head>
<frameset cols="187,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="left.htm" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame"/>
    <c:choose>
        <c:when test="${user.type == USERTYPE_ADMIN}">
            <frame src="user/myAccountInfo.htm" name="rightFrame" id="rightFrame" title="rightFrame"/>
        </c:when>
    </c:choose>
</frameset>
<noframes>
    <body>
    </body>
</noframes>
</html>
