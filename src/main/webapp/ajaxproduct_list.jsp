<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/27
  Time: 16:14
  To change this template use File | Settings | File Templates.
  ʵ����껬����ǩ��ʾ��Ʒ�б�
--%>
<%@ page contentType="text/html;charset=gbk" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .subnav{
            float: left;
            list-style: none;
            border: solid 1px;
            padding: 5px 10px;
            margin: 0 10px;
        }
        .subnav a{
            text-decoration: none;
            color: black;
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".subnav").mouseover(function () {
                $.post("/product",{method:"AqueryByCid",cid:$(this).attr("id")},function (data) {
                    $("#content").empty();
                    for(var i = 0;i<data.length;i++){
                        $("#content").append(data[i].pname+"<br>");
                    }
                })
            })
        })
    </script>
</head>
<body>
<ul>
    <li class="subnav" id="1"><a href="javascript:void(0)">�ֻ�����</a> </li>
    <li class="subnav" id="2"><a href="javascript:void(0)">���԰칫</a> </li>
    <div style="clear: both"></div>
    <hr>
    <div id="content"></div>
</ul>
</body>
</html>
