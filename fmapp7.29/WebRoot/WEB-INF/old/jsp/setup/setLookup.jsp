<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>第二步</h2>
<h3>请勾选查询栏中想要进行搜索的具体栏目</h3>
<form:form  modelAttribute="property" action="addProperty?mark=2" method="POST">
<table>
<tr><td><input type="hidden" name="id" value="${property.id }"></td></tr>
	<tr>
		<td>
		<form:checkbox path="propertyInfo" value="学（工）号" label="学号"/>
		</td>
		<td>
		<form:checkbox path="propertyInfo" value="姓名" label="姓名"/>
		</td>
	<c:if  test ="${not empty property.property1}" >
		<td>
		<form:checkbox path="propertyInfo" value="${property.property1 }" label="${property.property1 }"/>
		</td>	
	</c:if>
	<c:if  test ="${not empty property.property2}" >
		<td>
		<form:checkbox path="propertyInfo" value="${property.property2 }" label="${property.property2 }"/>
		</td>	
	</c:if>
	</tr>
	<tr>	
	<c:if  test ="${not empty property.property3}" >
		<td>
		<form:checkbox path="propertyInfo" value="${property.property3 }" label="${property.property3 }"/>
		</td>
	</c:if>
	<c:if  test ="${not empty property.property4}" >		
		<td>
		<form:checkbox path="propertyInfo" value="${property.property4 }" label="${property.property4 }"/>
		</td>	
	</c:if>
	<c:if  test ="${not empty property.property5}" >	
		<td>
		<form:checkbox path="propertyInfo" value="${property.property5 }" label="${property.property5 }"/>
		</td>
	</c:if>
	<c:if  test ="${not empty property.property6}" >		
		<td>
		<form:checkbox path="propertyInfo" value="${property.property6 }" label="${property.property6 }"/>
		</td>
	</c:if>
	</tr>
	<tr>
	<c:if  test ="${not empty property.property7}" >		
		<td>
		<form:checkbox path="propertyInfo" value="${property.property7 }" label="${property.property7 }"/>
		</td>
	</c:if>
	<c:if  test ="${not empty property.property8}" >		
		<td>
		<form:checkbox path="propertyInfo" value="${property.property8 }" label="${property.property8 }"/>
		</td>	
	</c:if>
	<c:if  test ="${not empty property.property9}" >	
		<td>
		<form:checkbox path="propertyInfo" value="${property.property9 }" label="${property.property9 }"/>
		</td>	
	</c:if>
	<c:if  test ="${not empty property.property10}" >
		<td>
		<form:checkbox path="propertyInfo" value="${property.property10 }" label="${property.property10 }"/>
		</td>	
	</c:if>		
	</tr>
	</table>
	<tr>
		<td><input type="submit" value="确定"></td>
	</tr>
</form:form>
</body>
</html>