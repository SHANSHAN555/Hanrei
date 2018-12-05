package controllers.category;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category;
import utils.DBUtil;

/**
 * Servlet implementation class CategoryEditServlet
 */
@WebServlet("/category/edit")
public class CategoryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();

		Category c = em.find(Category.class, Integer.parseInt(request.getParameter("id")));

		em.close();

		    request.setAttribute("category", c);
	        request.setAttribute("_token", request.getSession().getId());
	        request.getSession().setAttribute("category_id", c.getId());



		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/category/edit.jsp");
		rd.forward(request, response);
	}

}
