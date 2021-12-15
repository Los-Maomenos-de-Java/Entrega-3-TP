<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
</head>
<body>
	<main class="login">
		<section class="header"></section>
		<section class=formulario>

			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
			<form action="login" method="post">

				<div class="usuario">
					<label for="username" class="">Usuario</label> <input class=""
						name="username">
				</div>

				<div class="password">
					<label for="password" class="">Contraseña</label> <input
						type="password" class="" name="password">
				</div>

				<div class="ingreso">
					<button type="submit" class="">Ingresar</button>
				</div>
			</form>
		</section>



	</main>
</body>
</html>
