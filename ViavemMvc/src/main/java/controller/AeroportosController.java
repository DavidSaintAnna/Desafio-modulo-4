package controller;
import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import dao.AeroportoDAO;

import models.Aeroportos;



@WebServlet(urlPatterns = { "/aeroporto", "/aeroporto-create", "/aeroporto-edit", "/aeroporto-update", "/aeroporto-delete" })
public class AeroportosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AeroportoDAO adao = new AeroportoDAO();
	Aeroportos aeroporto = new Aeroportos();
   
    public AeroportosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action) {
		case "/aeroporto":
			read(request,response);
			break;
		case "/aeroporto-delete":
			delete(request, response);
			break;
		case "/aeroporto-create":
			create(request, response);
			break;
		case "/aeroporto-edit":
			edit(request, response);
			break;
		case "/aeroporto-update":
			update(request, response);
			break;
		
		default:
				response.sendRedirect("index.html");
			break;
	}
	}
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Aeroportos> lista = adao.read();
		request.setAttribute("listaAeroportos",lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/aeroportos/index.jsp");
		rd.forward(request,response);
	}
	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aeroporto.setNome(request.getParameter("nome"));
		aeroporto.setCidade(request.getParameter("cidade"));
		aeroporto.setPais(request.getParameter("pais"));
		
		adao.create(aeroporto);
		response.sendRedirect("aeroporto");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		aeroporto = adao.readById(id);
		
		request.setAttribute("aeroporto", aeroporto);

		RequestDispatcher rd = request.getRequestDispatcher("./views/aeroportos/update.jsp");
		rd.forward(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		aeroporto.setId(Integer.parseInt(request.getParameter("id")));
		aeroporto.setNome(request.getParameter("nome"));
		aeroporto.setCidade(request.getParameter("cidade"));
		aeroporto.setPais(request.getParameter("pais"));

		adao.update(aeroporto);
		response.sendRedirect("aeroporto");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		adao.delete(id);
		response.sendRedirect("aeroporto");
	}

}
