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

@WebServlet("/attractions/edit.do")
public class EditAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 4224083634145913364L;
	private AttractionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id2 = Integer.valueOf(req.getParameter("id"));

		Atraccion attraction = attractionService.find(id2);
		req.setAttribute("attraction", attraction);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atracciones/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		Integer costoVisita = Integer.parseInt(req.getParameter("costoVisita"));
		Double tiempoPromedio = Double.parseDouble(req.getParameter("tiempoPromedio"));
		Integer tipoDeAtraccion = Integer.parseInt(req.getParameter("tipoDeAtraccion"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));

		Atraccion attraction = attractionService.update(id, nombre, costoVisita, tiempoPromedio,  tipoDeAtraccion, cupo);

		resp.sendRedirect("/tp3/atracciones/index.do");

	}
}
