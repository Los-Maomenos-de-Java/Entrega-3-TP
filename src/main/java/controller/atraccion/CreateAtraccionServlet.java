package controller.atraccion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoDeAtraccion;
import services.AttractionService;

@WebServlet("/attractions/create.do")
public class CreateAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = -5552533315674453581L;
	private AttractionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		Integer costoVisita = Integer.parseInt(req.getParameter("costoVisita"));
		Double tiempoPromedio = Double.parseDouble(req.getParameter("tiempoPromedio"));
		TipoDeAtraccion tipoDeAtraccion = TipoDeAtraccion.valueOf(req.getParameter("tipoDeAtraccion"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));

		Atraccion attraction = attractionService.create(nombre, costoVisita, tiempoPromedio, tipoDeAtraccion, cupo);

		resp.sendRedirect("/tp3/atracciones/index.do");
	}

}