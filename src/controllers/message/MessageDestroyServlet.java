package controllers.message;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
import utils.DBUtil;

/**
 * Servlet implementation class MessageDestroyServlet
 */
@WebServlet("/message/destroy")
public class MessageDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageDestroyServlet() {
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

	        Message m = em.find(Message.class, (Integer)request.getSession().getAttribute("message_id"));

	        em.getTransaction().begin();
	        em.remove(m);
	        em.getTransaction().commit();
	        em.close();

	        request.getSession().setAttribute("flush", "削除完了");
	        request.getSession().removeAttribute("message_id");

	        response.sendRedirect(request.getContextPath() + "/message/index");
	    }
	}

}
