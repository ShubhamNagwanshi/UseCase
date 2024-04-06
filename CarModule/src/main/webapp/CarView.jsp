<%@page import="in.co.rays.dto.CarDTO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		CarDTO dto = (CarDTO) request.getAttribute("dto");
		String msg = (String) request.getAttribute("msg");
	%>
	<%
		if (dto != null) {
	%>
	<h1 align="center">Update Progress</h1>
	<%
		} else {
	%>
	<h1 align="center">Add Progress</h1>
	<%
		}
	%>
	<%
		if (msg != null) {
	%>
	<h3 align="center"><%=msg%></h3>
	<%
		}
	%>
	<form action="CarCtl" method="post">
		<table align="center">
			<input type="hidden" name="id"
				value="<%=(dto != null) ? dto.getId() : ""%>">
			<tr>
				<th>OwnerName :</th>
				<td><input type="text" name="name"
					value="<%=(dto != null) ? dto.getOwnerName() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>CarName :</th>
				<td><input type="text" name="carName"
					value="<%=(dto != null) ? dto.getCarName() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>CarModel :</th>
				<td><input type="text" name="carModel"
					value="<%=(dto != null) ? dto.getCarModel() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>Prize :</th>
				<td><input type="text" name="prize"
					value="<%=(dto != null) ? dto.getPrize() : ""%>"></td>
			</tr>
			&nbsp;
			
			<tr>
				<th>PurchasingDate :</th>
				<td><input type="<%=(dto != null) ? "text" : "date"%>"
					name="date"
					value="<%=(dto != null) ? dto.getPurchaseDate() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(dto != null) ? "Update" : "save"%>"> <!-- <input
					type="reset"></td> -->
			</tr>
		</table>
	</form>
</body>
</html>