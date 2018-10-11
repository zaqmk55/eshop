/**
 * Created by xiaohuang on 2018/9/27.
 */
$(function () {
    $("#username").blur(function () {
        if($("#username").val()==""){
            $("#usererror").html("")
        }else {
            var xmlreq = new XMLHttpRequest();
            xmlreq.onreadystatechange=function () {
                if (xmlreq.readyState==4){
                    if (xmlreq.status==200){
                        if (xmlreq.responseText === "yes"){
                            $("#usererror").html("可以注册 XP");
                        } else {
                            $("#usererror").html("不能注册");
                        }
                    }
                }
            }
            var $un = $("#username").val();
            xmlreq.open("POST", "/user");
            xmlreq.setRequestHeader("CONTENT-TYPE", "application/x-www-form-urlencoded");
            xmlreq.send("method=checkName&username=" + $un);
        }
    })
})