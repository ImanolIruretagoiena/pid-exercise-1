package exercise1;

import java.util.Scanner;

/**
 * Main class for exercise 1.
 * @author ImanolIruretagoiena
 * @version 2020.03.31
 */
public class Main {

	/**
	 * Runs the application.
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		
		ProteinBarOrganizer proteinBarOrganizer = new ProteinBarOrganizer();
		Scanner keyboard = new Scanner(System.in);
		proteinBarOrganizer.readDataFromXML();
		proteinBarOrganizer.displayApplicationHeader();
		while(true) {
			proteinBarOrganizer.displayOptionMenu();
			System.out.println("Select option(1, 2, 3, 4, 5 or 6): ");
			int operation = keyboard.nextInt();
			
			if(operation == 1) {
				proteinBarOrganizer.showBarNames();
			} else if(operation == 2) {
				proteinBarOrganizer.sortBarsByHighestProteinContent();
			} else if(operation == 3) {
				proteinBarOrganizer.sortBarsByHighestFatContent();
			} else if(operation == 4) {
				proteinBarOrganizer.filterBarsByEnteredFiberAndSortByHighest();
			} else if(operation == 5) {
				proteinBarOrganizer.findBarsWithMoreProteinAndReviewedBy();
			} else if(operation == 6) {
				System.out.println("\n" + "Goodbye!");
				break;
			}
		}
		keyboard.close();
	}

}
