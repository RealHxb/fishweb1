
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/my.css">
    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/bootstrap/bootstrap.min.js"></script>
    <script src="/static/js/jquery.qrcode.js"></script>
    <script src="/static/js/qrcode.js"></script>
	<style type="text/css">
		p {page-break-after: always;}
	</style>
</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>

<div class="container"  align="left" 	id="sysTableId">
	<h2 id="printTitle" align="center">${game.name}</h2>
</div>
</body>
</html>
<script>
    (function($){
    	$.ajax({url:"/person/ajaxPrint", 
    			type:"post", 
    			success:function(data){
    				var text = $("#printTitle").html();
    				var count = data.length;
    				$("#printTitle").html(text +"   "+count + "人名单");
    				var tables = $("#sysTableId");
    				var innerhtml="";
    				if(data!=null){
    					innerhtml += '<table class="table table-striped" style="width: 206px;float: left; " borderColor=#000000 cellSpacing=0 cellPadding=2 border=1>';
    					innerhtml +='<tr align="center" ><th width="30px">编号</th><th width="50px">姓名</th></tr>';
    					for(var i = 0; i < count; i++){
    						if(i != 0 && i%26 == 0){
    							innerhtml +='</tbody></table>';
    							if(i%78 == 0){
    								innerhtml +='<p></p>';
    							}
    							innerhtml +='<table class="table table-striped" style="width: 206px;float: left; " borderColor=#000000 cellSpacing=0 cellPadding=2 border=1>';
    							innerhtml +='<tr align="center" ><th width="30px">编号</th><th width="50px">姓名</th></tr>';
    							innerhtml +='<tr><td>'+data[i].number+'</td><td>'+data[i].name+'</td></tr>';
    						}else{
    							innerhtml +='<tr><td>'+data[i].number+'</td><td>'+data[i].name+'</td></tr>';
    						}
    					}
    					innerhtml +='</table>';
    				}
    				tables.append(innerhtml);
			    	window.print();
    			}
    		}  			
    	);
    	//PrintTable();
    })(jQuery);
</script>