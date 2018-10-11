<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>�̳ǹ��ﳵ</title>
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

		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">��������</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>ͼƬ</th>
								<th>��Ʒ</th>
								<th>�۸�</th>
								<th>����</th>
								<th>С��</th>
								<th>����</th>
							</tr>
							<c:forEach var="cart" items="${sessionScope.cartMap}">
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${cart.value.pimage}" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> ${cart.value.pname}</a>
								</td>
								<td width="20%">
									��${cart.value.shop_price}
								</td>
								<td width="10%">
									<input type="text" name="quantity" value="${cart.value.count}" maxlength="4" size="10">
								</td>
								<td width="15%">
									<span class="subtotal">��${cart.value.count*cart.value.shop_price}</span>
								</td>
								<td>
									<a href="/product?method=deleteCart&pid=${cart.value.pid}" class="delete">ɾ��</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					<em style="color:#ff6600;">
				��¼��ȷ���Ƿ������Ż�&nbsp;&nbsp;
			</em> ���ͻ���: <em style="color:#ff6600;">596</em>&nbsp; ��Ʒ���: <strong style="color:#ff6600;">��596.00Ԫ</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<form action="/order" method="post">
						<input type="hidden" name="method" value="submitorder">
					<a href="order_info.htm" id="clear" class="clear">��չ��ﳵ</a>
					<a href="order_info.htm">
						<input type="submit" width="100" value="�ύ����" name="submit" border="0" style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
					</a>
					</form>
				</div>
			</div>


		</div>

		<!-- ����footer.jsp -->
		<jsp:include page="footer.jsp"></jsp:include>

	</body>

</html>