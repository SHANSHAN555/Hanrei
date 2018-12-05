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
 * Servlet implementation class MessageCreateServlet
 */
@WebServlet("/message/create")
public class MessageCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageCreateServlet() {
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

	        Message m = new Message();

	        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	        m.setCreated_at(currentTime);
	        m.setUpdated_at(currentTime);
	        m.setName(request.getParameter("name"));
	        m.setTitle(request.getParameter("title"));
	        m.setContent(request.getParameter("content"));

	        List<String>errors = MessageValidator.validate(m);
	        if(errors.size() > 0){
	            em.close();

	            request.setAttribute("_token", _token);
	            request.setAttribute("message", m);
	            request.setAttribute("errors",errors );

	            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/message/index.jsp");
	            rd.forward(request, response);

	        }else{
	            em.getTransaction().begin();
	            em.persist(m);
	            em.getTransaction().commit();
	            em.close();
	        }

	        request.getSession().setAttribute("flush", "依頼が完了しました");
	        response.sendRedirect(request.getContextPath() + "/message/index");
	    }

	}

}
