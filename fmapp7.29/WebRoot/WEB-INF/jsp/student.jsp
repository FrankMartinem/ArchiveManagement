<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<%-- <link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" /> --%>
	<link rel="stylesheet" type="text/css" href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="/fmapp/css/test.css";type="text/css">
	<link rel="stylesheet" href="/fmapp/css/partyinfo.css";type="text/css">
	<style type="text/css">
		.mytable{
			display: inline-flex;
			margin-right:50px;
		}
		#tableWrapper{
			display: flex;
			/* flex-direction: column; */
  			position:absolute;
			/* left:60%; */
			top:17%;
			}
		#tableWrapper tr{
			margin-bottom: 1px;
			display:flex;
			justify-content:center;}
	</style>
	
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
	<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	       $(function(){
	    	   /** 获取上一次选中的部门数据 */
	    	   var boxs  = $("input[type='checkbox'][id^='box_']");

	    	   
	    	   /** 给全选按钮绑定点击事件  */
		    	$("#checkAll").click(function(){
		    		// this是checkAll  this.checked是true
		    		// 所有数据行的选中状态与全选的状态一致
		    		boxs.attr("checked",this.checked);
		    	})
		    	
	    	   /** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
		    	$("tr[id^='data_']").hover(function(){
		    		$(this).css("backgroundColor","#eeccff");
		    	},function(){
		    		$(this).css("backgroundColor","#ffffff");
		    	})
		    	
		    	
	    	   /** 删除员工绑定点击事件 */
	    	   $("#delete").click(function(){
	    		   /** 获取到用户选中的复选框  */
	    		   var checkedBoxs = boxs.filter(":checked");
	    		   if(checkedBoxs.length < 1){
	    			   $.ligerDialog.error("请选择一个需要删除的学生！");
	    		   }else{
	    			   /** 得到用户选中的所有的需要删除的ids */
	    			   var ids = checkedBoxs.map(function(){
	    				   return this.value;
	    			   })
	    			   
	    			   $.ligerDialog.confirm("确认要删除吗?","删除学生",function(r){
	    				   if(r){
	    					   // alert("删除："+ids.get());
	    					   // 发送请求
	    					   window.location = "${ctx }/removeStudent?ids=" + ids.get();
	    				   }
	    			   });
	    		   }
	    	   })
	       })
	</script>

</head>
<body>
<h2 style="margin-top:0px; position: absolute;font-size: 24px;left: 2%;top: 5%">学生查询</h2>
<table style="left:10%" width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
	  <!-- 查询区  -->
	  <%-- <tr><td style="position:absolute;left:172px;top:60px;">${sessionScope.lookup_list[0]}</td></tr> --%>	  
	  <tr valign="top">
	    <td height="30px">
		  <table style="font-size: 12px;"width="100%" border="0" cellpadding="0" cellspacing="3">
		    <tr>
			  <td>
			  	<form name="empform" method="post" id="empform" action="${pageContext.request.contextPath}/selectStudent">
				    <table width="100%" border="0" cellpadding="0" >
				     <%-- ${sessionScope.lookup_list[1]} --%>
					  <tr>				 
					  <td id = "tableWrapper"></td>
					    	<!-- <td style="position:absolute;left:172px;top:60px;" class="tablehook">姓名：<input type="text" name="stname"></td>			    	
					    	<td style="position:absolute;left:592px;top:60px;" class="tablehook">学号：<input type="text" name="cardid"></td> -->
					  </tr>
					  <tr>
					   <!--  <td style="position:absolute;left:172px;top:90px;" class="tablehook">班级：<input type="text" name="clazzname"></td>
					    <td style="position:absolute;left:555px;top:90px;" class="tablehook">所属党支部：<input type="text" name="party"></td> -->
					    <td style="position:absolute; left:85%;top:17%;">
					    	<input type="submit" value="搜索"/>
					    	<input id="delete" type="button" value="删除"/>
					    </td>
					    
					    <td style="position:absolute;left:95%;top:17%;>
					    <a href="${ctx}/export">下载</a>
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
		  <table style="font-size:12px;width:100%;position:absolute;top:25%;  border:#c2c6cc 1px solid; border-collapse:collapse;" border="1" cellpadding="5" cellspacing="0" align="center">
		    <tr align="center">
			  <td width="5%"><input type="checkbox" name="checkAll" id="checkAll"></td>
			  	<td width="7%">学（工）号</td>
			  	<td width="7%">姓名</td>
			  <c:if  test ="${not empty property.property1}" >
			  	<td width="7%">${sessionScope.property.property1}</td>
			  </c:if>
			  <c:if  test ="${not empty property.property2}" >
			  	<td width="7%">${sessionScope.property.property2}</td>
			  </c:if>
			  <c:if  test ="${not empty property.property3}" >
			  	<td width="7%">${sessionScope.property.property3}</td>
			  </c:if>
			  <c:if  test="${not empty property.property4}" >
			  	<td width="7%">${sessionScope.property.property4}</td>
			  </c:if>
			  <c:if  test="${not empty property.property5}" >
			  	<td width="7%">${sessionScope.property.property5}</td>
			  </c:if>
			  <c:if  test="${not empty property.property6}" >
			  	<td width="7%">${sessionScope.property.property6}</td>
			  </c:if>
			  <c:if  test="${not empty property.property7}" >
			  	<td width="7%">${sessionScope.property.property7}</td>
			  </c:if>
			  <c:if  test="${not empty property.property8}" >
			  	<td width="7%">${sessionScope.property.property8}</td>
			  </c:if>
			  <c:if  test="${not empty property.property9}" >
			  	<td width="7%">${sessionScope.property.property9}</td>
			  </c:if>
			  <c:if  test="${not empty property.property10}" >
			  	<td width="7%">${sessionScope.property.property10}</td>
			  </c:if>
			  <td colspan="5" align="center" width="60%">操作</td>
			</tr>
			<c:forEach items="${requestScope.studentss}" var="student" varStatus="stat">
				<tr id="data_${stat.index}" width="100%" border="1" cellpadding="5" cellspacing="0" style="font-size:100%; font-family:"黑体";">
					<td><input type="checkbox" id="box_${stat.index}" value="${student.id}"></td>
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
					  <td align="center" width="7%;">
					  <a href="${ctx}/updateStudent?flag=1&id=${student.id}">修改基本信息
							<%-- <img title="修改" src="${ctx}/images/update.gif"/> --%></a>
					  </td>
					  <td align="center" width="8%;">
					  <a href="${pageContext.request.contextPath}/findUiByCardid?cardid=${student.cardid}">查询学生档案</a>&nbsp;&nbsp;&nbsp; 
					  </td>
					  <td align="center" width="8%;">
					  <a href="${pageContext.request.contextPath}/findPiByCardid?cardid=${student.cardid}">查询党建档案</a>&nbsp;&nbsp;&nbsp; 
					  </td>
					  <td align="center" width="10%;">
					  <a href="${pageContext.request.contextPath}/autoAddUFileForm?cardid=${student.cardid}">智能增添学生档案</a>&nbsp;&nbsp;&nbsp; 
					  </td>
					  <td align="center" width="10%;">
					  <a href="${pageContext.request.contextPath}/autoAddPFileForm?cardid=${student.cardid}">智能增添党建档案</a>&nbsp;&nbsp;&nbsp; 
					  </td>
				</tr>
			</c:forEach>
		  </table>
		</td>
	  </tr>
	  <!-- 分页标签 -->
	  <tr valign="top"><td align="center" style="position:absolute;right:3%;top:95%;align:right;">
	  	 <fkjava:pager
	  	        pageIndex="${requestScope.pageModel.pageIndex}" 
	  	        pageSize="${requestScope.pageModel.pageSize}" 
	  	        recordCount="${requestScope.pageModel.recordCount}" 
	  	        style="digg"
	  	        submitUrl="${ctx}/selectStudent?pageIndex={0}"/>
	  </td></tr>
	</table>
	<div style="height:10px;"></div>
	
		<script type="text/javascript">	
		var myformat = function(){
			var wrapper = document.getElementById("tableWrapper");
			var formatter = {
				"学号": "cardid",
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