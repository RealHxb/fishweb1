<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2016/1/7 0007
  Time: 下午 12:06
  To change this template use File | Settings | File Templates.
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
    <title>比赛列表</title>
    <link href="/favicon.ico" type="image/x-icon" rel="shortcut icon" />

    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/datatables.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/datatables.min.js"></script>
    <script src="/static/js/tools.js"></script>
</head>
<body  class="body-bg">
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container" >
    <div align="center" style="margin-top: 30px;">
        <img src="/images/index-top.png" style="width: 30%;height: 30%;">
    </div>
    <div  align="center" style="margin-top: 30px;">
        <h1 style="color: black;font-weight: bold;">钓鱼比赛计分系统</h1>
    </div>
    <div  align="center" style="margin-top: 100px;">
        <table style="width: 100%;text-align: center;" align="center">
            <tr>
                <td align="center">
                    <a class="btn btn-warning" style="width: 125px;background-color: #FF6600;font-weight: bold;color: black;" href="/game/setting"  >赛事设置</a>
                </td>
                <td align="center">
                    <a class="btn btn-warning" style="width: 125px;background-color: #FF6600;font-weight: bold;color: black;" href="/person/setting" >报名检入</a>
                </td>
                <td align="center">
                    <button class="btn btn-warning" style="width: 125px;background-color: #FF6600;font-weight: bold;color: black;"  data-toggle="modal" data-target="#myModa3"  onclick="">罚&nbsp;&nbsp;&nbsp;分</button>
                </td>
                <td align="center">
                    <button class="btn btn-warning" style="width: 125px;background-color: #FF6600;font-weight: bold;color: black;"  data-toggle="modal" data-target="#myModal"  onclick="">制表打印</button>
                </td>
				<td align="center">
                    <button class="btn btn-warning" style="width: 125px;background-color: #FF6600;font-weight: bold;color: black;"  data-toggle="modal" data-target="#myModal4"  onclick="">成绩评审</button>
                </td>

                <td align="center">
                    <button class="btn btn-warning" style="width: 125px;background-color: #FF6600;font-weight: bold;color: black;"  data-toggle="modal" data-target="#myModal2"  onclick="">成绩打印</button>
                </td>
                <td align="center">
                    <a class="btn btn-warning" style="width: 125px;background-color: #FF6600;font-weight: bold;color: black;" href="/person/lucky/${game.id}" target="_blank">幸运抽奖</a>
                </td>
            </tr>
        </table>

    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">制表打印</h4>                
                <h4>
                <div><input id ="gamId" type="hidden" name="sporter" value="${game.id}" style="width:65px;">
                <div style="margin-left: 375px; margin-top: -32px;width:300px;">按编号:&nbsp;<input id ="perId" type="text" name="sporter" value="" style="width:65px;"> </div>
                </h4>
            </div>
            <div class="modal-body">
                <div>
                    <table style="width: 100%;" class="table table-striped table-bordered">
                        <tr>
                            <th align="center">场/区</th>
                            <c:forEach var="item1" varStatus="status1" begin="1" end="${game.qu}">
                                <th align="center"> 第 ${status1.index} 区</th>
                            </c:forEach>
                        </tr>
                        <c:forEach var="item1" varStatus="status1" begin="1" end="${game.chang}">
                            <tr>
                                <td align="center">
                                    <span>第 ${status1.index} 场</span>
                                </td>
                                <c:forEach var="item2" varStatus="status2" begin="1" end="${game.qu}">
                                    <td align="center">
                                        <a href="/grade/info/${game.id}/${status1.index}/${status2.index}" target="_blank">查看</a>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="modal-footer"> 
            	
            	<button type="button" class="btn btn-success" onclick="query()">查询</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>                
            </div>
        </div>
    </div>
</div>

<!-- Modal 成绩评审-->
<div class="modal fade" id="myModal4" tabindex="-3" role="dialog" aria-labelledby="myModalLabel">
     <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">成绩评审</h4>
            </div>
            <div class="modal-body">
                <div>
                    <table style="width: 100%;" class="table table-striped table-bordered">
                        <tr>
                            <th align="center">场/区</th>
                            <c:forEach var="item1" varStatus="status1" begin="1" end="${game.qu}">
                                <th align="center"> 第 ${status1.index} 区</th>
                            </c:forEach>
                        </tr>
                        <c:forEach var="item1" varStatus="status1" begin="1" end="${game.chang}">
                            <tr>
                                <td align="center">
                                    <span>第 ${status1.index} 场</span>
                                </td>
                                <c:forEach var="item2" varStatus="status2" begin="1" end="${game.qu}">
                                    <td align="center">
                                        <a href="/grade/check/${game.id}/${status1.index}/${status2.index}" target="_blank">查看</a>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="modal-footer"> 
            	<!-- <button type="button" class="btn btn-success" onclick="query()">查询</button>  -->
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>                
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModa3" tabindex="-3" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabe3">罚分 -  ${game.name}</h4>
            </div>
            <div class="modal-body">
                <div>
                    <form class="form-horizontal" id="fafenParam">
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">场次：</label>
                            <div class="col-sm-7">
                                <select name="chang" class="form-control">
                                    <c:forEach var="item1" varStatus="status1" begin="1" end="${game.chang}">
                                        <option value="${status1.index}">第${status1.index}场</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">编号：</label>
                            <div class="col-sm-7">
                                <input type="text" name="personId" class="form-control">
                                <input id="fgameId" type="hidden" name="gameId" value="${game.id}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label  class="col-sm-3 control-label">罚分：</label>
                            <div class="col-sm-7">
                                <input id="franking"  class="form-control" type="text" name="ranking" value=""/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="fafen()">保存</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">成绩打印 <a class="btn btn-danger" href="#" onclick="jifen()">计分排名</a></h4>

            </div>
            <div class="modal-body">
                <div>
                    <fieldset>
                        <legend>个人排名   <a class="btn btn-success" style="float:right;" href="/grade/show/${game.id}" target="_blank">总成绩</a></legend>
                    </fieldset>
                    <table style="width: 100%;" class="table table-striped table-bordered">
                        <tr>
                            <th align="center">场/区</th>
                            <c:forEach var="item1" varStatus="status1" begin="1" end="${game.qu}">
                                <th align="center"> 第 ${status1.index} 区</th>
                            </c:forEach>
                        </tr>
                        <c:forEach var="item1" varStatus="status1" begin="1" end="${game.chang}">
                            <tr>
                                <td align="center">
                                    <a href="/grade/show/${game.id}/${status1.index}" target="_blank">第 ${status1.index} 场</a>
                                </td>
                                <c:forEach var="item2" varStatus="status2" begin="1" end="${game.qu}">
                                    <td align="center">
                                        <a href="/grade/show/${game.id}/${status1.index}/${status2.index}" target="_blank">查看</a>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                    <fieldset>
                        <legend>队伍排名  <a class="btn btn-success" style="float:right;" href="/grade/group/${game.id}" target="_blank">总成绩</a></legend>
                    </fieldset>
                    <table style="width: 100%;" class="table table-striped table-bordered">
                        <tr>
                            <th align="center">场/区</th>
                            <c:forEach var="item1" varStatus="status1" begin="1" end="${game.qu}">
                                <th align="center"> 第 ${status1.index} 区</th>
                            </c:forEach>
                        </tr>
                        <c:forEach var="item1" varStatus="status1" begin="1" end="${game.chang}">
                            <tr>
                                <td align="center">
                                    <a href="/grade/group/${game.id}/${status1.index}" target="_blank">第 ${status1.index} 场</a>
                                </td>
                                <c:forEach var="item2" varStatus="status2" begin="1" end="${game.qu}">
                                    <td align="center">
                                        <a href="/grade/group/${game.id}/${status1.index}/${status2.index}" target="_blank">查看</a>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <!-- <button type="button" class="btn btn-primary">保存</button> -->
            </div>
        </div>
    </div>
</div>
</body>
<script>
	function check(){
	 var vgameId = ${game.id};
	 window.location.href="/grade/check/${game.id}";
		
		
	}
    function jifen(){
        tools.action("/grade/jifen/${game.id}",null,function(data){
            tools.tip(data,{1:"操作失败！"});
            location.reload();
        });
    }

    function fafen(){
    	var fgameid = $("#fgameId").val();    	
    	var fnumber = $("#franking").val();   	
 
 		
    	if(fgameid==""||fgameid==null||fnumber==""||fnumber==null){			
			alert("人员编号、罚分不能为空！");
			return;
		} 
        var param = tools.formParams("fafenParam");

        tools.action("/grade/fafen",param,function(data){
            tools.tip(data,{1:"操作失败！"});
            location.reload();
        });
    }
    function query(){
    	
    	var vgameid = $("#gamId").val();    	
    	var vnumber = $("#perId").val();   	
 
 		
    	if(vnumber==""||vnumber==null){			
			alert("人员编号不能为空！");
			return;
		} 


    	
    	//根据用户的编码进行查询
    	window.location.href="/grade/room/${game.id}/"+vnumber;
    	
    	
    }
    
</script>
</html>
