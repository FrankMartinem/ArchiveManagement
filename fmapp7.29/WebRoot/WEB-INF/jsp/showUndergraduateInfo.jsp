<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@taglib prefix="ui" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/fmapp/css/test.css" type="text/css">
<link rel="stylesheet" href="/fmapp/css/partyinfo.css" type="text/css">
<script type="text/javascript">
function printit(){
	if(confirm('确认打印吗？')){
	document.getElementById('butn').style.display="none";//隐藏
	window.print();//打印
	document.getElementById('butn').style.display="inline";//显示
	}
}
</script>
</head>
<body>

<form:form modelAttribute="student" action="showUndergraduate" method="POST">
	<table align="center" border="1" cellpadding="3" cellspacing="0" width="65%">
		
		<tr align="center">
			<td colspan="4" >学（工）号：${student.cardid}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			姓名：${student.stname}</td>
		</tr>	
		<tr>
			<td width=30% colspan="2">序号</td>
			<td width=70% colspan="2">项目</td>
			<!-- <td width=70% colspan="1">查看</td> -->
		</tr>
		<tr>
			<td><input type="checkbox" onclick="return false" name="uinfo" value="入学材料">入学材料</td>
			<td>1</td>
			<td>
			<form:checkbox path="undergraduateInfo"  onclick="return false"  value="高考有关材料" label="高考有关材料"/>
			</td>
			<td><a href="${ctx}/displayImage?flag=高考有关材料&cardid=${student.cardid}">查看</a></td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td rowspan="2"><input type="checkbox" onclick="return false" name="enrolment" >党团材料</td>
			<td>2</td>
			<td>
			<form:checkbox path="undergraduateInfo" onclick="return false" value="团建材料" label="团建材料"/>
			</td>
			<td><a href="${ctx}/displayImage?flag=团建材料&cardid=${student.cardid}">查看</a></td>
		</tr>
		<tr>
			<td>3</td>
			<td>
			<form:checkbox path="undergraduateInfo" onclick="return false" value="党建材料" label="党建材料"/>
			</td>
			<td><a href="${ctx}/displayImage?flag=党建材料&cardid=${student.cardid}">查看</a></td>
		</tr>
		<tr>
			<td><input type="checkbox" onclick="return false" name="enrolment" >成绩单</td>
			<td>4</td>
			<td>
			<form:checkbox path="undergraduateInfo" onclick="return false" value="成绩总表" label="成绩总表"/>
			</td>
			<td><a href="${ctx}/displayImage?flag=成绩总表&cardid=${student.cardid}">查看</a></td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td rowspan="5"><input type="checkbox" onclick="return false" name="enrolment" >毕业材料</td>
			<td>5</td>
			<td>
			<form:checkbox path="undergraduateInfo" onclick="return false" value="高等学校毕业登记表" label="高等学校毕业登记表"/>
			</td>
			<td><a href="${ctx}/displayImage?flag=高等学校毕业登记表&cardid=${student.cardid}">查看</a></td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td>6</td>
			<td>
			<form:checkbox path="undergraduateInfo" onclick="return false" value="就业通知书" label="就业通知书"/>
			</td>
			<td><a href="${ctx}/displayImage?flag=就业通知书&cardid=${student.cardid}">查看</a></td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td>7</td>
			<td>
			学年小结表&nbsp;&nbsp;<select name="summary" disabled="disabled" style="width:143px;">
					    	<option value="${student.summary}">${student.summary}</option>
					    	<option value="1份">1份</option>
					    	<option value="2份">2份</option>
					    	<option value="3份">3份</option>
					    	<%-- <c:forEach items="${requestScope.educations }" var="education">
					    		<option value="${education.id }">${education.name }</option>
					    	</c:forEach> --%>
			</select>
			（请选择份数）
			<%-- <form:checkbox path="undergraduateInfo" value="学年小结表" label="学年小结表"/> --%>
			</td>	
			<td><a href="${ctx}/displayImage?flag=学年小结表&cardid=${student.cardid}">查看</a></td>	
		</tr>
		<tr>
			<td>8</td>
			<td>
			<form:checkbox path="undergraduateInfo" onclick="return false" value="毕业证书复印件" label="毕业证书复印件"/>
			</td>
			<td><a href="${ctx}/displayImage?flag=毕业证书复印件&cardid=${student.cardid}">查看</a></td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td>9</td>
			<td>
			<form:checkbox path="undergraduateInfo" onclick="return false" value="学位证书复印件" label="学位证书复印件"/>
			</td>
			<td><a href="${ctx}/displayImage?flag=学位证书复印件&cardid=${student.cardid}">查看</a></td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td><input type="checkbox" onclick="return false" name="enrolment" >体检材料</td>
			<td>10</td>
			<td>
			<form:checkbox path="undergraduateInfo" onclick="return false" value="毕业生体检表" label="毕业生体检表"/>
			</td>
			<td><a href="${ctx}/displayImage?flag=毕业生体检表&cardid=${student.cardid}">查看</a></td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td><input type="checkbox" onclick="return false" name="enrolment" >奖励材料</td>
			<td>11</td>
			<td>
			<form:checkbox path="undergraduateInfo" onclick="return false" value="奖励材料" label="奖励材料"/>
			</td>
			<td><a href="${ctx}/displayImage?flag=奖励材料&cardid=${student.cardid}">查看</a></td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td><input type="checkbox" onclick="return false" name="enrolment" >惩处材料</td>
			<td>12</td>
			<td>
			<form:checkbox path="undergraduateInfo" onclick="return false" value="惩处材料" label="惩处材料"/>
			</td>
			<td><a href="${ctx}/displayImage?flag=惩处材料&cardid=${student.cardid}">查看</a></td>
			
			<!-- <td>高考有关材料</td> -->
		</tr>
		<tr>
			<td colspan="3">归档日期：<input type="text" readonly="true" name="udate" value=${student.udate }></td>
		</tr>
		<tr>
			<td align="center" colspan="3">
				<a href="${pageContext.request.contextPath}/editUndergraduate?cardid=${student.cardid}">编辑档案</a>	
			</td>
			
		</tr>
		<!-- <tr>
			<td colspan="3"><div style="position:absolute;left:50%;top:40%; width:70px;height:25px;"><input id="butn" type="button" value="打印" onclick="printit();"/></div>	</td>
		</tr> -->
		<tr>
			<td colspan="3"><div><input id="butn" type="button" value="打印" onclick="printit();"/></div>	</td>
		</tr>
		
	</table>
</form:form>

</body>
</html>