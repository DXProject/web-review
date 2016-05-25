<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">申报项目管理</a></li>
            <li><a href="#">分配专家</a></li>
        </ul>
    </div>
    <%@include file="../top.jsp" %>
</div>

<div class="rightinfo">
    <ul class="seachform">
        <form method="get" action="" id="searchForm">

            <li><label>关键字${type}</label>
                <input name="keyword" type="text" class="scinput" value="${keyword}"/>
            </li>

            <li><label>&nbsp;</label>
                <input name="" type="button" class="scbtn _searchBtn" value="查询" action="rulesList.htm"/>
            </li>
        </form>
        <input type="hidden" name="projectId" value="${projectId}">
        <li style="float: right;"><label>&nbsp;</label>
            <input name="" type="button" class="scbtn _doAddBtn" value="确认分配"/>
        </li>
    </ul>

    <table class="imgtable cart-menu">
        <thead>
        <tr>
            <input type="hidden" name="expertId" value="$">
            <th width="60px"><input type="checkbox" name="CheckboxGroup1" class="select-all">全选</th>
            <th>头像</th>
            <th>编号</th>
            <th>姓名</th>
            <th>手机号</th>
            <th>创建时间</th>
            <%--<th>操作</th>--%>
        </tr>
        </thead>
        <tbody id="sortable">
        <c:forEach var="r" items="${list}">
            <tr data="${r.id}" id="${r.id}" height="40">
                <td><input type="checkbox" name="CheckboxGroup1" id="CheckboxGroup1_1"></td>
                <td>
                    <img class="lazy" data-original="${r.avatar}"
                         style="width:60px;-moz-border-radius:30px;-webkit-border-radius:30px;border-radius:30px;"/>
                </td>
                <td>
                        ${r.number}
                </td>
                <td>
                        ${r.name}
                </td>
                <td>
                    <p>${r.phone}</p>
                </td>
                <td><fmt:formatDate value='${r.creationTime}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">${page}</div>
</div>
<%@include file="../footer.jsp" %>
<script type="text/javascript">
    $(function () {

        $(".seachform select").uedSelect('resize', 200);
        //
        function selectAll(obj, tf) {
            obj.each(function (i, e) {
                $(e).find("input[type='checkbox']").prop("checked", tf);
            })
        }

        //全选
        $(".select-all").click(function () {
            selectAll($(".cart-menu"), $(this).prop("checked"));
        });
        //
        //批量添加
        $("._doAddBtn").click(function () {
            var expertIds = "";
            var expertId;
            $(".cart-menu tr").each(function (i, e) {
                expertId = $(e).attr('data');
                console.log("expertId:" + expertId);
                if ($(e).find("input[type='checkbox']").prop("checked")) {
                    expertIds += "," + expertId;
                }
            });
            if (expertIds.substr(0, 1) == ',') {
                expertIds = expertIds.substr(1);
            }
            $K.http('distributionExpert.htm', {
                id: $.trim($('input[name="projectId"]').val()),
                expertIds: expertIds
            }, function (r) {
                $.zxxbox.remind("操作成功。", null, {
                    delay: 3000,
                    onclose: function () {
                        location.reload();
                    }
                });
            })
        });

        $('._searchBtn').on('click', function () {
            $('#searchForm').prop('action', $(this).attr('action')).submit();
        });
    });
</script>
