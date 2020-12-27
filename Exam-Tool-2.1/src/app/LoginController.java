package app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
public class LoginController {
	
	/**
	 * Creates a Test and a Question and redirects the user to the appropriate url depending on the question type.
	 *
	 * @param req the request
	 * @param res the response
	 * @throws Exception the exception
	 */
	public void setup(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		
		DBQueries q = new DBQueries();
		int id = Integer.valueOf(req.getParameter("idNum")); 
		String name = req.getParameter("studentName");
		int rNum = Integer.valueOf(req.getParameter("recNum"));
		String nId = req.getParameter("netid");
		String password = req.getParameter("password");
		Student s = new Student(id,name,rNum,nId,password);
		JSONObject student = s.toJson();
		req.getSession().setAttribute("Student", student.toString());
		q.addStudent(s);
		Test t = q.storeTestInfo();
		Question q1 = t.giveQuestion();
		JSONObject test = t.toJSon();
		req.getSession().setAttribute("Test", test.toString());
		JSONObject question = q1.toJSon();
		req.getSession().setAttribute("Question", question.toString());
		if(q1.getType().equalsIgnoreCase("MC"))
		{
			res.sendRedirect(req.getContextPath()+"/MultiChoice.jsp");
		}
		else if(q1.getType().equalsIgnoreCase("SA"))
		{
			res.sendRedirect(req.getContextPath()+"/ShortAnswer.jsp");
		}
	}

}
