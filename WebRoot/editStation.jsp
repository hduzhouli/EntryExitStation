<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改基站信息</title>
    
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
    <center><h3>修改基站信息</h3></center>
    <form action="${pageContext.request.contextPath }/updateStation" method="post">
<input type="hidden" name="id" value="${stationEntity.id }"/>
<table border="1" align="center" width="500px">
	<tr>
    	<th>地市</th>
        <td><input type="text" name="city" value="${stationEntity.city }" readonly="readonly"/></td>
    </tr>
    <tr>
    	<th>县区</th>
        <td><input type="text" name="region" value="${stationEntity.region }" readonly="readonly"/></td>
    </tr>
    <tr>
    	<th>基站名称</th>
        <td><input type="text" name="station" value="${stationEntity.station }" /></td>
    </tr>
    <tr>
    	<td colspan="2" align="center"><input type="submit" value="修改"/></td>
    </tr>
</table>
</form>
  </body>
</html>
