<%@ page language="java" pageEncoding="gbk"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>�˵�</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">չ������</a> | <a href="javascript: d.closeAll();">�ر�����</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
	
		d = new dTree('d');
		d.add('01',-1,'ϵͳ�˵���');
		d.add('0102','01','�������','','','mainFrame');
		d.add('010201','0102','�������','${pageContext.request.contextPath}/admin/category?method=queryList','','mainFrame');
        d.add('0103','01','�˺Ź���','','','mainFrame');
        d.add('010301','0103','�˺Ź���','${pageContext.request.contextPath}/admin/user?method=queryAll','','mainFrame');
        d.add('0104','01','��Ʒ����');
		d.add('010401','0104','��Ʒ����','${pageContext.request.contextPath}/admin/product?method=queryAll&currentpage=1','','mainFrame');
		document.write(d);
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
