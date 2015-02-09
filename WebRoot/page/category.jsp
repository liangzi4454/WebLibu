<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib uri="/WEB-INF/conf/page.tld" prefix="p"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("path", path);
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<head>
<script type="text/javascript">var basePath = '<%=basePath%>';</script>
<link href="<%=basePath%>/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/libu.min.js"></script>
<script type="text/javascript">
	pregnantType.init();
</script>
</head>

<body>
	测试
</body>