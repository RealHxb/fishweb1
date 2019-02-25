<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>手动抽签录入</title>
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
	width: 80px;
}
.green{
	color: #a94442;
	font-weight: bold;
}
</style>
<input type="hidden" value="${game.id}"  id="gameid"/>
<div id="sysTableId" class="container"  align="center">
    <div id="divTitleName"  align="center" style="font-family: 黑体;font-weight: bold;">
	    <h2>
	         ${game.name}抽签录入
	    </h2>
    </div>
    <div>
		<c:forEach var="item1" varStatus="status1" begin="1" end="${game.chang}">
	     <button class="changBtn btn btn-info" data-value="${status1.index}">第${status1.index}场</button>&nbsp; &nbsp;&nbsp;
	    </c:forEach>	    
    </div>
    <div id="itemDiv">
	    <table id="itemTab" style="margin-top: 10px; " class="table table-striped " borderColor=#000000 cellSpacing=0 cellPadding=2 border=1 >
	        <tr align="center" >
	            <th>编号</th>
	            <th>姓名</th>
	            <th>区</th>
	            <th>号</th>
	            <th>操作</th>
	        </tr>
	    </table>
	   <!--   <button type="button" class="btn btn-success" onclick="saveAll()">全部确认</button>-->
    </div>
</div>
</body>
</html>
<script type="text/javascript">
	$("#itemTab").delegate("button", "click", function(){
		var personid = $(this).attr("id");
		var itr = $(this).parent().parent();
		var chang = itr.attr("data-chang");
		var qu = itr.find(".iqu").val();
		var room = itr.find(".iroom").val();
		//console.log("id:"+personid+"-qu:"+qu+"-room:"+room);
		if (qu && room){ 
			tools.action("/grade/savechouqian",{"chang":chang,"qu":qu,"room":room,"personId":personid},function(data){
				tools.tip(data, {1: "操作失败！"});
		        if(data.success){
		        	$(itr).addClass("green");
		        }
		    });
		}else{
			alert("该记录区、号输入不全，无法提交！");
		}

	});
	$(".changBtn").click(function(){
		$(".btn-default").toggleClass("btn-info");
		$(".btn-default").toggleClass("btn-default");
		$(this).removeClass("btn-info");
		$(this).addClass("btn-default");
		var chang = $(this).attr("data-value");
		//异步获取每场抽签情况
		tools.action("/grade/chouqianList",{"chang":chang},function(result){
			var datas = result.data;
	        //console.log(datas);
	        var table = $("#itemTab");
	        $("tr").remove(".itr");
	        for(var i = 0;i<datas.length;i++){
	        	table.append("<tr class='itr' data-chang='"+chang+"' align='center'><td>"+datas[i].personNumber+"</td><td>"+datas[i].personName+"</td><td><input  class='iqu' type='number' value='"+datas[i].qu+"'/></td><td> <input  class='iroom' type='number' value='"+datas[i].room+"'/></td><td><button class='ibtn btn btn-success' id=\'"+datas[i].personId+"\'>确认</button></td></tr>");
	        }
	    });
	});
</script>