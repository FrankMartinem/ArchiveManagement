<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <h3>显示图片</h3>  --> 
<%-- ${displayPath} --%>
<div style="text-align:center;margin-top:11%">
 <c:if  test ="${not empty displayPath}" >
 	<img src="${basePath}${displayPath}"> 
  <hr>
 </c:if>
 <c:if  test ="${empty displayPath}" >
 <h3>该学生不存在此电子档案！</h3>
 </c:if>
 </div>
</body>
</html>