<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">评审方案管理</a></li>
            <li><a href="#">评审规则列表</a></li>
        </ul>
    </div>
    <%@include file="../top.jsp" %>
</div>

<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <%--<a href="reviewProgramInfo.htm">--%>
            <%--<li class="click"><span><img src="${path}/images/t01.png"/></span>添加</li>--%>
            <%--</a>--%>
            <li class="click _addBtn"><span><img src="${path}/images/t01.png"/></span>添加</li>
        </ul>
    </div>
    <ul class="seachform">
        <form method="get" action="" id="searchForm">
            <li><label>关键字${type}</label>
                <input name="keyword" type="text" class="scinput" value="${keyword}"/>
            </li>

            <li><label>&nbsp;</label>
                <input name="" type="button" class="scbtn _searchBtn" value="查询" action="reviewProgramList.htm"/>
            </li>
        </form>
    </ul>

    <table class="imgtable">
        <thead>
        <tr>
            <th>名称</th>
            <th>类型</th>
            <th>创建时间</th>
            <th>创建人</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="sortable">
        <c:forEach var="r" items="${list}">
            <tr data="${r.id}" id="${r.id}" height="40">
                <td>${r.name}</td>
                <td>
                    <c:if test="${REVIEW_PROGRAM_TYPE_ONE.value == r.type}">等级评定</c:if>
                    <c:if test="${REVIEW_PROGRAM_TYPE_TWO.value == r.type}">通过与否</c:if>
                    <c:if test="${REVIEW_PROGRAM_TYPE_THREE.value == r.type}">分数评定</c:if>
                    <c:if test="${REVIEW_PROGRAM_TYPE_FOUR.value == r.type}">细则评定</c:if>
                </td>
                <td><fmt:formatDate value='${r.creationTime}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
                <td>${r.creator}</td>
                    <%--<a href="getRulesByReviewProgramId.htm?id=${r.id}" class="tablelink _modifyBtn">添加评分细则</a>&nbsp;--%>
                    <%--<a href="javascript:;" class="tablelink _modifyBtn">修改</a>&nbsp;--%>
                    <%--<a href="javascript:;" class="tablelink _removeBtn">删除</a>&nbsp;--%>
                <td class="tdPosi _menu" data="${shop.id}">
                    <a>操作</a>
                    <i class="iconfont icMoreColor">&#xe602;</i>
                    <%--<canvas id="iCanvas" width="5px;" height="5px;" style="border:1px solid black;">not support</canvas>--%>
                    <div class="subDiv">
                        <ul>
                            <li>
                                <a href="javascript:;"
                                   target="rightFrame" class="_editPwdBtn">修改</a>
                            </li>
                            <li>
                                <a href="javascript:;"
                                   target="rightFrame" class="_removeBtn">删除</a>
                            </li>
                            <li>
                                <a href="getAlreadyAddedRules.htm?id=${r.id}">已有细则</a>
                            </li>
                            <li>
                                <a href="addFromRulesList.htm?reviewProgramId=${r.id}">所有细则</a>
                            </li>
                        </ul>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">${page}</div>
</div>
<%--add--%>
<ul class="forminfo short zxxbox_contaner validationEngineContainer" id="addBox" style="width: 400px">
    <input name="id" type="hidden" value=""/>
    <li class="line"><label>名称</label><input name="name" type="text" class="short-input validate[required]" value=""/>
    </li>
    <li class="line"><label>评审方案选择</label>

        <div class="vocation">
            <select name="type" class="useselect validate[required]">
                <c:forEach var="s" items="${REVIEW_PROGRAM}">
                    <option value="${s.value}"
                            <c:if test="${s.value == r.type}">selected</c:if> >${s.name}</option>
                </c:forEach>
            </select>
        </div>
    </li>
    <li></li>
    <li style="width: 100%;text-align: center"><input name="" type="button" class="btn _saveBtn" value="确认保存"/></li>
</ul>
<%@include file="../footer.jsp" %>
<script type="text/javascript">
    $(function () {

        $(".seachform select").uedSelect('resize', 200);

        var key = $('select[name="key"]').val();
        //add
        $('._addBtn').on('click', function () {
            $.zxxbox($('#addBox'), {
                title: '新增'
            });
        });

        //modify
        var id = '';
        $('._modifyBtn').on('click', function () {
            id = $(this).parents('tr').attr('data');
            $.zxxbox($('#addBox'), {
                title: '修改'
            });
            $K.http('getRulesInfo.htm', {
                id: id
            }, function (r) {
                var rules = r.result;
                $('input[name="id"]').val(rules.id);
                $('input[name="name"]').val(rules.name);
                $('input[name="details"]').val(rules.details);
            })
        });

        //do add or modify
        $('._saveBtn').ajaxbtn('doAddOrModifyReviewProgram.htm', function () {
            return {
                id: $.trim($('input[name="id"]').val()),
                name: $.trim($('input[name="name"]').val()),
                type: $.trim($('select[name="type"]').val())
            }
        }, function () {
            return $('#addBox').validationEngine('validate');
        });

        // remove
        $('._removeBtn').on('click', function () {
            var id = $(this).parents('tr').attr('data');
            $.zxxbox.ask('确定要删除?', function () {
                $K.http('removeReviewProgram.htm', {
                    id: id
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
        $('._menu').menu();

        $('._searchBtn').on('click', function () {
            $('#searchForm').prop('action', $(this).attr('action')).submit();
        });
    });


</script>
