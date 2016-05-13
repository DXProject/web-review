<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>基于Bootstrup 3可预览的HTML5文件上传插件</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${path}/uploadfiles/css/default.css">
    <link href="${path}/uploadfiles/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
    <!--[if IE]>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
    <![endif]-->
    <script src="${path}/uploadfiles/js/jquery.min.js"></script>
    <script src="${path}/uploadfiles/js/fileinput.js" type="text/javascript"></script>
    <script src="${path}/uploadfiles/js/fileinput_locale_zh.js" type="text/javascript"></script>
    <script src="${path}/uploadfiles/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container kv-main">

    <br>
    <form enctype="multipart/form-data">

        <div class="form-group">
            <input id="files" name="file" type="file" multiple class="file" data-overwrite-initial="false" data-min-file-count="2">
        </div>

    </form>
</div>
</body>
<script>

    $("#files").fileinput({
        uploadUrl: '${path}/common/file/upload.htm', // you must set a valid URL here else you will get an error
        allowedFileExtensions : ['gif','jpg','jpeg','bmp','png'],
        overwriteInitial: false,
        showUpload: true, //是否显示上传按钮
        enctype: 'multipart/form-data',
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function(filename) {
            return filename.replace('(', '_').replace(']', '_');
        },
        ajaxSettings: {
            //这里是重写文件上传成功后，前台处理后台返回json数据
            success: function(data)
            {
                console.log(data.result.path);
            }
        }
    });

</script>

</html>