<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- ��¼ ע�� ���ﳵ... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<c:choose>
				<c:when test="${not empty sessionScope.user}">
					<li>��ӭ${sessionScope.user.username}</li>
                    <li><a href="/user?method=logout">�˳�</a> </li>
				</c:when>
				<c:otherwise>
			<li><a href="login.jsp">��¼</a></li>
			<li><a href="register.jsp">ע��</a></li>
				</c:otherwise>
			</c:choose>
			<li><a href="cart.jsp">���ﳵ</a></li>
			<li><a href="/order?method=myOrderList">�ҵĶ���</a></li>
		</ol>
	</div>
</div>

<!-- ������ -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">��ҳ</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<%--<li class="active"><a href="product_list.htm">�ֻ�����<span class="sr-only">(current)</span></a></li>--%>
					<c:forEach items="${categorylist}" var="category">
						<li><a class="navbar-brand" href="/product?categorycid=${category.cid}&method=queryByCid"> ${category.cname}</a></li>
                    </c:forEach>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</nav>
</div>