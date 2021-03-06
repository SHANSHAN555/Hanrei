package controllers.hanrei;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category;
import models.Hanrei;
import utils.DBUtil;
/**
 * Servlet implementation class HanreiNewServlet
 */
@WebServlet("/hanrei/new")
public class HanreiNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HanreiNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    EntityManager em = DBUtil.createEntityManager();
	    List<Category> category = em.createNamedQuery("AllCategory", Category.class)
	            .getResultList();

	    em.close();
	    request.setAttribute("category", category);
	    request.setAttribute("hanrei", new Hanrei());
		request.setAttribute("_token", request.getSession().getId());

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/hanrei/new.jsp");
		rd.forward(request, response);
	}

}
