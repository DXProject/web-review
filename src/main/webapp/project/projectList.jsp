<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">项目管理</a></li>
            <li><a href="#">申报项目列表</a></li>
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
                <input name="" type="button" class="scbtn _searchBtn" value="查询" action="projectList.htm"/>
            </li>
        </form>
    </ul>

    <table class="imgtable">
        <thead>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>状态</th>
            <th>创建人</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="sortable">
        <c:forEach var="r" items="${list}">
            <tr data="${r.id}" id="${r.id}" height="40">
                <td>${r.number}</td>
                <td>${r.name}</td>
                <td>${r.status}</td>
                <td>${r.creator}</td>
                <td><fmt:formatDate value='${r.creationTime}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
                <td class="tdPosi _menu" data="${r.id}">
                    <a class="tablelink">操作</a>
                        <%--<i class="iconfont icMoreColor">&#xe602;</i>--%>
                        <%--<canvas id="iCanvas" width="5px;" height="5px;" style="border:1px solid black;">not support</canvas>--%>
                    <div class="subDiv">
                        <ul>
                            <li>
                                <a href="javascript:;"
                                   target="rightFrame" class="_editPwdBtn">详情</a>
                            </li>
                            <li>
                                <a href="uploadFile.htm?id=${r.id}"
                                   target="rightFrame" class="_distributionBtn">文件下载</a>
                            </li>
                            <li>
                                <a href="getExpertByDisciplineCategoryId.htm?id=${r.disciplineCategory}&projectId=${r.id}"
                                   target="rightFrame" class="_distributionBtn">分配专家</a>
                            </li>
                            <li>
                                <a href="getExpertByProjectId.htm?id=${r.id}"
                                   target="rightFrame" class="_editPwdBtn">已有专家</a>
                            </li>
                            <li>
                                <a href="javascript:;"
                                   target="rightFrame" class="_removeBtn">删除</a>
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
<%@include file="../footer.jsp" %>
<script type="text/javascript">
    $(function () {

        $(".seachform select").uedSelect('resize', 200);

        // remove
        $('._removeBtn').on('click', function () {
            var id = $(this).parents('tr').attr('data');
            $.zxxbox.ask('确定要删除?', function () {
                $K.http('removeProject.htm', {
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

        $('._searchBtn').on('click', function () {
            $('#searchForm').prop('action', $(this).attr('action')).submit();
        });
    });
</script>
