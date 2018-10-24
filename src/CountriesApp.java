
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int menuSelection;
		String userCountry;
		String directoryFolder = "WkL16CountruList";
		String fileName = "countries.txt";
		String userCont = "Y";

		//greet user and provide menu options
		System.out.println("Welcome to the Countries App! Here you can:");
		System.out.println();
		
		while (userCont.equalsIgnoreCase("y")) {
		System.out.println("1. View a list of recommended countries to visit.");
		System.out.println("2. Add countries you've visited to the above mentioned list.");
		System.out.println("3. Refrain from participating.");
		System.out.println();
		
		//instruct user to select option
		menuSelection = Validator.getInt(scan, "Please select a number corresponding to the option you'd like to select.", 1, 3);
		
		if (menuSelection == 1) {
			CountriesTextFile.readFromFile(directoryFolder, fileName);
		}else if (menuSelection == 2) {
			userCountry = Validator.getString(scan, "Please enter the name of a country you have visted: ");
			System.out.println("You have added " + userCountry + " to our list of user recommended locations.");
			CountriesTextFile.writeToFile(userCountry);
		}else {
			System.out.println("We understand that you are not interested in travel at this time. Please visit again once you are.");;
		}
		
		userCont = Validator.getString(scan, "Would you like to continue? (Y/N)");
		System.out.println();
	}
		System.out.println("Goodbye!");
	}

}
