<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Thêm Sinh Viên</h1>
		<h3>
			<a href="/QLSinhVien/SVL_main/*">Danh Sách Sinh Viên</a>
		</h3>
	</center>
	<div align="center">
		<form action="/QLSinhVien/SVL_main/insert" method="post" enctype="multipath/form-data">
			<table border="1" cellpadding="5">
				<tr>
					<th>ID:</th>
					<td><input type="text" name="id" size="45"/></td>
				</tr>
				<tr>
					<th>Tên Sinh Viên:</th>
					<td><input type="text" name="ten" size="45"/></td>
				</tr>
				<tr>
					<th>Ngày Sinh:</th>
					<td><input type="text" name="ngaysinh" size="45"/></td>
				</tr>
				<tr>
					<th>Quê Quán:</th>
					<td><input type="text" name="quequan" size="45"/></td>
				</tr>
				<tr>
					<th>Giới Tính:</th>
					<td><input type="text" name="gioitinh" size="45"/></td>
				</tr>
				<tr>
					<th>Lớp:</th>
					<td><input type="text" name="lop" size="45"/></td>
				</tr>
				<tr>
					<th>Ảnh:</th>
					<td><input type="file" name="photo"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="Submit" value="Save"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>