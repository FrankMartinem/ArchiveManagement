<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" language="javascript">
alert("${list_tip}");
window.document.location.href="${ctx}/findProperty?flag=2";
</script> 
${sessionScope.list_tip}
<a href="${ctx}/mainForm">点击此处跳转到主页面</a>
</body>
</html>