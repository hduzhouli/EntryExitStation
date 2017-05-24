<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基站登录系统</title>
    
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
        <form action="${pageContext.request.contextPath}/loginToStationServlet" method="post">
    	地市：<input type="text" name="city"/><br/>
    	区县：<input type="text" name="region"/><br/>
    	基站名称：<input type="text" name="station"/><br/>
    	进站原因：<input type="text" name="reason"/><br/>
    	手机号码：<input type="text" name="phone"/><br/>
    	<input type="submit" value="登录"/>    
    </form>
  </body>
</html>
