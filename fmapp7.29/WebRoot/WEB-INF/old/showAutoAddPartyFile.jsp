<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="${ctx}/upload?flag=p&cardid=${cardid }"   >
    
    <p style="position:absolute;top:55%;left:12%;font-size:24px;color:#1262b3;">智能添加</p>
	<p style="position:absolute;left:12%;top:60%;font-size:15px;">请上传图片：</p>
	<input style="position:absolute; left:35%;top:65%; width:300px;height:27px;" type="file" name="imageFile" />
	<input style="position:absolute; left:60%;top:65%; width:70px;height:25px;" type="submit" value="加载图片">
</form>
</body>
</html> 