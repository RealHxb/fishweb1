<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成绩打印</title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>


</head>
<body style="background-color: #95ABF7;">
<jsp:include page="../navbar.jsp"></jsp:include>

<div id="sysTableId" class="container"  align="center" >
    <div id="divTitleName"  align="center" style="font-family: 黑体;font-weight: bold;">
	    <h2>
	        ${game.name}---第 ${chang} 场 <c:if test="${qu != null}"> ，第 ${qu} 区  </c:if>
	    </h2>
    </div>

    <table style="margin-top: 10px;width: 85%" class="table table-striped " borderColor=#000000 cellSpacing=0 cellPadding=2 border=1>
        <tr align="center" >
            <th>序号</th>
            <th>编号</th>
            <th>姓名</th>
            <th>尾数</th>
            <th>重量</th>
            <th>计分</th>
            <th>罚分</th>
            <th>得分</th>
            <th>名次</th>
        </tr>
        <c:forEach var="item" items="${grades}" varStatus="status">
            <tr align="center" >
            	<td>${status.count}</td>
                <td>${item.personNumber}</td>
                <td>${item.personName}</td>
                <td>${item.number==0?"":item.number}</td>
                <td>${item.weight==0?"":item.weight}</td>
                <td>${item.grade}</td>
                <td>${item.ranking==0?"":item.ranking}</td>
                <td>${item.grade+item.ranking}</td>
                <td>第${status.count}名</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
<script>

</script>