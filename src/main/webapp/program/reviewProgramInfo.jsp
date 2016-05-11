<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../header.jsp" %>
<link href="${path}/js/3rd/cityselect/css/select2.css" rel="stylesheet"/>
<link href="${path}/js/3rd/kindeditor/themes/default/default.css" rel="stylesheet"/>
<div class="top">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">评审方案管理</a></li>
            <li><a href="#">评审方案管理</a></li>
        </ul>
    </div>
    <%@include file="../top.jsp" %>
</div>

<div class="formbody">

    <div class="formtitle"><span>编辑评审方案</span></div>

    <ul class="forminfo short validationEngineContainer">
        <input name="toursId" type="hidden" value="${tours.id}"/>

        <li class="line"><label>产品名称</label><input name="title" type="text" class="long-input validate[required]"
                                                   value="${tours.title}"/></li>
        <li class="line"><label>产品副标题</label><input name="secondTitle" type="text" class="long-input"
                                                    value="${tours.secondTitle}"/></li>
        <li class="line"><label>出发地</label>

            <div class="vocation">
                <select class="loc_province" name="fromProvince" style="width:120px;">
                </select>
                <select class="loc_city" name="fromCity" style="width:120px; margin-left: 10px">
                </select>
                <select class="loc_town" name="fromTown" style="width:120px;margin-left: 10px">
                </select>
            </div>
        </li>
        <li class="line"><label>目的地</label>

            <div class="vocation">
                <select class="loc_province" name="toProvince" style="width:120px;">
                </select>
                <select class="loc_city" name="toCity" style="width:120px; margin-left: 10px">
                </select>
                <select class="loc_town" name="toTown" style="width:120px;margin-left: 10px">
                </select>
            </div>
        </li>
        <li class="line"><label>缩略图片</label>
            <input name="pic" type="hidden" class="short-input validate[required]" value="${tours.pic}"/>

            <div class="upload-img" id="upload-img-pic"><img
                    src="${tours.pic == null?'../images/upload-image.png':tours.pic}" class=""/></div>
        </li>
        <li><label>价格</label><input name="minPrice" type="text" class="short-input validate[required,custom[number]]"
                                    value="${tours.minPrice}"/>&nbsp;元
        </li>
        <li><label>市场价</label><input name="otherPrice" type="text" class="short-input validate[required,custom[number]]"
                                     value="${tours.otherPrice}"/>&nbsp;元
        </li>
        <li><label>行程天数</label><input name="days" type="text" class="short-input validate[required,custom[number]]t"
                                      value="${tours.days}"/>&nbsp;天
        </li>
        <li><label>线路类型</label>

            <div class="vocation">
                <select name="type" class="useselect validate[required]">
                    <c:forEach var="t" items="${TOURS_TYPE}">
                        <option value="${t.value}"
                                <c:if test="${t.value == tours.type}">selected</c:if> >${t.name}</option>
                    </c:forEach>
                </select>
            </div>
        </li>
        <c:forEach var="i" items="${toursDayPrices}">
            <li class="line _dayPrice">
            <label>团期价格</label>
            <input name="startTime" type="text" class="short-input Wdate"
                   value="${i.startTime}" onfocus="WdatePicker({minDate:'%y-%M-%d'})"/>&emsp;~&emsp;
            <input name="endTime" type="text" class="short-input Wdate"
                   value="${i.endTime}" onfocus="WdatePicker({minDate:'%y-%M-%d'})"/>
            <%--&emsp;价格--%>
            <%--<input name="dayPrice" type="text" class="short-input" value="${i.price}"/>&nbsp;元&emsp;--%>
            <a href="javascript:;" class="tablelink _delDayPriceBtn">删除</a>
            <c:forEach var="i" items="${toursPreferentialPeople}">
                <li class="line _toursPP" style="margin-left:100px;">
                    <label>人群定价</label>

                    <div class="vocation">
                        <select name="preferentialPeoples" class="useselect validate[required]">
                            <c:forEach var="t" items="${preferentialPeoples}">
                                <option value="${t.id}"
                                        <c:if test="${i.preferentialPeopleId == t.id}">selected</c:if>>${t.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    &emsp;价格
                    <input name="ppPrice" type="text" class="short-input" value="${i.price}"/>&nbsp;元&emsp;
                    <a href="javascript:;" class="tablelink _delToursPPBtn">删除</a>
                </li>
            </c:forEach>
            <li class="line" style="margin-left:100px;">
                <label>&nbsp;</label>
                <label><a href="javascript:;" class="tablelink _addToursPPBtn">添加优惠人群</a></label>
            </li>
            </li>
        </c:forEach>
        <li class="line">
            <label>&nbsp;</label>
            <label><a href="javascript:;" class="tablelink _addDayPriceBtn">添加团期价格</a></label>
        </li>
        <%--&lt;%&ndash;优惠人群价格&ndash;%&gt;--%>
        <%--<c:forEach var="i" items="${toursPreferentialPeople}">--%>
        <%--<li class="line _toursPP">--%>
        <%--<label>优惠人群</label>--%>

        <%--<div class="vocation">--%>
        <%--<select name="preferentialPeoples" class="useselect validate[required]">--%>
        <%--<c:forEach var="t" items="${preferentialPeoples}">--%>
        <%--<option value="${t.id}"--%>
        <%--<c:if test="${i.preferentialPeopleId == t.id}">selected</c:if>>${t.name}</option>--%>
        <%--</c:forEach>--%>
        <%--</select>--%>
        <%--</div>--%>
        <%--&emsp;价格--%>
        <%--<input name="ppPrice" type="text" class="short-input" value="${i.price}"/>&nbsp;元&emsp;--%>
        <%--<a href="javascript:;" class="tablelink _delToursPPBtn">删除</a>--%>
        <%--</li>--%>
        <%--</c:forEach>--%>
        <%--<li class="line">--%>
        <%--<label>&nbsp;</label>--%>
        <%--<label><a href="javascript:;" class="tablelink _addToursPPBtn">添加优惠人群</a></label>--%>
        <%--</li>--%>
        <li class="line">
            <label>产品特色</label>
            <textarea style="width:80%;height:300px" name="characteristic" id="characteristic"
                      class="ke">${toursDescription.characteristic}</textarea>
        </li>
        <li class="line">
            <label>行程描述</label>
            <textarea style="width:80%;height:300px" name="tripDescription"
                      class="ke">${toursDescription.tripDescription}</textarea>
        </li>
        <li class="line">
            <label>费用须知</label>
            <textarea style="width:80%;height:300px" name="feeDescription"
                      class="ke">${toursDescription.feeDescription}</textarea>
        </li>
        <li class="line">
            <label>预定须知</label>
            <textarea style="width:80%;height:300px" name="reserveDescription"
                      class="ke">${toursDescription.reserveDescription}</textarea>
        </li>
        <c:forEach var="i" items="${toursPlans}">
            <li class="line _toursPlan">
                <label>行程安排</label>

                <div style="float:left;width:80%">
                    <input name="toursPlanTitle" type="text" class="long-input" value="${i.title}"/><br/><br/>
                    <textarea style="width:100%;height:300px" name="toursPlanContent"
                              class="ke">${i.content}</textarea><br/>
                    <a href="javascript:;" class="tablelink _delPlanBtn">删除</a>
                </div>
            </li>
        </c:forEach>
        <li class="line">
            <label>&nbsp;</label>
            <label><a href="javascript:;" class="tablelink _addPlanBtn">添加行程安排</a></label>
        </li>
        <li class="line _require">
            <label>必签合同</label>

            <div style="float:left;width:80%;line-height:34px;">
                <c:forEach var="i" items="${toursContracts}">
                    <c:if test="${TOURSCONTRACT_TYPE_REQUIRE == i.type}">
                        <i><input name="contractId" type="hidden" value="${i.id}"/>${i.name}&emsp;<a
                                href="javascript:;" class="tablelink _delContractBtn">删除</a><br/></i>
                    </c:if>
                </c:forEach>
                <label><a href="javascript:;" class="tablelink _addContractBtn">关联必签合同</a></label><br/>
            </div>
        </li>
        <li class="line _option">
            <label>可选合同</label>

            <div style="float:left;width:80%;line-height:34px;">
                <c:forEach var="i" items="${toursContracts}">
                    <c:if test="${TOURSCONTRACT_TYPE_OPTION == i.type}">
                        <i><input name="contractId" type="hidden" value="${i.id}"/>${i.name}&emsp;<a
                                href="javascript:;" class="tablelink _delContractBtn">删除</a><br/></i>
                    </c:if>
                </c:forEach>
                <label><a href="javascript:;" class="tablelink _addContractBtn">关联可选合同</a></label><br/>
            </div>
        </li>
        <li><label>&nbsp;</label><input type="button" class="btn saveBtn" value="确认保存"/></li>
        <c:if test="${user.type == PASSPORTTYPE_ADMIN}">
            <li>
                <label>&nbsp;</label>
                <input name="" type="button" class="btn _reviewBtn" value="审核"/>
            </li>
        </c:if>
    </ul>
</div>
<%--section toursPreferendialPeople--%>
<li class="line _toursPP" style="display:none;margin-left:100px;" id="toursPP">
    <label>人群定价</label>

    <div class="vocation">
        <select name="preferentialPeoples" class="useselect validate[required]">
            <c:forEach var="t" items="${preferentialPeoples}">
                <option value="${t.id}">${t.name}</option>
            </c:forEach>
        </select>
    </div>
    <input name="ppPrice" type="text" class="short-input" value="${i.price}"/>&nbsp;元&emsp;
    <a href="javascript:;" class="tablelink _delToursPPBtn">删除</a>
</li>
<%--section dayprice--%>
<li class="line _dayPrice" style="display:none" id="dayPriceSection">
    <label>团期价格</label>
    <input name="startTime" type="text" class="short-input Wdate"
           value="" onfocus="WdatePicker({minDate:'%y-%M-%d'})"/>&emsp;~&emsp;
    <input name="endTime" type="text" class="short-input Wdate"
           value="" onfocus="WdatePicker({minDate:'%y-%M-%d'})"/>
    <%--&emsp;价格--%>
    <%--<input name="dayPrice" type="text" class="short-input" value=""/>&nbsp;元&emsp;--%>
    <a href="javascript:;" class="tablelink _delDayPriceBtn">删除</a>
<%--<li class="line" style="margin-left:100px;">--%>
    <%--<label>&nbsp;</label>--%>
    <%--<label><a href="javascript:;" class="tablelink _addToursPPBtn">添加优惠人群</a></label>--%>
<%--</li>--%>
</li>
<%--section plan--%>
<li class="line _toursPlan" style="display:none" id="planSection">
    <label>行程安排</label>

    <div style="float:left;width:80%">
        <input name="toursPlanTitle" type="text" class="long-input" value="${i.title}"/><br/><br/>
        <textarea style="width:100%;height:300px" name="toursPlanContent"
                  class="ke-async">${i.toursPlan}</textarea><br/>
        <a href="javascript:;" class="tablelink _delPlanBtn">删除</a>
    </div>
</li>
<%--contract--%>
<div class="zxxbox_list" id="contractBox">
    <ul class="list"></ul>
    <ul class="button">
        <li>
            <input name="" type="button" class="btn _doAddContractBtn" value="确定"/>
        </li>
    </ul>
</div>
<ul class="forminfo zxxbox_contaner" id="reviewBox" style="width:450px">
    <input type="hidden" name="reviewId" value="" id="reviewId">
    <li style="width: 100%;text-align: center">
        <input name="" type="button" class="btn _cashSuccess" value="审核通过"/>
        <input name="" type="button" class="btn _cashFail" value="审核拒绝"/>
        <input name="" type="button" class="btn btn-cancel _cancelBtn" value="取消"/>
    </li>
</ul>
<%@include file="../footer.jsp" %>
<script type="text/javascript" src="${path}/js/3rd/cityselect/js/area.js"></script>
<script type="text/javascript" src="${path}/js/3rd/cityselect/js/location.js"></script>
<script type="text/javascript" src="${path}/js/3rd/cityselect/js/select2.js"></script>
<script type="text/javascript" src="${path}/js/3rd/cityselect/js/select2_locale_zh-CN.js"></script>
<script type="text/javascript" src="${path}/js/3rd/kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript" src="${path}/js/3rd/kindeditor/lang/zh_CN.js"></script>

<script>
    $(function () {
        //init
        var fromCityCodes = '${tours.fromCityCode}'.split(',');
        var toCityCodes = '${tours.toCityCode}'.split(',');
        $('select[name="fromProvince"]').val(fromCityCodes[0]).trigger('change');
        $('select[name="fromCity"]').val(fromCityCodes[1]).trigger('change');
        $('select[name="fromTown"]').val(fromCityCodes[2]).trigger('change');
        $('select[name="toProvince"]').val(toCityCodes[0]).trigger('change');
        $('select[name="toCity"]').val(toCityCodes[1]).trigger('change');
        $('select[name="toTown"]').val(toCityCodes[2]).trigger('change');
        //
        KindEditor.create('.ke');
        //
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
            $('input[name="pic"]').val(data.result.path);
            $('#upload-img-pic').find('img').prop('src', data.result.path);
        });
        upload.on('uploadError', function (file) {
            $.zxxbox.remind("上传出错", null, {delay: 2000});
        });
        //
        var dayPriceSection = $('#dayPriceSection');
        $('.forminfo').on('click', '._delDayPriceBtn', function () {
            $(this).parents('li').remove();
        });
        $('._addDayPriceBtn').on('click', function () {
            var html = dayPriceSection.prop("outerHTML");
            var htmldom = $(html);
            htmldom.insertBefore($(this).parents('li')).show();
        });
        //优惠人群
        var toursPPSection = $('#toursPP');
        $('.forminfo').on('click', '._delToursPPBtn', function () {
            $(this).parents('li').remove();
        });
        $('._addToursPPBtn').on('click', function () {
            var html = toursPPSection.prop("outerHTML");
            var htmldom = $(html);
            htmldom.insertBefore($(this).parents('li')).show();
        });
        //
        var planSection = $('#planSection');
        $('.forminfo').on('click', '._delPlanBtn', function () {
            $(this).parents('li').remove();
        });
        $('._addPlanBtn').on('click', function () {
            var html = planSection.prop("outerHTML");
            var htmldom = $(html);
            htmldom.insertBefore($(this).parents('li')).show();
            KindEditor.create(htmldom.find('.ke-async'));
        });
        //contract
        $('.forminfo').on('click', '._delContractBtn', function () {
            $(this).parents('i').remove();
        });
        $('#contractBox .list').on('click', 'input', function (event) {
            event.stopPropagation();
        })
        $('#contractBox .list').on('click', 'li', function () {
            var select = $(this).find('input');
            if (select.is(':checked')) {
                select.prop('checked', false);
            } else {
                select.prop('checked', true);
            }
            return true;
        });
        var that = null;
        $('._addContractBtn').on('click', function () {
            that = $(this).parents('li');
            console.log(that.find('input[name="contractId"]'));
            var html = '';
            $('#contractBox .list').empty();
            var contracts = [];
            that.find('input[name="contractId"]').each(function (i, input) {
                contracts.push($(input).val());
            });
            $K.http('${path}/contract/getTravelAgencyContracts.htm', {}, function (r) {
                $.zxxbox($('#contractBox'), {
                    title: '线路合同'
                });
                $.each(r.result.list, function (i, s) {
                    html += '<li>' +
                            '<input type="checkbox" name="contract" value=\'' + JSON.stringify(s) + '\' ' + (contracts.includes(s.id) ? 'checked' : '') + '/>' +
                            '<label>' + s.name + '</label>' +
                            '</li>';
                });
                $('#contractBox .list').html(html);
            });
        });
        $('._doAddContractBtn').on('click', function () {
            that.find('input[name="contractId"]').parents('i').remove();
            $.each($('input[name="contract"]:checked'), function (i, s) {
                var json = JSON.parse($(s).val());
                that.find('._addContractBtn').parents('label').before('<i><input name="contractId" type="hidden" value="' + json.id + '"/>' + json.name + '&emsp;<a href="javascript:;" class="tablelink _delContractBtn">删除</a><br/></i>');
            });
            $.zxxbox.hide();
        });
        //
        $('._reviewBtn').on('click', function () {
            var id = $(this).parents('tr').attr('data');
            $.trim($('input[name="reviewId"]').val(id))
            $.zxxbox($('#reviewBox'), {
                title: '审核'
            });
        });
        // toggle
        $('._cashSuccess').on('click', function () {
            status = ${TOURS_AUTH_STATUS_REVIEW.value}
                    $.zxxbox.ask('确认更改状态?', function () {
                        $K.http('toggleAuthStatus.htm', {
                            id: $.trim($('input[name="toursId"]').val()),
                            status: status
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
        $('._cashFail').on('click', function () {
            status = ${TOURS_AUTH_STATUS_REFUSE.value}
                    $.zxxbox.ask('确认更改状态?', function () {
                        $K.http('toggleAuthStatus.htm', {
                            id: $.trim($('input[name="toursId"]').val()),
                            status: status
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
        //取消
        $("._cancelBtn").click(function () {
            $.zxxbox.hide();
        });
        //
        $('.saveBtn').ajaxbtn('doAddOrModifyToursInfo.htm', function () {
            var data = $(".forminfo").serialize();
            delete data.toursPlanTitle;
            delete data.toursPlanContent;
            delete data.startTime;
            delete data.endTime;
            delete data.dayPrice;
            delete data.preferentialPeoples;
            delete data.ppPrice;
            //
            data.fromCity = $('select[name="fromCity"]').select2('data').text
            data.toCity = $('select[name="toCity"]').select2('data').text
            data.fromCityCode = $('select[name="fromProvince"]').val() + ',' + $('select[name="fromCity"]').val() + ',' + $('select[name="fromTown"]').val()
            data.toCityCode = $('select[name="toProvince"]').val() + ',' + $('select[name="toCity"]').val() + ',' + $('select[name="toTown"]').val()
            //toursplan
            var toursPlans = [];
            $('.forminfo ._toursPlan').each(function (i, li) {
                var title = $(li).find('input[name="toursPlanTitle"]').val();
                var content = $(li).find('textarea[name="toursPlanContent"]').val();
                toursPlans.push({
                    title: title,
                    content: content
                });
            });
            //优惠人
            var toursPP = [];
            $('.forminfo ._toursPP').each(function (i, li) {
                var preferentialPeoples = $(li).find('select[name="preferentialPeoples"]').val();
                var ppPrice = $(li).find('input[name="ppPrice"]').val();
                toursPP.push({
                    preferentialPeopleId: preferentialPeoples,
                    price: ppPrice
                });
            });
            //dayprice
            var dayPrices = [];
            $('.forminfo ._dayPrice').each(function (i, li) {
                var startTime = $(li).find('input[name="startTime"]').val();
                var endTime = $(li).find('input[name="endTime"]').val();
                var dayPrice = $(li).find('input[name="dayPrice"]').val();
                dayPrices.push({
                    startTime: startTime,
                    endTime: endTime,
                    price: dayPrice
                });
            });
            //contract
            var contractsRequire = [];
            $('._require').find('input[name="contractId"]').each(function (i, input) {
                contractsRequire.push($(input).val());
            });
            var contractsOption = [];
            $('._option').find('input[name="contractId"]').each(function (i, input) {
                contractsOption.push($(input).val());
            });
            data.toursPlan = JSON.stringify(toursPlans);
            data.toursDayPrice = JSON.stringify(dayPrices);
            data.toursPreferentialPeople = JSON.stringify(toursPP);
            data.requireContractIds = contractsRequire.join(',');
            data.optionContractIds = contractsOption.join(',');
            return data;
        }, function () {
            KindEditor.sync('.ke,.ke-async');
            return $('.forminfo').validationEngine('validate');
        });
    });
</script>
