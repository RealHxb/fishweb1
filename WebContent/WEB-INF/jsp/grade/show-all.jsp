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

<div id="sysTableId" class="container"  align="center">
    <div id="divTitleName"  align="center" style="font-family: 黑体;font-weight: bold;">
	    <h2>
	         ${game.name}总成绩
	    </h2>
    </div>
    
    <table style="margin-top: 10px; " class="table table-striped " borderColor=#000000 cellSpacing=0 cellPadding=2 border=1 >
        <tr align="center" >
            <th>序号</th>
            <th>编号</th>
            <th>姓名</th>
            <c:forEach var="item1" varStatus="status1" begin="1" end="${game.chang}">
                <th>第${status1.index}场</th>
            </c:forEach>
            <th>罚分</th>
            <th>得分</th>
            <th>名次</th>
        </tr>
        <c:forEach var="item" items="${grades}" varStatus="status">
            <tr align="center" >
            	<td style="width:50px" >${status.count}</td>
                <td style="width:60px" >${item.personNumber}</td>
                <td style="width:100px" >${item.personName}</td>
                <c:forEach var="item2" items="${item.child}" varStatus="status2">
                    <td style="width:80px" >${item2.grade==0?"":item2.grade}</td>
                </c:forEach>
                <td style="width:60px" >${item.ranking==0?"":item.ranking}</td>
                <td style="width:60px" >${item.defen==0?"":item.defen}</td>
                <td style="width:100px"  >第${status.count}名</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
<script type="text/javascript">

</script>