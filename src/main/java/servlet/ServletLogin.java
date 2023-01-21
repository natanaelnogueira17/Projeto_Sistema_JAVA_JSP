package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelLogin;

//o chamado controller sao as servlets ou servletLoginController
@WebServlet("/ServletLogin") // mapeamento de url que vem da tela
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
		super();
	}

	// recebe os dados pela url em parametros
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	// recebe os dados enviados por um formulario
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("Login");
		String senha = request.getParameter("Senha");
		if(login != null && !login.isEmpty() && senha !=null && !senha.isEmpty()) {
			
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			
			if(modelLogin.getLogin().equalsIgnoreCase("admin")&& modelLogin.getSenha().equalsIgnoreCase("admin")) {
				request.getSession().setAttribute("usuario", modelLogin.getLogin());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("principal/principal.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "informe o login e senha corretamente");
				dispatcher.forward(request, response);
			}
			
			
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "informe o login e senha corretamente");
			dispatcher.forward(request, response);
		}
		
	}

}
