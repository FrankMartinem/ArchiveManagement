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
<h2 style="margin-top:0px; position: absolute;font-size: 24px;left: 2%;top: 5%">第二步</h2>
<h3 style="margin-top:0px; position: absolute;font-size: 20px;left: 2%;top: 15%">请勾选查询栏中想要进行搜索的具体栏目</h3>
<form:form  modelAttribute="property" action="addProperty?mark=2" method="POST">
<table width=98% >
<tr><td><input type="hidden" name="id" value="${property.id }"></td></tr>
	<tr>
		<td style="position:absolute;top:25%; left:10%">
		<form:checkbox path="propertyInfo" value="学（工）号" label="学号"/>
		</td>
		<td style="position:absolute;top:25%; left:20%">
		<form:checkbox path="propertyInfo" value="姓名" label="姓名"/>
		</td>
	<c:if  test ="${not empty property.property1}" >
		<td style="position:absolute;top:25%; left:30%">
		<form:checkbox path="propertyInfo" value="${property.property1 }" label="${property.property1 }"/>
		</td>	
	</c:if>
	<c:if  test ="${not empty property.property2}" >
		<td style="position:absolute;top:25%; left:40%">
		<form:checkbox path="propertyInfo" value="${property.property2 }" label="${property.property2 }"/>
		</td>	
	</c:if>
	</tr>
	<tr>	
	<c:if  test ="${not empty property.property3}" >
		<td style="position:absolute;top:35%; left:10%">
		<form:checkbox path="propertyInfo" value="${property.property3 }" label="${property.property3 }"/>
		</td>
	</c:if>
	<c:if  test ="${not empty property.property4}" >		
		<td style="position:absolute;top:35%; left:20%">
		<form:checkbox path="propertyInfo" value="${property.property4 }" label="${property.property4 }"/>
		</td>	
	</c:if>
	<c:if  test ="${not empty property.property5}" >	
		<td style="position:absolute;top:35%; left:30%">
		<form:checkbox path="propertyInfo" value="${property.property5 }" label="${property.property5 }"/>
		</td>
	</c:if>
	<c:if  test ="${not empty property.property6}" >		
		<td style="position:absolute;top:35%; left:40%">
		<form:checkbox path="propertyInfo" value="${property.property6 }" label="${property.property6 }"/>
		</td>
	</c:if>
	</tr>
	<tr>
	<c:if  test ="${not empty property.property7}" >		
		<td style="position:absolute;top:45%; left:20%">
		<form:checkbox path="propertyInfo" value="${property.property7 }" label="${property.property7 }"/>
		</td>
	</c:if>
	<c:if  test ="${not empty property.property8}" >		
		<td style="position:absolute;top:45%; left:40%">
		<form:checkbox path="propertyInfo" value="${property.property8 }" label="${property.property8 }"/>
		</td>	
	</c:if>
	<c:if  test ="${not empty property.property9}" >	
		<td style="position:absolute;top:45%; left:60%">
		<form:checkbox path="propertyInfo" value="${property.property9 }" label="${property.property9 }"/>
		</td>	
	</c:if>
	<c:if  test ="${not empty property.property10}" >
		<td style="position:absolute;top:45%; left:80%">
		<form:checkbox path="propertyInfo" value="${property.property10 }" label="${property.property10 }"/>
		</td>	
	</c:if>		
	</tr>
	</table>
	<tr>
		<td><input style="position:absolute;top:50%; left:2%" type="submit" value="确定"></td>
	</tr>
</form:form>
</body>
</html>