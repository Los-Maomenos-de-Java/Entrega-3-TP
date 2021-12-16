package controller.atraccion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/promociones/index.do")
public class ListPromocionesServlet extends HttpServlet implements Servlet {


	private static final long serialVersionUID = 1726850304799151345L;


	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promociones/index.jsp");
		dispatcher.forward(req, resp);

	}

}