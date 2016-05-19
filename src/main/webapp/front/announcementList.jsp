<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>水院教科研项目网上评审</title>
</head>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/announcement.css">
<link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/web-nav.css">
<link rel="stylesheet" type="text/css" href="${path}/css/left-tab.css">
<link rel="stylesheet" type="text/css" href="${path}/css/Modification.css">
<body>
<div class="wrap">


    <div class="header">
        <div class="container">

            <div class="web-title">
                <span class="title-l"></span>
					<span class="txt">
						<a>水院教科研项目网上评审</a><br>University Scientific Research Project Online Review
					</span>
            </div>
            <ul class="nav nav-pills pull-right">
                <li role="presentation"><a href="${path}/front/index.htm">首页</a></li>
                <li role="presentation"><a href="${path}/front/project/announcementList.htm">通告通知</a></li>
                <li role="presentation"><a href="#">历史文献</a></li>
                <li role="presentation"><a href="#">常见问题</a></li>
                <li role="presentation"><a href="#">关于我们</a></li>
            </ul>

        </div>
    </div>
    <div class="container">
        <div class="main">

            <div class="left-tab">
                <ul>
                    <li class="apply"><a href="#">公告</a><span></span></li>
                    <li <c:if test="${type != 1 && type != 2}">class="active"</c:if>><a
                            href="announcementList.htm">所有公告</a></li>
                    <li <c:if test="${type == 1}">class="active"</c:if>><a href="announcementList.htm?type=1">一般公告</a>
                    </li>
                    <li <c:if test="${type == 2}">class="active"</c:if>><a href="announcementList.htm?type=2">项目公告</a>
                    </li>
                </ul>
            </div>
            <div class="content">
                <div class="document">
                    <div class="news-title">
                        <a href="#">通知公告</a>
                    </div>
                    <div class="introcontent">
                        <ul style="list-style: url(../images/li-icon.png);">
                            <c:forEach var="r" items="${list}">
                                <li style="border-bottom: 1px dashed #999;height:30px;line-height: 30px;"><a
                                        href="announcementInfo.htm?id=${r.id}">${r.title}</a><span
                                        class="pull-right">[ <fmt:formatDate
                                        value='${r.creationTime}' pattern='yyyy-MM-dd'/> ]</span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="pagin">${page}</div>

                    <br/>
                </div>
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
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.zxxbox.3.0.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.jp.ajaxbtn.js"></script>
<script type="text/javascript" src="${path}/js/3rd/validate/jquery.validationEngine.js"></script>
<script type="text/javascript" src="${path}/js/3rd/validate/jquery.validationEngine-zh_CN.js"></script>
<script type="text/javascript" src="${path}/js/json2.js"></script>
<script type="text/javascript" src="${path}/js/kiss-web.1.0.js"></script>
<script type="text/javascript">
    $('#myModal').on('shown.bs.modal', function () {
        $('#myInput').focus()
    });
</script>
<script type="text/javascript">
    $(function () {
    });
</script>