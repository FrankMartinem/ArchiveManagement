<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@taglib prefix="ui" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/fmapp/css/test.css";type="text/css">
<link rel="stylesheet" href="/fmapp/css/partyinfo.css";type="text/css">
</head>
<body>
<uiForFind:forEach items="${uilist}" var="uiForFind">
<form:form  action="saveUndergraduate?studentid=${uiForFind.studentid }" method="POST">
	<font color="red">${requestScope.message}</font>
	<table border="1" align="center" width="65%">
		<tr>
			<td>学号：<td>
			<td>${uiForFind.studentid}<td>
		</tr>	
		<tr>
			<td colspan="2">序号</td>
			<td colspan="2">项目</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="enrolment" ></td>
			<td>入学材料</td>
			<td>1</td>
			<td><input type="checkbox" name="gaokao" value="有" <uiForFind:if test="${uiForFind.gaokao == '有'}">checked</uiForFind:if>>高考有关材料</td>
		</tr>
		<tr>
			<td rowspan="5"><input type="checkbox" name="party"></td>
			<td rowspan="5">参加党派材料</td>
			<td>2</td>
			<td><input type="checkbox" name="youthApplication" value="有" <uiForFind:if test="${uiForFind.youthApplication == '有'}">checked</uiForFind:if>>加入共青团申请书</td>
			<!-- <td>加入共青团申请书</td> -->
		</tr>
		<tr>
			<td>3</td>
			<td><input type="checkbox" name=youthVoluntary value="有" <uiForFind:if test="${uiForFind.youthVoluntary == '有'}">checked</uiForFind:if>>加入共青团志愿书</td>
		</tr>
		<tr>
			<td>4</td>
			<td><input type="checkbox" name="partyApplication" value="有" <uiForFind:if test="${uiForFind.partyApplication == '有'}">checked</uiForFind:if>>加入共产党申请书</td>
		</tr>
		<tr>
			<td>5</td>
			<td><input type="checkbox" name="partyVoluntary" value="有" <uiForFind:if test="${uiForFind.partyVoluntary == '有'}">checked</uiForFind:if>>加入共产党志愿书</td>
		</tr>
		<tr>
			<td>6</td>
			<td><input type="checkbox" name="admission" value="有" <uiForFind:if test="${uiForFind.admission == '有'}">checked</uiForFind:if>>转正报告</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="grades"></td>
			<td>成绩单</td>
			<td>7</td>
			<td><input type="checkbox" name="grade" value="有" <uiForFind:if test="${uiForFind.grade == '有'}">checked</uiForFind:if>>成绩总表</td>
		</tr>
		<tr>
			<td rowspan="5"><input type="checkbox" name="graduation"></td>
			<td rowspan="5">毕业材料</td>
			<td>8</td>
			<td><input type="checkbox" name="graduationForm" value="有"<uiForFind:if test="${uiForFind.graduationForm == '有'}">checked</uiForFind:if>>高等学校毕业登记表</td>
		</tr>
		<tr>
			<td>9</td>
			<td><input type="checkbox" name="employment" value="有"<uiForFind:if test="${uiForFind.employment == '有'}">checked</uiForFind:if>>就业通知书(报到证)</td>
		</tr>
		<tr>
			<td>10</td>
			<td><input type="checkbox" name="summary" value="有"<uiForFind:if test="${uiForFind.summary == '有'}">checked</uiForFind:if>>学年小结表</td>
		</tr>
		<tr>
			<td>11</td>
			<td><input type="checkbox" name="graduationCertificate" value="有" <uiForFind:if test="${uiForFind.graduationCertificate == '有'}">checked</uiForFind:if>>毕业证书复印件</td>
		</tr>
		<tr>
			<td>12</td>
			<td><input type="checkbox" name="diploma" value="有"<uiForFind:if test="${uiForFind.diploma == '有'}">checked</uiForFind:if>>学位证书复印件</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="examination"></td>
			<td>体检材料</td>
			<td>13</td>
			<td><input type="checkbox" name="physicalExamination" value="有"<uiForFind:if test="${uiForFind.physicalExamination == '有'}">checked</uiForFind:if>>毕业生体检表</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="rewardMaterial "></td>
			<td>奖励材料</td>
			<td>14</td>
			<td><input type="checkbox" name="reward" value="有"<uiForFind:if test="${uiForFind.reward == '有'}">checked</uiForFind:if>>奖励材料</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="punishingMateria"></td>
			<td>惩处材料</td>
			<td>15</td>
			<td><input type="checkbox" name="punish" value="有"<uiForFind:if test="${uiForFind.punish == '有'}">checked</uiForFind:if>>惩处材料</td>
		</tr>
		<tr>
			<td><input type="submit" value="保存"/></td>
		</tr>
	</table>
</form:form>
</uiForFind:forEach>
<%-- <form:form modelAttribute="student" action="saveUndergraduate?cardid=${student.cardid}" method="POST">
	<table class="mediumtable" align="center" border="1" cellpadding="3" cellspacing="0" width="65%" style="font-size:12px;">
		<tr align="center">
			<td colspan="3" >学号：${student.cardid}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			姓名：${student.stname}</td>
		</tr>	
		<tr>
			<td width="30%" colspan="2">序号</td>
			<td width="70" colspan="2">项目</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="uinfo" value="入学材料">入学材料</td>
			<td>1</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="高考有关材料" label="高考有关材料"/>
			</td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td rowspan="2"><input type="checkbox" name="enrolment" >党团材料</td>
			<td>2</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="团建材料" label="团建材料"/>
			</td>
		</tr>
		<tr>
			<td>3</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="党建材料" label="党建材料"/>
			</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="enrolment" >成绩单</td>
			<td>7</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="成绩总表" label="成绩总表"/>
			</td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td rowspan="5"><input type="checkbox" name="enrolment" >毕业材料</td>
			<td>8</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="高等学校毕业登记表" label="高等学校毕业登记表"/>
			</td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td>9</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="就业通知书" label="就业通知书"/>
			</td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td>10</td>
			<td>
			学年小结表&nbsp;&nbsp;<select name="summary" style="width:143px;">
					    	<option value="${student.summary}">${student.summary}</option>
					    	<option value="1份">1份</option>
					    	<option value="2份">2份</option>
					    	<option value="3份">3份</option>
					    	<c:forEach items="${requestScope.educations }" var="education">
					    		<option value="${education.id }">${education.name }</option>
					    	</c:forEach>
			</select>
			（请选择份数）
			<form:checkbox path="undergraduateInfo" value="学年小结表" label="学年小结表"/>
			</td>		
		</tr>
		<tr>
			<td>11</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="毕业证书复印件" label="毕业证书复印件"/>
			</td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td>12</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="学位证书复印件" label="学位证书复印件"/>
			</td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td><input type="checkbox" name="enrolment" >体检材料</td>
			<td>13</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="毕业生体检表" label="毕业生体检表"/>
			</td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td><input type="checkbox" name="enrolment" >奖励材料</td>
			<td>14</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="奖励材料" label="奖励材料"/>
			</td>
			<!-- <td>高考有关材料</td> -->
			
		</tr>
		<tr>
			<td><input type="checkbox" name="enrolment" >惩处材料</td>
			<td>15</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="惩处材料" label="惩处材料"/>
			</td>
			
			<!-- <td>高考有关材料</td> -->
		</tr>
		<tr>
			<td colspan="3">归档日期：<input type="text" name="udate" value=${student.udate }></td>
			<input type="text" name="udate" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日'})" class="Wdate" style="width:200px" />
		</tr>
		<tr>
			<td colspan="3">
				<a href="${pageContext.request.contextPath}/saveUndergraduate?cardid=${student.cardid}">保存</a>
			<input style="font-size:100%" type="submit" value="保存">
			</td>
		</tr>
	</table>
</form:form> --%>
</body>
</html>