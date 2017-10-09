
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
	<script src="/static/js/LodopFuncs.js"></script>
</head>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/game">钓鱼比赛</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
           <ul class="nav navbar-nav">
               <li class="active"><a href="/game">主页 <span class="sr-only">(current)</span></a></li>
               <!-- <li class="active"><a href="javascript:window.print()">打印 </a></li> -->
               <li class="active"><a href="javascript:PrintTable()">打印 </a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">服务器地址：192.168.1.88</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<script>

	function PrintTable(){
		/**
		LODOP=getLodop();  
		LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_无边线表格");
			
		var strBodyStyle="<style>table,td {border: 1 solid #000000;border-collapse:collapse;line-height:225% }</style>";		
		var strFormHtml=strBodyStyle+"<body>"+document.getElementById("sysTableId").innerHTML+"</body>";

		LODOP.ADD_PRINT_HTM(25,20,"95%",1100,strFormHtml);		
		
		LODOP.PREVIEW();*/
		window.print();
	};	

</script>

