<%--
  Created by IntelliJ IDEA.
  User: zhangtianfeng
  Date: 16/5/15
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>高校教科研项目网上评审</title>
</head>
<%@include file="../common.jsp" %>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/uploadfiles/css/default.css">
<link href="${path}/uploadfiles/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/web-nav.css">
<link rel="stylesheet" type="text/css" href="${path}/css/left-tab.css">
<link rel="stylesheet" type="text/css" href="${path}/css/Applicants.css">

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
                    <li class="apply"><a href="#">申请者栏目</a><span></span></li>
                    <li class="active"><a href="Applicants.html">申请项目</a></li>
                    <li><a href="Modification.html">查询项目</a></li>
                    <li><a href="participantprojectstate.html">修改项目</a></li>
                </ul>
            </div>
            <div class="content">
                <div class="notes">
						<span>
							<h4><a>填报注意：</a></h4>
							<p>1.按照要求仔细填写科研项目申请书。</p>
							<p>2.所有申请书必须按规定时间报送，项目申报时间为2015年6月1日至2015年8月1日。</p>
							<p>3.所有项目书按照所要求的格式填写，可上传相关附件。</p>
						</span>
                </div>
                <div class="table">
                    <form method="get" action="declareProject.htm" id="searchForm">
                        <table border=1>
                            <input type="hidden" value="${reviewProgram}" name="reviewProgram">
                            <input type="hidden" value="${classThree.id}" name="classThree">
                            <input type="hidden" value="${department.id}" name="department">
                            <tr>
                                <td colspan="5" class="bigtitle">
                                    <span>科研项目申请书</span>
                                </td>
                            </tr>
                            <tr>
                                <td rowspan="8" class="title-1  "><span>科研项目</span></td>

                            </tr>
                            <tr>
                                <td class="title-2"><span>项目名称</span></td>
                                <td colspan="4"><span><input type="text" name="name" value="${project.name}"></span>
                                </td>
                            </tr>
                            <tr>
                                <td rowspan="2"><span>负责人</span></td>
                                <td class="title-2-2"><span>姓名</span></td>
                                <td class="title-4"><span>所在学院、专业</span></td>
                                <td colspan="2"><span>联系方式</span></td>
                            </tr>
                            <tr>
                                <td><span><input type="text" value="${application.name}" disabled></span></td>
                                <td><span><input type="text" value="${department.name}" disabled></span></td>
                                <td colspan="2"><span><input type="text" value="${application.phone}" disabled></span>
                                </td>
                            </tr>
                            <tr>
                                <td rowspan="4"><span>参加成员</span></td>
                                <td class="title-2"><span>姓名</span></td>
                                <td class="title-4"><span>所在学院、专业</span></td>
                                <td colspan="2" class="title-5"><span>联系方式</span></td>
                            </tr>
                            <tr>
                                <td><span><input type="text"></span></td>
                                <td><span><input type="text"></span></td>
                                <td colspan="2"><span><input type="text"></span></td>
                            </tr>
                            <tr>
                                <td><span><input type="text"></span></td>
                                <td><span><input type="text"></span></td>
                                <td colspan="2"><span><input type="text"></span></td>
                            </tr>
                            <tr>
                                <td colspan="4"><span><a href="">添加成员</a></span></td>
                            </tr>

                            <tr>
                                <td class="title-1-1  "><span>课题类别</span></td>
                                <td colspan="4" class="textleft">
                                    <c:forEach var="s" items="${subjectCategory}">
                                        <label>
                                            <input type="radio" name="subjectCategory"
                                                   value="${project.subjectCategory}">${s.name}
                                        </label>
                                    </c:forEach>
                                </td>
                            </tr>
                            <tr>
                                <td class="title-1-1  "><span>学科门类</span></td>
                                <td colspan="4" class="textleft">
                                    <c:forEach var="d" items="${disciplineCategory}">
                                        <label>
                                            <input type="radio" name="disciplineCategory"
                                                   value="${project.disciplineCategory}">${d.name}
                                        </label>
                                    </c:forEach>
                                </td>
                            </tr>
                            <tr>
                                <td class="title-1-1  "><span>选题依据</span></td>
                                <td colspan="5">
									<span>
										<textarea placeholder="（包括项目的学术价值、应用价值、现状分析）"
                                                  name="topicBase">${project.topicBase}</textarea>
									</span>
                                </td>
                            </tr>
                            <tr>
                                <td class="title-1-1"><span>申请理由</span></td>
                                <td colspan="5">
									<span>
										<textarea></textarea>
									</span>
                                </td>
                            </tr>
                            <tr>
                                <td class="title-1-1"><span>研究内容</span></td>
                                <td colspan="5">
									<span>
										<textarea name="research">${project.research}</textarea>
									</span>
                                </td>
                            </tr>
                            <tr>
                                <td class="title-2  "><span>所需经费</span></td>
                                <td colspan="4"><span><input type="text" name="funds" value="${project.funds}"></span>
                                </td>

                            </tr>
                        </table>

                        <div class="appbtn">
                            <label><a href="uploadFile.htm?id=${project.id}">
                                <input type="button" value="文件下载"></a></label>
                            <c:if test="${reviewProgramType==1}">
                                <label><input type="button" value="评审" data-toggle="modal"
                                              data-target="#levelchoose"></label>
                            </c:if>
                            <c:if test="${reviewProgramType==2}">
                                <label><input type="button" value="评审" data-toggle="modal" data-target="#mark"></label>
                            </c:if>
                            <c:if test="${reviewProgramType==3}">
                                <label><input type="button" value="评审" data-toggle="modal"
                                              data-target="#access"></label>
                            </c:if>
                            <c:if test="${reviewProgramType==4}">
                                <label><input type="button" value="评审" data-toggle="modal" data-target="#xize"></label>
                            </c:if>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<div class="modal fade" id="levelchoose" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">评审</h4>
            </div>
            <div class="modal-body">
                <form>
        <span class="radio">等级：
        <label style="margin-left:10px;"><input type="radio" name="level">A</label>
        <label style="margin-left:10px;"><input type="radio" name="level">B</label>
        <label style="margin-left:10px;"><input type="radio" name="level">C</label>
        <label style="margin-left:10px;"><input type="radio" name="level">D</label>
        </span>

                </form>

            </div>
            <div class="modal-footer">
                <a type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">确定</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="mark" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">评审</h4>
            </div>
            <div class="modal-body">
                <form class="form-inline">
                    <label class="user">分&nbsp;&nbsp;数：<input type="text" class="form-control" id="username"
                                                              name="username"></label>
                </form>

            </div>
            <div class="modal-footer">
                <a type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">确定</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div class="modal fade" id="access" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">评审</h4>
            </div>

            <div class="modal-footer" style="text-align:center;">
                <a type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">通过</a>
                <a type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close"
                   style="margin-left:20px;">淘汰</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="xize" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">评审</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">

                    <div class="form-group" style="border-bottom:1px dashed #eee;padding-bottom:10px;font-size: 14px;">
                        <label for="item1" class="col-sm-10 " style="text-align:left;">1.第一条评审细则</label>

                        <div class="col-sm-2">
                            <input type="email" class="form-control" id="item1">
                        </div>
                    </div>
                    <div class="form-group" style="border-bottom:1px dashed #eee;padding-bottom:10px;font-size: 14px;">
                        <label for="item2" class="col-sm-10 " style="text-align:left;">1.第二条评审细则</label>

                        <div class="col-sm-2">
                            <input type="email" class="form-control" id="item2">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">确定</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>
<!--[if IE]>
<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script src="${path}/uploadfiles/js/fileinput.js" type="text/javascript"></script>
<script src="${path}/uploadfiles/js/fileinput_locale_zh.js" type="text/javascript"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.jp.ajaxbtn.js"></script>
<script>
    //多文件上传
    $("#files").fileinput({
        uploadUrl: '${path}/common/file/upload.htm', // you must set a valid URL here else you will get an error
        allowedFileExtensions: ['doc', 'xls', 'ppt', 'docx', 'xlsx', 'pptx', 'pdf', 'txt'],
        overwriteInitial: false,
        showUpload: true, //是否显示上传按钮
        enctype: 'multipart/form-data',
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function (filename) {
            return filename.replace('(', '_').replace(']', '_');
        },
        ajaxSettings: {
            //这里是重写文件上传成功后，前台处理后台返回json数据
            success: function (data) {
                $(".paths").append("<input type=\"hidden\" name=\"paths\" value=\"" + data.result.path + "\" />");
                // console.log(data.result.path);
            }
        }
    });
    $(function () {
        $('._searchBtn').on('click', function () {
            $('#searchForm').prop('action', $(this).attr('action')).submit();
        });

    });
</script>
