package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuariosDAO;
import javax.servlet.RequestDispatcher;
import models.Passagens;
import models.Usuarios;

@WebServlet(urlPatterns = { "/usuario", "/usuario-create", "/usuario-edit", "/usuario-update", "/usuario-delete" })
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuariosDAO udao = new UsuariosDAO();
	Usuarios usuario = new Usuarios();

       
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch(action) {
		case "/usuario":
			read(request,response);
			break;
		case "/usuario-delete":
			delete(request, response);
			break;
		case "/usuario-create":
			create(request, response);
			break;
		case "/usuario-edit":
			edit(request, response);
			break;
		case "/usuario-update":
			update(request, response);
			break;
		
		default:
				response.sendRedirect("index.html");
			break;
	}

	}
	
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuarios> lista = udao.read();
		request.setAttribute("listaUsuarios",lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/usuarios/index.jsp");
		rd.forward(request,response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		int id_passagem = Integer.parseInt(request.getParameter("id_passagem"));
		Passagens passagens = new Passagens();
		passagens.setId(id_passagem);
		usuario.setPassagens(passagens);
		udao.create(usuario);
		response.sendRedirect("usuario");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		usuario = udao.readById(id);
		
		request.setAttribute("usuario", usuario);

		RequestDispatcher rd = request.getRequestDispatcher("./views/usuarios/update.jsp");
		rd.forward(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));

		udao.update(usuario);
		response.sendRedirect("usuario");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		udao.delete(id);
		response.sendRedirect("usuario");
	}
	

	
}


