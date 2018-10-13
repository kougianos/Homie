package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(urlPatterns="/MyServlet", 
initParams={ @WebInitParam(name="n1", value="v1"), @WebInitParam(name="n2", value="v2") })
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Map<String, String> initParamsMap = new HashMap<String, String>();

	public void init() throws ServletException {

		Enumeration<String> initParams = getServletConfig().getInitParameterNames();
		System.out.println(initParams + " initParams");

		while (initParams.hasMoreElements()) {

			String initParamName = initParams.nextElement();
			System.out.println(initParamName + " initParamName");
			String initParamValue = getServletConfig().getInitParameter(initParamName);

			initParamsMap.put(initParamName, initParamValue);

		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served ").append(request.getParameter("name")).append(" at: ").
		//append(request.getRequestURI());
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/Hello.jsp");
		String nameChanged = request.getParameter("name").replace('o', 'a');
		request.setAttribute("changed", nameChanged);
		disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
