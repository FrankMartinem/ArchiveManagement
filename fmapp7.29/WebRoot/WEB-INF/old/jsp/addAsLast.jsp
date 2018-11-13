<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/fmapp/css/test.css";type="text/css">
<link rel="stylesheet" href="/fmapp/css/partyinfo.css";type="text/css">
</head>
<body>
<body>
<div id="top">
<p class=toptitle>学生档案管理系统</p>
</div>
<div id="left">
<table class="lefttable">
<tr><td style="font-size:200%;">档案管理</td></tr>
<tr><td style="font-size:150%;">学生查询</td></tr>
<tr><td style="font-size:150%;">添加学生</td></tr>
<tr><td></td></tr>
<tr><td style="font-size:200%;">借阅管理</td></tr>
<tr><td style="font-size:150%;"><a href="${ctx}/selectLoanStudent">借阅情况管理</a></td></tr>
<tr><td style="font-size:150%;"><a href="${ctx}/selectVistorForm">借阅记录查询</a></td></tr>
</table>
</div>
<div id="mainwindow">
<table width="15%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
	<td ><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：员工管理  &gt; 添加员工</td>
	<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="${ctx}/addStudent" id="studentForm" method="post">
		 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table class="toptable">
		    		<tr>
		    			<td class="font3 fftd">学号：<input type="text" name="cardid" id="cardid" size="20"/></td>
		    			<td class="font3 fftd">姓名：<input type="text" name="stname" id="stname" size="20"/></td>
		    			<td class="font3 fftd">手机号码：<input type="text" name="phone" id="phone" size="20"/></td>
		    			<td class="font3 fftd">性别：
									<select name="gender" style="width:143px;">
					    			<option value="0">${sessionScope.student.gender}</option>
					    			<option value="男">男</option>
					    			<option value="女">女</option>
					    			</select>
					    </td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">学历：
		    			 <select name="education_id" style="width:143px;">
					    			<option value="${sessionScope.student.education.id}">${sessionScope.student.education.name}</option>
					    			<c:forEach items="${sessionScope.educations }" var="education">
					    				<option value="${sessionScope.education.id }">${sessionScope.education.name }</option>
					    			</c:forEach>
					    		</select>
					    </td>
					    <td class="font3 fftd">年级：
		    			 <select name="grade_id" style="width:143px;">
					    			<option value="${sessionScope.student.grade.id}">${sessionScope.student.grade.name}</option>
					    			<c:forEach items="${sessionScope.grades }" var="grade">
					    				<option value="${sessionScope.grade.id }">${sessionScope.grade.name }</option>
					    			</c:forEach>
					    		</select>
					    </td>
					    <td class="font3 fftd">专业：
		    			 <select name="major_id" style="width:143px;">
					    			<option value="${sessionScope.student.major.id}">${sessionScope.student.major.name}</option>
					    			<c:forEach items="${sessionScope.majors }" var="major">
					    				<option value="${sessionScope.major.id }">${sessionScope.major.name }</option>
					    			</c:forEach>
					    		</select>
					    </td>
					    <td class="font3 fftd">班号：
		    			 <select name="clazznum_id" style="width:143px;">
					    			<option value="${sessionScope.student.clazznum.id}">${sessionScope.student.clazznum.name}</option>
					    			<c:forEach items="${sessionScope.clazznums }" var="clazznum">
					    				<option value="${sessionScope.clazznum.id }">${sessionScope.clazznum.name }</option>
					    			</c:forEach>
					    		</select>
					    </td>
		    		</tr>
		    </table>
		    </td></tr>
	<table class="addtable" align="center" border="1" width="65%">
		<tr>
			<td><input type="checkbox" name="uinfo" >入学材料</td>
			<td>1</td>
			<td><input type="checkbox" name="uinfo" value="高考有关材料" >高考有关材料</td>
			<!-- <td>高考有关材料</td> -->
		</tr>
		<tr>
			<td rowspan="5"><input type="checkbox" name="party">参加党派材料</td>
			<td>2</td>
			<td><input type="checkbox" name="uinfo" value="加入共青团申请书" >加入共青团申请书</td>
			<!-- <td>加入共青团申请书</td> -->
		</tr>
		<tr>
			<td>3</td>
			<td><input type="checkbox" name=uinfo value="加入共青团志愿书" >加入共青团志愿书</td>
		</tr>
		<tr>
			<td>4</td>
			<td><input type="checkbox" name="uinfo" value="加入共产党申请书" >加入共产党申请书</td>
		</tr>
		<tr>
			<td>5</td>
			<td><input type="checkbox" name="uinfo" value="加入共产党志愿书" >加入共产党志愿书</td>
		</tr>
		<tr>
			<td>6</td>
			<td><input type="checkbox" name="uinfo" value="转正报告" >转正报告</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="grades">成绩单</td>
			<td>7</td>
			<td><input type="checkbox" name="uinfo" value="成绩总表" >成绩总表</td>
		</tr>
		<tr>
			<td rowspan="5"><input type="checkbox" name="graduation">毕业材料</td>
			<td>8</td>
			<td><input type="checkbox" name="uinfo" value="高等学校毕业登记表">高等学校毕业登记表</td>
		</tr>
		<tr>
			<td>9</td>
			<td><input type="checkbox" name="uinfo" value="就业通知书(报到证)">就业通知书(报到证)</td>
		</tr>
		<tr>
			<td>10</td>
			<td><input type="checkbox" name="uinfo" value="学年小结表">学年小结表</td>
		</tr>
		<tr>
			<td>11</td>
			<td><input type="checkbox" name="uinfo" value="毕业证书复印件" >毕业证书复印件</td>
		</tr>
		<tr>
			<td>12</td>
			<td><input type="checkbox" name="uinfo" value="学位证书复印件">学位证书复印件</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="examination" value="有">体检材料</td>
			<td>13</td>
			<td><input type="checkbox" name="uinfo" value="毕业生体检表">毕业生体检表</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="rewardMaterial" value="有">奖励材料</td>
			<td>14</td>
			<td><input type="checkbox" name="uinfo" value="奖励材料">奖励材料</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="punishingMateria" value="有">惩处材料</td>
			<td>15</td>
			<td><input type="checkbox" name="uinfo" value="惩处材料">惩处材料</td>
		</tr>
		<tr>
			<td colspan="3">归档日期：<input type="text" name="udate"></td>
		</tr>
		
		</table>
			<tr><td>
			<input class="btn" style="top:70%;left:30%;"type="submit" value="添加">&nbsp;&nbsp;
			<input class="btn" style="top:70%;left:40%;"type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</div>
</body>
</html>