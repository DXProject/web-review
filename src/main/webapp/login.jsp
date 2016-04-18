<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link href="js/3rd/validate/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>
</head>
<body id="loginBody">
<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>
<div class="loginbody">
    <span class="systemlogo">后台管理系统</span>

    <form name="loginForm" id="loginForm" action="doLogin.htm" method="post">
        <div class="loginbox">
            <ul>
                <li><input name="number" type="text" class="loginuser validate[required]" placeholder="用户名"/></li>
                <li><input name="password" type="password" class="loginpwd validate[required]" placeholder="密码"/></li>
                <li>
                    <input type="submit" class="loginbtn" value="登录"/>
                    <label class="findpwd"><a href="#">忘记密码？</a></label>
                </li>
                <li>
                    <c:if test="${result!=null && result.code!=SUCCESS}">
                        <label><font class="errorTips">${result.message}</font></label>
                    </c:if>
                </li>
            </ul>
        </div>
    </form>
</div>
<div class="loginbm">© 2015-2016 MrZhang 版权所有</div>
</body>
</html>
<script type="text/javascript" src="js/jquery/jquery.1.11.2.min.js"></script>
<script type="text/javascript" src="js/cloud.js"></script>
<script type="text/javascript" src="js/3rd/validate/jquery.validationEngine.js"></script>
<script type="text/javascript" src="js/3rd/validate/jquery.validationEngine-zh_CN.js"></script>
<script language="javascript">
    $(function () {
        //session超时跳出iframe
        if (window != top) {
            top.location.href = location.href;
        }
        //position
        $(window).resize(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 420) / 2});
        })
        //
        $('input[type="text"],input[type="password"]').on('click', function () {
            $(this).val('');
        });
        //
        $("#loginForm").validationEngine({
            promptPosition: 'topLeft',
            autoHidePrompt: true,
            autoHideDelay: 3000,
            showOneMessage: true
        });
    });
</script>