package controller.atraccion;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoDeAtraccion;
import persistence.TipoAtraccionDAO;
import persistence.commons.DAOFactory;
import services.AttractionService;
import services.ListTipoAttractionService;

@WebServlet("/attractions/edit.do")
public class EditAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 4224083634145913364L;
	private AttractionService attractionService;
	private ListTipoAttractionService ListtipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
		this.ListtipoAtraccionService = new ListTipoAttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id2 = Integer.valueOf(req.getParameter("id"));

		Atraccion attraction = attractionService.find(id2);
		
		List<TipoDeAtraccion> tipoattractions = ListtipoAtraccionService.list();
		req.setAttribute("tipoattractions", tipoattractions);
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
		TipoAtraccionDAO tipoAtraccionDAO = DAOFactory.getTipoAtraccionDAO();
		TipoDeAtraccion tipo = tipoAtraccionDAO.find(tipoDeAtraccion);

		Atraccion attraction = attractionService.update(id, nombre, costoVisita, tiempoPromedio, tipo, cupo);

		resp.sendRedirect("/tp3/atracciones/index.do");

	}
}
