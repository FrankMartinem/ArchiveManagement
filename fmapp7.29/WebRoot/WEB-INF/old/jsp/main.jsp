<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
<link rel="stylesheet" href="/fmapp/css/css.css"  type="text/css"> 
</head>
<frameset rows="80,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="${ctx}/jsp/top.jsp" name="title" scrolling="no" noresize="noresize" >
  <frameset cols="220,*" frameborder="no" border="0" framespacing="0">
    <frame src="${ctx}/jsp/left.jsp" name="tree" scrolling="no" marginheight="0" marginwidth="0">
    <frame src="${ctx}/jsp/right.jsp" name="main" scrolling="yes" frameborder="0" marginwidth="0" marginheight="0" noresize="noresize">
  </frameset>
</frameset>
<body>

</body>
</html>	