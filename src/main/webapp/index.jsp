<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="partials/nav.jsp"></jsp:include>
	<section class="carrusel">
		<div id="carouselExampleSlidesOnly" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active" data-bs-interval="2000">
					<img src="/tp3/assets/images/banner1.png" class="d-block w-100"
						alt="...">
				</div>
				<div class="carousel-item" data-bs-interval="2000">
					<img src="/tp3/assets/images/banner2.png" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item" data-bs-interval="2000">
					<img src="/tp3/assets/images/banner3.png" class="d-block w-100" alt="...">
				</div>
			</div>
		</div>
	</section>
</body>
</html>
