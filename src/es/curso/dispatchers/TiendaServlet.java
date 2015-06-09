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

import es.curso.controllers.ejb.BorrarPorIdEjb;
import es.curso.controllers.ejb.BuscarPorNombreControllerEjb;
import es.curso.controllers.ejb.DarAltaClienteControllerEjb;
import es.curso.controllers.ejb.ListarTodoControllerEjb;
import es.curso.controllers.ejb.ModificarPorNombreControllerEjb;
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
			titulo = "Listado general de clientes";
			request.setAttribute("titulo", titulo);
			rd.forward(request, response);
			
			break;
		case "BuscarPorNombre": // se invoca al controlador adecuado que
								// obtendra
								// se redirige a otra pagina
			
			rd = request.getRequestDispatcher("/jsp/BuscarPorNombre.jsp");
			rd.forward(request, response);
			break;
			
		case "altaCliente": // se invoca al controlador adecuado
			
			
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String dni = request.getParameter("dni");
			Cliente cliente = new Cliente(0, nombre, apellido, dni);

			DarAltaClienteControllerEjb controlador = new DarAltaClienteControllerEjb();
			controlador.agregar(cliente);
			rd = request.getRequestDispatcher("../html/altaClienteView.html");
			rd.forward(request, response);

			break;
			
		case "BorrarPorId":
			rd = request.getRequestDispatcher("/jsp/BorrarPorId.jsp");
 			rd.forward(request, response);
			break;
			
		case "Modificar":
			rd=request.getRequestDispatcher("/jsp/Modificar.jsp");
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
			rd = request.getRequestDispatcher("../index.html");
			rd.forward(request, response);

			break;
		case "BuscarPorNombre":
			String cadenaNombre = request.getParameter("nombre");
			BuscarPorNombreControllerEjb controladorBusqueda = new BuscarPorNombreControllerEjb();
			ArrayList<Cliente> resultado =  controladorBusqueda.buscarPorNombre(cadenaNombre);
			request.setAttribute("clientes", resultado);
			rd = request.getRequestDispatcher("/jsp/ListarTodo.jsp");
			request.setAttribute("titulo", "Búsqueda por: " + cadenaNombre);
			rd.forward(request, response);
			break;
			
		case "BorrarPorId":
			Integer borrar = Integer.parseInt(request.getParameter("id"));
			BorrarPorIdEjb BusquedaId = new BorrarPorIdEjb();
			
			boolean resultadoId =  BusquedaId.borrarPorId(borrar);
			request.setAttribute("titulo", resultadoId);
			rd = request.getRequestDispatcher("../index.html");
			/*request.setAttribute("titulo", "Borrado el id: " + borrar);*/
			rd.forward(request, response);
			break;
			
		case "Modificar1":
			String cadena1 = request.getParameter("nombre");
			ModificarPorNombreControllerEjb controladorModificar = new ModificarPorNombreControllerEjb();
			ArrayList<Cliente> result = controladorModificar.buscarPorNombre(cadena1);
			request.setAttribute("clientes", result);
			rd=request.getRequestDispatcher("/jsp/ModificarCliente.jsp");
			rd.forward(request, response);
			break;
			
		case "Modificar2":
			int idCliente = Integer.parseInt(request.getParameter("id"));
			String nombreCliente = request.getParameter("nombre");
			String apellidosCliente = request.getParameter("apellidos");
			String dniCliente = request.getParameter("dni");
			ModificarPorNombreControllerEjb controladorModificar2 = new ModificarPorNombreControllerEjb();
			Cliente clienteActual = new Cliente(idCliente, nombreCliente, apellidosCliente, dniCliente);
			controladorModificar2.actualizar(clienteActual);
			response.sendRedirect("ListaTodo");
			break;
			
			
		}
	}

}
