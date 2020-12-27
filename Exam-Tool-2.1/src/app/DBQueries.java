package app;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// TODO: Auto-generated Javadoc
/**
 * The Class DBQueries.
 */
public class DBQueries {
	
	
	/**
	 * Creates and gets the connection to the database.
	 *
	 * @return the connection
	 * @throws Exception the exception
	 */
	private static Connection getConnection() throws Exception
	{
		Connection c =null;
		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		c = DriverManager.getConnection("jdbc:mysql://localhost/exam?user=root&password=Kdurant35");
		return c;
	}
	
	/**
	 * Creates a JSON Array from the string of choices.
	 *
	 * @param choices the choices
	 * @return the JSON array
	 * @throws ParseException the parse exception
	 */
	private static JSONArray choiceCreator(String choices) throws ParseException
	{
		JSONParser js = new JSONParser();
		JSONArray j = (JSONArray)js.parse(choices);
		return j;
	}
	
	/**
	 * Stores the test information from the database into a test object.
	 *
	 * @return the test
	 * @throws Exception the exception
	 */
	public Test storeTestInfo() throws Exception
	{
		String query = "SELECT * FROM exam.masterbank";
		ArrayList<Question> q = new ArrayList<>();
		JSONArray j = null;
		try(Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);){
			rs.first();
			Question q2 = new Question(rs.getInt("id"),rs.getString("questionType"),rs.getString("question"));
			if(q2.getType().equalsIgnoreCase("MC"))
			{
				j = choiceCreator(rs.getString("choices"));
				q2.addChoices(j);
			}
			q.add(q2);
			while(rs.next())
			{
				Question q1 = new Question(rs.getInt("id"),rs.getString("questionType"),rs.getString("question"));
				if(q1.getType().equalsIgnoreCase("MC"))
				{
					j = choiceCreator(rs.getString("choices"));
					q1.addChoices(j);
				}
				q.add(q1);
			}
			Collections.shuffle(q);
		}
		return new Test(q,null,0);
	}
	
	/**
	 * Gets the choices for the question matching the question id in the database.
	 *
	 * @param questionId the question id
	 * @return the choices
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public JSONArray getChoices(int questionId) throws SQLException, Exception
	{
		JSONArray j = new JSONArray();
		String query = "SELECT * FROM exam.masterbank WHERE id = " + questionId;
		try(Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);)
		{
			rs.next();
			j = choiceCreator(rs.getString("choices")); 
		}
		return j;
	}
	
	/**
	 * Adds a student to the database.
	 *
	 * @param s the s
	 * @throws Exception the exception
	 */
	public void addStudent(Student s) throws Exception
	{
		String query = "INSERT INTO exam.student"+
				        " VALUES(" + s.getIdNumber() + ", "+"'" +s.getName()+"'"+ ", "+s.getRecitationNum()+", "+"'"+s.getNetID()+"'"+", "+"'"+s.getPassword()+"'"+")";
		try(Connection con = getConnection(); Statement stmt = con.createStatement()){
				stmt.executeUpdate(query);
		}	
	}
	
	/**
	 * Records a student's answer in the database.
	 *
	 * @param studentId the student id
	 * @param currentQuestionId the current question id
	 * @param studentAnswer the student answer
	 * @throws Exception the exception
	 */
	public void recordAnswer(int studentId,int currentQuestionId,String studentAnswer) throws Exception
	{
		String query = "INSERT INTO exam.test" +
						" VALUES(" + studentId+", " + currentQuestionId+", " +"'"+ studentAnswer+"'"+")";
		try(Connection con = getConnection(); Statement stmt = con.createStatement()){
			stmt.executeUpdate(query);
		}
	}
	
	

}
