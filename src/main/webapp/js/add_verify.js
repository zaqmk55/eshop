/**
 * Created by xiaohuang on 2018/9/26.
 */

    $(function () {
        jQuery.validator.addMethod("isMobile", function(value, element) {
                var tel = /^1[35789]\d{9}$/;
                return this.optional(element) || (tel.test(value));},
            "号码格式错误");

        $("#reg_form").validate({
            errorPlacement:function (error, element) {
                if(element.is(":radio")){
                    error.appendTo(element.parent().parent());
                }else if(element.is(":checkbox")){
                    error.appendTo(element.next());
                }else {
                    element.after(error)
                }
            },
            errorElement:"lable",
            rules:{
                username:{
                    required:true,
                },
                password:{
                    required:true,
                },
                repassword:{
                    equalTo:"#inputPassword3"
                },
                email:{
                    email:true
                },
                telephone:{
                    isMobile:true
                },
                name:"required",
                sex:"required",
                verifycode:"required",
                birthday:{
                    date:true
                }
            },
            messages:{
                username:{
                    required:"用户名不为空"
                },
                password:{
                    required:"密码不为空"
                },
                repassword:{
                    equalTo:"与密码不一致"
                },
                email:{
                    email:"请输入正确的邮箱格式"
                },
                telephone:{
                    isMobile:true
                },
                name:"姓名不为空",
                sex:"性别不为空",
                verifycode:"验证码不为空",
                birthday:{
                    date:"日期格式错误"
                }
            }
        })

        $("#login_form").validate({
            errorPlacement:function (error, element) {
                if(element.is(":radio")){
                    error.appendTo(element.parent().parent());
                }else if(element.is(":checkbox")){
                    error.appendTo(element.next());
                }else {
                    element.after(error)
                }
            },
            errorElement:"span",
            rules:{
                username:"required",
                password:"required",
                verifycode:"required"
            },
            messages:{
                username:"用户名不为空",
                password:"密码不为空",
                verifycode:"验证码不为空"
            }
        })
    })