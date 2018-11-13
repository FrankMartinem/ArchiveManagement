<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>人事管理系统 ——后台管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	</head>
<body>
	<div style="margin:10px;background-color:#FFFFFF; text-align:left;">
		<table width="200" height="100%" border="0" cellpadding="0" cellspacing="0" class="left_nav_bg">
	  
		  <tr><td id="navbg1" class="left_nav_closed" ><div class="font1">档案管理</div></td></tr>
		  <tr valign="top">
		    <td class="left_nav_bgshw" height="50">
			  <p class="left_nav_link"><img src="${ctx}/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx}/selectStudent" target="main">学生查询</a></img></p>
			  <p class="left_nav_link"><img src="${ctx}/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx}/addStudent?flag=1" target="main">添加学生</a></img></p>
			  <p class="left_nav_link"><img src="${ctx}/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx}/showAutoAddStudent" target="main">智能添加学生</a></img></p>
			</td>
		  </tr>
		  <tr><td height="2"></td></tr>
		  
		  <tr><td id="navbg2" class="left_nav_closed" ><div class="font1">借阅管理</div></td></tr>
		  <tr valign="top">
		    <td class="left_nav_bgshw" height="50">
			  <p class="left_nav_link"><img src="${ctx}/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx}/selectLoanStudent" target="main">借阅情况管理</a></img></p>
			  <p class="left_nav_link"><img src="${ctx}/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx}/selectVisitorForm" target="main">借阅记录查询</a></img></p>
			</td>
		  </tr>
		  <tr><td height="2"></td></tr>
		  
		  <tr><td id="navbg2" class="left_nav_closed" ><div class="font1">设置</div></td></tr>
		  <tr valign="top">
		    <td class="left_nav_bgshw" height="50">
			  <p class="left_nav_link"><img src="${ctx}/images/left_nav_arrow.gif">&nbsp;&nbsp;<a href="${ctx}/setProp" target="main">个性化设置</a></img></p>
			</td>
		  </tr>
		  <tr><td height="2"></td></tr>

		  <tr><td height="10"><img src="${ctx}/images/left_nav_bottom.gif" height="10"></img></td></tr>
		  <tr><td height="10" bgcolor="#e5f0ff">&nbsp;</td></tr>
		</table>
	</div>
</body>
</html>