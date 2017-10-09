<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2016/1/8 0008
  Time: 下午 18:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>下载比赛信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/jquery.qrcode.js"></script>
    <script src="/static/js/qrcode.js"></script>

</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>

<div class="container" style="margin-top: 80px;">

    <form class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">下载二维码</label>
            <div class="col-sm-10">
                <div id="erweima"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">比赛名称</label>
            <div class="col-sm-10">
                <p class="form-control-static">${game.name}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">主办方</label>
            <div class="col-sm-10">
                <p class="form-control-static">${game.zhu}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">承办方</label>
            <div class="col-sm-10">
                <p class="form-control-static">${game.cheng}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">场次</label>
            <div class="col-sm-10">
                <p class="form-control-static">${game.chang}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">钓区数量</label>
            <div class="col-sm-10">
                <p class="form-control-static">${game.qu}</p>
            </div>
        </div>


    </form>


</div>
</body>
</html>
<script>

    (function($){
        jQuery('#erweima').qrcode({
            text : "${game.id}",
            width:230,
            height:230
        });
        /*jQuery('#erweima-server').qrcode({
            text : "192.168.23.1",
            width:230,
            height:230
        });*/
    })(jQuery);
</script>