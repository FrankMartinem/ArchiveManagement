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
<!-- 	<link rel="stylesheet" href="/fmapp/css/test.css";type="text/css">
	<link rel="stylesheet" href="/fmapp/css/partyinfo.css";type="text/css"> -->
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
<table class="toptable" style="left:10%" width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
	  <!-- 查询区  -->
	  <tr valign="top">
	    <td height="30">
		  <table style="font-size: 12px;"width="100%" border="0" cellpadding="0" cellspacing="3">
		    <tr>
			  <td>
			  	<form name="empform" method="post" id="empform" action="${pageContext.request.contextPath}/selectStudent">
				    <table width="80%" border="0" cellpadding="0" >
					  <tr>
					    	<td>姓名：<input type="text" name="stname"></td>
					    	<td style="position:absolute;left:29%;">学号：<input type="text" name="cardid"></td>
					  </tr>
					  <tr>
					    <td>班级：<input type="text" name="clazzname"></td>
					    <td>所属党支部：<input type="text" name="party"></td>
					    <td>
					    	<input type="submit" value="搜索"/>
					    	<input id="delete" type="button" value="删除"/>
					    </td>
					    
					    <td>
					    <a href="${ctx}/addStudent?flag=1">添加学生</a>&nbsp;&nbsp;
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
		  <table  width="80%" border="1" cellpadding="5" cellspacing="0" style="font-size:12px; border:#c2c6cc 1px solid; border-collapse:collapse;">
		    <tr align="center">
			  <td><input type="checkbox" name="checkAll" id="checkAll"></td>
			  <td>学号</td>
			  <td>姓名</td>
			  <td>手机号码</td>
			  <td>班级</td>
			  <td>所属党支部</td>
			  <td>档案位置</td>
			  <td colspan="3" align="center">操作</td>
			</tr>
			<c:forEach items="${requestScope.studentss}" var="student" varStatus="stat">
				<tr id="data_${stat.index}" width="80%" border="1" cellpadding="5" cellspacing="0" style="font-size:100%; font-family:"黑体";">
					<td><input type="checkbox" id="box_${stat.index}" value="${student.id}"></td>
					  <td>${student.cardid }</td>
					  <td>${student.stname }</td>
					  <td>${student.phone }</td>
					  <td>${student.clazzname }</td>
					  <td>${student.party }</td>
					  <td>${student.location }</td>
					  <td align="center" width="40px;">
					  <a href="${ctx}/updateStudent?flag=1&id=${student.id}">修改
							<%-- <img title="修改" src="${ctx}/images/update.gif"/> --%></a>
					  </td>
					  <td align="center" width="40px;">
					  <a href="${pageContext.request.contextPath}/findUiByCardid?cardid=${student.cardid}">查询学生档案</a>&nbsp;&nbsp;&nbsp; 
					  </td>
					  <td align="center" width="40px;">
					  <a href="${pageContext.request.contextPath}/findPiByCardid?cardid=${student.cardid}">查询党建档案</a>&nbsp;&nbsp;&nbsp; 
					  </td>
				</tr>
			</c:forEach>
		  </table>
		</td>
	  </tr>
	  <!-- 分页标签 -->
	  <tr valign="top"><td align="center" class="font3">
	  	 <fkjava:pager
	  	        pageIndex="${requestScope.pageModel.pageIndex}" 
	  	        pageSize="${requestScope.pageModel.pageSize}" 
	  	        recordCount="${requestScope.pageModel.recordCount}" 
	  	        style="digg"
	  	        submitUrl="${ctx}/selectStudent?pageIndex={0}&clazzname=${student.clazzname }&party=${student.party }"/>
	  </td></tr>
	</table>
	<div style="height:10px;"></div>
	
</body>
</html>