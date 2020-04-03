package exercise1;

/**
 * Class for review objects.
 * @author ImanolIruretagoiena
 * @version 2020.03.31
 */
public class Review {

	//ID of the reviewing person.
	private String personID;
	//Score given by the reviewer.
	private int score;
	//Date of the review.
	private String date;
	
	/**
	 * Getter method for personID.
	 * @return Person ID.
	 */
	public String getPersonID() {
		return personID;
	}
	
	/**
	 * Setter method to change personID.
	 * @param personID New ID.
	 */
	public void setPersonID(String personID) {
		this.personID = personID;
	}
	
	/**
	 * Getter method for score.
	 * @return Score given by reviewer.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Setter method to change score.
	 * @param score New score.
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Getter method for date.
	 * @return Date of the review.
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Setter method to change date.
	 * @param date New date.
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
