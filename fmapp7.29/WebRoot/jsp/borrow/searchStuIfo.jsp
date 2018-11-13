<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
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
	
	<style type="text/css">
		.mytable{
			display: inline-flex;
			margin-right:50px;
		}
		#tableWrapper{
			display: flex;
			flex-direction: column;
			}
		#tableWrapper tr{
			margin-bottom: 20px;
			display:flex;
			justify-content:center;}
	</style>
	
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
<title>借阅管理</title>
<script type="text/javascript">
	$(
			function() {
				/** 获取上一次选中的部门数据 */
				var boxs = $("input[type='checkbox'][id^='box_']");

				/** 给全选按钮绑定点击事件  */
				$("#checkAll").click(function() {
					// this是checkAll  this.checked是true
					// 所有数据行的选中状态与全选的状态一致
					boxs.attr("checked", this.checked);
				})

				/** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
				$("tr[id^='data_']").hover(function() {
					$(this).css("backgroundColor", "#eeccff");
				}, function() {
					$(this).css("backgroundColor", "#ffffff");
				})

				/** 删除员工绑定点击事件 */
				$("#delete")
					.click(
						function() {
							/** 获取到用户选中的复选框  */
							var checkedBoxs = boxs.filter(":checked");
							if (checkedBoxs.length < 1) {
								$.ligerDialog.error("请选择一个需要删除的员工！");
								} else {
								/** 得到用户选中的所有的需要删除的ids */
								var ids = checkedBoxs.map(function() {
									return this.value;
									})

									$.ligerDialog
									.confirm(
											"确认要删除吗?",
											"删除员工",
									function(r) {
										if (r) {
										// alert("删除："+ids.get());
										// 发送请求
										window.location = "${ctx }/employee/removeEmployee?ids="
															+ ids
															.get();
														}
									});
									}
								})
			})
</script>
</head>
<body>
	<!-- <h3 class="wsearch" style="top:5%;align:center;width:100%;height:100%">查询档案</h3> -->
	<input type="hidden" name="flag" value="2">
	<table width="100%" height="90%" border="0" cellpadding="5"
		cellspacing="0">
		<!-- 查询区  -->
		<tr valign="top">
			<td height="30">
				<table width="100%" border="0" cellpadding="0" cellspacing="10">
					<tr>
						<td>
							<form name="stuform" method="post" id="stuform"
								action="${pageContext.request.contextPath}/selectLoanStudent">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									 <tr>
									 <td id = "tableWrapper"></td>
					    	<!-- <td class="winput" style="top:15%; left:5%">姓名：</td>
					    	<td class="winput" style="top:15%; left:25%">学号：</td>
					    	<td class="input" style="top:15%; left:10%;"><input type="text" name="stname" size="13"></td>
					    	<td class="input" style="top:15%; left:30%"><input type="text" name="cardid" size="13"></td>	 -->
					  </tr>
					  <tr>
					    <!-- <td class="winput" style="top:15%; left:45%">班级：</td>
					    <td class="input" style="top:15%; left:50%"><input type="text" name="clazzname" size="13"></td>
					    <td class="winput" style="top:15%; left:65%">所属党支部：</td>
					    <td class="input" style="top:15%; left:75%"><input type="text" name="party" size="13"></td>
					    <td class="btn" style="top:15%; left:95%" > -->
					    <input type="submit" value="搜索" /> <!-- <input id="delete" type="button" value="删除"/> -->
						</td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<!-- 数据展示区 -->
		<tr valign="top">
			<td height="20">
				<table class="stutable" style="top:20%;left:0;" width="100%" border="1" cellpadding="3" cellspacing="0"
					style="border:#c2c6cc 1px solid; border-collapse:collapse;">
					<tr align="center">
						<td>学号</td>
			  			<td>姓名</td>
					  <c:if  test ="${not empty property.property1}" >
					  	<td>${sessionScope.property.property1}</td>
					  </c:if>
					  <c:if  test ="${not empty property.property2}" >
					  	<td>${sessionScope.property.property2}</td>
					  </c:if>
					  <c:if  test ="${not empty property.property3}" >
					  	<td>${sessionScope.property.property3}</td>
					  </c:if>
					  <c:if  test="${not empty property.property4}" >
					  	<td>${sessionScope.property.property4}</td>
					  </c:if>
					  <c:if  test="${not empty property.property5}" >
					  	<td>${sessionScope.property.property5}</td>
					  </c:if>
					  <c:if  test="${not empty property.property6}" >
					  	<td>${sessionScope.property.property6}</td>
					  </c:if>
					  <c:if  test="${not empty property.property7}" >
					  	<td>${sessionScope.property.property7}</td>
					  </c:if>
					  <c:if  test="${not empty property.property8}" >
					  	<td>${sessionScope.property.property8}</td>
					  </c:if>
					  <c:if  test="${not empty property.property9}" >
					  	<td>${sessionScope.property.property9}</td>
					  </c:if>
					  <c:if  test="${not empty property.property10}" >
					  	<td>${sessionScope.property.property10}</td>
					  </c:if>
					  	<td>学生档案状态</td>
						<td>党建档案状态</td>
						<td colspan="4" align="center">操作</td>
					</tr>
					<c:forEach items="${studentss}" var="student" varStatus="stat">
						<tr id="data_${stat.index}"align="center">
							<td>${student.cardid }</td>
						  	<td>${student.stname }</td>
						  <c:if  test ="${not empty property.property1}" >
						  	<td>${student.param1}</td>
						  </c:if>
						  <c:if  test ="${not empty property.property2}" >
						  	<td>${student.param2}</td>
						  </c:if>
						  <c:if  test ="${not empty property.property3}" >
						  	<td>${student.param3}</td>
						  </c:if>
						  <c:if  test="${not empty property.property4}" >
						  	<td>${student.param4}</td>
						  </c:if>
						  <c:if  test="${not empty property.property5}" >
						  	<td>${student.param5}</td>
						  </c:if>
						  <c:if  test="${not empty property.property6}" >
						  	<td>${student.param6}</td>
						  </c:if>
						  <c:if  test="${not empty property.property7}" >
						  	<td>${student.param7}</td>
						  </c:if>
						  <c:if  test="${not empty property.property8}" >
						  	<td>${student.param8}</td>
						  </c:if>
						  <c:if  test="${not empty property.property9}" >
						  	<td>${student.param9}</td>
						  </c:if>
						  <c:if  test="${not empty property.property10}" >
						  	<td>${student.param10}</td>
						  </c:if>
							<td>${student.state}</td>
							<td>${student.pstate}</td>
							<!-- <td align="center" width="200px;"> --><td><a
								href="${pageContext.request.contextPath}/findUiByCardid?cardid=${student.cardid}">查询学生档案</a></td>&nbsp;&nbsp;
								<td><a
								href="${pageContext.request.contextPath}/findPiByCardid?cardid=${student.cardid}">查询党建档案</a></td>&nbsp;&nbsp;
								<td><a
								href="${pageContext.request.contextPath}/loan?cardid=${student.cardid}">借出</a></td>&nbsp;&nbsp;
								<td><a
								href="${pageContext.request.contextPath}/back?cardid=${student.cardid}">归还</a></td>&nbsp;&nbsp;
							<!-- </td> -->
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr valign="top"><td align="center" style="position:absolute;right:3%;top:70%;align:right;">
	  	 <fkjava:pager
	  	        pageIndex="${requestScope.pageModel.pageIndex}" 
	  	        pageSize="${requestScope.pageModel.pageSize}" 
	  	        recordCount="${requestScope.pageModel.recordCount}" 
	  	        style="digg"
	  	        submitUrl="${ctx}/selectLoanStudent?pageIndex={0}&education_id=${student.education.id }&grade_id=${student.grade.id }&major_id=${student.major.id }&clazznum_id=${student.clazznum.id }"/>
	  </td></tr>
	</table>
	
	<script type="text/javascript">	
		var myformat = function(){
			var wrapper = document.getElementById("tableWrapper");
			var formatter = {
				"学（工）号": "cardid",
				"姓名": "stname",
				"${property.property1}": "param1",
				"${property.property2}": "param2",
				"${property.property3}": "param3",
				"${property.property4}": "param4",
				"${property.property5}": "param5",
				"${property.property6}": "param6",
				"${property.property7}": "param7",
				"${property.property8}": "param8",
				"${property.property9}": "param9",
				"${property.property10}": "param10"
			}
			//console.log(wrapper);
			//var hooker = document.getElementsByClassName("tablehook");
			//console.log(hooker);
			var list = "${property.plookup}";
			var arr = list.split(',');
			var trr;
			arr.forEach(function(single, index){
				var tdd = document.createElement('td');
				tdd.innerHTML = single + ":";
				tdd.setAttribute("class", "mytable")
				var inputt = document.createElement('input');
				inputt.setAttribute("type","text");
				//inputt.setAttribute("name", "stname");
				var inputname;
				Object.keys(formatter).forEach(function(key){
					if(key === single){
						inputname = formatter[key]
					}
				});
				inputt.setAttribute("name", inputname);

				//for(var i=0; i<formatter.leng)
				if(index % 2 === 0){
					trr = document.createElement('tr');
				}
				tdd.appendChild(inputt);
				trr.appendChild(tdd);
				wrapper.appendChild(trr);
			})
			
		}
		
		myformat();
		
	</script>
</body>
</html>