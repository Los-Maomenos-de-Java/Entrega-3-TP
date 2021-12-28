package controller.atraccion;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoDeAtraccion;
import services.ListTipoAttractionService;

@WebServlet("/atracciones/create.do")
public class ListTipoAtraccionServlet extends HttpServlet implements Servlet {


	private static final long serialVersionUID = -8601488269702341838L;
	private ListTipoAttractionService ListtipoAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.ListtipoAtraccionService = new ListTipoAttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<TipoDeAtraccion> tipoattractions = ListtipoAtraccionService.list();
		System.out.println(tipoattractions);
		req.setAttribute("tipoattractions", tipoattractions);


		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/atracciones/create.jsp");
		dispatcher.forward(req, resp);

	}

}