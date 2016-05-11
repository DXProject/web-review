<%@ page import="com.review.www.enums.*" %>
<%@ page import="com.review.www.constants.Constants" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="SUCCESS" value="1"/>
<%--user--%>
<c:set var="USERTYPE_ADMIN" value="<%=UserType.ADMIN%>"/>
<c:set var="BASE_CONSTANT_TITLE" value="<%=Constants.BASE_CONSTANT_TITLE%>"/>
<c:set var="BASE_CONSTANT_DEGREE" value="<%=Constants.BASE_CONSTANT_DEGREE%>"/>
<c:set var="BASE_CONSTANT_EDUCATION" value="<%=Constants.BASE_CONSTANT_EDUCATION%>"/>
<c:set var="BASE_CONSTANT_DEPARTMENT" value="<%=Constants.BASE_CONSTANT_DEPARTMENT%>"/>
<c:set var="BASE_CONSTANT_DISCIPLINE_CATEGORY" value="<%=Constants.BASE_CONSTANT_DISCIPLINE_CATEGORY%>"/>
<c:set var="BASE_CONSTANT_SUBJECT_CATEGORY" value="<%=Constants.BASE_CONSTANT_SUBJECT_CATEGORY%>"/>
<%--annountmentType--%>
<c:set var="NORMAL_ANNOUNCEMENT" value="<%=AnnouncementTypeEnum.NORMAL_ANNOUNCEMENT.getValue()%>"/>
<c:set var="PROJECT_ANNOUNCEMENT" value="<%=AnnouncementTypeEnum.PROJECT_ANNOUNCEMENT.getValue()%>"/>