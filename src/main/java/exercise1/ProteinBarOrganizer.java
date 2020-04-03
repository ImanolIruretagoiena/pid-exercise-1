package exercise1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * Class for organizing protein bars and do different actions with the
 * protein bar list.
 * @author ImanolIruretagoiena
 * @version 2020.03.31
 */
public class ProteinBarOrganizer {

	//ArrayList containing all protein bars.
	private ArrayList<ProteinBar> proteinBarList;
	//Scanner for user input.
	Scanner keyboard;
	
	/**
	 * Constructor for new ProteinBarOrganizer objects. Initialises
	 * the ArrayList and the Scanner.
	 */
	public ProteinBarOrganizer() {
		proteinBarList = new ArrayList<>();
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * Displays application header when application is first started.
	 */
	public void displayApplicationHeader() {
		System.out.println("Protein Bar Database" + "\n"  + "\n" + "---------------------" + "\n"
		+ "\n" + "Welcome to Protein Bar Database");
	}
	
	/**
	 * Displays user menu with different options for what action to do next.
	 */
	public void displayOptionMenu() {
		System.out.println("\n" + "Pick an option:" + "\n" + "\n" + "(1) Show name of all bars" + "\n" 
	    + "(2) Sort bars based on highest protein content" + "\n" 
		+ "(3) Sort bars based on highest fat content" + "\n" 
	    + "(4) Filter bars by maximum fiber content and sort based on highest fiber content" + "\n"
		+ "(5) Find bars by minimum protein content and reviewer" + "\n" + "(6) Quit" + "\n");
	}
	
	/**
	 * Method which reads the data from the XML file and stores it in
	 * the ArrayList.
	 */
	public void readDataFromXML() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			SAXHandler handler = new SAXHandler();
			saxParser.parse("bars.xml", handler);
			proteinBarList = handler.getProteinBarList();
		} catch(ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Shows name and details of all available protein bars.
	 */
	public void showBarNames() {
		System.out.println("\n" + "All bar names:" + "\n");
		for(ProteinBar bar : proteinBarList) {
			System.out.println(bar.getDetails());
		}
	}
	
	/**
	 * Sorts protein bars by highest protein content and prints their details.
	 */
	public void sortBarsByHighestProteinContent() {
		Collections.sort(proteinBarList, ProteinBar.ProteinContentComparator);
		System.out.println("\n" + "List sorted by protein content:" + "\n");
		for(ProteinBar bar : proteinBarList) {
			System.out.println(bar.getDetails());
		}

	}
	
	/**
	 * Sorts protein bars by highest fat content and prints their details.
	 */
	public void sortBarsByHighestFatContent() {
		Collections.sort(proteinBarList, ProteinBar.FatContentComparator);
		System.out.println("\n" + "List sorted by fat content:" + "\n");
		for(ProteinBar bar : proteinBarList) {
			System.out.println(bar.getDetails());
		}
	}
	
	/**
	 * Filters protein bars by maximum fiber content specified by the user and
	 * sorts them by highest fiber content, then printing their details.
	 */
	public void filterBarsByEnteredFiberAndSortByHighest() {
		System.out.println("\n" + "Enter maximum fiber content: ");
		Double fiberContent = keyboard.nextDouble();
		List<ProteinBar> filteredByFiber = proteinBarList.stream()
												.filter(bar -> fiberContent > bar.getFiber())
												.collect(Collectors.toList());
		Collections.sort(filteredByFiber, ProteinBar.FiberContentComparator);
		System.out.println("\n" + "List sorted by fiber content: " + "\n");
		for(ProteinBar bar : filteredByFiber) {
			System.out.println(bar.getDetails());
		}
	}
	
	/**
	 * Selects only the protein bars with a protein amount higher than the one
	 * specified by the user and containing a review by the reviewer specified
	 * by the user. Then prints their details.
	 */
	public void findBarsWithMoreProteinAndReviewedBy() {
		System.out.println("\n" + "Enter minimum protein content: ");
		Double proteinContent = keyboard.nextDouble();
		keyboard.nextLine();
		System.out.println("\n" + "Enter reviewer ID: ");
		String reviewerID = keyboard.nextLine();
		List<ProteinBar> filteredByProtein = proteinBarList.stream()
												.filter(bar -> proteinContent < bar.getProtein())
												.collect(Collectors.toList());
		List<ProteinBar> filteredByProteinAndReviewer = new ArrayList<>();
		for(ProteinBar bar : filteredByProtein) {
			List<Review> filteredByProteinReviews = bar.getReviews();
			for(Review review : filteredByProteinReviews) {
				if(reviewerID.equals(review.getPersonID())){
					filteredByProteinAndReviewer.add(bar);
				}
			}
		}
		System.out.println("\n" + "Protein bars with specified protein content and reviewer: " + "\n");
		for(ProteinBar bar : filteredByProteinAndReviewer) {
			System.out.println(bar.getDetails());
		}
	}
}
