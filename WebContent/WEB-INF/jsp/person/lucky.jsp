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
    <title>幸运抽奖</title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">

    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/jquery.qrcode.js"></script>
    <script src="/static/js/qrcode.js"></script>

</head>
<body style="background-color: #95ABF7;">
<jsp:include page="../navbar.jsp"></jsp:include>

<div id="sysTableId" class="container"   style="margin-top: 80px;">
    <di style="padding-bottom: 50px;" align="left">
        <button class="btn btn-info" onclick="luck()">抽奖</button>
        <label style="margin-left: 50px;">抽奖数量：</label>
        <input id="chouCount" value="1" style="width: 100px;"> 人
        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中奖用户：<span id="luckResoult">点击抽奖开始抽奖...</span>--%>
        <button id="modeshow" class="btn btn-warning" style="display: none;"  data-toggle="modal" data-target="#myModaLucky"  onclick="">中奖用户</button>
    </di>

    <table style="width: 100%;margin-top: 20px; " class="table table-striped " borderColor=#000000 cellSpacing=0 cellPadding=2 border=3>
        <tr align="center" >
            <th>选择</th>
            <th>姓名</th>
            <th>编号</th>
            <th>得分</th>
            <th>顺序</th>
        </tr>
        <c:forEach var="item" items="${persons}" varStatus="status">
            <tr vAlign=center align=middle onMouseOut="this.style.background='';" onMouseOver="this.style.background='#EFB792';" >
                <td style="width:30%" >
                    <input type="checkbox" id="p_${item.personId}" checked name="persons" value="${item.personId}">
                    ${item.personId}
                </td>
                <td style="width:20%"  id="n_${item.personId}">${item.personName}</td>
                <td style="width:20%" id="nb_${item.personId}">${item.personNumber}</td>
                <td style="width:20%" >${item.defen+item.ranking}</td>
                <td style="width:10%" >${status.count}</td>
            </tr>
        </c:forEach>

    </table>
</div>



<!-- Modal -->
<div class="modal fade" id="myModaLucky" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">中奖用户</h4>
            </div>
            <div class="modal-body">
                <div>
                    <table style="width: 100%;" id="luckyTable" class="table table-bordered">
                       <%-- <tr>
                            <th align="center">场/区</th>
                        </tr>--%>
                    </table>

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
<script>

    function getAllChecked(){
        var arrays = new Array();
        $('input[name="persons"]:checked').each(function(){
            arrays.push($(this).val());
        });
        return arrays
    }

    function luck(){
        $("#luckyTable").html("");

        var luckyCount = 1;
        try{
            luckyCount = parseInt($("#chouCount").val());

        }catch (e){
            luckyCount = 1;
        }
        for(var i = 0 ;i<luckyCount;i++){
            var arrays = getAllChecked()
            var random = parseInt(Math.random()*arrays.length);
            var id = arrays[random];
            intoLuckyTable(id);
        }
        $("#modeshow").click();
        //alert("中奖用户："+zhongjiang.join(","));
    }

    function intoLuckyTable(id){
        var name = $("#n_"+id).text();
        var number = $("#nb_"+id).text();
        $("#p_"+id).attr("checked",false);

        var tr = $("<tr>");
        var td = $("<td align='center'>");
        td.text(number+"     "+name);
        td.appendTo(tr);
        tr.appendTo($("#luckyTable"));

    }

</script>