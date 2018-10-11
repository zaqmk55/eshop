/**
 * Created by xiaohuang on 2018/9/26.
 */

    $(function () {
        jQuery.validator.addMethod("isMobile", function(value, element) {
                var tel = /^1[35789]\d{9}$/;
                return this.optional(element) || (tel.test(value));},
            "�����ʽ����");

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
                    required:"�û�����Ϊ��"
                },
                password:{
                    required:"���벻Ϊ��"
                },
                repassword:{
                    equalTo:"�����벻һ��"
                },
                email:{
                    email:"��������ȷ�������ʽ"
                },
                telephone:{
                    isMobile:true
                },
                name:"������Ϊ��",
                sex:"�Ա�Ϊ��",
                verifycode:"��֤�벻Ϊ��",
                birthday:{
                    date:"���ڸ�ʽ����"
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
                username:"�û�����Ϊ��",
                password:"���벻Ϊ��",
                verifycode:"��֤�벻Ϊ��"
            }
        })
    })