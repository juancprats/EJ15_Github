package es.curso.dispatchers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.controllers.ejb.DarAltaClienteControllerEjb;
import es.curso.controllers.ejb.ListarTodoControllerEjb;
import es.curso.model.entity.Cliente;

/**
 * Servlet implementation class TiendaServlet
 */
@WebServlet("/Tienda/*")
public class TiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public TiendaServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");

		String titulo = "Sin titulo";
		RequestDispatcher rd;
		switch (action) {
		case "ListaTodo": // se invoca al controlador adecuado
							// se redirige a otra pagina
			ListarTodoControllerEjb todos = new ListarTodoControllerEjb();
			ArrayList<Cliente> clientes = todos.listarTodos();
			request.setAttribute("clientes", clientes);
			rd = request.getRequestDispatcher("/jsp/ListarTodo.jsp");
			request.setAttribute("titulo", titulo);
			rd.forward(request, response);
			titulo = "Listado general de clientes";
			break;
		case "BuscarPorNombre": // se invoca al controlador adecuado que
								// obtendra
								// se redirige a otra pagina
			titulo = "Resultado de la búsqueda por nombre";
			request.setAttribute("titulo", titulo);
			rd = request.getRequestDispatcher("/jsp/ListarTodo.jsp");
			rd.forward(request, response);
			break;
			
		case "altaCliente": // se invoca al controlador adecuado
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String dni = request.getParameter("dni");
			Cliente cliente = new Cliente(0, nombre, apellido, dni);

			DarAltaClienteControllerEjb controlador = new DarAltaClienteControllerEjb();
			controlador.agregar(cliente);
			rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);

			break;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd;
		switch (action) {
		// se redirige a otra pagina

		case "altaCliente": // se invoca al controlador adecuado
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String dni = request.getParameter("dni");
			Cliente cliente = new Cliente(0, nombre, apellido, dni);

			DarAltaClienteControllerEjb controlador = new DarAltaClienteControllerEjb();
			controlador.agregar(cliente);
			rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);

			break;
		}
	}

}
