package controllers.message;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
import models.validator.MessageValidator;
import utils.DBUtil;
/**
 * Servlet implementation class MessageUpdateServlet
 */
@WebServlet("/message/update")
public class MessageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageUpdateServlet() {
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

	        Message m = em.find(Message.class, (Integer)(request.getSession().getAttribute("message_id")));

	        m.setName(request.getParameter("name"));
	        m.setTitle(request.getParameter("title"));
	        m.setContent(request.getParameter("content"));

	        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	        m.setUpdated_at(currentTime);

	        List<String>errors = MessageValidator.validate(m);
	        if(errors.size() > 0){
	            em.close();

	            request.setAttribute("message", m);
	            request.setAttribute("_token", request.getSession().getId());
	            request.setAttribute("error", errors);

	            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/message/edit?id=${message_id}");
	            rd.forward(request, response);

	        }else{
	            em.getTransaction().begin();
	            em.getTransaction().commit();
	            em.close();

	            request.getSession().setAttribute("flush","更新完了");
	            request.getSession().removeAttribute("message_id");

	            response.sendRedirect(request.getContextPath() + "/message/index");
	        }
	    }
	}

}
