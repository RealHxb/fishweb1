<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>总成绩修改</title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
	<script src="/static/js/tools.js"></script>

</head>
<body style="background-color: #95ABF7;">
<jsp:include page="../navbar.jsp"></jsp:include>
<style type="text/css">
input{
	width: 40px;
}
</style>
<input type="hidden" value="${game.id}"  id="gameid"/>
<div id="sysTableId" class="container"  align="center">
    <div id="divTitleName"  align="center" style="font-family: 黑体;font-weight: bold;">
	    <h2>
	         ${game.name}总成绩
	    </h2>
    </div>
    <form id="finalForm">
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
	            <tr align="center" class ="record">
	            	<td style="width:50px" >${status.count}</td>
	                <td style="width:60px" >
	                	<input type="text" name="personNumber" disabled value="${item.personNumber}" />
	                </td>
	                <td style="width:100px">
	                	<input type="text" style="width: 60px" name="personName" disabled value="${item.personName}" />
	                </td>
	                <c:forEach var="item2" items="${item.child}" varStatus="status2">
	                    <td style="width:80px" >
	                    	<input type="text" class="fenshu" name="g${status2.count}" value="${item2.grade==0 ? '':item2.grade}" />
	                    </td>
	                </c:forEach>
	                <td style="width:60px">
	                	<input type="text" class="fenshu" name="ranking" disabled value="${item.ranking==0 ? '':item.ranking}" />
	                </td>
	                <td style="width:60px">
	                	<input type="text" style="width: 60px" name="defen" class="defen" disabled value="${item.defen==0?"":item.defen}" />
	                </td>
	                <td style="width:100px"  >第${status.count}名</td>
	            </tr>	
	        </c:forEach>
	
	    </table>
	    <button type="button" class="btn btn-success" onclick="save()">确认修改</button>
    </form>
</div>
</body>
</html>
<script type="text/javascript">
	$(".fenshu").change(function(){
		var thisfenshu = $(this).val();
		if(isNaN(thisfenshu)){
			alert("请填入数字");
			return;
		}
		var fenshu= Number(0);
		$(this).parent().parent().find(".fenshu").each(function(){
			fenshu = Number($(this).val()) +fenshu;
		})
		$(this).parent().parent().find(".defen").val(fenshu);
	});
function save() {
    var param =[];	
	$(".record").each(function(){
		var personNumber = $(this).find("input[name='personNumber']").val();
		var personName = $(this).find("input[name='personName']").val();
		var ranking = $(this).find("input[name='ranking']").val();
		var defen = $(this).find("input[name='defen']").val();
		var g1 = $(this).find("input[name='g1']").val();
		var g2 = $(this).find("input[name='g2']").val();
		var g3 = $(this).find("input[name='g3']").val();
		var g4 = $(this).find("input[name='g4']").val();
		var g5 = $(this).find("input[name='g5']").val();
		var g6 = $(this).find("input[name='g6']").val();
		var g7 = $(this).find("input[name='g7']").val();
		var g8 = $(this).find("input[name='g8']").val();
		var record={"personNumber":personNumber,"personName": personName,"ranking": ranking,
				"defen":defen,"g1":g1,"g2":g2,"g3":g3,"g4":g4,
				"g5":g5,"g6":g6,"g7":g7,"g8":g8};
		param.push(record);
	})
	var b =JSON.stringify(param);
	tools.action("/grade/finalSave", b, function (data) {
		tools.tip(data, {1: "操作失败！"});
        if(data.success){
        		var gameid = $("#gameid").val();
                location.href="/grade/show/"+gameid;
        }
    });
}
</script>