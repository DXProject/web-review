<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">账户信息</a></li>
            <li><a href="#">变更密码</a></li>
        </ul>
    </div>
    <%@include file="../top.jsp" %>
</div>

<div class="formbody">

    <div class="formtitle"><span>变更密码</span></div>

    <ul class="forminfo validationEngineContainer">
        <input name="id" type="hidden" value="${user.userId}"/>
        <li><label>原密码</label><input name="oldPwd" type="password" class="long-input validate[required]" value=""/></li>
        <li><label>新密码</label><input name="newPwd" id="newPwd" type="password" class="long-input validate[required]"
                                     value=""/></li>
        <li><label>确认新密码</label><input name="confirmPwd" type="password"
                                       class="long-input validate[required,equals[newPwd]]" value=""/></li>
        <li><label>&nbsp;</label><input name="" type="button" class="btn saveBtn" value="确认保存"/></li>
    </ul>


</div>


<%@include file="../footer.jsp" %>
<script type="text/javascript">
    $(function () {
        $('.saveBtn').ajaxbtn('doModifyPassword.htm', function () {
            return {
                id: $.trim($('input[name="id"]').val()),
                oldPwd: $.trim($('input[name="oldPwd"]').val()),
                newPwd: $.trim($('input[name="newPwd"]').val()),
            }
        }, function () {
            return $('.forminfo').validationEngine('validate');
        });
    });
</script>
