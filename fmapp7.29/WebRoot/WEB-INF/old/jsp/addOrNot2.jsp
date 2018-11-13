<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/fmapp/css/test.css";type="text/css">
<link rel="stylesheet" href="/fmapp/css/partyinfo.css";type="text/css">
<title>Insert title here</title>
<script>
function run(){
		var answer = confirm("是否继续添加同一班级的学生？") 
		if(answer){
			window.location ="${ctx}/continueAddPostgraduate"; 
		}else{
			window.location ="${ctx}/selectStudent"; 
		}
	}
</script>
</head>
<body>
<div id="top">
<p class=toptitle>学生档案管理系统</p>
</div>
<div id="left">
<table class="lefttable">
<tr><td style="font-size:200%;">档案管理</td></tr>
<tr><td style="font-size:150%;">学生查询</td></tr>
<tr><td style="font-size:150%;">添加学生</td></tr>
<tr><td></td></tr>
<tr><td style="font-size:200%;">借阅管理</td></tr>
<tr><td style="font-size:150%;">借阅查询</td></tr>
</table>
</div>
<div id="mainwindow">
<h1 style="position:absolute;font-size:350%;top:20%;left:40%">中转</h1>
<input style="position:absolute;font-size:200%;top:27%;left:40%;" id="add" type="button" value="继续添加" onclick="run()"/>
</div>
</body>
</html>