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
    <title></title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/jquery.qrcode.js"></script>
    <script src="/static/js/qrcode.js"></script>

</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>

<div class="container"  align="center">
    <div class="row"  style="margin-top: 60%;width: 200px;">

        <div  align="center" style="font-family: 黑体;font-weight: bold;width: 200px;">
            <h4>编号：${obj.number}</h4>
            <h4>姓名：${obj.name}</h4>
        </div>
        <div  style="margin-top: 10px;">
            <div id="erweima"></div>
        </div>

    </div>
</div>
</body>
</html>
<script>

    (function($){
        jQuery('#erweima').qrcode({
            text : "${obj.id}",
            width:120,
            height:120
        });
        window.print();
    })(jQuery);
</script>