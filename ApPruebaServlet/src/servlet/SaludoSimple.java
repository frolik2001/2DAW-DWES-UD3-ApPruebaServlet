package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ejemplo de uso de servlet
 * Muestra un saludo simple empleando el parámetro nombre
 * Servlet implementation class SaludoSimple
 */
public class SaludoSimple extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Nombre de la aplicación
	 */
	private String nombreAp;
	
	/**
	 * Constante para establecer el tipo de contenido devuelto y codificación
	 */
	private static final String CONTENT_TYPE="text/html;charset=UTF-8";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaludoSimple() {
        super();
    }

    /**
     * Método de inicialización del servlet
     */
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	System.out.println("En método init");
    	ServletContext application = config.getServletContext();
    	nombreAp = (String) application.getInitParameter("nombreAp");
    	System.out.println("Nombre Ap: "+nombreAp);
    }
	/**
	 * Procesamiento de peticiones GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * Procesamiento de peticiones POST
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<head><title>Saludo Simple</title></head>");
		out.write("<body><p>");
		out.write("Aplicación: "+nombreAp);
		out.write("<br>");
		out.write("\n¡Saludos "+ nombre + ", me alegra mucho verte!");
		out.write("</body>");
		out.write("</html>");
		out.close();
	}

}
