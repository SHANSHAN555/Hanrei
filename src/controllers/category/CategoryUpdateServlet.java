package controllers.category;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category;
import utils.DBUtil;
/**
 * Servlet implementation class CategoryUpdateServlet
 */
@WebServlet("/category/update")
public class CategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String _token = (String)request.getParameter("_token");
	    if(_token != null && _token.equals(request.getSession().getId())){
	        EntityManager em = DBUtil.createEntityManager();

	        Category c = em.find(Category.class, (Integer)(request.getSession().getAttribute("category_id")));
	        c.setName(request.getParameter("name"));
	        c.setContent(request.getParameter("content"));

	        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	        c.setUpdated_at(currentTime);


	            em.getTransaction().begin();
	            em.getTransaction().commit();
	            em.close();

	            request.setAttribute("flush", "更新完了");
	            request.getSession().removeAttribute("category_id");

	            response.sendRedirect(request.getContextPath() + "/category/index");
	        }
	    }
	}

