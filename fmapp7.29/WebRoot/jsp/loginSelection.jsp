<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录主界面</title>
<!-- <link rel="stylesheet" href="/fmapp/css/test.css" type="text/css"> -->
<link rel="stylesheet" href="/fmapp/css/partyinfo.css" type="text/css">
</head>
<link href="${ctx}/test.css" type="text/css" rel="stylesheet" />
<body>
<div style="position:absolute;width:100%;height:90%; background:url(../images/login.jpg);">
<%-- <font color="red">${requestScope.message }</font> --%>
	<table align="center" >
		<tr>
			<th>
				<form action="${pageContext.request.contextPath}/login/student">
					<input style="position: absolute;left:20%;top:55%;width:90px;height:35px;font-size:12px;"type="submit" value="学生登录">
				</form><br>
				<form action="${pageContext.request.contextPath}/login/admin">
					<input style="position: absolute;left:35%;top:55%;width:90px;height:35px;font-size:12px;" type="submit" value="管理员登录">
				</form>
			</th>
		</tr>
	</table>
</div>
</body>
</html>