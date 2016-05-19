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
<link rel="stylesheet" type="text/css" href="${path}/css/register.css">
<link rel="stylesheet" type="text/css" href="${path}/js/3rd/validate/validationEngine.jquery.css"/>
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
                <li role="presentation"><a href="${path}/front/index.htm">首页</a></li>
                <li role="presentation"><a href="${path}/front/project/announcementList.htm">通告通知</a></li>
                <li role="presentation"><a href="#">历史文献</a></li>
                <li role="presentation"><a href="#">常见问题</a></li>
                <li role="presentation"><a href="#">关于我们</a></li>
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="regcontent">
            <div class="regtitle">
                <h4>浙江水利水电学院科研项目注册填报</h4>
            </div>
            <div class="reginfo">
                <form class="forminfo form-horizontal">

                    <div class="form-group">
                        <label class="col-sm-4 control-label">教师工号：</label>

                        <div class="col-sm-8">
                            <input type="text" name="number" class="validate[required] form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">手机：</label>

                        <div class="col-sm-8">
                            <input type="text" name="phone" class="validate[required] form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">姓名：</label>

                        <div class="col-sm-8">
                            <input type="text" name="name" class="validate[required] form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">性别：</label>

                        <div class="col-sm-8">
                            <input name="sex" type="radio" value="0" checked/>&nbsp;男 &nbsp;
                            <input name="sex" type="radio" value="1"/>&nbsp;女
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">邮箱：</label>

                        <div class="col-sm-8">
                            <input type="text" name="email" class="form-control"></div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">登录密码:</label>

                        <div class="col-sm-8">
                            <input type="password" id="password" class="validate[required] form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">确认密码:</label>

                        <div class="col-sm-8">
                            <input type="password" name="password"
                                   class="validate[required,equals[password]] form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">学历：</label>

                        <div class="col-sm-8">
                            <select name="eduction" class="form-control validate[required]">
                                <c:forEach var="t" items="${list3}" varStatus="status">
                                    <option value="${t.id}">${t.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">学位：</label>

                        <div class="col-sm-8">
                            <select name="degree" class="form-control validate[required]">
                                <c:forEach var="t" items="${list2}">
                                    <option value="${t.id}">${t.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">职称：</label>

                        <div class="col-sm-8">
                            <select name="title" class="form-control">
                                <c:forEach var="t" items="${list1}">
                                    <option value="${t.id}">${t.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">学院：</label>

                        <div class="col-sm-8">
                            <select name="department" class="form-control">
                                <c:forEach var="t" items="${list}">
                                    <option value="${t.id}">${t.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="regbtn">
                        <label></label><input type="button" class="btn btn-primary pull-right doRegister" value="提交注册"/>
                    </div>
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
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/3rd/validate/jquery.validationEngine.js"></script>
<script type="text/javascript" src="${path}/js/3rd/validate/jquery.validationEngine-zh_CN.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.zxxbox.3.0.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.jp.ajaxbtn.js"></script>
<script type="text/javascript" src="${path}/js/json2.js"></script>
<script type="text/javascript" src="${path}/js/kiss-web.1.0.js"></script>
<script type="text/javascript">
    $(function () {
        $('.doRegister').ajaxbtn('${path}/front/doRegister.htm', function () {
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
        }, function (r) {
            $.zxxbox.remind(r.message, null, {
                delay: 2000,
                onclose: function () {
                    if (r.code == 1) {
                        location.href = "${path}/front/index.htm";
                    }
                }
            });
        });
       
    });
</script>