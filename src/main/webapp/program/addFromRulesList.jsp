<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">评审细则</a></li>
            <li><a href="#">添加评审细则</a></li>
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
        <input type="hidden" name="reviewProgramId" value="${reviewProgramId}">
        <li style="float: right;"><label>&nbsp;</label>
            <input name="" type="button" class="scbtn _doAddBtn" value="确认组团"/>
        </li>
    </ul>

    <table class="imgtable cart-menu">
        <thead>
        <tr>
            <input type="hidden" name="reviewProgramId" value="$">
            <th width="60px"><input type="checkbox" name="CheckboxGroup1" class="select-all">全选</th>
            <th>编号</th>
            <th>名称</th>
            <th style="width: 50%;">详细</th>
            <th>创建时间</th>
            <%--<th>状态</th>--%>
        </tr>
        </thead>
        <tbody id="sortable">
        <c:forEach var="r" items="${list}">
            <tr data="${r.id}" id="${r.id}" height="40">
                <td><input type="checkbox" name="CheckboxGroup1" id="CheckboxGroup1_1"></td>
                <td>${r.number}</td>
                <td>${r.name}</td>
                <td>${r.details}</td>
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
            var rules = "";
            var ruleId;
            var peopleCount = 0;
            var count;
            var startTime = "";
            $(".cart-menu tr").each(function (i, e) {
                ruleId = $(e).attr('data');
                console.log("ruleId:" + ruleId);
                if ($(e).find("input[type='checkbox']").prop("checked")) {
                    rules += "," + ruleId;
                }
            });
            if (rules.substr(0, 1) == ',') {
                rules = rules.substr(1);
            }
            $K.http('addRulesToReviewProgramRules.htm', {
                reviewProgramId:$.trim($('input[name="reviewProgramId"]').val()),
                rules: rules
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
