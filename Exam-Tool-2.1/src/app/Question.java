package app;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Question.
 */
public class Question {
	
	/** The question. */
	private String question;
	
	/** The question id. */
	private int questionId;
	
	/** The type of question. */
	private String type;
	
	/** The choices(Only really used for multiple choice questions). */
	private ArrayList<String>choices = new ArrayList<>();
	
	/**
	 * Instantiates a new question.
	 *
	 * @param questionId the question id
	 * @param type the type
	 * @param question the question
	 */
	public Question(int questionId, String type,String question)
	{
		this.type = type;
		this.question = question;
		this.questionId = questionId;
	}
	
	/**
	 * Creates a JSON Object with the question's information.
	 *
	 * @return the JSON object
	 */
	public JSONObject toJSon()
	{
		JSONObject ques = new JSONObject();
		ques.put("question", question);
		ques.put("id", questionId);
		ques.put("type", type);
		return ques;
	}
	
	/**
	 * Gets the question id.
	 *
	 * @return the question id
	 */
	public int getQuestionId()
	{
		return questionId;
	}
	
	/**
	 * Gets the type of the question.
	 *
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * Takes a JSON Array and adds the values to the question's choice list.
	 *
	 * @param choice the choice
	 */
	public void addChoices(JSONArray choice)
	{
		Iterator<String> iterator = choice.iterator();
		while(iterator.hasNext())
		{
			String c = iterator.next();
			choices.add(c);
		}
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString()
	{
		return question;
	}
	

}
