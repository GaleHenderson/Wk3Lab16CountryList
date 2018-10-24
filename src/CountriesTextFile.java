

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {

	public static void main(String[] args) {
		
		//creates directory and file
		String directoryFolder = "WkL16CountruList";
		String fileName = "countries.txt";
		createDirectory(); 
		createFile(directoryFolder, fileName);
		//writeToFile(directoryFolder, fileName);
		//readFromFile(directoryFolder, fileName);

	}

	public static void readFromFile(String directoryFolder, String fileName) {
		Path filePath = Paths.get(directoryFolder, fileName);
		File file = filePath.toFile();
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("Contact customer service.");
		}

	}
	
	
	public static void writeToFile(String userCountry) {
		String directoryFolder = "WkL16CountruList";
		String fileName = "countries.txt";
		Path filePath = Paths.get(directoryFolder, fileName);
		File file = filePath.toFile();
		Country s = new Country(userCountry);
		
		try {
			//the true parameter for the file output stream constructor appends data 
			//to the end of the file. False rewrites over the entire file
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(s);
			outW.close(); //mandatory: this needs to be closed when done or may not write all info
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found.");
		}

		
	}
	
	
	public static void createFile(String directoryFolder, String fileName) {
		 
		Path filePath = Paths.get(directoryFolder, fileName);
		if (Files.notExists(filePath)) {
		try {
			Files.createFile(filePath);
			System.out.println("The file was created successfuly.");
		} catch (IOException e) {
			System.out.println("Something went wrong with the file creation.");
			e.printStackTrace();
		}
		}else {
			System.out.println("File already exists.");
		}
	}
	
	public static void createDirectory() {
		String dirPath = "WkL16CountruList";
		Path folder = Paths.get(dirPath);
		if (Files.notExists(folder)) {
			
			//example of checked exception
			try {
				Files.createDirectories(folder);
				System.out.println("The folder was created successfuly.");
			} catch (IOException e) {
				System.out.println("Something went wrong with the folder creation.");
			}
		}
	}
	
}
