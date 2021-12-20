<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="id" class="col-form-label">Id:</label> <input type="number"
		readonly class="form-control" id="id" name="id" required
		value="${attraction.getId()}">
</div>
<div class="mb-3">
	<label for="name" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="name" name="nombre" required
		value="${attraction.getNombre()}">
</div>
<div class="mb-3">
	<label for="cost">Costo:</label> <input class="form-control"
		type="number" id="cost" name="costoVisita" required
		value="${attraction.getCosto()}"></input>
</div>
<div class="mb-3">
	<label for="duration">Duration:</label> <input class="form-control"
		type="number" id="duration" name="tiempoPromedio" required
		value="${attraction.getTiempo()}"></input>
</div>
<div class="mb-3">
	<label for="tipoDeAtraccion">Tipo de Atraccion:</label> <select
		class="form-control" type="text" id="tipoDeAtraccion" name="tipoDeAtraccion" required>
		<option value="1">NULA</option>
		<option value="2">DEGUSTACION</option>
		<option value="3">RECORRIDO</option>
		<option value="4">ACCION</option>
		<option value="5">SHOW</option>
		<option value="6">MONTAÑA_RUSA</option>
		<option value="7">SHOP</option>
		<option value="8">TERROR</option>
		<option value="9">CULTURAL</option>
		<option value="10">AVENTURA</option>
		<option value="9">PAISAJE</option>
	</select>
</div>
<div class="mb-3">
	<label for="capacity">Cupo:</label> <input class="form-control"
		type="number" id="capacity" name="cupo" required
		value="${attraction.getCupo()}"></input>
</div>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>