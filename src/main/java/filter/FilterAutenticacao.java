package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/principal/*") // intercepta todas as requisicoes que vinheram do projeto ou mapeamento
public class FilterAutenticacao extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public FilterAutenticacao() {
		super();

	}

	// encerr os processos quando o servidor e parado
	// mataria a conexao com banco
	public void destroy() {

	}

	// intercepta as requisicoes e respostas // tudo vai passar por ele
	// validar autenticação
	// dar commit e rolback de transacoes do banco
	// validar e fazer direcionamento de paginas
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		String usuarioLogado = (String) session.getAttribute("usuario");

		String urlParaAutenticar = req.getServletPath();

		// validar se esta logado senao redireciona pra tela de login
		if (usuarioLogado == null
				&& !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {
			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "por favor realizar o login");
			redireciona.forward(request, response);
			return;
		} else {

			chain.doFilter(request, response);

		}

	}

	public void init(FilterConfig fConfig) throws ServletException { // inicia os processos ou recursos quando o
																		// servidor sobe o projeto

	}

}
