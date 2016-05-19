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
    <title>高校教科研项目网上评审</title>
</head>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/web-nav.css">
<link rel="stylesheet" type="text/css" href="${path}/css/index.css">
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
                <li role="presentation"><a href="">通告通知</a></li>
                <li role="presentation"><a href="">历史文献</a></li>
                <li role="presentation"><a href="${path}/frontStaticHtml/problem.html">常见问题</a></li>
                <li role="presentation"><a href="${path}/frontStaticHtml/aboutus.html">关于我们</a></li>
            </ul>

        </div>
    </div>

    <div class="container">
        <div class="main">
            <div class="main-top">
                <!-- 轮播图开始 -->
                <div class="main-slide">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img src="${path}/images/banner_1.jpg" alt="...">

                                <div class="carousel-caption">
                                    ...
                                </div>
                            </div>
                            <div class="item">
                                <img src="${path}/images/banner_2.jpg" alt="...">

                                <div class="carousel-caption">
                                    ...
                                </div>
                            </div>
                            <div class="item">
                                <img src="${path}/images/banner_1.jpg" alt="...">

                                <div class="carousel-caption">
                                    ...
                                </div>
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" role="button"
                           data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" role="button"
                           data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <!-- end -->
            </div>

            <div class="main-foot">
                <!-- 公告栏开始 -->
                <div class="main-foot-notice">
                    <div class="news-title">
                        <span class="icon"><img src="${path}/images/icon-1.png"></span>
                        <a href="${path}/front/project/announcementList.htm">通知通告</a>
                    </div>
                    <div class="news-content">
                        <ul>
                            <c:forEach var="r" items="${announcements}">
                                <li>
                                    <a href="${path}/front/project/announcementInfo.htm?id=${r.id}">${r.title}[<fmt:formatDate
                                            value='${r.creationTime}' pattern='yyyy-MM-dd'/>]</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- end -->


                <!-- 快速入口 -->
                <div class="main-foot-fast">
                    <div class="link-title">
                        <span class="icon"><img src="${path}/images/icon-2.png"></span>
                        <a href="#">快速入口</a>
                    </div>
                    <div class="content">
                        <div class="block-l">
                            <div class="left-1">
                                <c:if test="${user.userId==null}">
                                <span><img src="${path}/images/icon-3.gif"><a href="##" data-toggle="modal"
                                                                              data-target="#myModal">登录/注册</a></span>
                                </c:if>
                                <c:if test="${user.userId!=null}">
                                    <span><img src="${path}/images/icon-3.gif"><a
                                            href="${path}/front/logout.htm">${user.name}/注销</a></span>
                                </c:if>
                            </div>
                            <span class="connect"></span><span class="connect"></span><span class="connect"></span><span
                                class="connect"></span>

                            <div class="left-2">
                                <span><img src="${path}/images/icon-4.gif"><a href="">历史文献</a></span>
                            </div>

                        </div>
                        <div class="block-r">
                            <div class="right-1">
                                <span><img src="${path}/images/icon-6.gif"><a
                                        href="${path}/front/project/announcementList.htm?type=2">项目申报</a></span>
                            </div>
                            <span class="connect"></span><span class="connect"></span><span class="connect"></span><span
                                class="connect"></span>

                            <div class="right-2">
                                <span><img src="${path}/images/icon-5.gif"><a href="">关于我们</a></span>
                            </div>

                        </div>
                    </div>
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


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">用户登录</h4>
            </div>
            <div class="modal-body">

                <div class="login-content">
                    <form class="forminfo">
                        <div class="info-div">
                            <label class="user" style="line-height:30px;">用&nbsp;&nbsp;户：<input type="text" id="number"
                                                                                                name="number"
                                                                                                class="form-control pull-right validate[required]"></label>
                            <label class="password" style="line-height:30px;">密&nbsp;&nbsp;码：<input type="password"
                                                                                                    id="password"
                                                                                                    name="password"
                                                                                                    class="form-control pull-right validate[required]"></label>
    <span class="radio">用户类型：
    <label><input type="radio" name="identity" value="1" checked/> 项目申请人</label>
    <label><input type="radio" name="identity" value="2"/> 评审专家</label>
    </span>
                        </div>

                    </form>
                </div>

            </div>
            <div class="modal-footer">
                <a type="button" class="btn btn-default" href="${path}/front/register.htm">注册</a>
                <a type="button" class="btn btn-primary doLoginBtn">登录</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

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
        $('.doLoginBtn').ajaxbtn('${path}/front/doLoginFront.htm', function () {
            return {
                number: $.trim($('input[name="number"]').val()),
                password: $.trim($('input[name="password"]').val()),
                identity: $.trim($('input:radio[name="identity"]:checked').val())
            }
        }, function () {
            return $('.forminfo').validationEngine('validate');
        }, function (r) {
            if (r.code == 1) {
                location.reload();
            } else {
                $.zxxbox.remind(r.message, function () {
                    $("#password").val("");
                }, {
                    delay: 1000,
                    onclose: function () {


                    }
                });
            }
        });
    });
</script>