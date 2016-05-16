<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>高校教科研项目网上评审</title>
</head>
<link rel="stylesheet" type="text/css" href="${path}/frontStaticHtml/Css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/frontStaticHtml/Css/web-nav.css">
<link rel="stylesheet" type="text/css" href="${path}/frontStaticHtml/Css/register.css">
<body>
<div class="wrap">
    <div class="header">
        <div class="container">
            <div class="web-title">
                <span class="title-l"></span>
					<span class="txt">
						<a>高校教科研项目网上评审</a><br>University Scientific Research Project Online Review
					</span>
            </div>
            <ul class="nav nav-pills pull-right">
                <li role="presentation"><a href="index.html">首页</a></li>
                <li role="presentation"><a href="news.html">通告通知</a></li>
                <li role="presentation"><a href="document2015.html">历史文献</a></li>
                <li role="presentation"><a href="problem.html">常见问题</a></li>
                <li role="presentation"><a href="aboutus.html">关于我们</a></li>
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="regcontent">
            <div class="regtitle">
                <h4>浙江水利水电学院科研项目注册填报</h4>
            </div>
            <div class="reginfo">
                <form class="forminfo">
						<span>
							<label>学院部门：</label>
							<select name="department">
                                <c:forEach var="t" items="${list}">
                                    <option value="${t.id}">${t.name}</option>
                                </c:forEach>
                                <%--<option value="volvo">水利与环境工程学院</option>--%>
                                <%--<option value="saab">建筑工程学院</option>--%>
                                <%--<option value="fiat">机械与汽车工程学院</option>--%>
                                <%--<option value="audi">信息工程与艺术设计学院</option>--%>
                                <%--<option value="audi">测绘与市政工程学院</option>--%>
                                <%--<option value="audi">电气工程学院</option>--%>
                                <%--<option value="audi">经济与管理工程学院</option>--%>
                                <%--<option value="audi">国际教育交流学院</option>--%>
                            </select>
						</span>
						<span>
							<label>教师工号：</label>
							<input type="text" name="number">
						</span>
						<span>
							<label>职称：</label>
							<select name="title">
                                <c:forEach var="t" items="${list1}">
                                    <option value="${t.id}">${t.name}</option>
                                </c:forEach>
                            </select>
						</span>
						<span>
							<label>手机：</label>
							<input type="text" name="phone">
						</span>
						<span>
							<label>邮箱：</label>
							<input type="text" name="email">
						</span>
						<span>
							<label>登录密码：</label>
							<input type="password" id="password" class="validate[required]" >
						</span>
						<span>
							<label>确认密码:</label>
							<input type="password" name="password" class="validate[required,equals[password]]">
						</span>
						<span class="regbtn">
							<label></label><input type="button" class="doRegister" value="提交注册"/>
						</span>
                </form>
            </div>
        </div>
    </div>
    <div class="footer">

        <div class="copyright">
            <span>主办单位：<a href="#">浙江水利水电学院</a>&nbsp;&nbsp;<a href="#">信息工程与艺术设计学院</a></span>
            <span>联系电话：010-62510667&nbsp;电子信箱：xmsb2015@sinoss.net</span>
            <span>京ICP备10054422号 技术支持：东旭工作室</span>
        </div>

    </div>

</div>
</body>
</html>
<script type="text/javascript" src="${path}/js/jquery/jquery.1.11.2.min.js"></script>
<script type="text/javascript" src="${path}/frontStaticHtml/JS/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/3rd/validate/jquery.validationEngine.js"></script>
<script type="text/javascript" src="${path}/js/3rd/validate/jquery.validationEngine-zh_CN.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.zxxbox.3.0.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.jp.ajaxbtn.js"></script>
<script type="text/javascript" src="${path}/js/json2.js"></script>
<script type="text/javascript" src="${path}/js/kiss-web.1.0.js"></script>
<script type="text/javascript" >
    $(function(){
        $('.doRegister').ajaxbtn('${path}/front/doRegister.htm',function () {
            return {
                phone: $.trim($('input[name="phone"]').val()),
                title: $.trim($('select[name="title"]').val()),
                department: $.trim($('select[name="department"]').val()),
                email: $.trim($('input[name="email"]').val()),
                number: $.trim($('input[name="number"]').val()),
                password: $.trim($('input[name="password"]').val())
            }
        }, function () {
            return $('.forminfo').validationEngine('validate');
        },function(r){
            $.zxxbox.remind(r.message, null, {
                delay: 2000,
                onclose: function () {
                    if(r.code==1){
                        location.href="${path}/front/index.htm";
                    }
                }
            });
        });
    });
</script>