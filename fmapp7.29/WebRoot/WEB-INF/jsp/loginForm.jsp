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
<div style="position:absolute;width:100%;height:90%; background:url(${ctx}/images/login.jpg) no-repeat;">
<%-- <font color="red">${requestScope.message }</font> --%>
	<table align="center" >
		<tr>
			<th>
				<form action="${pageContext.request.contextPath}/login/student">
					<input style="position: absolute;left:430px;top:500px;width:120px;height:50px;font-size:20px;font-family:黑体"type="submit" value="普通登录">
				</form><br>
				<form action="${pageContext.request.contextPath}/login/admin">
					<input style="position: absolute;left:670px;top:500px;width:120px;height:50px;font-size:20px;font-family:黑体" type="submit" value="管理员登录">
				</form>
			</th>
		</tr>
	</table>
</div>
</body>
</html>