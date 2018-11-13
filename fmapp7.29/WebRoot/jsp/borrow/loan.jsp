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
<%-- <font color="red">${requestScope.message }</font> --%>
<font color="red">${message }</font>
	<form id="loan" name="loan" action="${pageContext.request.contextPath}/insertVisitor"  method="post">
		<table align="center" border="1" cellpadding="3" cellspacing="0" style="position:absolute; width:65%; left:20%; top:10%; color:#000000">
			<tr>
				<th colspan="2" style="height:30px; color:#000000">借出信息管理</th>
			</tr>
			<tr>
				<td colspan="2" style="height:30px; color:#000000">借出档案信息</td>
			</tr>
				<tr>	
					<td style="height:30px;">学生姓名：</td>
					<td><input type="text" name="sname" value="${requestScope.student.stname}"></td>
				</tr>
				<tr>	
					<td style="height:30px;">学号：</td>
					<td><input type="text" name="sid" value="${requestScope.student.cardid}"></td>
				</tr>
				<tr>
				<td style="height:30px;">档案类型：</td>
				<td style="height:30px;"><select name="unifoType" style="width:143px;">
						<option value="0">--档案类型--</option>
						<option value="党建档案">党建档案</option>
						<option value="学生档案">学生档案</option>
				</select></td>
				</tr>
				<tr style="height:30px;">
					<td>备注：</td>
					<td><input type="text" name="remark"></td>
				</tr>
				<tr style="height:30px"><td><input type="hidden" name ="state" value="借出"><td></tr>
				<tr style="height:30px;"><td><input type="hidden" name ="pstate" value="借出"><td></tr>
				<tr style="height:30px;"><td><input type="hidden" name ="id" value="${requestScope.student.id}"><td></tr>
			<tr>
				<td  colspan="2" style="height:30px; color:#000000">借阅人信息</td>
			</tr>
			<tr>
				<td style="height:30px;">姓名：</td>
				<td><input type="text" name="visitorName"></td>
			</tr>
			<tr>
				<td style="height:30px;">联系电话：</td>
				<td><input type="text" name="visitorPhone"></td>
			</tr>
			<tr>
				<td style="height:30px;">借出时间：</td>
				<th>
					<input type="text" name="date" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分'})" class="Wdate" style="width:200px"/>
				</th>
			</tr>
			<tr>
			<td style="height:30px;" colspan="2"><input type="submit" value="保存"></td>
			</tr>
		</table>


	</form>
</body>
</html>