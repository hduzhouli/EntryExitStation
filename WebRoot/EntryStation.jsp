<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>局房基站进站登记</title>
    
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
    <center><h3>局房基站进站登记</h3></center>
    <form action="${pageContext.request.contextPath}/loginToStationServlet" method="post">
    	地市：<input type="text" name="city" value="${stationEntity.city }" readonly="readonly"/><br/>
    	区县：<input type="text" name="region" value="${stationEntity.region }" readonly="readonly"/><br/>
    	基站名称：<input type="text" name="station" value="${stationEntity.station }" readonly="readonly"/><br/>
    	进站原因：<input type="text" name="reason"/><br/>
    	联系方式：<input type="text" name="phone"/><br/>
    	<input type="submit" value="进站"/>
     </form>
  </body>
</html>
