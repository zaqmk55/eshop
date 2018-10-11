<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	width: 100%;
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


	<div class="row" style="width: 1210px; margin: 0 auto;">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="#">��ҳ</a></li>
			</ol>
		</div>
		<c:forEach var="product" items="${requestScope.productlist}">
		<div class="col-md-2">
			<a href="/product?pid=${product.pid}&method=queryByPid"> <img src="${product.pimage}"
				width="170" height="170" style="display: inline-block;"></a>
			<p>
				<a href="/product?pid=${product.pid}&method=queryByPid" style='color: green'>${product.pname}</a>
			</p>
			<p>
				<font color="#FF0000">�̳Ǽۣ�&yen;${product.market_price}</font>
			</p>
		</div>
		</c:forEach>

	</div>
	<!--��ҳ -->
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
		<ul class="pagination" style="text-align: center; margin-top: 10px;">
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
	<!-- ��ҳ���� -->

	<!--��Ʒ�����¼-->
	<div
		style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">

		<h4 style="width: 50%; float: left; font: 14px/30px ΢���ź�">�����¼</h4>
		<div style="width: 50%; float: right; text-align: right;">
			<a href="">more</a>
		</div>
		<div style="clear: both;"></div>

		<div style="overflow: hidden;">
			<c:forEach var="product" items="${sessionScope.productlistmap}">
			<ul style="list-style: none;">
				<li
					style="width: 150px; height: 216; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;"><img
					src="${product.value.pimage}" width="130px" height="130px" /></li>
			</ul>
			</c:forEach>
		</div>
	</div>
	<!-- ����footer.jsp -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>