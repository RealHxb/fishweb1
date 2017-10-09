<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>工作人员查询</title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/jquery.qrcode.js"></script>
    <script src="/static/js/qrcode.js"></script>
    <script src="/static/js/LodopFuncs.js"></script>   

</head>
<body style="background-color: #95ABF7;">
<jsp:include page="../navbar.jsp"></jsp:include>

 
<div id="sysTableId" class="container"   style="margin-top: 80px;">
		<div id="divTitleName"  align="center" style="font-family: 黑体;font-weight: bold;">
	            <h2>${game.name}---人员名单</h2>         
	    </div>
	    <table style="width: 100%;" class="table table-striped " borderColor=#000000 cellSpacing=0 cellPadding=2 border=3>
	        <tr align="center" >
	            <th>序号</th>
	            <th>编号</th>
	            <th>姓名</th>
	            <th>电话</th>
	<%--            <th>地址</th>
	            <th>报名费</th>
	            <th>队伍</th>
	            <th>备注</th>--%>
	            <th>备注</th>
	        </tr>
	        <c:forEach var="item" items="${persons}" varStatus="status">
	            <tr align="center" >
	            	<td>${status.count}</td>
	                <td>${item.number}</td>
	                <td>${item.name}</td>
	                <td>${item.phone}</td>
				<%--<td>${item.address}</td>
	                <td>${item.price}</td>
	                <td>${item.group}</td>
	                <td>${item.intro}</td>
	                <td>
	                    <a href="javascript:void(0);" onclick="del('${item.id}')">删除</a>
	                    <a href="/person/print/${item.id}"  target="_blank">查看/打印</a>
	                </td>
	                --%>
	                 <td style="width:30%" > </td>
	            </tr>
	        </c:forEach>
	
	    </table>
	</div>
	

</body>
</html>
