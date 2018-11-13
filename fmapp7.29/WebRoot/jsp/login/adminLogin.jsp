<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/fmapp/css/test.css" type="text/css"; rel="stylesheet"/>
<link rel="stylesheet" href="/fmapp/css/partyinfo.css" type="text/css">
<title>管理员登录</title>
</head>
<body>
<div style="position:absolute;width:100%;height:90%;background-size:100%;background:url(login.jpg) no-repeat;">
<h4 style="position:absolute;font-size: 300%;font-family:Arial;left:5%;top:65%;">管理员登陆</h4>
<font color="red">${requestScope.message }</font>
<form action="login" method="POST">
<p><label  style="position:absolute;left:400px;top:500px;font-size:24px;">教工号/学号：</label></p>
<p><label  style="position:absolute;left:400px;top:550px;font-size:24px;">密码：</label></p>
	<input style="position:absolute;left:550px;top:500px; width: 10%;height: 25px;" type="text" name="id"/><br/>
	<input style="position:absolute;left:550px;top:550px; width: 10%;height: 25px;" type="password" name="password"/><br/>
	<input style="position:absolute;left:30%;top:77%;width:70px;height:25px;" type="submit" value="登录"/>
</form>
</div>
</body>
</html>