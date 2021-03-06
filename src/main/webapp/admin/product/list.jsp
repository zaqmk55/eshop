<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="gbk"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/admin/product/add.jsp";
			}
			$(function () {
				$.post("/admin/category",{method:"queryAll"},function (data) {
					var str ="";
					$(data).each(function () {
						str += "<option value="+this.cid+">"+this.cname+"</option>";
					})
					$("#category").append(str);
				})

				$("#listItem").change(function () {
					var v =$(this).children('option:selected').val();
					var s ="category";
					if(v==s){
						$("#category").show();
					}else {
						alert("=========");
						$("#category").hide();
					}
				})
			})
		</script>
</HEAD>
<body>
	<br>
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
					</TD>
				</tr>
				<tr>
					<td>
						<form action="/admin/product" method="post">
							<input type="hidden" name="method" value="search">
							类型
							<select name="type" id="listItem">
								<option value="all">全局搜索</option>
								<option value="pname">按名称搜索</option>
								<option value="pdesc">按详情搜索</option>
								<option value="category">按类别搜索</option>
							</select>
							<select id="category" name="categorySelect" style="display:none"></select>
							<input type="text" name="keyword" placeholder="请输入关键字">
							<input type="submit" value="搜索">
						</form>
					</td>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="添加"
							class="button_add" onclick="addProduct()">
							&#28155;&#21152;</button>
					</td>

				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="18%">序号</td>
								<td align="center" width="17%">商品图片</td>
								<td align="center" width="17%">商品名称</td>
								<td align="center" width="17%">商品价格</td>
								<td align="center" width="17%">是否热门</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>
							<c:forEach var="p" items="${pageBean.plist}">
							<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="18%">${p.pid}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%"><img width="40" height="45" src="${pageContext.request.contextPath}/${p.pimage}"></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">${p.pname}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">${p.shop_price}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">是</td>
								<td align="center" style="HEIGHT: 22px">
									<a href="${pageContext.request.contextPath }/admin/product?method=deliverPid&pid=${p.pid}&currentpage=${pageBean.currentPage}">
										<img src="${pageContext.request.contextPath}/images/i_edit.gif"
										border="0" style="CURSOR: hand">
								</a>
								</td>

								<td align="center" style="HEIGHT: 22px">
									<a href="${pageContext.request.contextPath }/admin/product?method=delete&pid=${p.pid}&currentpage=${pageBean.currentPage}">
										<img src="${pageContext.request.contextPath}/images/i_del.gif"
										width="16" height="16" border="0" style="CURSOR: hand">
								</a>
								</td>
							</tr>
							</c:forEach>
							<tr align="center"><td colspan="7">第${pageBean.currentPage}页/共${pageBean.totalPage}页
								<a href="/admin/product?method=queryAll&currentpage=1">首页</a>
								<a href="/admin/product?method=queryAll&currentpage=${pageBean.prePage}">上一页</a>
								<a href="/admin/product?method=queryAll&currentpage=${pageBean.nextPage}">下一页</a>
								<a href="/admin/product?method=queryAll&currentpage=${pageBean.totalPage}">末页</a>
								跳到第<input type="number" size="2">页</td> </tr>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
</body>
</HTML>