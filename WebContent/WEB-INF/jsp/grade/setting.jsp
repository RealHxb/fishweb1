<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2016/1/19 0019
  Time: 下午 14:26
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
    <title>人员设置</title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">
    <script src="/static/js/LodopFuncs.js"></script>   
    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/tools.js"></script>
</head>
<body style="background-color: #9DB6F7;">
<!-- #99CCCC #3399CC-->
<jsp:include page="../navbar.jsp"></jsp:include>
<div class="container" style="margin-top: 70px;">

    <form class="form-horizontal" id="personParam">
        <fieldset>
            <legend>参赛人员添加</legend>
        </fieldset>
        <div class="form-group">
            <label for="input1" class="col-sm-2 control-label">人员名称</label>
            <div class="col-sm-5">
                <input type="text" name="name" class="form-control" id="input1">
                <input type="hidden" name="type" value="20">
                <input type="hidden" name="gameId" value="${game.id}">
            </div>
        </div>

        <div class="form-group">
            <label for="input2" class="col-sm-2 control-label">联系电话</label>
            <div class="col-sm-5">
                <input type="text" name="phone" class="form-control" id="input2">
            </div>
        </div>

        <div class="form-group">
            <label for="input3" class="col-sm-2 control-label">地址</label>
            <div class="col-sm-5">
                <input type="text" name="address" class="form-control" id="input3">
            </div>
        </div>

        <div class="form-group">
            <label for="input4" class="col-sm-2 control-label">报名费</label>
            <div class="col-sm-5">
                <input type="text" name="price" class="form-control span3" id="input4">
            </div>
        </div>
        <div class="form-group">
            <label for="input5" class="col-sm-2 control-label">队伍</label>
            <div class="col-sm-5">
                <input type="text" name="group" class="form-control"  id="input5">
            </div>
        </div>

        <div class="form-group">
            <label for="input6" class="col-sm-2 control-label">备注</label>
            <div class="col-sm-5">
                <input type="text" name="intro" class="form-control" id="input6">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-5">
                <button type="button" class="btn btn-success" onclick="save()">确认</button>
                <a class="btn btn-info"  style="margin-left: 30px;" href="javascript:location.reload()" >清空内容</a>
                <label class="btn btn-info" style="margin-left: 30px;">总人数：${persons.size()}</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-success" onclick="queryPerson()">查询</button>
             
            </div>
        </div>
    </form>
	<div id="sysTableId">
		<!-- 
		    <div id="divTitleName"  align="center" style="margin-left: 225px;font-family: 黑体;font-weight: bold;width:520px;">
			    <h2>
			        ${game.name}---参赛人员名单
			    </h2>
	   		</div>
   		 -->
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
	            <th>操作</th>
	        </tr>
	        <c:forEach var="item" items="${persons}" varStatus="status">
	            <tr align="center" >
	            	<td>${status.count}</td>
	                <td>${item.number}</td>
	                <td>${item.name}</td>
	                <td>${item.phone}</td>
	<%--                <td>${item.address}</td>
	                <td>${item.price}</td>
	                <td>${item.group}</td>
	                <td>${item.intro}</td>--%>
	                <td>
	                    <a href="javascript:void(0);" onclick="del('${item.id}')">删除</a>
	                    <a href="/person/print/${item.id}"  target="_blank">查看/打印</a>
	                </td>
	            </tr>
	        </c:forEach>
	
	    </table>
	</div>
</div>
</body>
</html>
<script>

    function save() {
        var param = tools.formParams("personParam");
        var vname = param.name;
		var vphone = param.phone;		
		if(vname==""||vname==null){			
			alert("姓名不能为空！");
			return;
		}
		if(vphone==""||vphone==null){			
			alert("电话不能为空！");
			return;
		}
		
		tools.action("/person/save", param, function (data) {
            tools.tip(data, {1: "操作失败！"});
            if(data.success){
                if(confirm("是否打印？")){
                    location.href="/person/print/"+data.data;
                }else{
                    location.reload();
                }
            }

        });
    }

    function del(id) {
        if(!confirm("确定删除么？")){
            return;
        }

        tools.action("/person/delete", {"id": id}, function (data) {
            tools.tip(data, {1: "操作失败！"});
            location.reload();
        });
    }
     
    function queryPerson(){ 
    	
    	 window.location.href="/person/sport/${game.id}";
     
     
    }
	
</script>