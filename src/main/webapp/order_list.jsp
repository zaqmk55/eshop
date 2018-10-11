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
				<strong>�ҵĶ���</strong>
				<table class="table table-bordered">
					<c:forEach var="map" items="${sessionScope.MyOrderListMap}">
					<tbody>
						<tr class="success">
							<th colspan="5">�������:${map.key}</th>
						</tr>
						<tr class="warning">
							<th>ͼƬ</th>
							<th>��Ʒ</th>
							<th>�۸�</th>
							<th>����</th>
							<th>С��</th>
						</tr>
						<c:forEach var="myorderlist" items="${map.value}">
						<tr class="active">
							<td width="60" width="40%"><input type="hidden" name="id"
								value="22"> <img src="${myorderlist.pimage}" width="70"
								height="60"></td>
							<td width="30%"><a target="_blank"> ${myorderlist.pname}</a></td>
							<td width="20%">��${myorderlist.shop_price}</td>
							<td width="10%">${myorderlist.count}</td>
							<td width="15%"><span class="subtotal">��${myorderlist.subtotal}</span></td>
						</tr>
						</c:forEach>
					</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
		<div style="text-align: center;">
			<ul class="pagination">
				<li class="disabled"><a href="#" aria-label="Previous"><span
						aria-hidden="true">&laquo;</span></a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">6</a></li>
				<li><a href="#">7</a></li>
				<li><a href="#">8</a></li>
				<li><a href="#">9</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</div>
	</div>
	<!-- ����footer.jsp -->
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>

</html>