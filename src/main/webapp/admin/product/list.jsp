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
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>��Ʒ�б�</strong>
					</TD>
				</tr>
				<tr>
					<td>
						<form action="/admin/product" method="post">
							<input type="hidden" name="method" value="search">
							����
							<select name="type" id="listItem">
								<option value="all">ȫ������</option>
								<option value="pname">����������</option>
								<option value="pdesc">����������</option>
								<option value="category">���������</option>
							</select>
							<select id="category" name="categorySelect" style="display:none"></select>
							<input type="text" name="keyword" placeholder="������ؼ���">
							<input type="submit" value="����">
						</form>
					</td>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="���"
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

								<td align="center" width="18%">���</td>
								<td align="center" width="17%">��ƷͼƬ</td>
								<td align="center" width="17%">��Ʒ����</td>
								<td align="center" width="17%">��Ʒ�۸�</td>
								<td align="center" width="17%">�Ƿ�����</td>
								<td width="7%" align="center">�༭</td>
								<td width="7%" align="center">ɾ��</td>
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
									width="17%">��</td>
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
							<tr align="center"><td colspan="7">��${pageBean.currentPage}ҳ/��${pageBean.totalPage}ҳ
								<a href="/admin/product?method=queryAll&currentpage=1">��ҳ</a>
								<a href="/admin/product?method=queryAll&currentpage=${pageBean.prePage}">��һҳ</a>
								<a href="/admin/product?method=queryAll&currentpage=${pageBean.nextPage}">��һҳ</a>
								<a href="/admin/product?method=queryAll&currentpage=${pageBean.totalPage}">ĩҳ</a>
								������<input type="number" size="2">ҳ</td> </tr>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
</body>
</HTML>