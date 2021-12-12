<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<header>
	<div class="menu">
		<a href="index.jsp"><img src="assets/images/logo.svg" alt=""></a>
		<nav>
			<ul class="lista">
				<li>Promociones</li>
				<li><a href="/tp3/atracciones/index.do">Atracciones</a></li>
				<a href="#">
					<li>Mi cuenta</li>
				</a>
				<c:if test="${user.isAdmin()}">
					<li>Administración
						<ul class="submenu">
							<li>Atracciones</li>
							<li>Promociones</li>
							<li>Tipo de Atracciones</li>
							<li>Usuarios</li>
						</ul>
					</li>
				</c:if>
			</ul>
		</nav>
	</div>
</header>
<c:if test="${success != null}">
	<div class="alert alert-success">
		<p>
			<c:out value="${success}" />
		</p>
	</div>
</c:if>