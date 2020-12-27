package app;

import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// TODO: Auto-generated Javadoc
/**
 * The Class MultipleChoiceController.
 */
public class MultipleChoiceController {
	
	/**
	 * Creates an ArrayList of questions from the JSON Array.
	 *
	 * @param j the j
	 * @return the array list
	 */
	private ArrayList<Question> questionParser(JSONArray j)
	{
		ArrayList<Question> q = new ArrayList<>();
		Iterator<JSONObject> i = j.iterator();
		while(i.hasNext())
		{
			JSONObject o = i.next();
			Long l = (Long)o.get("id");
			q.add(new Question(l.intValue(),(String)o.get("type"),(String)o.get("question")));
		}
		return q;
		
	}
	
	/**
	 * Stores the student's answer into the database and redirects to the next question.
	 *
	 * @param req the req
	 * @param res the res
	 * @throws Exception the exception
	 */
	public void storeAnswer(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		DBQueries q = new DBQueries();
		JSONParser p = new JSONParser();
		JSONObject s = (JSONObject)p.parse((String)req.getSession().getAttribute("Student"));
		JSONObject ques = (JSONObject)p.parse((String)req.getSession().getAttribute("Question"));
		JSONObject t = (JSONObject)p.parse((String)req.getSession().getAttribute("Test"));
		s.put("answer",(String)req.getParameter("choice"));
		Long l = (Long)s.get("id");
		Long l1 = (Long)ques.get("id");
		q.recordAnswer(l.intValue(),l1.intValue(),(String)s.get("answer"));
		ArrayList<Question> questions = questionParser((JSONArray)t.get("questions"));
		Long l2 = (Long)t.get("counter");
		int counter = l2.intValue();
		JSONObject c = (JSONObject)t.get("current");
		Long l3 = (Long)c.get("id");
		Question cur = new Question(l3.intValue(),(String)c.get("type"),(String)c.get("question"));
		Test t1 = new Test(questions,cur,counter);
		Question q1 = t1.giveQuestion();
		JSONObject test = t1.toJSon();
		req.getSession().setAttribute("Test", test.toString());
		if(q1 != null)
		{
			JSONObject question = q1.toJSon();
			req.getSession().setAttribute("Question", question.toString());
		}
		else
		{
			res.sendRedirect("http://localhost:8080/Exam_Tool_2.1/Finish.jsp");
			return;
		}
		if(q1.getType().equalsIgnoreCase("MC"))
		{
			res.sendRedirect("http://localhost:8080/Exam_Tool_2.1/MultiChoice.jsp");
		}
		else if(q1.getType().equalsIgnoreCase("SA"))
		{
			res.sendRedirect("http://localhost:8080/Exam_Tool_2.1/ShortAnswer.jsp");
		}
	}
}
