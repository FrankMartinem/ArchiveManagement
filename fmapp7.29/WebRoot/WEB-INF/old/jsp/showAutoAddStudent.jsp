<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<table style="position:absolute;" width="100%" height="90%" border="0" cellpadding="5" cellspacing="0">
	<form action="${ctx}/addStudent" id="studentForm" method="post">
	<!-- 隐藏表单，flag表示添加标记 -->
	<input type="hidden" name="flag" value="2">
	<table width="100%" border="0" cellpadding="0" cellspacing="10">
	<tr>
	<!-- <td style="position:absolute;top:5%;left:12%;font-size:24px;color:#1262b3;">单个添加</td> -->
	</tr>
	<tr style="font-size:19px;">	
	<td style="position:absolute;top:10%;left:12%">学（工）号：<input type="text" name="cardid" id="cardid" value="${student.cardid }" size="20" /></td>
	<td style="position:absolute;top:10%;left:40%">姓名：<input type="text" name="stname" id="stname" value="${student.stname }" size="20" /></td>
	<c:if  test ="${not empty property.property1}" >
	<td style="position:absolute;top:10%;left:72%">${property.property1}：<input type="text" name="param1" id="param1" value="${student.param1 }" size="20" /></td>
	</c:if>
	</tr>
	
	<tr style="font-size:19px;">
	<c:if  test ="${not empty property.property2}" >
	<td style="position:absolute;top:15%;left:12%">${property.property2}：<input type="text" name="param2" id="param2" value="${student.param2 }" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property3}" >
	<td style="position:absolute;top:15%;left:39%">${property.property3}：<input type="text" name="param3" id="param3" value="${student.param3 }" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property4}" >
	<td style="position:absolute;top:15%;left:72%">${property.property4}：<input type="text" name="param4" id="param4" value="${student.param4 }" size="20" /></td>
	</c:if>
	</tr>
	
	<tr style="font-size:19px;">
	<c:if  test ="${not empty property.property5}" >
	<td style="position:absolute;top:20%;left:12%">${property.property5}：<input type="text" name="param5" id="param5" value="${student.param5 }" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property6}" >
	<td style="position:absolute;top:20%;left:39%">${property.property6}：<input type="text" name="param6" id="param6" value="${student.param6 }" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property7}" >
	<td style="position:absolute;top:20%;left:72%">${property.property7}：<input type="text" name="param7" id="param7" value="${student.param7 }" size="20" /></td>
	</c:if>
	</tr>
	
	<tr style="font-size:19px;">
	<c:if  test ="${not empty property.property8}" >
	<td style="position:absolute;top:15%;left:12%">${property.property8}：<input type="text" name="param8" id="param8" value="${student.param8 }" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property9}" >
	<td style="position:absolute;top:15%;left:39%">${property.property9}：<input type="text" name="param9" id="param9" value="${student.param9 }" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property10}" >
	<td style="position:absolute;top:15%;left:39%">${property.property10}：<input type="text" name="param10" id="param10" value="${student.param10 }" size="20" /></td>
	</c:if>
	</tr>
	</table>
		<tr>
		<input style="position:absolute; left:35%;top:25%; width:70px;height:25px;" type="submit" value="添加">&nbsp;&nbsp;
		<input style="position:absolute; left:60%;top:25%; width:70px;height:25px;" type="reset" value="取消 ">
	    </tr>
	</form>
	
	<form action="${ctx}/upload?flag=basic" method="post" enctype="multipart/form-data">
    <p style="position:absolute;top:55%;left:12%;font-size:24px;color:#1262b3;">智能添加</p>
	<p style="position:absolute;left:12%;top:60%;font-size:15px;">请上传图片：</p>
	<input style="position:absolute; left:35%;top:65%; width:300px;height:27px;" type="file" name="imageFile" />
	<input style="position:absolute; left:60%;top:65%; width:70px;height:25px;" type="submit" value="加载图片">
	</form>
	</table>
</body>
</html>