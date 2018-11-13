<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="/fmapp/css/test.css";type="text/css">
	<link rel="stylesheet" href="/fmapp/css/partyinfo.css";type="text/css">
   <%--  <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script> --%>
	<%-- <script language="javascript" type="text/javascript" src="${ctx }/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"> --%>
<title>Insert title here</title>
</head>
<body>
<table width="20%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
	<td><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：学生档案管理  &gt; 修改学生信息</td>
	<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0">
<tr valign="top">
<td>
<form  modelAttribute="student" action="${ctx}/updateStudent" id="studentForm" method="post">
<!-- 隐藏表单，flag表示添加标记 -->
<input type="hidden" name="flag" value="2">
<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
<table style="top:10%">
<tr>
<p style="position:absolute; left:12%;top:7%;">序号：</p>
<input type="hidden" name="id"  value=${student.id } size="20"/></td>
<td style="position:absolute;top:10%;left:12%">学号：<input type="text" name="cardid" id="cardid" value="${student.cardid }" size="20"/></td>
<td style="position:absolute;top:10%;left:40%">姓名：<input type="text" name="stname" id="stname" value="${student.stname }" size="20"/></td>
<td style="position:absolute;top:10%;left:72%">联系方式：<input type="text" name="phone" id="phone" value="${student.phone }" size="20"/></td>
</tr>
<tr>
<td style="position:absolute;top:15%;left:12%">班级：<input type="text" name="clazzname" id="clazzname" value="${student.clazzname }" size="20" /></td>
<td style="position:absolute;top:15%;left:39.5%">党支部：<input type="text" name="party" id="party" value="${student.party }" size="20" /></td>
<td style="position:absolute;top:15%;left:72%">档案位置：<input type="text" name="location" id="location" value="${student.location }" size="20" /></td>
</tr>
</table>
<tr><td>
<input style="position:absolute; left:35%;top:20%; width:70px;height:25px;" type="submit" value="修改">&nbsp;&nbsp;
<input style="position:absolute; left:50%;top:20%; width:70px;height:25px;" type="reset" value="取消 "></td></tr>
</table>
</form>
</td>
</tr>
</table>
<div style="height:10px;"></div>
</body>
</html>