<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>App de empleados</title>
</head>
<body>
<h1>Gestión de empleados</h1>

<!-- Formulario -->


<p>
		<table>
			<tr><th>Cif</th><th>Nombre</th><th>Apellidos</th><th>Edad</th></tr>
			<c:forEach items="${listaEmpleados}" var="empleado">
				<tr>
					<td>${empleado.cif}</td>
					<td>${empleado.nombre}</td>
					<td>${empleado.apellidos}</td>
					<td>${empleado.edad}</td>
				</tr>
			</c:forEach>
		</table>
</p>
<p>
${mensaje}
</p>
</body>
</html>