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
<h2 style="margin-top:0px; position: absolute;font-size: 24px;left: 2%;top: 5%">第一步</h2>
<h3 style="margin-top:0px; position: absolute;font-size: 20px;left: 2%;top: 15%">请添加您需要录入的人员基本信息（如:性别、住址、邮箱等）</h3>
<form  style="position:absolute;top:25%; left:2%" action="updateProperty" method="POST">
<td><input type="hidden" name="id" value="${property_update.id }"></td>
	<table style="font-size:12px;width:100%; border:#c2c6cc 0px solid; border-collapse:collapse;" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
	<td><input style="height:25px;" type="text" name="cardid" value="学（工）号"/><br/></td>
	<td><input style="height:25px;" type="text" name="stname" value="姓名"/><br/></td>
	<!-- <input type="text" name="party" value="所属党支部"/><br/> -->
	<td><input style="height:25px;" type="text" name="property1" value="${property_update.property1 }"/><br/></td>
	<td><input style="height:25px;" type="text" name="property2" value="${property_update.property2 }"/><br/></td>
	</tr>
	<tr>
	<td><input style="height:25px;" type="text" name="property3" value="${property_update.property3 }"/><br/></td>
	<td><input style="height:25px;" type="text" name="property4" value="${property_update.property4 }"/><br/></td>
	<td><input style="height:25px;" type="text" name="property5" value="${property_update.property5 }"/><br/></td>
	<td><input style="height:25px;" type="text" name="property6" value="${property_update.property6 }"/><br/></td>
	</tr>
	<tr>
	<td><input style="height:25px;" type="text" name="property7" value="${property_update.property7 }"/><br/></td>
	<td><input style="height:25px;" type="text" name="property8" value="${property_update.property8 }"/><br/></td>
	<td><input style="height:25px;" type="text" name="property9" value="${property_update.property9 }"/><br/></td>
	<td><input style="height:25px;" type="text" name="property10" value="${property_update.property10 }"/><br/></td>
	</tr>
	</table>
	<input style="position:absolute;top:120%; left:0%" type="submit" value="确定"/><br/>
</form>
<%-- <form  action="updateProperty" method="POST">
	<td><input type="hidden" name="id" value="${property_update.id }"></td>
	<input type="text" name="cardid" value="学号"/><br/>
	<input type="text" name="stname" value="姓名"/><br/>
	<!-- <input type="text" name="party" value="所属党支部"/><br/> -->
	<input type="text" name="property1"/><br/>
	<input type="text" name="property2"/><br/>
	<input type="text" name="property3"/><br/>
	<input type="text" name="property4"/><br/>
	<input type="text" name="property5"/><br/>
	<input type="text" name="property6"/><br/>
	<input type="text" name="property7"/><br/>
	<input type="text" name="property8"/><br/>
	<input type="text" name="property9"/><br/>
	<input type="text" name="property10"/><br/>
	<input type="submit" value="确定"/><br/>
</form> --%>

</body>
</html>