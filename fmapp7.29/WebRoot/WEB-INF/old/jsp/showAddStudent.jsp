<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link rel="stylesheet" href="/fmapp/css/test.css";type="text/css">
<link rel="stylesheet" href="/fmapp/css/partyinfo.css";type="text/css">
<%-- <script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script> --%>
<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />
<%-- <script language="javascript" type="text/javascript" src="${ctx }/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"> --%>
<title>新增学生</title>
</head>
<body>
	<table width=20%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="10"></td>
		</tr>
		<%-- <tr>
			<td><img
				src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：学生管理
				&gt; 添加学生</td>
		</tr> --%>
	</table>
	
	<table style="position:absolute;" width="100%" height="90%" border="0" cellpadding="5" cellspacing="0">
	<form action="${ctx}/addStudent" id="studentForm" method="post">
	<!-- 隐藏表单，flag表示添加标记 -->
	<input type="hidden" name="flag" value="2">
	<table width="100%" border="0" cellpadding="0" cellspacing="10">
	<tr>
	<td style="position:absolute;top:5%;left:12%;font-size:24px;color:#1262b3;">单个添加</td>
	</tr>
	<tr style="font-size:19px;">	
	<td style="position:absolute;top:10%;left:12%">学（工）号：<input type="text" name="cardid" id="cardid" value="${student.cardid }" size="20" /></td>
	<td style="position:absolute;top:10%;left:40%">姓名：<input type="text" name="stname" id="stname" value="${student.stname }" size="20" /></td>
	<c:if  test ="${not empty property.property1}" >
	<td style="position:absolute;top:10%;left:72%">${property.property1}：<input type="text" name="param1" id="param1" size="20" /></td>
	</c:if>
	</tr>
	
	<tr style="font-size:19px;">
	<c:if  test ="${not empty property.property2}" >
	<td style="position:absolute;top:15%;left:12%">${property.property2}：<input type="text" name="param2" id="param2" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property3}" >
	<td style="position:absolute;top:15%;left:39%">${property.property3}：<input type="text" name="param3" id="param3" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property4}" >
	<td style="position:absolute;top:15%;left:72%">${property.property4}：<input type="text" name="param4" id="param4" size="20" /></td>
	</c:if>
	</tr>
	
	<tr style="font-size:19px;">
	<c:if  test ="${not empty property.property5}" >
	<td style="position:absolute;top:20%;left:12%">${property.property5}：<input type="text" name="param5" id="param5" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property6}" >
	<td style="position:absolute;top:20%;left:39%">${property.property6}：<input type="text" name="param6" id="param6" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property7}" >
	<td style="position:absolute;top:20%;left:72%">${property.property7}：<input type="text" name="param7" id="param7" size="20" /></td>
	</c:if>
	</tr>
	
	<tr style="font-size:19px;">
	<c:if  test ="${not empty property.property8}" >
	<td style="position:absolute;top:15%;left:12%">${property.property8}：<input type="text" name="param8" id="param8" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property9}" >
	<td style="position:absolute;top:15%;left:39%">${property.property9}：<input type="text" name="param9" id="param9" size="20" /></td>
	</c:if>
	<c:if  test ="${not empty property.property10}" >
	<td style="position:absolute;top:15%;left:39%">${property.property10}：<input type="text" name="param10" id="param10" size="20" /></td>
	</c:if>
	</tr>
	</table>
		<tr>
		<input style="position:absolute; left:35%;top:25%; width:70px;height:25px;" type="submit" value="添加">&nbsp;&nbsp;
		<input style="position:absolute; left:60%;top:25%; width:70px;height:25px;" type="reset" value="取消 ">
	    </tr>
	</form>
	
    <form action="${ctx}/import" method="post" enctype="multipart/form-data">
    <p style="position:absolute;top:35%;left:12%;font-size:24px;color:#1262b3;">批量添加</p>
	<p style="position:absolute;left:12%;top:40%;font-size:15px;">选择Excel文件进行添加：</p>
	<input style="position:absolute; left:35%;top:45%; width:300px;height:27px;" type="file" name="file" /> 
	<input style="position:absolute; left:60%;top:45%; width:70px;height:25px;" type="submit" value="加载文件">
	</form>
	
	<form action="${ctx}/upload?flag=basic" method="post" enctype="multipart/form-data">
    <p style="position:absolute;top:55%;left:12%;font-size:24px;color:#1262b3;">智能添加</p>
	<p style="position:absolute;left:12%;top:60%;font-size:15px;">请上传图片：</p>
	<input style="position:absolute; left:35%;top:65%; width:300px;height:27px;" type="file" name="imageFile" />选择图片
	<input style="position:absolute; left:60%;top:65%; width:70px;height:25px;" type="submit" value="加载图片">
	</form>
	</table>
</body>
</html>