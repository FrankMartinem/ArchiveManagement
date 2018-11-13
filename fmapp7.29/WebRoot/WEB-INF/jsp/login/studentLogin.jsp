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
<div style="position:absolute;width:100%;height:90%;background-size:100%;background:url(${ctx}/images/login.jpg) no-repeat;">
<h4 style="position:absolute;font-size: 350%;font-family:黑体;color:#ffffff;left:100px;top:530px;">普通登陆</h4>
<font color="red">${requestScope.message }</font>
<form action="studentLogin" method="POST">
<p><label style="position:absolute;left:400px;top:500px;font-size:24px;color:#ffffff;">学号：</label></p>
<p><label style="position:absolute;left:400px;top:550px;font-size:24px;color:#ffffff;">密码：</label></p>
	<input style="position:absolute;left:550px;top:500px; width: 10%;height: 25px;" type="text" name="cardid"/><br/>
	<input style="position:absolute;left:550px;top:550px; width: 10%;height: 25px;" type="password" name="password"/><br/>
	<input style="position:absolute;left:560px;top:600px;width:120px;height:40px;font-size:20px;font-family:黑体" type="submit" value="登录"/>
</form>
</div>
</body>
</html>