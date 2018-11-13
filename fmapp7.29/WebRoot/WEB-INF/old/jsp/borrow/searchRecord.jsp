<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link rel="stylesheet" href="/fmapp/css/brrow.css";type="text/css">
	<link rel="stylesheet" href="/fmapp/css/test.css";type="text/css">
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
<title>借阅管理</title>
</head>
<body>
<h3 style="position:absolute;left:25%;top:10%;width:50%;height:10%;font-size:300%;">借阅记录</h3>
	<table style="position:absolute;top:15%;"width="100%" height="90%" border="0" cellpadding="5"
		cellspacing="0">
		<tr valign="top">
			<td height="20">
				<form name="visitorform" method="post" id="visitorform"
					action="${pageContext.request.contextPath}/selectVistor">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td style="position:absolute;top:5%; left:5%">档案姓名：</td>
							<td style="position:absolute;top:5%;left:10%"><input type="text" name="sname" size="13"></td>	
							<td style="position:absolute;top:5%; left:25%">档案学号：</td>
							<td style="position:absolute;top:5%;left:30%"><input type="text" name="sid" size="13"></td>			
						</tr>
						<tr>
							<%-- <td class="font3">专业： <select name="major"
								style="width:143px;">
									<option value="0">--请选择专业--</option>.
									<c:forEach items="${requestScope.majors }" var="major">
										<option value="${major.name }">${major.name }</option>
									</c:forEach>
							</select>
							</td>
							<td class="font3">班号： <select name="clazz"
								style="width:143px;">
									<option value="0">--请选择班号--</option>
									<c:forEach items="${requestScope.clazznums }" var="clazznum">
										<option value="${clazznum.name }">${clazznum.name }</option>
									</c:forEach>
							</select>&nbsp; --%> 
						<td style="position:absolute; top:5%; left:45%">借阅人：</td>
						<td style="position:absolute; top:5%;left:50%"><input type="text" name="visitorName" size="13"></td>
							<td style="position:absolute; top:5%; left:65%">借出时间：</td>
							<td style="position:absolute; top:4%; left:75%"><input type="text" name="date" size="13"
								onclick="WdatePicker({dateFmt:'yyyy年MM月dd日 '})"
								class="Wdate" /> 
							</td>
							<td style="position:absolute; top:4%; left:95%"><input  type="submit"
								value="搜索" /> <!-- <input id="delete" type="button" value="删除"/> --></td>
						</tr>
					</table>
				</form>
				<table style="position:absolute;top:10%;left:0;"width="100%" border="1" cellpadding="3" cellspacing="0"
					style="border:#c2c6cc 1px solid; border-collapse:collapse;">
					<tr align="center">
						<td>档案姓名</td>
						<td>档案学号</td>
						<td>借阅人</td>
						<td>借阅人联系方式</td>
						<td>借出时间</td>
						<td>归还时间</td>
						<td>档案类型</td>
						<td>备注</td>
					</tr style="font-size:12px;">
					<c:forEach items="${visitors}" var="visitor" varStatus="stat">
						<tr id="data_${stat.index}" align="center">
						<td>${visitor.sname}</td>
						<td>${visitor.sid}</td>
						<td>${visitor.visitorName }</td>
						<td>${visitor.visitorPhone}</td>
						<td>${visitor.date}</td>
						<td>${visitor.backdate}</td>
						<td>${visitor.unifoType}</td>
						<td>${visitor.remark}</td>
						<%-- <td>${visitor.education}</td>
						<td>${visitor.major}</td>
						<td>${visitor.clazz}</td> --%>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
	<div style="height:10px;"></div>
</body>
</html>