<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">账户管理</a></li>
            <li><a href="#">我的账户信息</a></li>
        </ul>
    </div>
    <%@include file="../top.jsp" %>
</div>

<div class="formbody">

    <div class="formtitle"><span>我的账户信息</span></div>


    <ul class="forminfo short validationEngineContainer">
        <input name="id" type="hidden" value="${user.id}"/>
        <li class="line"><label>头像</label>
            <input name="avatar" type="hidden" class="short-input validate[required]" value="${user.avatar}"/>

            <div class="upload-img" id="upload-img-pic"><img
                    src="${user.avatar == null?'../images/upload-image.png':user.avatar}" class=""/></div>
        </li>
        <li><label>编号</label><input name="number" type="text" class="short-input validate[required]"
                                    value="${user.number}" disabled/></li>
        <li><label>手机号</label><input name="phone" type="text" class="short-input validate[required]"
                                     value="${user.phone}" disabled/></li>
        <li><label>姓名</label><input name="name" type="text" class="short-input"
                                    value="${user.name}"/></li>

            <li><label>&nbsp;</label><input type="button" class="btn saveAdminBtn" value="确认保存"/></li>
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
        });
        upload.on('uploadError', function (file) {
            $.zxxbox.remind("上传出错", null, {delay: 2000});
        });
        //身份证正面照
        var upload = WebUploader.create({
            swf: '../js/webuploader/Uploader.swf',
            server: '${path}/common/file/upload.htm',
            //paste: document.body,
            pick: '#idcardPicFront-img-pic',
            auto: true,
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        upload.on('uploadSuccess', function (file, data) {
            $('input[name="idcardPicFront"]').val(data.result.path);
            $('#idcardPicFront-img-pic').find('img').prop('src', data.result.path);
        });
        //身份证反面照
        var upload = WebUploader.create({
            swf: '../js/webuploader/Uploader.swf',
            server: '${path}/common/file/upload.htm',
            //paste: document.body,
            pick: '#idcardPicBack-img-pic',
            auto: true,
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        upload.on('uploadSuccess', function (file, data) {
            $('input[name="idcardPicBack"]').val(data.result.path);
            $('#idcardPicBack-img-pic').find('img').prop('src', data.result.path);
        });
        //手持正面照
        var upload = WebUploader.create({
            swf: '../js/webuploader/Uploader.swf',
            server: '${path}/common/file/upload.htm',
            //paste: document.body,
            pick: '#idcardPicHold-img-pic',
            auto: true,
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        upload.on('uploadSuccess', function (file, data) {
            $('input[name="idcardPicHold"]').val(data.result.path);
            $('#idcardPicHold-img-pic').find('img').prop('src', data.result.path);
        });
        //营业执照
        var upload = WebUploader.create({
            swf: '../js/webuploader/Uploader.swf',
            server: '${path}/common/file/upload.htm',
            //paste: document.body,
            pick: '#businessLicencePic-img-pic',
            auto: true,
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        upload.on('uploadSuccess', function (file, data) {
            $('input[name="businessLicencePic"]').val(data.result.path);
            $('#businessLicencePic-img-pic').find('img').prop('src', data.result.path);
        });
        //
        $('.saveBtn').ajaxbtn('doAddOrModifyTravelAgencyInfo.htm', function () {
            return {
                id: $.trim($('input[name="id"]').val()),
                avatar: $.trim($('input[name="avatar"]').val()),
                phone: $.trim($('input[name="phone"]').val()),
                name: $.trim($('input[name="name"]').val()),
                contactPhone: $.trim($('input[name="contactPhone"]').val()),
                authStatus: $.trim($('select[name="authStatus"]').val()),
                idcardNumber: $.trim($('input[name="idcardNumber"]').val()),
                idcardPicFront: $.trim($('input[name="idcardPicFront"]').val()),
                idcardPicBack: $.trim($('input[name="idcardPicBack"]').val()),
                idcardPicHold: $.trim($('input[name="idcardPicHold"]').val()),
                businessLicencePic: $.trim($('input[name="businessLicencePic"]').val())
            }
        }, function () {
            return $('.forminfo').validationEngine('validate');
        });
        //
        $('.saveAdminBtn').ajaxbtn('doAddOrModifyMonitorInfo.htm', function () {
            return {
                id: $.trim($('input[name="id"]').val()),
                avatar: $.trim($('input[name="avatar"]').val()),
                name: $.trim($('input[name="name"]').val())
            }
        }, function () {
            return $('.forminfo').validationEngine('validate');
        });
    });
</script>
