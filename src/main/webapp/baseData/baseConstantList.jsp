<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">通用数据维护</a></li>
            <li><a href="#">学位维护</a></li>
        </ul>
    </div>
    <%@include file="../top.jsp" %>
</div>

<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <li class="click _addBtn"><span><img src="${path}/images/t01.png"/></span>添加</li>
        </ul>
    </div>
    <ul class="seachform">
        <form method="get" action="" id="searchForm">
            <li><label>数据类型</label>

                <div class="vocation">
                    <select name="key">
                        <option value="${BASE_CONSTANT_TITLE}"
                                <c:if test="${BASE_CONSTANT_TITLE  == key}">selected</c:if>>职称
                        </option>
                        <option value="${BASE_CONSTANT_DEGREE}"
                                <c:if test="${BASE_CONSTANT_DEGREE == key}">selected</c:if>>学位
                        </option>
                        <option value="${BASE_CONSTANT_EDUCATION}"
                                <c:if test="${BASE_CONSTANT_EDUCATION == key}">selected</c:if>>学历
                        </option>
                        <option value="${BASE_CONSTANT_DEPARTMENT}"
                                <c:if test="${BASE_CONSTANT_DEPARTMENT == key}">selected</c:if>>部门学院
                        </option>
                        <option value="${BASE_CONSTANT_DISCIPLINE_CATEGORY}"
                                <c:if test="${BASE_CONSTANT_DISCIPLINE_CATEGORY == key}">selected</c:if>>学科门类
                        </option>
                        <option value="${BASE_CONSTANT_SUBJECT_CATEGORY}"
                                <c:if test="${BASE_CONSTANT_SUBJECT_CATEGORY == key}">selected</c:if>>课题类别
                        </option>
                    </select>
                </div>
            </li>

            <li><label>&nbsp;</label>
                <input name="" type="button" class="scbtn _searchBtn" value="查询" action="baseConstantList.htm"/>
            </li>
        </form>
    </ul>

    <table class="imgtable">
        <thead>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th style="width: 50%;">备注</th>
            <th>创建时间</th>
            <%--<th>状态</th>--%>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="sortable">
        <c:forEach var="baseConstant" items="${list}">
            <tr data="${baseConstant.id}" id="${baseConstant.id}" height="40">
                <td>${baseConstant.number}</td>
                <td>${baseConstant.name}</td>
                <td>${baseConstant.remark}</td>
                <td><fmt:formatDate value='${baseConstant.creationTime}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
                <td>
                    <a href="javascript:;" class="tablelink _modifyBtn">修改</a>&nbsp;
                    <a href="javascript:;" class="tablelink _removeBtn">删除</a>&nbsp;
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">${page}</div>
</div>
<%--add--%>
<ul class="forminfo short zxxbox_contaner validationEngineContainer" id="addBox" style="width: 550px">
    <input name="id" type="hidden" value=""/>
    <li class="line"><label>名称</label><input name="name" type="text" class="short-input validate[required]" value=""/>
    </li>
    <li class="line"><label>备注</label><input name="remark" type="text" class="long-input" value=""/>
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
            $K.http('getBaseConstantsInfo.htm', {
                id: id
            }, function (r) {
                var baseConstant = r.result;
                $('input[name="id"]').val(baseConstant.id);
                $('input[name="name"]').val(baseConstant.name);
                $('input[name="remark"]').val(baseConstant.remark);
            })
        });

        //do add or modify
        $('._saveBtn').ajaxbtn('doAddOrModifyBaseConstants.htm', function () {
            return {
                id: $.trim($('input[name="id"]').val()),
                key: key,
                name: $.trim($('input[name="name"]').val()),
                remark: $.trim($('input[name="remark"]').val())
            }
        }, function () {
            return $('#addBox').validationEngine('validate');
        });

        // remove
        $('._removeBtn').on('click', function () {
            var id = $(this).parents('tr').attr('data');
            $.zxxbox.ask('确定要删除?', function () {
                $K.http('doRemoveBaseConstant.htm', {
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

        $('._searchBtn').on('click', function () {
            $('#searchForm').prop('action', $(this).attr('action')).submit();
        });
    });
</script>
