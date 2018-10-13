package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import database.dao.UserDAO;
import database.dao.UserDAOImpl;
import database.entities.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAOImpl(true);
		String strId = request.getParameter("id");
		if ( strId != null)
		{
			if (NumberUtils.isNumber(strId)) {
				int id = Integer.parseInt(strId);
				User user = dao.find(new Long(id));
				response.getWriter().println(user);
			}
			else response.getWriter().println("Not a number in id");
		}
		else
		{
			List<User> ulist = dao.list();
			if (ulist != null) {
				for (User user: ulist)
					response.getWriter().println(user);
			}
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
