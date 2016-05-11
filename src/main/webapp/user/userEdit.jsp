<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">${title}管理</a></li>
            <li><a href="#">编辑</a></li>
        </ul>
    </div>
    <%@include file="../top.jsp" %>
</div>

<div class="formbody">

    <div class="formtitle"><span>编辑${title}</span></div>

    <ul class="forminfo short validationEngineContainer">
        <li class="line"><label>头像</label>
            <input name="id" value="${user.id}" type="hidden"/>
            <input name="avatar" id="avatar" type="hidden" class="short-input validate[required]" value="${user.avatar}"/>

            <div class="upload-img" id="upload-img-pic"><img
                    src="${user.avatar == null?'../images/upload-image.png':user.avatar}" class=""/></div>
        </li>
        <li class="line"><label>手机号</label>
            <input name="phone" type="text" class="short-input validate[required]" value="${user.phone}"/>
        </li>
        <li class="line"><label>教工号</label>
            <input name="number" type="text" class="short-input validate[required]" value="${user.number}"/>
        </li>
        <li class="line"><label>姓名</label>
            <input name="name" type="text" class="short-input" value="${user.name}"/></li>

        <c:if test="${type!=3}">
            <li class="line"><label>性别</label>
                <input name="sex" type="radio" value="0" <c:if test="${user.sex==false}">checked</c:if>/>&nbsp;男 &nbsp;
                <input name="sex" type="radio" value="1" <c:if test="${user.sex==true}">checked</c:if>/>&nbsp;女</li>
        </c:if>
        <li class="line"><label>邮箱</label>
            <input name="email" type="text" class="short-input" value="${user.email}"/></li>
        <c:if test="${type!=3}">
            <li class="line"><label>出生日期</label>
                <input name="birthday" type="text" class="short-input" value="${user.birthday}"/></li>
        </c:if>
        <li class="line"><label>职位:</label>
            <div class="vocation">
                <select name="title" class="useselect validate[required]">
                    <c:forEach var="t" items="${list1}">
                        <option value="${t.id}" <c:if test="${user.titleId==t.id}">selected</c:if>>${t.name}</option>
                    </c:forEach>
                </select>
            </div>
        </li>
        <li class="line"><label>学位:</label>

            <div class="vocation">
                <select name="degree" class="useselect validate[required]">
                    <c:forEach var="t" items="${list2}">
                        <option value="${t.id}" <c:if test="${user.degreeId==t.id}">selected</c:if>>${t.name}</option>
                    </c:forEach>
                </select>
            </div>
        </li>
        <c:if test="${type!=3}">
            <li class="line"><label>学历:</label>

                <div class="vocation">
                    <select name="eduction" class="useselect validate[required]">
                        <c:forEach var="t" items="${list3}" varStatus="status">
                            <option value="${t.id}" <c:if test="${user.eductionId==t.id}">selected</c:if>>${t.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </li>
        </c:if>
        <li class="line"><label>部门学院:</label>

            <div class="vocation">
                <select name="department" class="useselect validate[required]">
                    <c:forEach var="t" items="${list4}">
                        <option value="${t.id}" <c:if test="${user.departmentId==t.id}">selected</c:if>>${t.name}</option>
                    </c:forEach>
                </select>
            </div>
        </li>
        <c:if test="${null == user.password}">
        <li class="line"><label>密码</label><input name="password" type="password" class="short-input"
                                                 value="" placeholder="默认密码:12345"/></li>
        </c:if>
        <c:if test="${null != user.password}">
            <li class="line"><label>修改密码</label><input name="password" type="password" class="short-input"
                                                       value="" placeholder="不填写则为原密码"/></li>
        </c:if>
        <li><label>&nbsp;</label><input type="button" class="btn saveBtn" value="确认添加"/></li>

    </ul>
</div>
<%@include file="../footer.jsp" %>

<script>
    $(function () {
        //头像
        var upload = WebUploader.create({
            swf: '../js/webuploader/Uploader.swf',
            server: '${path}/common/file/upload.htm',
            //paste: document.body,
            pick: '#upload-img-pic',
            auto: true,
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        upload.on('uploadSuccess', function (file, data) {
            $('input[name="avatar"]').val(data.result.path);
            $('#upload-img-pic').find('img').prop('src', data.result.path);
            $('#avatar').val(data.result.path);
        });
        upload.on('uploadError', function (file) {
            $.zxxbox.remind("上传出错", null, {delay: 2000});
        });
        //
        $('.saveBtn').ajaxbtn('${path}/user/doUserEditPage${type}.htm',function () {
            return {
                id : $.trim($('input[name="id"]').val()),
                avatar: $.trim($('input[name="avatar"]').val()),
                phone: $.trim($('input[name="phone"]').val()),
                sex: $.trim($('input:radio[name="sex"]:checked').val()),
                degree: $.trim($('select[name="degree"]').val()),
                title: $.trim($('select[name="title"]').val()),
                eduction: $.trim($('select[name="eduction"]').val()),
                department: $.trim($('select[name="department"]').val()),
                email: $.trim($('input[name="email"]').val()),
                birthday: $.trim($('input[name="birthday"]').val()),
                name: $.trim($('input[name="name"]').val()),
                number: $.trim($('input[name="number"]').val()),
                password: $.trim($('input[name="password"]').val())
            }
        }, function () {
            return $('.forminfo').validationEngine('validate');
        });
    });
</script>