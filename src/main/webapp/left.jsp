<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<div class="lefttop">
    <a href="#" target="_parent">评审系统</a>
</div>
<dl class="leftmenu">

    <c:choose>
        <c:when test="${user.type == USERTYPE_ADMIN}">
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>账户管理
                </div>
                <ul class="menuson">
                    <li class="active"><a target="rightFrame" href="user/myAccountInfo.htm">我的信息</a></li>
                    <li><cite></cite><a href="user/modifyPassword.htm" target="rightFrame">登录密码变更</a><i></i>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>用户管理
                </div>
                <ul class="menuson">

                    <li><a target="rightFrame" href="${ctx}/user/userPage1.htm">项目申报者</a></li>
                    <li><a target="rightFrame" href="${ctx}/user/userPage2.htm">二级学院管理人员</a></li>
                    <li><a target="rightFrame" href="${ctx}/user/userPage4.htm">科研室管理人员</a></li>
                    <li><cite></cite><a href="${ctx}/user/userPage3.htm" target="rightFrame">专家</a><i></i>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>项目管理
                </div>
                <ul class="menuson">
                    <li class="active"><a target="rightFrame" href="project/addProjectAnnouncement.htm">添加新申报项目</a></li>
                    <li><a target="rightFrame" href="project/AnnouncementList.htm">公告管理</a></li>
                    <li><cite></cite><a href="project/projectAnnouncementList.htm" target="rightFrame">项目列表</a><i></i>
                    <li><cite></cite><a href="project/projectList.htm" target="rightFrame">申报项目列表</a><i></i>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>我的评审
                </div>
                <ul class="menuson">
                    <li><cite></cite><a href="" target="rightFrame"></a><i></i>
                    <li class="active"><a target="rightFrame" href="">评审细则管理</a></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>评审方案管理
                </div>
                <ul class="menuson">
                    <li><cite></cite><a href="program/reviewProgramList.htm" target="rightFrame">评审方案管理</a><i></i>
                    <li class="active"><a target="rightFrame" href="program/rulesList.htm">评审细则管理</a></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>通用数据维护
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="baseData/baseConstantList.htm">通用数据维护</a></li>
                </ul>
            </dd>
        </c:when>
    </c:choose>

    <div class="bq">© 2015-2016 Mr.Zhang 版权所有</div>
</dl>
</body>
</html>
<script language="JavaScript" src="js/jquery/jquery.1.11.2.min.js"></script>
<script type="text/javascript">
    $(function () {
        //导航切换
        $(".menuson li").click(function () {
            $(".menuson li.active").removeClass("active")
            $(this).addClass("active");
        });

        $('.title').click(function () {
            var $ul = $(this).next('ul');
            $('dd').find('ul').slideUp();
            if ($ul.is(':visible')) {
                $(this).next('ul').slideUp();
            } else {
                $(this).next('ul').slideDown();
            }
        });
    })
</script>
