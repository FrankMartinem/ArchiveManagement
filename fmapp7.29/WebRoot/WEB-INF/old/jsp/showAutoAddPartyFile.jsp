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
    <script src="http://libs.baidu.com/jquery/1.6.4/jquery.min.js"></script>
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
                            url: "${ctx}/addFileByImage",
                            data: { type: "pixel", image: canvas.toDataURL("image/png") },
                            dataType: "html",
                            success: function (data) {
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
                            url: "${ctx}/addFileByImage",
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
        <form action="${ctx}/upload?flag=p&cardid=${cardid }" id="studentForm" method="post">
            <!-- éèè¡¨åï¼flagè¡¨ç¤ºæ·»å æ è®° -->
            <input type="hidden" name="flag" value="2">
            <table width="100%" border="0" cellpadding="0" cellspacing="10">
                

            </table>
           <!--  <tr>
                <input style="position:absolute; left:35%;top:25%; width:70px;height:25px;" type="submit" value="添加">&nbsp;&nbsp;
              "WebRoot/WEB-INF/jsp/addStudentFromImage.jsp"  <input style="position:absolute; left:60%;top:25%; width:70px;height:25px;" type="reset" value="取消">
            </tr> -->
        </form>

        <form action="${ctx}/upload?flag=p&cardid=${cardid }" method="post" enctype="multipart/form-data">
            <p style="position:absolute;top:35%;left:12%;font-size:24px;color:#1262b3;">导入档案</p>
            <!-- <p style="position:absolute;left:12%;top:40%;font-size:15px;">è¯·ä¸ä¼ å¾çï¼</p> -->
            <input style="position:absolute; left:75%;top:56%; width:800px;height:100px;" type="file" name="imageFile" />
            <input style="position:absolute; left:75%;top:68%; width:120px;height:50px;margin: 3px;" type="submit" value="加载图片">
        </form>
    </table>
    
</body>

<body>
    <div id="webcam"></div>
    <div class="btn">
        <input type="button" value="拍照" id="saveBtn" onclick="savePhoto();" />
        <input type="button" value="清除" id="delBtn" onclick="delPhoto();" />
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
            left:12%;
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
            height: auto;
            margin: 5px 0px;
            position:absolute; 
            left:60%;
            top:50%;
        }

        .btn input[type=button] {
            width: 120px;
            height: 50px;
            line-height: 10px;
            margin: 30px;
        }
    </style>
</body>

</html>