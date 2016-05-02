<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">用户管理</a></li>
            <li><a href="#">编辑运营人员</a></li>
        </ul>
    </div>
    <%@include file="../top.jsp" %>
</div>

<div class="formbody">

    <div class="formtitle"><span>编辑运营人员</span></div>

    <ul class="forminfo short validationEngineContainer">
        <input name="id" type="hidden" value="${passport.id}"/>
        <input name="type" type="hidden" value="${PASSPORTTYPE_ADMIN}"/>
        <li class="line"><label>手机号</label><input name="phone" type="text" class="short-input validate[required]"
                                                  value="${passport.phone}" <c:if test="${null!=passport.id}">disabled</c:if>/></li>
        <li class="line"><label>姓名</label><input name="name" type="text" class="short-input"
                                                 value="${passport.name}"/></li>
        <li class="line"><label>审核状态</label>

            <div class="vocation">
                <select name="authStatus" class="useselect validate[required]">
                    <c:forEach var="t" items="${PASSPORT_AUTH_STATUS}">
                        <option value="${t.value}"
                                <c:if test="${t.value == passport.authStatus}">selected</c:if> >${t.name}</option>
                    </c:forEach>
                </select>
            </div>
        </li>
        <c:if test="${null == passport.id}">
            <li class="line"><label>密码</label><input name="password" type="password" class="short-input"
                                                       value="" placeholder="默认密码:12345"/></li>
        </c:if>
        <c:if test="${null != passport.id}">
            <li class="line"><label>修改密码</label><input name="password" type="password" class="short-input"
                                                       value="" placeholder="不填写则为原密码"/></li>
        </c:if>
        <li><label>&nbsp;</label><input type="button" class="btn saveBtn" value="确认保存"/></li>

    </ul>
</div>
<%@include file="../footer.jsp" %>

<script>
    $(function () {
        //
        $('.saveBtn').ajaxbtn('doAddOrModifyMonitorInfo.htm', function () {
            return {
                id: $.trim($('input[name="id"]').val()),
                phone: $.trim($('input[name="phone"]').val()),
                name: $.trim($('input[name="name"]').val()),
                type: $.trim($('input[name="type"]').val()),
                password: $.trim($('input[name="password"]').val()),
                authStatus: $.trim($('select[name="authStatus"]').val())
            }
        }, function () {
            return $('.forminfo').validationEngine('validate');
        });
    });
</script>
