<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">用户管理</a></li>
            <li><a href="#">中介</a></li>
        </ul>
    </div>
    <%@include file="../top.jsp" %>
</div>
<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <a href="agentInfo.htm">
                <li class="click"><span><img src="${path}/images/t01.png"/></span>添加</li>
            </a>
        </ul>
    </div>

    <ul class="seachform">
        <form method="get" action="" id="searchForm">
            <input type="hidden" name="type" value="${type}">
            <li><label>审核状态</label>

                <div class="vocation">
                    <select name="authStatus">
                        <option value="-1">全部</option>
                        <c:forEach var="s" items="${PASSPORT_AUTH_STATUS}">
                            <option value="${s.value}"
                                    <c:if test="${s.value == authStatus}">selected</c:if> >${s.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </li>
            <li><label>状态</label>

                <div class="vocation">
                    <select name="status">
                        <option value="-1">全部</option>
                        <c:forEach var="s" items="${PASSPORT_STATUS}">
                            <option value="${s.value}"
                                    <c:if test="${s.value == status}">selected</c:if> >${s.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </li>
            <li><label>关键字${type}</label>
                <input name="keyword" type="text" class="scinput" value="${keyword}"/>
            </li>
            <li><label>&nbsp;</label>
                <input name="" type="button" class="scbtn _searchBtn" value="查询" action="passportList.htm"/>
            </li>
        </form>
    </ul>
    <table class="imgtable">
        <thead>
        <tr>
            <th width="100px;">头像</th>
            <th>姓名</th>
            <th>类型</th>
            <th>审核状态</th>
            <th>账户余额</th>
            <th>创建时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${list}">
            <tr data="${i.passport.id}">
                <td class="imgtd"><img class="lazy" data-original="${i.passport.avatar}"
                                       style="width:60px;-moz-border-radius: 30px;-webkit-border-radius: 30px;border-radius:30px;"/>
                </td>
                <td>
                    <a href="#">${i.passport.name}</a>

                    <p>手机号:${i.passport.phone}</p>
                </td>
                <td>
                    <c:if test="${PASSPORTTYPE_ADMIN == i.passport.type}">运营</c:if>
                    <c:if test="${PASSPORTTYPE_TOURIST == i.passport.type}">游客</c:if>
                    <c:if test="${PASSPORTTYPE_AGENT == i.passport.type}">中介</c:if>
                    <c:if test="${PASSPORTTYPE_TRAVEL_AGENCY == i.passport.type}">旅行社</c:if>
                    <c:if test="${PASSPORTTYPE_GUIDE == i.passport.type}">导游</c:if>
                    <c:if test="${PASSPORTTYPE_MONITOR == i.passport.type}">监管</c:if>
                </td>

                <td>
                    <c:if test="${PASSPORT_AUTH_STATUS_UNREVIEW.value  == i.passport.authStatus}">未审核</c:if>
                    <c:if test="${PASSPORT_AUTH_STATUS_REVIEWING.value == i.passport.authStatus}"><font
                            class="color-orange">待审核</font></c:if>
                    <c:if test="${PASSPORT_AUTH_STATUS_REVIEW.value == i.passport.authStatus}"><font
                            class="color-green">已审核</font></c:if>
                    <c:if test="${PASSPORT_AUTH_STATUS_REFUSE.value == i.passport.authStatus}"><font
                            class="color-red">未通过</font></c:if>
                </td>
                <td><fmt:formatNumber type="currency" value="${i.amount} " pattern="#,#00.00#"/><a
                        href="${path}/account/passportAccountList.htm?passportId=${i.passport.id}"
                        class="tablelink _amountBtn">(详情)</a></td>
                <td><fmt:formatDate value='${i.passport.creationTime}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
                <td>
                    <a href="javascript:;" class="tablelink _updateBtn">
                        <c:if test="${PASSPORT_STATUS_NORMAL.value == i.passport.status}"><font
                                class="color-green">正常</font></c:if>
                        <c:if test="${PASSPORT_STATUS_DISABLE.value == i.passport.status}"><font
                                class="color-red">禁用</font></c:if>
                    </a>
                </td>
                <td>
                    <a href="agentInfo.htm?passportId=${i.passport.id}" class="tablelink _modifyBtn">修改</a>&nbsp;
                    <a href="javascript:;" class="tablelink _removeBtn">删除</a>&nbsp;
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">${page}</div>
</div>
<%@include file="../footer.jsp" %>
<script>
    $(function () {
        // toggle
        $('._updateBtn').on('click', function () {
            var passportId = $(this).parents('tr').attr('data');
            $.zxxbox.ask('确定更改状态?', function () {
                $K.http('togglePassportStatus.htm', {
                    passportId: passportId
                }, function (r) {
                    $.zxxbox.remind("操作成功。", null, {
                        delay: 3000,
                        onclose: function () {
                            location.reload();
                        }
                    });
                })
            })
        });
        //
        $('._searchBtn').on('click', function () {
            $('#searchForm').prop('action', $(this).attr('action')).submit();
        });
        // remove
        $('._removeBtn').on('click', function () {
            var data = $(this).parents('tr').attr('data');
            var passportId = data;
            $.zxxbox.ask('确定要删除?', function () {
                $K.http('doRemovePassport.htm', {
                    passportId: passportId
                }, function (r) {
                    $.zxxbox.remind("操作成功。", null, {
                        delay: 3000,
                        onclose: function () {
                            location.reload();
                        }
                    });
                })
            })
        });
    });
</script>
