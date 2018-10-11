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
			<div
				style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
				<a href="./index.htm">��ҳ&nbsp;&nbsp;&gt;</a> <a href="./�߲˷���.htm">�߲�&nbsp;&nbsp;&gt;</a>
				<a>�޹����߲�</a>
			</div>

			<div style="margin: 0 auto; width: 950px;">
				<div class="col-md-6">
					<img style="opacity: 1; width: 400px; height: 350px;" title=""
						class="medium"
						src="${product.pimage}">
				</div>

				<div class="col-md-6">
					<div>
						<strong>${product.pname}</strong>
					</div>
					<div
						style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
						<div>��ţ�${product.pid}</div>
					</div>

					<div style="margin: 10px 0 10px 0;">
						�ڼҼ�: <strong style="color: #ef0101;">����${product.shop_price}</strong> �� �� �ۣ�
						<del>��${product.market_price}</del>
					</div>

					<div style="margin: 10px 0 10px 0;">
						����: <a target="_blank" title="��ʱ���� (2014-07-30 ~ 2015-01-01)"
							style="background-color: #f07373;">��ʱ����</a>
					</div>

					<div
						style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
						<div style="margin: 5px 0 10px 0;">��ɫ</div>
						<form action="/product" method="post" >
							<input type="hidden" name="method" value="addCart">
							<input type="hidden" name="pid" value="${product.pid}">
						<div
							style="border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;">
							��������: <input id="quantity" name="quantity" value="1"
								maxlength="4" size="10" type="number" min="1">
						</div>

						<div style="margin: 20px 0 10px 0;; text-align: center;">
							 <input
								style="background: url('./images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;"
								value="���빺�ﳵ" type="submit">
							 &nbsp;�ղ���Ʒ
						</div>
						</form>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div style="width: 950px; margin: 0 auto;">
				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>��Ʒ����</strong>
				</div>

				<div>
					<img
						src="${product.pimage}">
				</div>

				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>��Ʒ����</strong>
				</div>
				<div style="margin-top: 10px; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th colspan="2">��������</th>
							</tr>
							<tr>
								<th width="10%">����</th>
								<td width="30%">��׼</td>
							</tr>
							<tr>
								<th width="10%">����</th>
								<td>500</td>
							</tr>
							<tr>
								<th width="10%">����</th>
								<td>200</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>��Ʒ����</strong></th>
							</tr>
							<tr class="warning">
								<th>������Ʒ������Ϣ <a>[������Ʒ����]</a></th>
							</tr>
						</tbody>
					</table>
				</div>

				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>��Ʒ��ѯ</strong></th>
							</tr>
							<tr class="warning">
								<th>������Ʒ��ѯ��Ϣ <a>[������Ʒ��ѯ]</a></th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>


	<!-- ����footer.jsp -->
	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>