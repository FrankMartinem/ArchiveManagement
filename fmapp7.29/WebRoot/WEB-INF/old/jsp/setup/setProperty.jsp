<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>第一步</h2>
<h3>请添加您需要录入的人员基本信息（如:性别、住址、邮箱等）</h3>
<c:if  test ="${empty property.id}" >
<form modelAttribute="property" action="addProperty?mark=1" method="POST">
	<input type="text" name="cardid" value="学（工）号"/><br/>
	<input type="text" name="stname" value="姓名"/><br/>
	<!-- <input type="text" name="party" value="所属党支部"/><br/> -->
	<input type="text" name="property1" value="${property.property1 }"/><br/>
	<input type="text" name="property2" value="${property.property2 }"/><br/>
	<input type="text" name="property3" value="${property.property3 }"/><br/>
	<input type="text" name="property4" value="${property.property4 }"/><br/>
	<input type="text" name="property5" value="${property.property5 }"/><br/>
	<input type="text" name="property6" value="${property.property6 }"/><br/>
	<input type="text" name="property7" value="${property.property7 }"/><br/>
	<input type="text" name="property8" value="${property.property8 }"/><br/>
	<input type="text" name="property9" value="${property.property9 }"/><br/>
	<input type="text" name="property10" value="${property.property10 }"/><br/>
	<c:if  test ="${not empty property.id}" >
	<input type="submit" value="修改"/><br/>
	</c:if>
	<c:if  test ="${empty property.id}" >
	<input type="submit" value="确定"/><br/>
	</c:if>
</form>
</c:if>

<!-- 如果之前录入过个性化设置信息，则使文本框变为只读状态 -->
<c:if  test ="${not empty property.id}" >
<form modelAttribute="property" action="addProperty?mark=1" method="POST">
	<input type="text" name="cardid" value="学号" readonly="readonly"/><br/>
	<input type="text" name="stname" value="姓名" readonly="readonly"/><br/>
	<!-- <input type="text" name="party" value="所属党支部"/><br/> -->
	<input type="text" name="property1" value="${property.property1 }" readonly="readonly"/><br/>
	<input type="text" name="property2" value="${property.property2 }" readonly="readonly"/><br/>
	<input type="text" name="property3" value="${property.property3 }" readonly="readonly"/><br/>
	<input type="text" name="property4" value="${property.property4 }" readonly="readonly"/><br/>
	<input type="text" name="property5" value="${property.property5 }" readonly="readonly"/><br/>
	<input type="text" name="property6" value="${property.property6 }" readonly="readonly"/><br/>
	<input type="text" name="property7" value="${property.property7 }" readonly="readonly"/><br/>
	<input type="text" name="property8" value="${property.property8 }" readonly="readonly"/><br/>
	<input type="text" name="property9" value="${property.property9 }" readonly="readonly"/><br/>
	<input type="text" name="property10" value="${property.property10 }" readonly="readonly"/><br/>
	<c:if  test ="${not empty property.id}" >
	<input type="submit" value="修改"/><br/>
	</c:if>
	<c:if  test ="${empty property.id}" >
	<input type="submit" value="确定"/><br/>
	</c:if>
</form>
</c:if>
</body>
</html>