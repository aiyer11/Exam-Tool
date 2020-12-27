package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 */
public class Test{
	
	/** The list of questions. */
	private ArrayList<Question> questions;
	
	/** The current question in the test. */
	private Question current;
	
	/** The question number. */
	private int counter;
	
	/**
	 * Instantiates a new test.
	 *
	 * @param questions the questions
	 * @param current the current
	 * @param counter the counter
	 */
	public Test(ArrayList<Question> questions,Question current,int counter)
	{
		this.questions = questions;
		this.current = current;
		this.counter = counter;
	}
	
	/**
	 * Creates a JSON Object with the test's information.
	 *
	 * @return the JSON object
	 */
	public JSONObject toJSon()
	{
		JSONObject j = new JSONObject();
		j.put("current", current.toJSon());
		j.put("questions", questionJson());
		j.put("counter", counter);
		return j;
	}
	
	/**
	 * Converts the list of questions into a JSON Array.
	 *
	 * @return the JSON array
	 */
	public JSONArray questionJson()
	{
		JSONArray j = new JSONArray();
		for(int i = 0; i < questions.size(); i++)
		{
			j.add(questions.get(i).toJSon());
		}
		return j;
	}
	
	/**
	 * Gets the question list.
	 *
	 * @return the question list
	 */
	public ArrayList<Question> getQuestionList()
	{
		return questions;
	}
	
	/**
	 * Gets the current question.
	 *
	 * @return the current
	 */
	public Question getCurrent()
	{
		return current;
	}
	
	/**
	 * Gives a question from the question list to the student.
	 *
	 * @return the question
	 */
	public Question giveQuestion()
	{
		if(counter == questions.size())
		{
			return null;
		}
		current = questions.get(counter);
		counter++;
		return current;
		
	}
	
	/**
	 * Gets the counter.
	 *
	 * @return the counter
	 */
	public int getCounter()
	{
		return counter;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString()
	{
		String question = "";
		for(int i = 1; i <= questions.size(); i++)
		{
			question += i + questions.get(i).toString();
		}
		return question;
	}

	
	

}
