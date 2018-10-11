<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>��Աע��</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.js"></script>
<script type="text/javascript" charset="gbk" src="js/add_verify.js"></script>
<script type="text/javascript" charset="gbk" src="js/checkName.js"></script>
<!-- �����Զ���css�ļ� style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
.error{
	color: red;
}
font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>

	<!-- ����header.jsp -->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>��Աע��</font>USER REGISTER
				<form  method="post" action = "/user" class="form-horizontal" style="margin-top: 5px;" id="reg_form">
					<input type="hidden" name="method" value="register">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">�û���</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
							name="username"	placeholder="�������û���">
							<span id="usererror"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">����</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="inputPassword3"
							name="password"	placeholder="����������">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">ȷ������</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd"
							name="repassword"	placeholder="������ȷ������">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="inputEmail3"
							name="email"	placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">�绰</label>
						<div class="col-sm-6">
							<input type="tel" class="form-control" id="inputTel"
								   name="telephone"	placeholder="tel">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">����</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="usercaption"
							name="name"	placeholder="����������">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">�Ա�</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio1" value="��">
								��
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio2" value="Ů">
								Ů
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">��������</label>
						<div class="col-sm-6">
							<input type="date" class="form-control" name="birthday">
						</div>
					</div>

					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">��֤��</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="verifycode">

						</div>
						<div class="col-sm-2">
							<img src="./image/captcha.jhtml" />
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="ע��" name="submit"
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- ����footer.jsp -->
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>




