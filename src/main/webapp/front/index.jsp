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
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/web-nav.css">
<link rel="stylesheet" type="text/css" href="${path}/css/index.css">
<script type="text/javascript" src="${path}/Js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/Js/bootstrap.min.js"></script>
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

    <div class="container">
        <div class="main">
            <div class="main-left">
                <!-- 轮播图开始 -->
                <div class="main-left-1">
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
                                <img src="images/banner_1.jpg" alt="...">
                                <div class="carousel-caption">
                                    ...
                                </div>
                            </div>
                            <div class="item">
                                <img src="images/banner_2.jpg" alt="...">
                                <div class="carousel-caption">
                                    ...
                                </div>
                            </div>
                            <div class="item">
                                <img src="images/banner_1.jpg" alt="...">
                                <div class="carousel-caption">
                                    ...
                                </div>
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <!-- end -->

                <!-- 公告栏开始 -->
                <div class="main-left-2">
                    <div class="news-title">
                        <span class="icon"><img src="images/icon-1.png"></span>
                        <a href="#">通知通告</a>
                    </div>
                    <div class="news-content">
                        <ul>
                            <li><a href="#">不忘初心，方得始终—记经管学院赴杭州嘉兴等地开展双百暑期社会实践活动</a></li>
                            <li><a href="#">风云定海山 治水我先行—记经管学院赴定海暑期社会实践活动</a></li>
                            <li><a href="#">我校参加第四届全国大学生水利创新设计大赛获佳绩</a></li>
                            <li><a href="#">穹顶之下 守望乡村碧水蓝天——记测市学院“追寻致污源头，共创节水家园”暑期社会实践活动</a></li>
                            <li><a href="#">穹顶之下 守望乡村碧水蓝天——记测市学院“追寻致污源头，共创节水家园”暑期社会实践活动</a></li>
                            <li><a href="#">穹顶之下 守望乡村碧水蓝天——记测市学院“追寻致污源头，共创节水家园”暑期社会实践活动</a></li>
                        </ul>
                    </div>
                </div>
                <!-- end -->
            </div>

            <div class="main-right">

                <!-- 登录开始 -->
                <div class='main-right-1'>
                    <div class="login">
                        <div class="login-title">
                            <span class="icon"><img src="images/icon-2.png"></span>
                            <a href="#">用户登录</a>
                        </div>
                        <div class="login-content">
                            <form>
                                <div class="info-div">
                                    <label>用&nbsp;&nbsp;户：<input type="username" id="username" name="username"></label>
                                    <label>密&nbsp;&nbsp;码：<input type="username" id="username" name="username"></label>
                                </div>
                                <div class="select-div">
                                    <a>用户类型</a>
												<span>
													<label><input type="radio" name="identity"> 项目申请人</label>
													<label><input type="radio" name="identity"> 评审专家</label>
												</span>
                                </div>

                                <div class="btn-div">
                                    <label><input type="submit" value="登录" class="btn"></label>
                                    <label><input type="submit" value="注册" class="btn"></label>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
                <!-- end -->

                <!-- 快速入口 -->
                <div class="main-right-2">
                    <div class="link-title">
                        <span class="icon"><img src="images/icon-2.png"></span>
                        <a href="#">快速入口</a>
                    </div>
                    <div class="content">
                        <div class="block-l">
                            <div class="left-1">
                                <span><img src="images/icon-3.gif"><a href="register.html">会员注册</a></span>
                            </div>
                            <span class="connect"></span><span class="connect"></span><span class="connect"></span><span class="connect"></span>
                            <div class="left-2">
                                <span><img src="images/icon-4.gif"><a href="document2014.html">历史文献</a></span>
                            </div>

                        </div>
                        <div class="block-r">
                            <div class="right-1">
                                <span><img src="images/icon-6.gif"><a href="Applicants.html">项目申报</a></span>
                            </div>
                            <span class="connect"></span><span class="connect"></span><span class="connect"></span><span class="connect"></span>
                            <div class="right-2">
                                <span><img src="images/icon-5.gif"><a href="aboutus">关于我们</a></span>
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
</body>
</html>