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
    <title>成绩打印</title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/datatables.min.js"></script>
    <script src="/static/js/tools.js"></script>

</head>
<body style="background-color: #95ABF7;">
<jsp:include page="../navbar.jsp"></jsp:include>

<div id="sysTableId" class="container"  align="center" >
    <div id="divTitleName"  align="center" style="font-family: 黑体;font-weight: bold;">
	   <h3>
         ${game.name}---第 ${chang} 场 
         <c:if test="${qu != null}"> ,第 ${qu} 区 </c:if>
		</h3>
    </div>

     <table style="width: 85%;margin-top: 30px;border-color: #0c0c0c;" class="table table-striped " borderColor=#000000 cellSpacing=0 cellPadding=2 border=3>
        <tr align="center" >
            <th>序号</th>
            <th>编号</th>
            <th>姓名</th>
            <!-- <th>场次</th>
			<th>区域</th>  -->
            <th>钓位</th>
            <th>尾数</th>
            <th>重量</th> 
            <th>罚分</th>
            <th>操作</th>
            
        </tr>
        <c:forEach var="item" items="${grades}" varStatus="status">
            <tr align="center" >
              	<td>${status.count}</td>
                <td>${item.personNumber}</td>
                <td>${item.personName}</td>  
                <!-- <td>${item.chang}</td>     
                <td>${item.qu}</td> -->              
                <td>${item.room}</td>                
                <td><input id ="n${item.id}" type="text" name="number" value="${item.number==0?"":item.number}" style="width:60px;"> </td>
                <td><input id ="w${item.id}" type="text" name="weight" value="${item.weight==0?"":item.weight}" style="width:60px;"> </td>                
                <!-- <td>${item.number==0?"":item.number}</td> -->
                <!-- <td>${item.weight==0?"":item.weight}</td> -->
                <td><input id ="f${item.id}" type="text" name="ranking" value="${item.ranking==0?"":item.ranking}" style="width:60px;"> </td>
                <td>
	               <a href="javascript:void(0);" onclick="del('${item.id}')">删除</a>|
	               <a style="font-weight: bold;" href="javascript:void(0);" onclick="update('${item.id}')">修改</a>
	            </td>
            </tr>
        </c:forEach>

    </table> 
    
</div>
 
</body>
</html>
<script>
  //删除赛事管理人员
    function del(id){
        if(!confirm("确定删除成绩吗？")){
            return;
        }
        tools.action("/grade/delete",{"id":id},function(data){
            tools.tip(data,{1:"操作失败！"});
            location.reload();
        });
    }
 //修改赛事管理人员
    function update(id){
    	
    	var vnumber = $("#n"+id).val();
    	var vweight = $("#w"+id).val();    	
    	var vranking = $("#f"+id).val();    	
       	if (!vnumber){ vnumber = 0}
       	if (!vweight){ vweight = 0}
    	if (!vranking){ vranking = 0}
        tools.action("/grade/update",{"id":id,"number":vnumber,"weight":vweight,"ranking":vranking},function(data){
            tools.tip(data,{1:"操作失败！"});
            location.reload();
        });
    }
</script> 