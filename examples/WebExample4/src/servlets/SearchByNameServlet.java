package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import entities.Student;
import utils.UtilityMethods;

/**
 * Servlet implementation class SearchByNameServlet
 */
@WebServlet("/search_by_name")
public class SearchByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
	    String pattern = request.getParameter("name");
	    StudentDAO dao = new StudentDAOImpl();
	    
	    if (action.equals("complete") && pattern != null)
	    {
	    	List<Student> students = dao.searchByName(pattern);
	    	String studentsJson = UtilityMethods.createJSON(students);
	    	response.setContentType("application/json");
	    	response.getWriter().append(studentsJson);
	    }
	    else
	    {
	    	response.getWriter().append("[]");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
