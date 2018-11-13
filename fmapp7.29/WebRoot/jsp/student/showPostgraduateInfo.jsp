<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/fmapp/css/test.css";type="text/css">
<link rel="stylesheet" href="/fmapp/css/student.css";type="text/css">
</head>
<body>
<form:form modelAttribute="student" action="showUndergraduate" method="POST">
	<table border="1" align="center" width="65%">
		<tr>
			<td colspan="2">学号：<td>
			<td colspan="1">${student.cardid}</td>
		</tr>	
		<tr>
			<td width=30% colspan="2">序号</td>
			<td width=70% colspan="1">项目</td>
		</tr>
		<tr>
			<td rowspan="10"><input type="checkbox" name="pinfo" value="入学材料">入学材料</td>
			<td>1</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="高考招生登记表" label="高考招生登记表"/>
			</td>		
		</tr>
		<tr>
			<td>2</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="保送生招生登记表" label="保送生招生登记表"/>
			</td>
		</tr>
		<tr>
			<td>3</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="报考硕士学位研究生（单独考试）登记表" label="报考硕士学位研究生（单独考试）登记表"/>
			</td>
		</tr>
		<tr>
			<td>4</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="免试推荐攻读硕士学位研究生登记表" label="免试推荐攻读硕士学位研究生登记表"/>
			</td>
		</tr>
		<tr>
			<td>5</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="报考博士学位研究生登记表" label="报考博士学位研究生登记表"/>
			</td>
		</tr>
		<tr>
			<td>6</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="在职攻读硕士学位报名资格审查表" label="在职攻读硕士学位报名资格审查表"/>
			</td>
		</tr>
		<tr>
			<td>7</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="报考博士学位研究生二位专家推荐书" label="报考博士学位研究生二位专家推荐书"/>
			</td>
		</tr>
		<tr>
			<td>8</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="报考单独考试硕士学位研究生二位专家推荐书" label="报考单独考试硕士学位研究生二位专家推荐书"/>
			</td>
		</tr>
		<tr>
			<td>9</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="研究生新生登记表" label="研究生新生登记表"/>
			</td>
		</tr>
		<tr>
			<td>10</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="在校硕士生提前攻读博士学位研究生申请表" label="在校硕士生提前攻读博士学位研究生申请表"/>
			</td>
		</tr>
		<tr>
			<td rowspan="2"><input type="checkbox" name="enrolment" >党团派材料</td>
			<td>11</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="团建材料" label="团建材料"/>
			</td>
		</tr>
		<tr>
			<td>12</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="党建材料" label="党建材料"/>
			</td>
		</tr>
		<tr>
			<td rowspan="6"><input type="checkbox" name="enrolment" >成绩单</td>
			<td>19</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="高中（中专）生阶段成绩单" label="高中（中专）生阶段成绩单"/>
			</td>
		</tr>
		<tr>
			<td>20</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="本科（专科）生阶段成绩单" label="本科（专科）生阶段成绩单"/>
			</td>
		</tr>
		<tr>
			<td>21</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="硕士研究生阶段成绩单" label="硕士研究生阶段成绩单"/>
			</td>
		</tr>
		<tr>
			<td>22</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="同等学力须有国家统考科目成绩合格证书复印件" label="同等学力须有国家统考科目成绩合格证书复印件"/>
			</td>
		</tr>
		<tr>
			<td>23</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="申请硕士学位须有研究生课程进修成绩单" label="申请硕士学位须有研究生课程进修成绩单"/>
			</td>
		</tr>
		<tr>
			<td>24</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="博士研究生阶段成绩单" label="博士研究生阶段成绩单"/>
			</td>
		</tr>
		<tr>
			<td rowspan="3"><input type="checkbox" name="enrolment" >学位材料</td>
			<td>25</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="申请硕士学位（同等学力、专业学位）申请书" label="申请硕士学位（同等学力、专业学位）申请书"/>
			</td>
		</tr>
		<tr>
			<td>26</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="申请博士学位（同等学力）申请书" label="申请博士学位（同等学力）申请书"/>
			</td>
		</tr>
		<tr>
			<td>27</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="学位授予证明（或学位证书复印件）" label="学位授予证明（或学位证书复印件）"/>
			</td>
		</tr>
		<tr>
			<td rowspan="6"><input type="checkbox" name="enrolment" >毕业材料</td>
			<td>28</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="本、专科毕业登记表" label="本、专科毕业登记表"/>
			</td>
		</tr>
		<tr>
			<td>29</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="本、专科就业派遣通知" label="本、专科就业派遣通知"/>
			</td>
		</tr>
		<tr>
			<td>30</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="硕士生毕业登记表" label="硕士生毕业登记表"/>
			</td>
		</tr>
		<tr>
			<td>31</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="硕士生就业派遣通知" label="硕士生就业派遣通知"/>
			</td>
		</tr>
		<tr>
			<td>32</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="博士生毕业登记表" label="博士生毕业登记表"/>
			</td>
		</tr>
		<tr>
			<td>33</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="博士生就业派遣通知" label="博士生就业派遣通知"/>
			</td>
		</tr>
		<tr>
			<td rowspan="3"><input type="checkbox" name="enrolment" >体检材料</td>
			<td>34</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="新生入学体检表" label="新生入学体检表"/>
			</td>
		</tr>
		<tr>
			<td>35</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="复查体检表" label="复查体检表"/>
			</td>
		</tr>
		<tr>
			<td>36</td>
			<td>
			<form:checkbox path="undergraduateInfo" value="研究生毕业体检表" label="研究生毕业体检表"/>
			</td>
		</tr>
		<tr>
			<td colspan="3">归档日期：<input type="text" name="udate" value=${student.udate }></td>
		</tr>
		<tr>
			<td colspan="3">
				<a href="${pageContext.request.contextPath}/editUndergraduate?cardid=${student.cardid}">编辑档案</a>
				
			</td>
		</tr>
	</table>
	</form:form>
</body>
</html>