<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>第一个 Highcharts 图表</title>
</head>

<body>
  <form action="${ctx}/upload?flag=basic" method="post" enctype="multipart/form-data">
    <p style="position:absolute;top:0%;left:5%;font-size:24px;color:#1262b3;">统计分析</p>
      <table style="position:absolute;top:15%;left:5%;font-size:12px;color:#1262b3;">
      <tr>
          <td>属性选择 <select name="chooseIn" id="chooseIn">
            <option value=1>性别</option>
            <option value=2>班级</option>
            <option value=3>档案位置</option>
        </select>
      </td>
        <td>图表类型 <select name="chooseType" id="chooseType">
            <option value="line">折线图</option>
            <option value="column">柱状图</option>
            <option value="pie">饼图</option>
        </select>
        </td>
      </tr>
      </table>
  </form>
</form>
  <!-- <form action="${ctx}/upload?flag=basic" method="post" enctype="multipart/form-data"> -->
    <!-- <input  type="submit" value="生成图表"> -->
      <input style="position:absolute; left:75%;top:15%; width:100px;height:20px;margin: 3px;line-height: 20px;"type="button" value="生成图表" id="saveBtn" onclick="display();" />
  </form>
  <!-- 图表容器 DOM -->
  <div id="container" style="position:absolute; left:20%;top:30%; width: 600px;height:400px;"></div>
  <!-- 引入 highcharts.js -->
  <script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
  <script>
    function display(){
          // 图表配置
      var options = {
        chart: {
          type: 'column'                          //指定图表的类型，默认是折线图（line）
        },
        title: {
          text: '统计图表'                 // 标题
        },
        xAxis: {
          categories: ['数字一所', '数字二所', '数字三所']   // x 轴分类
        },
        yAxis: {
          title: {
            text: '数量'                // y 轴标题
          }
        },
        series: [{ data: []}]
        // series: [{                              // 数据列
        //   data: [15, 10, 14]                     // 数据
        // }]
      };
      //options.chart.type= ${student.type};
      
      options.chart.type=document.getElementById("chooseType").value;
      var dataIn=document.getElementById("chooseIn").value;
      // options.series[0].data=[15,21,4];
      if(options.chart.type!="pie")
      {
        if(dataIn==1)
        {
          options.xAxis.categories=['男','女'];
          options.series[0].data=[29,16];
        }
        else if(dataIn==2)
        {
          options.xAxis.categories=['测控1501班','测控1502班','测控1601班','测控1601班'];
          options.series[0].data=[11,10,12,12];
        }
        else
        {
          options.xAxis.categories=['A1','A2','A3'];
          options.series[0].data=[15,12,18];
        }
      }
      else
      {
        if(dataIn==1)
        {
          options.series[0].data[0]=['男',29];
          options.series[0].data[1]=['女',16];
        }
        else if(dataIn==2)
        {
          options.series[0].data[0]=['测控1501班',11];
          options.series[0].data[1]=['测控1502班',10];
          options.series[0].data[2]=['测控1601班',12];
          options.series[0].data[3]=['测控1601班',12];
        }
        else
        {
          options.series[0].data[0]=['A1',15];
          options.series[0].data[1]=['A2',12];
          options.series[0].data[2]=['A3',18];
        }        
      }

      // 图表初始化函数
      var chart = Highcharts.chart('container', options);
    }
  </script>
</body>

</html>