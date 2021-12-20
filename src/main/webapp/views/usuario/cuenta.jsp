<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">
<title>¡Atracciones Los Simpsons!</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link href="/tp3/assets/css/styles.css" rel=stylesheet>
</head>
<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="bg-light p-4 mb-3 rounded">
			<h1>¡Mi cuenta!</h1>
		</div>


		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Presupuesto</th>
					<th>Tiempo Disponible</th>
					<th>Tipo de Atracción preferido</th>
					<th>Atracciones compradas</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><strong><c:out value="${user.getNombre()}"></c:out></strong></td>
					<td><c:out value="${user.getPresupuestoActual()}"></c:out></td>
					<td><c:out value="${user.getTiempoDisponible()}"></c:out></td>
					<td><c:out value="${user.getTipoDeAtraccionPreferida()}"></c:out></td>
					<td><c:out value="${user.getOfertasCompradas()}"></c:out><img class="chiste" src="/tp3/assets/images/viejo.png"></td>
				</tr>
			</tbody>
		</table>
	</main>
</body>
</html>