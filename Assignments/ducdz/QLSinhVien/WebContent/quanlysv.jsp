<%@page import="model.SinhVien"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản Lý Sinh Viên</title>
<style>
table, th, td {
	border: 1px solid;
}
</style>
</head>
<body>
<div align="center">
	<h1>Quản Lý Sinh Viên</h1>
	<h3><a href="/QLSinhVien/SVL_main/new">Thêm Sinh Viên</a></h3>
	<h3><a href="/QLSinhVien/SVL_main/pagination?pid=1">Danh Sách Sinh Viên</a></h3>
	<table>
		<tr>
			<th>Mã Sinh Viên</th>
			<th>Tên Sinh Viên</th>
			<th>Ngày Sinh</th>
			<th>Quê Quán</th>
			<th>Giới Tính</th>
			<th>Lớp</th>
			<th>Photo</th>
			<th>Action</th>
		</tr>
		<c:forEach var="listSV" items="${sv}">
			<tr>
				<td><c:out value="${listSV.id }"/></td>
				<td><c:out value="${listSV.tensv}" /></td>
				<td><c:out value="${listSV.ngaysinh}" /></td>
				<td><c:out value="${listSV.quequan}" /></td>
				<td><c:out value="${listSV.gioitinh}" /></td>
				<td><c:out value="${listSV.lop}" /></td>	
				<td><img src="images/${listSV.photo}" width="120" height="150"></td>
				<td><a href="/QLSinhVien/SVL_main/edit?sid=${listSV.id}">Edit</a> <a href="/QLSinhVien/SVL_main/delete?sid=${listSV.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>