<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %> --%>
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
<title>Insert title here</title>
</head>
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
<tr><td style="font-size:150%;">借阅查询</td></tr>
</table>
</div>
<div id="mainwindowLarge">
<table width="15%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：学生管理  &gt; 添加学生</td>
	<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="${ctx}/addPostgraduate" id="studentForm" method="post">
		 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table class="toptablew">
		    		<tr>
			    	<td style="position:absolute;top:-30px;left:-270px"><a href="${ctx}/addAsLast">按上次信息添加</a></td>
			    	</tr>
		    		<tr>
		   
		    			<td class="font3 fftd">学号：<input type="text" name="cardid" id="cardid" size="20"/></td>
		    			<td class="font3 fftd">姓名：<input type="text" name="stname" id="stname" size="20"/></td>
		    			<td class="font3 fftd">手机号码：<input type="text" name="phone" id="phone" size="20"/></td>
		    			<td class="font3 fftd">性别：
									<select name="gender" style="width:143px;">
					    			<option value="${sessionScope.student.gender}">${sessionScope.student.gender}</option>
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
	<table class="addtable" border="1" align="center" width=65%>
		<tr>
			<td colspan="2">序号</td>
			<td colspan="2">项目</td>
		</tr>
		<tr>
			<td rowspan="10"><input type="checkbox" name="pinfo" value="入学材料">入学材料</td>
			<td>1</td>
			<td>
			<input type="checkbox" name="uinfo" value="高考招生登记表" label="高考招生登记表"/>高考招生登记表
			</td>		
		</tr>
		<tr>
			<td>2</td>
			<td>
			<input type="checkbox"  name="uinfo" value="保送生招生登记表" label="保送生招生登记表"/>保送生招生登记表
			</td>
		</tr>
		<tr>
			<td>3</td>
			<td>
			<input type="checkbox" name="uinfo" value="报考硕士学位研究生（单独考试）登记表" label="报考硕士学位研究生（单独考试）登记表"/>报考硕士学位研究生（单独考试）登记表
			</td>
		</tr>
		<tr>
			<td>4</td>
			<td>
			<input type="checkbox" name="uinfo" value="免试推荐攻读硕士学位研究生登记表" label="免试推荐攻读硕士学位研究生登记表"/>免试推荐攻读硕士学位研究生登记表
			</td>
		</tr>
		<tr>
			<td>5</td>
			<td>
			<input type="checkbox" name="uinfo" value="报考博士学位研究生登记表" label="报考博士学位研究生登记表"/>报考博士学位研究生登记表
			</td>
		</tr>
		<tr>
			<td>6</td>
			<td>
			<input type="checkbox" name="uinfo" value="在职攻读硕士学位报名资格审查表" label="在职攻读硕士学位报名资格审查表"/>在职攻读硕士学位报名资格审查表
			</td>
		</tr>
		<tr>
			<td>7</td>
			<td>
			<input type="checkbox" name="uinfo" value="报考博士学位研究生二位专家推荐书" label="报考博士学位研究生二位专家推荐书"/>报考博士学位研究生二位专家推荐书
			</td>
		</tr>
		<tr>
			<td>8</td>
			<td>
			<input type="checkbox" name="uinfo" value="报考单独考试硕士学位研究生二位专家推荐书" label="报考单独考试硕士学位研究生二位专家推荐书"/>报考单独考试硕士学位研究生二位专家推荐书
			</td>
		</tr>
		<tr>
			<td>9</td>
			<td>
			<input type="checkbox" name="uinfo" value="研究生新生登记表" label="研究生新生登记表"/>研究生新生登记表
			</td>
		</tr>
		<tr>
			<td>10</td>
			<td>
			<input type="checkbox" name="uinfo" value="在校硕士生提前攻读博士学位研究生申请表" label="在校硕士生提前攻读博士学位研究生申请表"/>在校硕士生提前攻读博士学位研究生申请表
			</td>
		</tr>
		<tr>
			<td rowspan="8"><input type="checkbox" name="enrolment" >参加党派材料</td>
			<td>11</td>
			<td>
			<input type="checkbox" name="uinfo" value="加入共青团申请书" label="加入共青团申请书"/>加入共青团申请书
			</td>
		</tr>
		<tr>
			<td>12</td>
			<td>
			<input type="checkbox" name="uinfo" value="加入共青团志愿书" label="加入共青团志愿书"/>加入共青团志愿书
			</td>
		</tr>
		<tr>
			<td>13</td>
			<td>
			<input type="checkbox" name="uinfo" value="加入共产党申请书" label="加入共产党申请书"/>加入共产党申请书
			</td>
		</tr>
		<tr>
			<td>14</td>
			<td>
			<input type="checkbox" name="uinfo" value="加入共产党志愿书" label="加入共产党志愿书"/>加入共产党志愿书
			</td>
		</tr>
		<tr>
			<td>15</td>
			<td>
			<input type="checkbox" name="uinfo" value="转正报告" label="转正报告"/>转正报告
			</td>
		</tr>
		<tr>
			<td>16</td>
			<td>
			<input type="checkbox" name="uinfo" value="党员民主评议表" label="党员民主评议表"/>党员民主评议表
			</td>
		</tr>
		<tr>
			<td>17</td>
			<td>
			<input type="checkbox" name="uinfo" value="参加民主党派申请书" label="参加民主党派申请书"/>参加民主党派申请书
			</td>
		</tr>
		<tr>
			<td>18</td>
			<td>
			<input type="checkbox" name="uinfo" value="参加民主党派登记表" label="参加民主党派登记表"/>参加民主党派登记表
			</td>
		</tr>
		<tr>
			<td rowspan="6"><input type="checkbox" name="enrolment" >成绩单</td>
			<td>19</td>
			<td>
			<input type="checkbox" name="uinfo" value="高中（中专）生阶段成绩单" label="高中（中专）生阶段成绩单"/>高中（中专）生阶段成绩单
			</td>
		</tr>
		<tr>
			<td>20</td>
			<td>
			<input type="checkbox" name="uinfo" value="本科（专科）生阶段成绩单" label="本科（专科）生阶段成绩单"/>本科（专科）生阶段成绩单
			</td>
		</tr>
		<tr>
			<td>21</td>
			<td>
			<input type="checkbox" name="uinfo" value="硕士研究生阶段成绩单" label="硕士研究生阶段成绩单"/>硕士研究生阶段成绩单
			</td>
		</tr>
		<tr>
			<td>22</td>
			<td>
			<input type="checkbox" name="uinfo" value="同等学力须有国家统考科目成绩合格证书复印件" label="同等学力须有国家统考科目成绩合格证书复印件"/>同等学力须有国家统考科目成绩合格证书复印件
			</td>
		</tr>
		<tr>
			<td>23</td>
			<td>
			<input type="checkbox" name="uinfo" value="申请硕士学位须有研究生课程进修成绩单" label="申请硕士学位须有研究生课程进修成绩单"/>申请硕士学位须有研究生课程进修成绩单
			</td>
		</tr>
		<tr>
			<td>24</td>
			<td>
			<input type="checkbox" name="uinfo" value="博士研究生阶段成绩单" label="博士研究生阶段成绩单"/>博士研究生阶段成绩单
			</td>
		</tr>
		<tr>
			<td rowspan="3"><input type="checkbox" name="enrolment" >学位材料</td>
			<td>25</td>
			<td>
			<input type="checkbox" name="uinfo" value="申请硕士学位（同等学力、专业学位）申请书" label="申请硕士学位（同等学力、专业学位）申请书"/>申请硕士学位（同等学力、专业学位）申请书
			</td>
		</tr>
		<tr>
			<td>26</td>
			<td>
			<input type="checkbox" name="uinfo" value="申请博士学位（同等学力）申请书" label="申请博士学位（同等学力）申请书"/>申请博士学位（同等学力）申请书
			</td>
		</tr>
		<tr>
			<td>27</td>
			<td>
			<input type="checkbox" name="uinfo" value="学位授予证明（或学位证书复印件）" label="学位授予证明（或学位证书复印件）"/>学位授予证明（或学位证书复印件）
			</td>
		</tr>
		<tr>
			<td rowspan="6"><input type="checkbox" name="enrolment" >毕业材料</td>
			<td>28</td>
			<td>
			<input type="checkbox" name="uinfo" value="本、专科毕业登记表" label="本、专科毕业登记表"/>本、专科毕业登记表
			</td>
		</tr>
		<tr>
			<td>29</td>
			<td>
			<input type="checkbox" name="uinfo" value="本、专科就业派遣通知" label="本、专科就业派遣通知"/>本、专科就业派遣通知
			</td>
		</tr>
		<tr>
			<td>30</td>
			<td>
			<input type="checkbox" name="uinfo" value="硕士生毕业登记表" label="硕士生毕业登记表"/>硕士生毕业登记表
			</td>
		</tr>
		<tr>
			<td>31</td>
			<td>
			<input type="checkbox" name="uinfo" value="硕士生就业派遣通知" label="硕士生就业派遣通知"/>硕士生就业派遣通知
			</td>
		</tr>
		<tr>
			<td>32</td>
			<td>
			<input type="checkbox" name="uinfo" value="博士生毕业登记表" label="博士生毕业登记表"/>博士生毕业登记表
			</td>
		</tr>
		<tr>
			<td>33</td>
			<td>
			<input type="checkbox" name="uinfo" value="博士生就业派遣通知" label="博士生就业派遣通知"/>博士生就业派遣通知
			</td>
		</tr>
		<tr>
			<td rowspan="3"><input type="checkbox" name="enrolment" >体检材料</td>
			<td>34</td>
			<td>
			<input type="checkbox" name="uinfo" value="新生入学体检表" label="新生入学体检表"/>新生入学体检表
			</td>
		</tr>
		<tr>
			<td>35</td>
			<td>
			<input type="checkbox" name="uinfo"  value="复查体检表" label="复查体检表"/>复查体检表
			</td>
		</tr>
		<tr>
			<td>36</td>
			<td>
			<input type="checkbox" name="uinfo" value="研究生毕业体检表" label="研究生毕业体检表"/>研究生毕业体检表
			</td>
		</tr>
		<tr>
			<td colspan="3">归档日期：<input type="text" name="udate" value=${student.udate }></td>
		</tr>
		</table>
			<input class="btn" style="top:90%;left:50%;" type="submit" value="添加">&nbsp;&nbsp;
			<input class="btn" style="top:90%;left:60%;" type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</div>
</body>
</html>