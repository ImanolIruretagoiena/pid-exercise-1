package exercise1;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAXHandler class which defines how to read the XML file and
 * what actions to do depending on found word.
 * @author ImanolIruretagoiena
 * @version 2020.03.31
 */
public class SAXHandler extends DefaultHandler {

	//ArrayList to hold protein bar objects found in the XML
	private ArrayList<ProteinBar> proteinBarList = null;
	//Field to save new protein bar objects
	private ProteinBar proteinBar = null;
	//ArrayList to hold review objects found in the XML
	private ArrayList<Review> reviews = null;
	//Field to save new review objects
	private Review review = null;
	//String builder object to hold data read from the XML.
	private StringBuilder data = null;
	//Determines when to start reading XML file for fat values
	boolean bfat = false;
	//Determines when to start reading XML file for energy values.
	boolean benergy = false;
	//Determines when to start reading XML file for carbohydrate values.
	boolean bcarbohydrate = false;
	//Determines when to start reading XML file for protein values.
	boolean bprotein = false;
	//Determines when to start reading XML file for fiber values.
	boolean bfiber = false;
	//Determines when to start reading XML file for date values.
	boolean bdate = false;
	//Determines when to start reading XML file for score values.
	boolean bscore = false;
	
	/**
	 * Method which returns the ArrayList of all protein bars
	 * @return List of all protein bars.
	 */
	public ArrayList<ProteinBar> getProteinBarList(){
		return proteinBarList;
	}
	
	//boolean bfat = false;
	//boolean benergy = false;
	//boolean bcarbohydrate = false;
	//boolean bprotein = false;
	//boolean bfiber = false;
	//boolean bdate = false;
	//boolean bscore = false;
	
	/**
	 * Determines what to do whenever a start element (start tag) is found on the
	 * XML file. Different actions are performed depending on what the text in the
	 * start element contains.
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException{
		
		if(qName.contains("BAR")) {
			String barName = qName;
			String serNumber = attributes.getValue("SN");
			proteinBar = new ProteinBar();
			proteinBar.setName(barName);
			proteinBar.setSerialNumber(serNumber);
			if(proteinBarList == null) {
				proteinBarList = new ArrayList<>();
			}
		} else if(qName.equalsIgnoreCase("fett")) {
			bfat = true;
		} else if(qName.equalsIgnoreCase("energy")) {
			benergy = true;
		} else if(qName.equalsIgnoreCase("kolhydrat")) {
			bcarbohydrate = true;
		} else if(qName.equalsIgnoreCase("protein")) {
			bprotein = true;
		} else if(qName.equalsIgnoreCase("fiber")) {
			bfiber = true;
		} else if(qName.equalsIgnoreCase("review")) {
			reviews = new ArrayList<>();
		} else if(qName.equalsIgnoreCase("reviewer")) {
			String reviewerID = attributes.getValue("personID");
			review = new Review();
			review.setPersonID(reviewerID);
		} else if(qName.equalsIgnoreCase("date")) {
			bdate = true;
		} else if(qName.equalsIgnoreCase("score")) {
			bscore = true;
		}
		data = new StringBuilder();
	}
	
	/**
	 * Determines what to do whenever an end element (end tag) is found on the
	 * XML file. Different actions are performed depending on what the text in the
	 * end element contains and what the values of the boolean fields are.
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException{
		if(bfat == true) {
			proteinBar.setFat(Double.parseDouble(data.toString()));
			bfat = false;
		} else if(benergy == true) {
			proteinBar.setEnergy(Double.parseDouble(data.toString()));
			benergy = false;
		} else if(bcarbohydrate == true) {
			proteinBar.setCarbohydrate(Double.parseDouble(data.toString()));
			bcarbohydrate = false;
		} else if(bprotein == true) {
			proteinBar.setProtein(Double.parseDouble(data.toString()));
			bprotein = false;
		} else if(bfiber == true) {
			proteinBar.setFiber(Double.parseDouble(data.toString()));
			bfiber = false;
		} else if(bdate == true) {
			review.setDate(data.toString());
			bdate = false;
		} else if(bscore == true) {
			review.setScore(Integer.parseInt(data.toString()));
			bscore = false;
		}
		if(qName.equalsIgnoreCase("reviewer")) {
			reviews.add(review);
		} else if(qName.equalsIgnoreCase("review")) {
			proteinBar.setReviews(reviews);
		} else if(qName.contains("BAR")) {
			proteinBarList.add(proteinBar);
		}
	}
	
	/**
	 * Determines what to do with the text between the start and end elements.
	 * In this case, they are just added to a StringBuilder.
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException{
		data.append(new String(ch, start, length));
	}
}
