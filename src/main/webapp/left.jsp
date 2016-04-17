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
    <a href="#" target="_parent">智游配</a>
</div>
<dl class="leftmenu">

    <c:choose>
        <c:when test="${user.type == PASSPORTTYPE_TRAVEL_AGENCY}">
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>线路管理
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="tours/toursInfo.htm">新增线路</a><i></i></li>
                    <li class="active"><a target="rightFrame" href="tours/toursList.htm">所有线路</a><i></i></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>订单管理
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="">所有订单</a></li>
                    <li><a target="rightFrame" href="">所有组团</a></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>推广管理
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="spread/spreadList.htm">推广线路</a></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>合同管理
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="contract/contractList.htm">系统合同</a></li>
                    <li><a target="rightFrame" href="contract/travelAgencyContractList.htm">我的合同</a></li>
                </ul>
            </dd>

            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>账户管理
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="">我的信息</a></li>
                    <li><a target="rightFrame" href="">我的账户</a></li>
                </ul>
            </dd>
        </c:when>

        <c:when test="${user.type == PASSPORTTYPE_ADMIN}">
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>用户管理
                </div>
                <ul class="menuson">
                        <%--<li class="active"><a target="rightFrame" href="passport/passportList.htm?type=${PASSPORTTYPE_ALL}">所有用户</a><i></i></li>--%>
                    <li class="active"><a target="rightFrame"
                           href="passport/passportList.htm?type=${PASSPORTTYPE_TRAVEL_AGENCY}">旅行社</a><i></i></li>
                    <li><a target="rightFrame"
                           href="passport/passportList.htm?type=${PASSPORTTYPE_TOURIST}">游客</a><i></i></li>
                    <li><a target="rightFrame" href="passport/passportList.htm?type=${PASSPORTTYPE_GUIDE}">导游</a><i></i>
                    </li>
                    <li><a target="rightFrame" href="passport/passportList.htm?type=${PASSPORTTYPE_AGENT}">中介</a><i></i>
                    </li>
                    <li><a target="rightFrame"
                           href="passport/passportList.htm?type=${PASSPORTTYPE_MONITOR}">监管</a><i></i></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>线路管理
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="tours/toursList.htm">所有线路</a><i></i></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>推广管理
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="spread/spreadList.htm">推广线路</a></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>智游配
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="tours/customToursList.htm">智游配线路列表</a></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>订单管理
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="">所有订单</a></li>
                    <li><a target="rightFrame" href="">所有组团</a></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>合同管理
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="contract/contractList.htm">所有合同</a><i></i></li>
                </ul>
            </dd>
            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png"/></span>首页广告
                </div>
                <ul class="menuson">
                    <li><a target="rightFrame" href="ad/advertismentList.htm">广告位管理</a><i></i></li>
                </ul>
            </dd>
        </c:when>
    </c:choose>

    <div class="bq">© 2015-2016 智游配 版权所有</div>
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
