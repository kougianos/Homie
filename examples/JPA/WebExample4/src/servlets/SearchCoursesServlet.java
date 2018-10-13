package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import entities.Student;


/**
 * Servlet implementation class SearchCoursesServlet
 */
@WebServlet("/search")
public class SearchCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/SearchResults.jsp");
		String id = request.getParameter("id");
		StudentDAO dao = new StudentDAOImpl();
		if (id != null)
		{
			if (NumberUtils.isNumber(id)) {
				long identifier = Long.parseLong(id);
				Student student = dao.find(identifier);
				if (student != null) {
					request.setAttribute("student", student);
					disp.forward(request, response);
				}
				else response.getWriter().println("There is no student with id: " + id);
			}
			else response.getWriter().println("Not a valid id");
		}
		else 
		{
			response.getWriter().append("Parameter id is null");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
