package exercise1;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class for containing details of protein bar objects.
 * @author ImanolIruretagoiena
 * @version 2020.03.31
 */
public class ProteinBar {

	//Name of protein bar.
	private String name;
	//Serial number of protein bar.
	private String serialNumber;
	//Fat content of protein bar.
	private double fat;
	//Energy content of protein bar.
	private double energy;
	//Carbohydrate content of protein bar.
	private double carbohydrate;
	//Protein content of protein bar.
	private double protein;
	//Fiber content of protein bar.
	private double fiber;
	//List containing all reviews given to a specific protein bar.
	private ArrayList<Review> reviews;
	
	/**
	 * Getter method for name of protein bar.
	 * @return Name of protein bar.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter method for serial number of protein bar.
	 * @return Serial number of protein bar.
	 */
	public String getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * Setter method for serial number.
	 * @param serialNumber New serial number.
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	/**
	 * Getter method for fat content of protein bar.
	 * @return Fat content of protein bar.
	 */
	public double getFat() {
		return fat;
	}
	
	/**
	 * Setter method for fat content.
	 * @param fat New fat content.
	 */
	public void setFat(double fat) {
		this.fat = fat;
	}
	
	/**
	 * Getter method for energy content of protein bar.
	 * @return Energy content of protein bar.
	 */
	public double getEnergy() {
		return energy;
	}
	
	/**
	 * Setter method for name.
	 * @param name New name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Setter method for energy content.
	 * @param energy New energy content.
	 */
	public void setEnergy(double energy) {
		this.energy = energy;
	}
	
	/**
	 * Getter method for carbohydrate content of protein bar.
	 * @return Carbohydrate content of protein bar.
	 */
	public double getCarbohydrate() {
		return carbohydrate;
	}
	
	/**
	 * Setter method for carbohydrate content.
	 * @param carbohydrate New carbohydrate content.
	 */
	public void setCarbohydrate(double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	
	/**
	 * Getter method for protein content of protein bar.
	 * @return Protein content of protein bar.
	 */
	public double getProtein() {
		return protein;
	}
	
	/**
	 * Setter method for protein content.
	 * @param protein New protein content.
	 */
	public void setProtein(double protein) {
		this.protein = protein;
	}
	
	/**
	 * Getter method for fiber content of protein bar.
	 * @return Fiber content of protein bar.
	 */
	public double getFiber() {
		return fiber;
	}
	
	/**
	 * Setter method for fiber content.
	 * @param fiber New fiber content.
	 */
	public void setFiber(double fiber) {
		this.fiber = fiber;
	}
	
	/**
	 * Getter method for list of reviews for a protein bar.
	 * @return List of reviews.
	 */
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	
	/**
	 * Setter method for protein bar reviews.
	 * @param reviews New reviews.
	 */
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	
	/**
	 * Returns details of a protein bar.
	 * @return Details of a protein bar.
	 */
	public String getDetails() {
		return "Protein bar: " + name + ", Fat: " + fat + ", Energy: " + energy + ", Carbohydrate: "
				+ carbohydrate + ", Protein: " + protein + ", Fiber: " + fiber;
	}
	
	/**
	 * Comparator of protein content of two protein bars
	 */
	public static Comparator<ProteinBar> ProteinContentComparator = new Comparator<ProteinBar>() {
		
		public int compare(ProteinBar proteinBar1, ProteinBar proteinBar2) {
			double ProteinContent1 = proteinBar1.getProtein();
			double ProteinContent2 = proteinBar2.getProtein();
			return (ProteinContent1 > ProteinContent2 ? -1:1);
		}
	};
	
	/**
	 * Comparator of fat content of two protein bars.
	 */
	public static Comparator<ProteinBar> FatContentComparator = new Comparator<ProteinBar>() {
		
		public int compare(ProteinBar proteinBar1, ProteinBar proteinBar2) {
			double FatContent1 = proteinBar1.getFat();
			double FatContent2 = proteinBar2.getFat();
			return (FatContent1 > FatContent2 ? -1:1);
		}
	};
	
	/**
	 * Comparator of fiber content of two protein bars.
	 */
	public static Comparator<ProteinBar> FiberContentComparator = new Comparator<ProteinBar>() {
		
		public int compare(ProteinBar proteinBar1, ProteinBar proteinBar2) {
		double FiberContent1 = proteinBar1.getFiber();
		double FiberContent2 = proteinBar2.getFiber();
		return (FiberContent1 > FiberContent2 ? -1:1);
		}
	};
}
