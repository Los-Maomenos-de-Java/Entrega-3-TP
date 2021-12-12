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
import model.Atraccion;
import services.AttractionService;

@WebServlet("/atracciones/index.do")
public class ListAtraccionServlet extends HttpServlet implements Servlet {

	static final long serialVersionUID = -3153850129554345157L;
	private AttractionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Atraccion> attractions = attractionService.list();
		req.setAttribute("attractions", attractions);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/attractions/index.jsp");
		dispatcher.forward(req, resp);

	}

}