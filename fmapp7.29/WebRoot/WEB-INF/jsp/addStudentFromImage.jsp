<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script src="http://libs.baidu.com/jquery/1.6.4/jquery.js"></script>
    <script type="text/javascript" src="/fmapp/js/jQuery-webcam-master/jquery.webcam.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var w = 320, h = 240;
            var pos = 0, ctx = null, saveCB, image = [];

            var canvas = document.createElement("canvas");
            canvas.setAttribute('width', w);
            canvas.setAttribute('height', h);

            console.log(canvas.toDataURL);
            if (canvas.toDataURL) {

                ctx = canvas.getContext("2d");

                image = ctx.getImageData(0, 0, w, h);

                saveCB = function (data) {

                    var col = data.split(";");
                    var img = image;

                    for (var i = 0; i < w; i++) {
                        var tmp = parseInt(col[i]);
                        img.data[pos + 0] = (tmp >> 16) & 0xff;
                        img.data[pos + 1] = (tmp >> 8) & 0xff;
                        img.data[pos + 2] = tmp & 0xff;
                        img.data[pos + 3] = 0xff;
                        pos += 4;
                    }

                    if (pos >= 4 * w * h) {
                        ctx.putImageData(img, 0, 0);
                        /* $.post("servlet/CatD", {type: "data", image: canvas.toDataURL("image/png")}, function(msg){
                            console.log("===="+eval(msg));
                            pos = 0;
                            $("#img").attr("src", msg+"");
                        }); */
                        $.ajax({
                            type: "post",
                            url: "${ctx}/addStudentByImage",
                            data: { type: "pixel", image: canvas.toDataURL("image/png") },
                            dataType: "html",
                            success:function (data) {
                                console.log("====" + data);
                                pos = 0;
                                $("#img").attr("src", "");
                                $("#img").attr("src", data);
                            }
                        });
                    }
                };

            } else {

                saveCB = function (data) {
                    image.push(data);

                    pos += 4 * w;

                    if (pos >= 4 * w * h) {
                        /* $.post("servlet/CatD", {type: "pixel", image: image.join('|')}, function(msg){
                            console.log("+++++"+eval(msg));
                            pos = 0;
                            $("#img").attr("src", msg+"");
                        }); */

                        $.ajax({
                            type: "post",
                            url: "${ctx}/addStudentByImage",
                            data: { type: "pixel", image: image.join('|') },
                            dataType: "json",
                            success: function (data) {
                                console.log("+++++" + eval(msg));
                                pos = 0;
                                $("#img").attr("src", msg + "");
                            }
                        });
                    }
                };
            }

            $("#webcam").webcam({
                width: w,
                height: h,
                mode: "callback",
                swffile: "js/jQuery-webcam-master/jscam_canvas_only.swf",

                onSave: saveCB,

                onCapture: function () {
                    webcam.save();
                },

                debug: function (type, string) {
                    console.log(type + ": " + string);
                }
            });
        });

        //拍照
        function savePhoto() {
            webcam.capture();
        }
        //清除
        function delPhoto() {
            $("#img").attr("src", "");
        }

    </script>


</head>

<body>
    <table style="position:absolute;" width="100%" height="90%" border="0" cellpadding="5" cellspacing="0">
        <form action="${ctx}/addStudent" id="studentForm" method="post">
            <!-- 隐藏表单，flag表示添加标记 -->
            <input type="hidden" name="flag" value="2">
            <table style="font-size: 12px;"width="100%" border="0" cellpadding="0" cellspacing="3">
                <tr>
                    <!-- <td style="position:absolute;top:5%;left:12%;font-size:24px;color:#1262b3;">单个添加</td> -->
                </tr>
                <tr>
                    <td style="position:absolute;top:17%;right:78%;">学（工）号：<input type="text" name="cardid" id="cardid"
                            value="${student.cardid }" size="20" /></td>
                    <td style="position:absolute;top:17%;right:58%;">姓名：<input type="text" name="stname" id="stname"
                            value="${student.stname }" size="20" /></td>
                    <c:if test="${not empty property.property1}">
                        <td style="position:absolute;top:17%;right:38%;">${property.property1}：<input type="text" name="param1"
                                id="param1" value="${student.param1 }" size="20" /></td>
                    </c:if>
                    <c:if test="${not empty property.property2}">
                        <td style="position:absolute;top:17%;right:18%;">${property.property2}：<input type="text" name="param2"
                                id="param2" value="${student.param2 }" size="20" /></td>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${not empty property.property3}">
                        <td style="position:absolute;top:22%;right:78%;">${property.property3}：<input type="text" name="param3"
                                id="param3" value="${student.param3 }" size="20" /></td>
                    </c:if>
                    <c:if test="${not empty property.property4}">
                        <td style="position:absolute;top:22%;right:58%;">${property.property4}：<input type="text" name="param4"
                                id="param4" value="${student.param4 }" size="20" /></td>
                    </c:if>
                    <c:if test="${not empty property.property5}">
                        <td style="position:absolute;top:22%;right:38%;">${property.property5}：<input type="text" name="param5"
                                id="param5" value="${student.param5 }" size="20" /></td>
                    </c:if>
                    <c:if test="${not empty property.property6}">
                        <td style="position:absolute;top:22%;right:18%;">${property.property6}：<input type="text" name="param6"
                                id="param6" value="${student.param6 }" size="20" /></td>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${not empty property.property7}">
                        <td style="position:absolute;top:27%;right:78%;">${property.property7}：<input type="text" name="param7"
                                id="param7" value="${student.param7 }" size="20" /></td>
                    </c:if>
                    <c:if test="${not empty property.property8}">
                        <td style="position:absolute;top:27%;right:58%;">${property.property8}：<input type="text" name="param8"
                                id="param8" value="${student.param8 }" size="20" /></td>
                    </c:if>
                    <c:if test="${not empty property.property9}">
                        <td style="position:absolute;top:27%;right:38%;">${property.property9}：<input type="text" name="param9"
                                id="param9" value="${student.param9 }" size="20" /></td>
                    </c:if>
                    <c:if test="${not empty property.property10}">
                        <td style="position:absolute;top:27%;right:18%;">${property.property10}：<input type="text" name="param10"
                                id="param10" value="${student.param10 }" size="20" /></td>
                    </c:if>
                </tr>
            </table>
            <tr>
                <input style="position:absolute; left:2%;top:35%; width:70px;height:25px;" type="submit" value="添加">&nbsp;&nbsp;
                <input style="position:absolute; left:20%;top:35%; width:70px;height:25px;" type="reset" value="取消 ">
            </tr>
        </form>

        <form action="${ctx}/upload?flag=basic" method="post" enctype="multipart/form-data">
            <h2 style="margin-top:0px; position: absolute;font-size: 24px;left: 2%;top: 5%">智能添加</h2>
            <!-- <p style="position:absolute;left:12%;top:40%;font-size:15px;">请上传图片：</p> -->
            <input style="position:absolute; left:75%;top:56%; width:200px;height:50px;" type="file" name="imageFile">
            <input type="button" style="position:absolute; left:75%;top:71%; margin: 3px;" type="submit" value="加载图片">
        </form>
    </table>
</body>

<body>
    <div id="webcam"></div>
    <div class="btn">
        <input type="button" value="拍照" id="saveBtn" onclick="savePhoto();" />
        <input type="button" style="position:absolute;top:103px;" value="删除" id="delBtn" onclick="delPhoto();" />
    </div>
    <div id="photos">
        <img src="" id="img">
    </div>
    <style type="text/css">
        #webcam {
            border: 1px solid #666666;
            width: 320px;
            height: 240px;
            position:absolute; 
            left:2%;
            top:50%;
        }

        #photos {
            border: 1px solid #666666;
            width: 320px;
            height: 240px;
            position:absolute; 
            left:35%;
            top:50%;
        }

        .btn {
             width: 120px; 
            /* height: auto; */
            margin: 5px 0px;
            position:absolute; 
            left:60%;
            top:51%;
        }

        .btn input[type=button] {
            width: 75px;
            /* height: 50px; */ 
            line-height: 10px;
            margin: 30px; 
        }
    </style>
</body>

</html>