package mypackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {
	
	
	static final String filePath = "/Users/sreenidhiramanujam/Desktop/LockedMeFiles";
	static final String errorMsg = "Some error occured. Please try again.";
	static final Scanner readInput = new Scanner(System.in);

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		try
		{
			int choice;

			do 
			{
				displayMenu();
				
				System.out.println("Enter your choice:");
				choice = Integer.parseInt(readInput.nextLine());
				
				switch (choice)
				{
					case 1: displayAllFiles();
					break;
					case 2: createFile();
					break;
					case 3: deleteFile();
					break;
					case 4: searchFile();
					break;
					case 5: System.out.println("Thank you. Exiting the application!");
							System.exit(0);
					break;
					default: System.out.println("Invalid option"); 
					break;
				}
				
			}while(choice>0);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		finally 
		{
			readInput.close();
		}
	}
	
	/**
	 * This is a function to display Menu options to the user
	 */
	
	public static void displayMenu()
	{
		
		System.out.println("**********************************************************");
		System.out.println("\tWelcome to LockedMe.com");
		System.out.println("\t\t\t(Developed by Sreenidhi Ramanujam)");
		System.out.println("**********************************************************");
		System.out.println("1. Display All Files");
		System.out.println("2. Create new File");
		System.out.println("3. Delete a File");
		System.out.println("4. Search for a File");
		System.out.println("5. Exit");
		
	}
	
	/**
	 * This is a function to display all files in a directory in a specified path
	 */
	
	public static void displayAllFiles()
	{
		try
		{

			File folder = new File(filePath);
			File[] filesList = folder.listFiles();
			Arrays.sort(filesList);
			if (filesList.length == 0)
				System.out.println("No files in the directory");
			
			else 
			{
				System.out.println("Files in the directory are: ");
				for (var f:filesList)
				{
					if(f.isFile()) 
						System.out.println(f.getName());
				}
			}

		}catch(Exception ex) 
		{
			System.out.println(errorMsg);
		}	
	}
	
	/**
	 * This is a function to create a new file if it doesn't already exist
	 */
	
	public static void createFile()
	{
		
		try
		{
			String fileName;
			System.out.println("Enter the file name to be created:");
			fileName = readInput.nextLine();
			File file = new File(filePath+ "/" +fileName);
			if(file.createNewFile())
				System.out.println("File " +fileName+ " was created successfully");
			else
				System.out.println("File " +fileName+ " already exists");
		}
		catch(Exception ex) 
		{
			System.out.println(errorMsg);
		}
	}
	
	/**
	 * This is a function to delete a user specified file
	 */
	
	public static void deleteFile()
	{
		try
		{
			String fileName;
			System.out.println("Enter file name to delete: ");
			fileName = readInput.nextLine();
			File file = new File(filePath +"/"+ fileName);
			if(file.exists())
			{
				file.delete();
				System.out.println("File " +fileName+ " deleted successfully");
			}
			else
				System.out.println("File " +fileName+ " is not available");
			
		}
		catch(Exception ex)
		{
			System.out.println(errorMsg);
		}
	}
	
	/**
	 * This is a function to search for a user specified file
	 */
	
	public static void searchFile()
	{
		try
		{
			String fileName;
			System.out.println("Enter file name to search: ");
			fileName = readInput.nextLine();
			File folder = new File(filePath);
			File[] filesList = folder.listFiles();
			ArrayList<String> filenames = new ArrayList<String>();
			if (filesList.length == 0)
				System.out.println("No files in the directory");
			
			else 
			{
				for (var f:filesList)
					filenames.add(f.getName().toLowerCase());
				
				if(filenames.contains(fileName.toLowerCase()))
					System.out.println("File " +fileName+ " is available");
				else
					System.out.println("File " +fileName+ " is not available");
				
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(errorMsg);
		}
	}
}
