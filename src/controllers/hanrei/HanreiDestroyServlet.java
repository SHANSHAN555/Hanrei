package controllers.hanrei;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Hanrei;
import utils.DBUtil;

/**
 * Servlet implementation class HanreiDestroyServlet
 */
@WebServlet("/hanrei/destroy")
public class HanreiDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HanreiDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String _token =(String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){
            EntityManager em = DBUtil.createEntityManager();

            Hanrei h = em.find(Hanrei.class, (Integer)request.getSession().getAttribute("hanrei_id"));

            em.getTransaction().begin();
            em.remove(h);
            em.getTransaction().commit();
            em.close();

            request.getSession().setAttribute("flush", "削除完了");
            request.getSession().removeAttribute("hanrei_id");

            response.sendRedirect(request.getContextPath() + "/hanrei/index?id=${sessionScope.employee_id}");
        }	}

}
