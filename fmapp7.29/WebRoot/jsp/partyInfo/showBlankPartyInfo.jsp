<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/fmapp/css/test.css";type="text/css">
<link rel="stylesheet" href="/fmapp/css/partyinfo.css";type="text/css">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="student" action="showUndergraduate" method="POST">
	<table border="1" align="center" width="65%">
		<tr align="center">
			<td colspan="3" >学号：${student.cardid}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			姓名：${student.stname}</td>
		</tr>
		<tr>
			<td>1</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="入党申请书" label="入党申请书"/>
			</td>
		</tr>
		<tr>
			<td>2</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="团组织推优表" label="团组织推优表"/>
			</td>
		</tr>
		<tr>
			<td>3</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="入党积极分子培养考察登记表" label="入党积极分子培养考察登记表"/>
			</td>
		</tr>
		<tr>
			<td>4</td>
			
			<td>入党积极分子思想汇报：
			<form:input path="into_report" readonly="true"  value="${student.into_report }" size="3"/>份
			</td>
		</tr>
		<tr>
			<td>5</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="党校入党积极分子培训班结业证书复印件" label="党校入党积极分子培训班结业证书复印件"/>
			</td>
		</tr>
		<tr>
			<td>6</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="确定发展对象群众座谈会议记录" label="确定发展对象群众座谈会议记录"/>
			</td>
		</tr>
		<tr>
			<td>7</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="发展对象函（外）调材料" label="发展对象函（外）调材料"/>
			</td>
		</tr>
		<tr>
			<td>8</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="发展对象政治审查综合表" label="发展对象政治审查综合表"/>
			</td>
		</tr>
		<tr>
			<td>9</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="发展对象 个人自传" label="发展对象 个人自传"/>
			</td>
		</tr>
		<tr>
			<td>10</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="入党志愿书" label="入党志愿书"/>
			</td>
		</tr>
		<tr>
			<td>11</td>
			
			<td>预备党员思想汇报：
			<form:input path="pre_report" readonly="true"  value="${student.pre_report }" size="3"/>份
			</td>
		</tr>
		<tr>
			<td>12</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="党校预备党员培训班结业证书复印件" label="党校预备党员培训班结业证书复印件"/>
			</td>
		</tr>
		<tr>
			<td>13</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="转正申请书" label="转正申请书"/>
			</td>
		</tr>
		<tr>
			<td>14</td>
			<td>
			<form:checkbox path="partyInfo" onclick="return false" value="其他相关材料" label="其他相关材料"/>
			</td>
		</tr>
		<tr>
			<td colspan="3">归档日期：<input type="text" readonly="true" name="pdate" value=${student.pdate }></td>
		</tr>
		<tr>
			<td colspan="3">
				<a href="${pageContext.request.contextPath}/editPartyInfo?cardid=${student.cardid}">编辑档案</a>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>