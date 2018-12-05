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

import models.Hanrei;
import utils.DBUtil;

/**
 * Servlet implementation class HanreiIndexServlet
 */
@WebServlet("/hanrei/index")
public class HanreiIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HanreiIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();

		int page = 1;
		try{
		    page = Integer.parseInt(request.getParameter("page"));
		}catch(NumberFormatException e){}

		List<Hanrei> hanrei = em.createNamedQuery("getAllHanrei", Hanrei.class)
		        .setFirstResult(10 * (page - 1))
		        .setMaxResults(10)
		        .getResultList();
		long hanrei_count = em.createNamedQuery("getHanreiCount", Long.class)
		        .getSingleResult();

		request.setAttribute("hanrei", hanrei);
		request.setAttribute("page", page);
		request.setAttribute("hanrei_count", hanrei_count);
		if(request.getSession().getAttribute("flush") != null){
		    request.setAttribute("flush", request.getSession().getAttribute("flush"));
		    request.getSession().removeAttribute("flush");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/hanrei/index.jsp");
		rd.forward(request, response);

	}

}
