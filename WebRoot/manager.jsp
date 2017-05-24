<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>局房基站进出站登记系统管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
        <center><h3>局房基站进出站登记系统管理</h3></center>
    	<a href="${pageContext.request.contextPath }/listAllServlet">进出站记录监控</a><br>
    	<a href="${pageContext.request.contextPath }/listAllStation">站点信息</a><br>
    	<a href="${pageContext.request.contextPath }/GenerateQR.jsp">二维码生成</a>
  </body>
</html>
