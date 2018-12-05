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
 * Servlet implementation class HanreiUpdateServlet
 */
@WebServlet("/hanrei/update")
public class HanreiUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HanreiUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubhanrei
	    String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){
            EntityManager em = DBUtil.createEntityManager();

            Hanrei h = em.find(Hanrei.class, (Integer)(request.getSession().getAttribute("hanrei_id")));

            h.setName(request.getParameter("name"));
            h.setUrl(request.getParameter("url"));
            h.setYear(request.getParameter("year"));
            h.setContent(request.getParameter("content"));

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            h.setUpdated_at(currentTime);

            List<String>errors = HanreiValidator.validate(h);
            if(errors.size() > 0){
                em.close();

                request.setAttribute("hanrei", h);
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/hanrei/edit?id=${hanrei_id}");
                rd.forward(request, response);

            }else{
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();

                request.getSession().setAttribute("flush","更新完了");
                request.getSession().removeAttribute("hanrei_id");

                response.sendRedirect(request.getContextPath() + "/hanrei/index?id=${sessionScope.employee_id}");
            }
        }
	}

}
