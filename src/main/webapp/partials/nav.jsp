<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<header>
	<div class="menu">
		<a href="/tp3/index.jsp"><img src="/tp3/assets/images/logo.svg" alt=""></a>
		<nav>
			<ul class="lista">
				<li><a href="/tp3/views/promociones/index.jsp">Promociones</a></li>
				<li><a href="/tp3/atracciones/index.do">Atracciones</a></li>
				<li><a href=/tp3/atracciones/cuenta.do>Mi cuenta</a></li>
				<li><a href="/tp3/logout">Salir</a></li>
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