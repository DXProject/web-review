<%@ page import="com.review.www.enums.*" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="SUCCESS" value="1"/>
<%--user--%>
<c:set var="USERTYPE_ADMIN" value="<%=UserType.ADMIN%>"/>