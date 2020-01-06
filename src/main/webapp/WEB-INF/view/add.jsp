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
<script type="text/javascript">

$(function () {
	var id = "${param.id}";
	
	$.post("selectbywork",{id:id},function(obj){
		
		$("[name='id']").val(obj.id);
		
		
		
		
		for ( var i in obj) {
			$("select").append("<option value='"+obj[i].id+"'>"+obj[i].name+"</option>")
		}
		
	},"json")
})

function add() {
	var param = $("form").serialize();
	alert(param)
	$.post("add",param,function(flag){
		if (flag) {
			alert("审核成功")
			location.href="works";
		}
	})
}

</script>
</head>
<body>
<div align="left" style="margin-left: 400px">
	<h3 align="left">审核记录</h3>
<hr>
<form action="" method="post">
<p>
	<input type="hidden" name="id" value="${param.id }">
	关键字:<input type="text" name="keywords">
	描述:<input type="text" name="keywords" style="width: 200px">
</p>
<p>
	编号:<input type="text" name="id">
	公司名称:<input type="text" name="name">
</p>
<p>
	主营产品:<input type="text" name="cp">
	地址:<input type="text" name="address">
</p>
<p>
	自测资本(万元):<input type="text" name="money">
	成立时间:<input type="text" name="created">
</p>
<p>
	年检日期:<input type="text" name="year">
	年间状态:<select name="yeartype">
			<option value="">未审核</option>
		</select>
</p>
<p>
	备注:<input type="text" name="being" style="height: 100px; width: 200px">
</p>
<p>
	<input type="button" value="审核" onclick="add()">
</p>
</form>
</div>
</body>
</html>