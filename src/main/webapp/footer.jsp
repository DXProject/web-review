</body>
</html>
<script type="text/javascript" src="${path}/js/jquery/jquery.1.11.2.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.zxxbox.3.0.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.jp.ajaxbtn.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.jp.autocomplete.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery-ui.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.jp.serialize.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.lazyload.js"></script>
<script type="text/javascript" src="${path}/js/3rd/validate/jquery.validationEngine.js"></script>
<script type="text/javascript" src="${path}/js/3rd/validate/jquery.validationEngine-zh_CN.js"></script>
<script type="text/javascript" src="${path}/js/3rd/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${path}/js/3rd/webuploader/webuploader.min.js"></script>
<script type="text/javascript" src="${path}/js/3rd/jstree/jstree.min.js"></script>
<script type="text/javascript" src="${path}/js/3rd/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="${path}/js/3rd/select/select-ui.min.js"></script>
<script type="text/javascript" src="${path}/js/json2.js"></script>
<script type="text/javascript" src="${path}/js/kiss-web.1.0.js"></script>
<script type="text/javascript" src="${path}/js/bmap.js"></script>
<script type="text/javascript" src="${path}/js/jquery.menu.js"></script>
<script>
    $(function () {
        //
        <c:if test="${result!=null && result.code!=SUCCESS}">
        $.zxxbox.remind('${result.message}');
        </c:if>
        //select
        $(".seachform select").uedSelect({
            width: 150
        });
        $(".short select.useselect").uedSelect({
            width: 200
        });
        //back
        $('._back').on('click', function () {
            history.go(-1);
        });
        //odd
        $('.tablelist tbody tr:odd').addClass('odd');
        $('.imgtable tbody tr:odd').addClass('odd');
        $('.imgtable tbody tr:odd').addClass('odd');
        //fancybox
        $(".fancy-box").fancybox();
        //lazyload
        $("img.lazy").lazyload({effect: "fadeIn",placeholder : "${path}/images/grey.gif",threshold : 200});
        //default img
        $('img.use-default').each(function () {
            var that = this;
            this.error = function () {
                that.src = '${path}/images/default-image.png';
            }
        });
    })
</script>