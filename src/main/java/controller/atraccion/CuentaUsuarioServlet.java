package controller.atraccion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.CuentaUsuarioService;

@WebServlet("/atracciones/cuenta.do")

public class CuentaUsuarioServlet extends HttpServlet implements Servlet {

	

	private static final long serialVersionUID = -5676908317618997997L;
	private CuentaUsuarioService cuentaService;
	

	@Override
	public void init() throws ServletException {
		super.init();
		this.cuentaService = new CuentaUsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		Usuario user2 = cuentaService.encontrarPorId(user.getId());
		
		req.setAttribute("user", user2);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuario/cuenta.jsp");
		dispatcher.forward(req, resp);

	}

}