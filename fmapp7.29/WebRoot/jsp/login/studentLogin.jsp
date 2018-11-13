<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生登录</title>
<link href="/fmapp/css/test.css" type="text/css"; rel="stylesheet"/>
</head>
<body>
<h4 id="LoginTitle">学生登录</h4>
<div id="Login">
<font color="red">${requestScope.message }</font>
<form action="studentLogin" method="POST">
<p><label class="LoginAccount" style="position:absolute;left:30%;top:30%;">教工号/学号：</label></p>
<p><label class="LoginPsw" style="position:absolute;left:30%;top:35%;">密码：</label></p>
	<input class="LoginAccountInput" style="position:absolute;left:45%;top:30%;" type="text" name="cardid"/><br/>
	<input class="LoginPswIpt" style="position:absolute;left:45%;top:35%;" type="password" name="password"/><br/>
	<input class="LoginBtn" style="position:absolute;left:45%;top:40%;" type="submit" value="登录"/>
</form>
</div>
</body>

</html>