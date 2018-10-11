<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>��Ա��¼</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
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
</style>
</head>

<body>
	<!-- ����header.jsp -->
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>��������</strong>
				<table class="table table-bordered">
					<tbody>
						<tr class="warning">
							<th colspan="5">${requestScope.oid}</th>
						</tr>
						<tr class="warning">
							<th>ͼƬ</th>
							<th>��Ʒ</th>
							<th>�۸�</th>
							<th>����</th>
							<th>С��</th>
						</tr>
						<c:forEach var="cart" items="${sessionScope.cartMap}">
						<tr class="active">
							<td width="60" width="40%"><input type="hidden" name="id"
								value="22"> <img src="${cart.value.pimage}" width="70"
								height="60"></td>
							<td width="30%"><a target="_blank">${cart.value.pname}</a></td>
							<td width="20%">��${cart.value.shop_price}</td>
							<td width="10%">${cart.value.count}</td>
							<td width="15%"><span class="subtotal">��${cart.value.count*cart.value.shop_price}</span></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div style="text-align: right; margin-right: 120px;">
				��Ʒ���: <strong style="color: #ff6600;">��${requestScope.total}Ԫ</strong>
			</div>
		</div>


		<form class="form-horizontal" action="/order" method="post" id="orderForm"
			  style="margin-top: 5px; margin-left: 150px;">
			<input type="hidden" name="method" value="confirmorder">
			<input type="hidden" name="oid" value="${requestScope.oid}">
			<input type="hidden" name="total" value="${requestScope.total}">


			<div>
			<hr />
				<div class="form-group">
					<label for="address" class="col-sm-1 control-label">��ַ</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="address" name="address">
					</div>
				</div>
				<div class="form-group">
					<label for="username" class="col-sm-1 control-label">�ջ���</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="username" name="name">
					</div>
				</div>
				<div class="form-group">
					<label for="telephone" class="col-sm-1 control-label">�绰</label>
					<div class="col-sm-5">
						<input type="tel" class="form-control" id="telephone" name="telephone">
					</div>
				</div>
			<hr />
			<div style="margin-top: 5px; margin-left: 150px;">
				<strong>ѡ�����У�</strong>
				<p>
					<br /> <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C"
						checked="checked" />�������� <img src="./bank_img/icbc.bmp"
						align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
						name="pd_FrpId" value="BOC-NET-B2C" />�й����� <img
						src="./bank_img/bc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="ABC-NET-B2C" />ũҵ���� <img
						src="./bank_img/abc.bmp" align="middle" /> <br /> <br /> <input
						type="radio" name="pd_FrpId" value="BOCO-NET-B2C" />��ͨ���� <img
						src="./bank_img/bcc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="PINGANBANK-NET" />ƽ������
					<img src="./bank_img/pingan.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CCB-NET-B2C" />�������� <img
						src="./bank_img/ccb.bmp" align="middle" /> <br /> <br /> <input
						type="radio" name="pd_FrpId" value="CEB-NET-B2C" />������� <img
						src="./bank_img/guangda.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C" />��������
					<img src="./bank_img/cmb.bmp" align="middle" />
				</p>
				<hr />
				<p style="text-align: right; margin-right: 100px;">
					<a href="javascript:document.getElementById('orderForm').submit();">
						<img src="./images/finalbutton.gif" width="204" height="51"
						border="0" />
					</a>
				</p>
				<hr />
			</div>
		</div>


		</form>


	</div>

	<!-- ����footer.jsp -->
	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>