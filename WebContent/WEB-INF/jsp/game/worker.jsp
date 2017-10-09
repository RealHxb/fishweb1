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
            <h2>${game.name}</h2>         
    </div>
    <table style="width: 100%;margin-top: 20px; " class="table table-striped " borderColor=#000000 cellSpacing=0 cellPadding=2 border=3>
        <tr align="center" >
         	<th>序号</th>
            <th>编号</th>
            <th>姓名</th>
			<th>身份</th>
            <th>电话</th>
 
        </tr>
        <c:forEach var="item" items="${persons}" varStatus="status">
            <tr align="center" >
             	<td id="n_${item.id}">${status.count}</td>
             	<td id="n_${item.id}">${item.number}</td>
                <td id="n_${item.id}">${item.name}</td>
               
                <td>
                <c:if test="${item.type==1}">组委会主席</c:if>
                <c:if test="${item.type==2}">主任仲裁员</c:if>
                <c:if test="${item.type==3}">总裁判长</c:if>
                <c:if test="${item.type==4}">副总裁判长</c:if>
                <c:if test="${item.type==5}">成统裁判长</c:if>
                <c:if test="${item.type==6}">成统裁判员</c:if>
                <c:if test="${item.type==7}">分区裁判长</c:if>
                <c:if test="${item.type==8}">分区裁判员</c:if>
                <c:if test="${item.type==9}">助理裁判员</c:if>
            	</td> 
            	<td id="n_${item.id}">${item.phone}</td>
            
                           
            </tr>
        </c:forEach>

    </table>
</div>


</body>
</html>
