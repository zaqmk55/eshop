<%--
  Created by IntelliJ IDEA.
  User: xiaohuang
  Date: 2018/9/27
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gbk" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        var xmlreq = new XMLHttpRequest();
        xmlreq.onreadystatechange=function () {

            if(xmlreq.readyState==4){
                if(xmlreq.status==200){
                    alert(xmlreq.responseText);
                }
            }
        }
//        调用get
//        xmlreq.open("GET","/AjaxServlet?name=hehe");
//        xmlreq.send(null);

//        调用post需要加编码格式说明,固定格式
        xmlreq.open("POST","/AjaxServlet");
        xmlreq.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
        xmlreq.send("name=hehe123");
    </script>
</head>
<body>
xx
</body>
</html>
