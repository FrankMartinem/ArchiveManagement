<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/fmapp/css/test.css" type="text/css">
<link rel="stylesheet" href="/fmapp/css/partyinfo.css" type="text/css">
<title>Insert title here</title>
</head>
<body>

<h4 id="LoginTitle" >登陆页面</h4>
<div id="Login">
<font color="red">${requestScope.message }</font>
<form action="login" method="POST">
	<input type="hidden" name="flag" value="1">
	<p class="LoginAccount">教工号/学号：</p>
	<input class="LoginAccountInput" type="text" name="id"/><br/>
	<p class="LoginPsw">密码：</p>
	<input class="LoginPswIpt" type="password" name="password"/><br/>
	<input class="LoginBtn" type="submit" value="登录"/>
</form>
</div>
</body>
</html>