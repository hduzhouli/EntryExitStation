<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改进站记录</title>
</head>

<body>
<center><h3>修改进站记录</h3></center>
<form action="${pageContext.request.contextPath }/updateRecordServlet" method="post">
<input type="hidden" name="id" value="${record.id }"/>
<table border="1" align="center" width="500px">
	<tr>
    	<th>地市</th>
        <td><input type="text" name="city" value="${record.city }" readonly="readonly"/></td>
    </tr>
    <tr>
    	<th>县区</th>
        <td><input type="text" name="region" value="${record.region }" readonly="readonly"/></td>
    </tr>
    <tr>
    	<th>基站名称</th>
        <td><input type="text" name="station" value="${record.station }" readonly="readonly"/></td>
    </tr>
    <tr>
    	<th>进站时间</th>
        <td><input type="text" name="entry_time" value="${record.entry_time }" readonly="readonly"/></td>
    </tr>
    <tr>
    	<th>出站时间</th>
        <td><input type="text" name="exit_time" value="${record.exit_time }" readonly="readonly"/></td>
    </tr>
    <tr>
    	<th>进站原因</th>
        <td><input type="text" name="reason" value="${record.reason }"/></td>
    </tr>
     <tr>
    	<th>联系方式</th>
        <td><input type="text" name="phone" value="${record.phone }"/></td>
    </tr>
    <tr>
    	<td colspan="2" align="center"><input type="submit" value="修改"/></td>
    </tr>
</table>
</form>
</body>
</html>
