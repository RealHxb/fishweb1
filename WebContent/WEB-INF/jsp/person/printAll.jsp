
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

<div class="container"  align="left" 	id="sysTableId">
       <table id="t1" class="table table-striped " style="width: 150px;float: left; " borderColor=#000000 cellSpacing=0 cellPadding=2 border=1>
	        <tr align="center" >
	            <th width="30px">编号</th>
	            <th width="50px">姓名</th>
	           <!--  <th width="160px">队名</th> -->
	        </tr>
	        <c:forEach var="item" items="${persons3}" varStatus="status">
	            <tr align="center" >
	                <td>${item.number}</td>
	                <td>${item.name}</td>
	               <!--   <td>${item.group}</td>-->
	            </tr>
	        </c:forEach>
	    </table>
	    <table id="t2" class="table table-striped " style="width: 150px;float: left ;margin-left: 15px" borderColor=#000000 cellSpacing=0 cellPadding=2 border=1>
	        <tr align="center" >
	            <th width="30px">编号</th>
	            <th width="50px">姓名</th>
	            <!--<th width="165px">队名</th>-->
	        </tr>
	        <c:forEach var="item" items="${persons2}" varStatus="status">
	            <tr align="center" >
	                <td>${item.number}</td>
	                <td>${item.name}</td>
	               <!--   <td>${item.group}</td>-->
	            </tr>
	        </c:forEach>
	    </table>
	    <table id="t3" class="table table-striped " style="width: 150px;float: left ;margin-left: 15px" borderColor=#000000 cellSpacing=0 cellPadding=2 border=1>
	        <tr align="center" >
	            <th width="30px">编号</th>
	            <th width="50px">姓名</th>
	            <!--<th width="165px">队名</th>-->
	        </tr>
	        <c:forEach var="item" items="${persons1}" varStatus="status">
	            <tr align="center" >
	                <td>${item.number}</td>
	                <td>${item.name}</td>
	               <!--   <td>${item.group}</td>-->
	            </tr>
	        </c:forEach>
	    </table>
</div>
</body>
</html>
<script>
    (function($){
    	 window.print();
    	//PrintTable();
    })(jQuery);
</script>