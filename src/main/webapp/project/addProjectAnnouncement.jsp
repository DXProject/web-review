<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">项目管理</a></li>
            <li><a href="#">开始新项目管理</a></li>
        </ul>
    </div>
    <%@include file="../top.jsp" %>
</div>

<div class="formbody">

    <div class="formtitle"><span>发布新项目申请</span></div>

    <ul class="forminfo short validationEngineContainer">
        <input name="" type="hidden" value=""/>
        <li><label>公告标题</label><input name="title" type="text" class="long-input validate[required]"
                                      value=""></li>
        <li class="line"><label>公告类别</label>
            <div class="vocation">
                <select name="type" class="useselect validate[required]">
                    <option value="1">1</option>
                    <option value="2">2</option>
                </select>
            </div>
        </li>
        <li class="line"><label>公告内容</label>
            <%--<textarea style="width:72%;height:250px" name="content"></textarea>--%>
            <textarea style="width:80%;height:300px" name="content" id="content"
                      class="ke"></textarea>
        </li>
        <li class="line"><label>申报时间</label>
            <input name="timeStart" type="text" class="short-input Wdate"
                   value="" onfocus="WdatePicker({minDate:'%y-%M-%d'})"/>&emsp;~&emsp;
            <input name="timeEnd" type="text" class="short-input Wdate"
                   value="" onfocus="WdatePicker({minDate:'%y-%M-%d'})"/>
        </li>
        <li><label>项目名称</label><input name="name" type="text" class="short-input validate[required]"
                                      value=""></li>
        <li class="line"><label>项目备注</label><input name="remark" type="text" class="long-input validate[required]"
                                                   value=""></li>
        <li class="line"><label>项目类别</label>

            <div class="vocation">
                <select name="classOne" class="useselect validate[required]">
                    <c:forEach var="t" items="${classOnes}">
                        <option value="${t.id}">${t.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="vocation" style="margin-left: 40px;">
                <select name="classTwo" class="useselect validate[required]">
                    <c:forEach var="t" items="${classTwos}">
                        <option value="${t.id}">${t.name}</option>
                    </c:forEach>
                </select>
            </div>
        </li>

        <li class="line"><label>评审方案选择</label>

            <div class="vocation">
                <select name="reviewProgram" class="useselect validate[required]">
                    <c:forEach var="t" items="${classTwos}">
                        <option value="${t.id}">${t.name}</option>
                    </c:forEach>
                </select>
            </div>
        </li>

        <li><label>&nbsp;</label><input type="button" class="btn saveBtn" value="确认保存"/></li>
    </ul>
</div>
<%@include file="../footer.jsp" %>
<script type="text/javascript" src="${path}/js/3rd/kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript" src="${path}/js/3rd/kindeditor/lang/zh_CN.js"></script>
<script>
    $(function () {
        //
        $('.saveBtn').ajaxbtn('doAddProjectAnnouncement.htm', function () {
            return {
                //id: $.trim($('input[name="id"]').val()),
                title: $.trim($('input[name="title"]').val()),
                type: $.trim($('select[name="type"]').val()),
                content: $.trim($('textarea[name="content"]').val()),
                name: $.trim($('input[name="name"]').val()),
                remark: $.trim($('input[name="remark"]').val()),
                timeStart: $.trim($('input[name="timeStart"]').val()),
                timeEnd: $.trim($('input[name="timeEnd"]').val()),
                classOne: $.trim($('select[name="classOne"]').val()),
                classTwo: $.trim($('select[name="classTwo"]').val())
            }
        }, function () {
            return $('.forminfo').validationEngine('validate');
        });
        //
        KindEditor.create('.ke');
    });
</script>
