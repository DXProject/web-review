<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">通用数据维护</a></li>
            <li><a href="#">职称维护</a></li>
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
        <form method="get" action="">
            <li><label>大类别名</label>
            </li>

            <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>
        </form>
    </ul>

    <table class="imgtable">
        <thead>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>备注</th>
            <th>创建时间</th>
            <%--<th>状态</th>--%>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="sortable">
        <c:forEach var="title" items="${list}">
            <tr data="${title.id}" id="${title.id}" height="40">
                <td>${title.number}</td>
                <td>${title.name}</td>
                <td>${title.remark}</td>
                <td><fmt:formatDate value='${title.creationTime}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
                <td>
                    <a href="javascript:;" class="tablelink _modifyBtn">修改</a>&nbsp;
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">${page}</div>
</div>
<%--add--%>
<ul class="forminfo short zxxbox_contaner validationEngineContainer" id="addBox" style="width: 700px">
    <input name="id" type="hidden" value=""/>
    <li><label>名称</label><input name="name" type="text" class="short-input validate[required]" value=""/>
    </li>
    <li><label>备注</label><input name="remark" type="text" class="short-input" value=""/>
    </li>
    <li></li>
    <li style="width: 100%;text-align: center"><input name="" type="button" class="btn _saveBtn" value="确认保存"/></li>
</ul>
<%@include file="../footer.jsp" %>
<script type="text/javascript">
    $(function () {
        //
        var sortable = $("#sortable");
        sortable.sortable({
            revert: true,
            stop: function (event, ui) {
                var arrayActivity = sortable.sortable("toArray");
                $K.http('${path}/basedata/modifyBaseConstantSort.htm', {
                    sortedIds: arrayActivity.join(',')
                });
            }
        });
        sortable.disableSelection();
        sortable.find('td').width(sortable.width() / 4);

        $(".seachform select").uedSelect('resize', 200);

        var key = $('select[name="key"]').val();
        //add
        $('._addBtn').on('click', function () {
            $.zxxbox($('#addBox'), {
                title: '新增'
            });
            $('.forminfo input[type="text"],.forminfo input[type="hidden"]').val("");
        });

        //modify
        var id = '';
        $('._modifyBtn').on('click', function () {
            id = $(this).parents('tr').attr('data');
            $.zxxbox($('#addBox'), {
                title: '修改'
            });
            $K.http('getTitleInfo.htm', {
                id: id
            }, function (r) {
                var title = r.result;
                $('input[name="id"]').val(title.id);
                $('input[name="name"]').val(title.name);
                $('input[name="remark"]').val(title.remark);
            })
        });

        //do add or modify
        $('._saveBtn').ajaxbtn('doAddOrModifyTitle.htm', function () {
            return {
                id: $.trim($('input[name="id"]').val()),
                name: $.trim($('input[name="name"]').val()),
                remark: $.trim($('input[name="remark"]').val())
            }
        }, function () {
            return $('#addBox').validationEngine('validate');
        });

        // toggle
        $('._updateBtn').on('click', function () {
            baseConstantId = $(this).parents('tr').attr('data');
            $.zxxbox.ask('确定更改状态?', function () {
                $.zxxbox.hide();
                $K.http('toggleBaseConstantStatus.htm', {
                    id: baseConstantId
                }, function () {
                    $.zxxbox.remind("操作成功。", null, {
                        delay: 1000,
                        onclose: function () {
                            location.reload();
                        }
                    });
                })
            })
        });
    });
</script>
