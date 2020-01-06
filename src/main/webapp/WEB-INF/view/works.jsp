<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path=request.getContextPath();
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resource/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
</head>
<body>
<div align="center">
<form action="/works" method="post">
<p style="margin-top: 10px">
	ID:<input type="text" name="mohu" value="${vo.mohu }">
 	关键字:<input type="text" name="keywords1" value="${vo.keywords1 }">
	描述:<input type="text" name="description1" value="${vo.description1 }"></p>
<p>	公司名称:<input type="text" name="name1" value="${vo.name1 }">
	主营产品:<input type="text" name="cp1" value="${vo.cp1 }">
	地址:<input type="text" name="address1" value="${vo.address1 }"> </p>
	
 <p>注册资本:<input type="text" name="startmoney" value="${vo.startmoney }">--
		<input type="text" name="endmoney" value="${vo.endmoney }">
	成立时间:<input type="text" name="startcreated" value="${vo.startcreated }">--
		<input type="text" name="endcreated" value="${vo.endcreated }"></p>
<p>	年检日期:<input type="text" name="startyeartype" value="${vo.startyeartype }">--
		<input type="text" name="endyeartype" value="${vo.endyeartype }">	 
	
	<button type="submit">查询</button></p>
</form>
</div>

<div class="container" style="table table-hover">
<table class="table table-hover">
	<tr>
		<td>编号</td>
		<td>关键字</td>
		<td>描述</td>
		<td>公司名称</td>
		<td>主营产品</td>
		<td>地址</td>
		<td>注册资本(万元)</td>
		<td>成立时间</td>
		<td>年检日期</td>
		<td>年检状态</td>
		<td>备注</td>
		<td>操作</td>
	</tr>
	
	<c:forEach items="${works }" var="e" varStatus="count">
		<tr>
			<td>${e.id}</td>
			<td>${e.keywords }</td>
			<td>${e.description }</td>
			<td>${e.name }</td>
			<td>${e.cp }</td>
			<td>${e.address }</td>
			<td>${e.money }</td>
			<td>${e.created }</td>
			<td>${e.year }</td>
			<td>${e.yeartype }</td>
			<td>${e.being }</td>
			<td>
				<a href="/add">年检审核</a>
			</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="20">${page }</td>
	</tr>
</table>
</div>
</body>
</html>