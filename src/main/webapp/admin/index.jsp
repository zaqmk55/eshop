<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>�����̳ǹ�������</title>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href="${pageContext.request.contextPath }/css/general.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" />

<style type="text/css">
body {
  color: white;
}
</style>
</head>
<body style="background: #278296">
<center></center>
<form method="post" action="${pageContext.request.contextPath }/admin/home.jsp" target="_parent" name='theForm' onsubmit="return validate()">
  <table cellspacing="0" cellpadding="0" style="margin-top: 100px" align="center">
  <tr>
    <td style="padding-left: 50px">
      <table>
      <tr>
        <td>����Ա������</td>
        <td><input type="text" name="username" /></td>
      </tr>
      <tr>
        <td>����Ա���룺</td>
        <td><input type="password" name="password" /></td>
      </tr>
      <tr><td>&nbsp;</td><td><input type="submit" value="�����������" class="button" /></td></tr>
      </table>
    </td>
  </tr>
  </table>
</form>
<script language="JavaScript">
<!--
  document.forms['theForm'].elements['username'].focus();
  
  /**
   * �������������
   */
  function validate()
  {
    var validator = new Validator('theForm');
    validator.required('username', user_name_empty);
    //validator.required('password', password_empty);
    if (document.forms['theForm'].elements['captcha'])
    {
      validator.required('captcha', captcha_empty);
    }
    return validator.passed();
  }
//-->
</script>
</body>