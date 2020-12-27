package app;

import org.json.simple.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
public class Student {
	
	/** The name of the student. */
	private String name;
	
	/** The recitation number. */
	private int recitationNum;
	
	/** The netID. */
	private String netID;
	
	/** The password. */
	private String password;
	
	/** The student's id number. */
	private int idNumber;
	
	/** The student's answer. */
	private String answer;
	
	/**
	 * Instantiates a new student.
	 *
	 * @param idNumber the id number
	 * @param name the name
	 * @param recitationNum the recitation number
	 * @param netID the net ID
	 * @param password the password
	 */
	public Student(int idNumber,String name,int recitationNum,String netID,String password)
	{
		this.idNumber = idNumber;
		this.name = name;
		this.recitationNum = recitationNum;
		this.netID = netID;
		this.password = password;
	}
	
	/**
	 * Creates a JSON object that contains the student's id .
	 *
	 * @return the JSON object
	 */
	public JSONObject toJson()
	{
		JSONObject j = new JSONObject();
		j.put("id", idNumber);
		return j;
	}
	
	/**
	 * Gets the id number.
	 *
	 * @return the id number
	 */
	public int getIdNumber() {
		return idNumber;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the recitation number.
	 *
	 * @return the recitation number
	 */
	public int getRecitationNum() {
		return recitationNum;
	}
	
	/**
	 * Gets the net ID.
	 *
	 * @return the net ID
	 */
	public String getNetID() {
		return netID;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Gets the student answer.
	 *
	 * @return the student answer
	 */
	public String getStudentAnswer()
	{
		return answer;
	}

}
