<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/fmapp/css/test.css" type="text/css">
<link rel="stylesheet" href="/fmapp/css/partyinfo.css" type="text/css">
<title></title>
<script type="text/javascript">
		function run(){
			//完成校验
			//确认密码和密码一致
			var password = document.form1.password.value;
			var repassword = document.form1.repassword.value;
			if(repassword =="" || repassword!=password){
				alert("两次密码不一致");
				return false;
			}
		}
		
</script>
</head>
<body>

<h3 id="LoginTitle">注册页面</h3>
<form:form modelAttribute="user" name="form1" action="register" method="POST" onsubmit="return run()">
	<font color="red">${requestScope.message}</font>
	<table style="position:absolute; left:30%; top:30%; font-size:20px;">
		<tr>
			<td>姓名:</td>
			<td><form:input path="username"/></td>
			<td><form:errors path="username" cssStyle= "color:red"/></td>
		</tr>
		<tr>
			<td>学号/教工号:</td>
			<td><form:input path="id"/></td>
			<td><form:errors path="id" cssStyle= "color:red"/></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><form:password path="password"/></td>
			<td><form:errors path="password" cssStyle= "color:red"/></td>
		</tr>
		<tr>
			<td>确认密码:</td>
			<td><form:password path="repassword"/></td>
			<td><form:errors path="repassword" cssStyle= "color:red"/></td>
		</tr>
		<tr>
			<td>手机号码:</td>
			<td><form:input path="phone"/></td>
			<td><form:errors path="phone" cssStyle= "color:red"/></td>
		</tr>
		<tr>
			<td>邮箱:</td>
			<td><form:input path="email"/></td>
			<td><form:errors path="email" cssStyle= "color:red"/></td>
		</tr>	
	</table>
	<input class="btn" style="left:43%; top:50%; width:70px;height:25px;" type="submit" value="提交"/>
</form:form>
</body>
</html>