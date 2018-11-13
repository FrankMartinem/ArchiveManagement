<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<title>借阅人借出信息录入</title>
<link rel="stylesheet" href="/fmapp/css/test.css";type="text/css">
<link rel="stylesheet" href="/fmapp/css/brrow.css";type="text/css">
</head>
<body>
<form id="loan" name="loan" action="${pageContext.request.contextPath}/addBack" method="post">
		<table align="center" border="1" cellpadding="3" cellspacing="0" style="position:absolute; width:65%; left:20%; top:10%; color:#000000">
			<tr style="height:30px">
				<th colspan="2" style="color:#000000">归还信息管理</th>
			</tr>
			<tr style="height:30px">
				<td colspan="2" style="color:#000000">归还档案信息</td>
			</tr>
				<tr style="height:30px">	
					<td>学生姓名：</td>
					<td><input type="text" name="sname" value="${requestScope.student.stname}"></td>
				</tr>
				<tr style="height:30px">	
					<td>学号：</td>
					<td><input type="text" name="sid" value="${requestScope.student.cardid}"></td>
				</tr>
				<td style="height:30px">档案类型：</td>
				<td><select name="unifoType" style="width:143px;">
						<option value="0">--档案类型--</option>
						<option value="党建档案">党建档案</option>
						<option value="学生档案">学生档案</option>
				</select></td>
				<tr style="height:30px"><td><input type="hidden" name ="state" value="在册"><td></tr>
				<tr style="height:30px"><td><input type="hidden" name ="pstate" value="在册"><td></tr>
				<tr style="height:30px"><td><input type="hidden" name ="id" value="${requestScope.student.id}"><td></tr>
			<tr style="height:30px">
				<td colspan="2" style="color:#000000">归还人信息</td>
			</tr>
			<td style="height:30px"><input type="hidden" name="id" value="${requestScope.visitor.id}"></td>
			<tr style="height:30px">
				<td>姓名：</td>
				<td><input type="text" name="backName" value="${requestScope.visitors.visitorName}"></td>
			</tr>
			<tr style="height:30px">
				<td>联系电话：</td>
				<td><input type="text" name="backPhone" value="${requestScope.visitors.visitorPhone}"></td>
			</tr>
			<tr style="height:30px">
				<td>归还时间：</td>
				<th>
					<input type="text" name="backdate" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分'})" class="Wdate" style="width:200px"/>
				</th>
			</tr>
			<tr style="height:30px">
			<td colspan="2"><input type="submit" value="保存"></td>
			</tr>
		</table>
	</form>
</body>
</html>