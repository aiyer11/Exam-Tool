package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class Servlet.
 */
public class Servlet extends HttpServlet{
	 
	/**
	 * Do post.
	 *
	 * @param req the req
	 * @param res the res
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		LoginController c = new LoginController();
		if(req.getRequestURL().toString().endsWith("/web/add"))
		{
			try {
				c.setup(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(req.getRequestURL().toString().endsWith("/web/store"))
		{
			MultipleChoiceController mc = new MultipleChoiceController();
			try {
				mc.storeAnswer(req,res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(req.getRequestURL().toString().equals("http://localhost:8080/Exam_Tool_2.1/web/storeSA"))
		{
			ShortAnswerController sc = new ShortAnswerController();
			try {
				sc.storeAnswer(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
