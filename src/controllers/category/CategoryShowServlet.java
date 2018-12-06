package controllers.category;

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
 * Servlet implementation class CategoryShowServlet
 */
@WebServlet("/category/show")
public class CategoryShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();

		Category c = em.find(Category.class, Integer.parseInt(request.getParameter("id")));

        int page = 1;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        }catch(NumberFormatException e){}


        List<Hanrei> h = em.createNamedQuery("getAllHanrei", Hanrei.class)
                .setFirstResult(10 * (page - 1))
                .setMaxResults(10)
                .getResultList();
        long hanrei_count = em.createNamedQuery("getHanreiCount", Long.class)
                .getSingleResult();

        em.close();
        request.setAttribute("category", c);
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("hanrei", h);
        request.setAttribute("page", page);
        request.setAttribute("hanrei_count", hanrei_count);
        request.getSession().setAttribute("category_id", Integer.parseInt((String) request.getParameter("id")));
        if(request.getSession().getAttribute("flush") != null){
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/category/show.jsp");
		rd.forward(request, response);
	}

}
