<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表页面</title>
</head>
<body>
	<table border="1" align="center" width="88%">
		<tr>
			<td colspan="7">
				<form action="${pageContext.request.contextPath}/findProductByCondition" method="post">
					商品名称：<input name="name" >
					商品描述：<input name="kw" >
					<input type="submit" value="查询">
				</form>
			</td>
			<td colspan="1" align="right">
				<input type="button" value="删除选中" onclick="delCheck()">
			</td>
		</tr>
		<tr>
			<td><input type="checkbox" onclick="checkAll(this)"></td><!-- 全选框 -->
			<th>pid</th>
			<th>商品图片</th>
			<th>商品名称</th>
			<th>市场价</th>
			<th>商城价</th>
			<th>商品描述</th>
			<th>操作</th>
		</tr>
		<form id="formId" action="${pageContext.request.contextPath}/delCheckedProduct" method="post">
			<c:forEach items="${list}" var="p">
				<tr>
					<td width='1%'><input type="checkbox" name="checked_pid" value="${p.pid}"></td>
					<td width='8%'>${p.pid}</td>
					<td width='8%'><img alt=""
						src="${pageContext.request.contextPath}/${p.pimage}" width="80px"></td>
					<td width='8%'>${p.pname }</td>
					<td width='8%'>${p.market_price }</td>
					<td width='8%'>${p.shop_price }</td>
					<td>${p.pdesc}</td>
					<td width='8%'><a
						href="${pageContext.request.contextPath}/getProductById?pid=${p.pid}">修改</a>
						| <a href="javascript:void(0)" onclick="deleteP('${p.pid}')">删除</a></td>
				</tr>
			</c:forEach>
		</form>
	</table>
</body>
<script type="text/javascript">
	//删除商品
	function deleteP(obj) {
		if (confirm("确定删除？")) {
			alert("删除成功！点击确定回到列表");
			//发送请求
			location.href = "${pageContext.request.contextPath}/deleteProduct?pid="
					+ obj;
		}
	}
	//全选
	function checkAll(obj) {
		//获取所有复选框
		var arr = document.getElementsByName("checked_pid");
		//遍历数组,修改选中状态
		for (var i = 0; i < arr.length; i++) {
			arr[i].checked = obj.checked;
			//alert(obj.checked);
		}
	}
	//删除选中
	function delCheck() {
		if (confirm("确定删除？")){
			document.getElementById("formId").submit();
		}
	}
</script>
</html>