package controllers.hanrei;

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

import models.Hanrei;
import models.validator.HanreiValidator;
import utils.DBUtil;
/**
 * Servlet implementation class HanreiCreateServlet
 */
@WebServlet("/hanrei/create")
public class HanreiCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HanreiCreateServlet() {
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

	        Hanrei h = new Hanrei();

	        h.setId(Integer.parseInt(request.getParameter("id")));
	        h.setName(request.getParameter("name"));
	        h.setContent(request.getParameter("content"));
	        h.setYear(request.getParameter("year"));
	        h.setUrl(request.getParameter("url"));

	        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	        h.setCreated_at(currentTime);
	        h.setUpdated_at(currentTime);

	        List<String>errors = HanreiValidator.validate(h);
	        if(errors.size() > 0){
	            em.close();

	            request.setAttribute("hanrei", h);
	            request.setAttribute("errors", errors);
	            request.setAttribute("_token", request.getSession().getId());

	            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/hanrei/new.jsp");
	            rd.forward(request, response);
	        }else{
	            em.getTransaction().begin();
	            em.persist(h);
	            em.getTransaction().commit();
	            em.close();

	            response.sendRedirect(request.getContextPath() + "/hanrei/index?id=${sessionScope.employee_id}");
	        }


	    }
	}

}
