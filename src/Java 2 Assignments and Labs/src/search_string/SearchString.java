package search_string;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class SearchString
{
  public static final String TO_STOP = "-1";
  public static final int NOT_FOUND = -1;
  public static final int MAX_SIZE = 10000;

  public static int count1;
  public static int count2;
  public static int count3;

  //public static int sequentialSearch(ArrayList<String> array, String value)
  public int sequentialSearch(ArrayList<String> array, String value)
  {
	int low = 0;
	int high = array.size()- 1;
	for (int i = low; i <= high; i++){
		count1++;
		if (array.get(i).equals(value))
			return i;
	}
	return NOT_FOUND;
  } // end of sequentialSearch()
  
  //I assume sequentialSearch1, 2 and 3 are not needed (just a different implementation?)
  public int sequentialSearch1(ArrayList<String> list, String item)
  {
    int location = -1;
    for (int i = 0; i < list.size(); i++){
      if (list.get(i).equals(item))
        location = i;
      }
      return location;
  }

  public int sequentialSearch2(ArrayList<String> list, String item)
  {
    int location = -1;
    boolean found = false;
    for (int i = 0; i < list.size() && !found; i++){
      if (list.get(i).equals(item))
      {
        location = i;
        found = true;
      }
    }
    return location;
  }

  public int sequentialSearch3(ArrayList<String> list, String item)
  {
	  int index = 0;
	  boolean found = false;
	  while (!found && index < list.size()){
		  if (list.get(index).equals(item))
		  	found = true;
		  else
		  	index++;
	  }
	  return index;
   }

  //public static int binarySearch(ArrayList<String> array, String value)
  public int binarySearch(ArrayList<String> array, String value)
  {
	int low = 0;
	int high = array.size() - 1;
	while (low <= high) {
		int mid = (low + high)/2;
		count2++;
		if (mid > array.indexOf(value)){
			high = mid - 1;
		} else if (mid < array.indexOf(value)){
			low = mid + 1;
	   	} else
			return mid;
	}
	return NOT_FOUND;
  } // end of binarySearch()

  //public static int binarySearch(ArrayList<String> array, int low, int high, String value)
  public int binarySearch(ArrayList<String> array, int low, int high, String value)
  {
	if (low > high)
		return NOT_FOUND;
	int mid = (low + high)/2;
	count3++;
	if (mid > array.indexOf(value)){
		return binarySearch(array, low, mid-1, value);
	} else if (mid < array.indexOf(value)){
		return binarySearch(array, mid+1, high, value);
	} else
		return mid;
  } // end of binarySearch()



  public static void main(String[] args) throws IOException
  {

	ArrayList<String> array = new ArrayList<>();

	Scanner keyboard = new Scanner(System.in);

    boolean wantToContinue = true;

	SearchString ss = new SearchString(); //Must create an object and use it in main if using instance methods. (H5 of pdf)
	
	//File reading
	System.out.print("Type the filename to read: ");
	String filename = keyboard.nextLine();
	
	// Open the file.
	File file = new File(filename);
	Scanner inputFile = new Scanner(file);	
	int wordCount = 0;	
	
	// Read lines (line by line) from the file until no more are left.
	while (inputFile.hasNext()){
		
		// Read the next name.
		String word = inputFile.nextLine();
		wordCount++;
		
		//Populate the list
		array.add(word);
	}	
	System.out.println(wordCount + " words are populated in the instance of ArrayList");
	
	// Close the file.
	inputFile.close();

    do {
		//Searching
		System.out.print("Type a word to search ("+ TO_STOP + " to stop): ");
		String word2Search = keyboard.nextLine();
		
		if (word2Search.equals(TO_STOP)){
			wantToContinue = false;
		} else {
			count1 = count2 = count3 = 0;
			int index;

			index = ss.sequentialSearch(array, word2Search); //using instance methods
			if (index == NOT_FOUND)
				System.out.println("sequentialSearch()      : " + word2Search + " is not found (comparison=" + count1 + ").");
			else
				System.out.println("sequentialSearch()      : " + word2Search + " is found in [" + index + "] (comparison=" + count1 + ").");

			index = ss.binarySearch(array, word2Search);
			if (index == NOT_FOUND)
				System.out.println("iterative binarySearch(): " + word2Search + " is not found (comparison=" + count2 + ").");
			else
				System.out.println("iterative binarySearch(): " + word2Search + " is found in [" + index + "] (comparison=" + count2 + ").");

			index = ss.binarySearch(array, 0, array.size()-1, word2Search);
			if (index == NOT_FOUND)
				System.out.println("recursive binarySearch(): " + word2Search + " is not found (comparison=" + count3 + ").");
			else
				System.out.println("recursive binarySearch(): " + word2Search + " is found in [" + index + "] (comparison=" + count3 + ").");
		}
	} while (wantToContinue);
    
    keyboard.close();
  } // end of main()
  
  
  public void main() throws FileNotFoundException //Use this main() with static methods.
  {
		ArrayList<String> array = new ArrayList<>();

		Scanner keyboard = new Scanner(System.in);

	    boolean wantToContinue = true;
		
		//File reading
		System.out.print("Type the filename to read: ");
		String filename = keyboard.nextLine();

		// Open the file.
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		int wordCount = 0;
		
		// Read lines (line by line) from the file until no more are left.
		while (inputFile.hasNext()){
			// Read the next name.
			String word = inputFile.nextLine();
			wordCount++;
			//Populate the list
			array.add(word);
		}
		System.out.println(wordCount + "words are populated in the instance of ArrayList");

		// Close the file.
		inputFile.close();

	    do {
			//Searching
			System.out.print("Type a word to search ("+ TO_STOP + " to stop): ");
			String word2Search = keyboard.nextLine();
			
			if (word2Search.equals(TO_STOP)){
				wantToContinue = false;
			} else {
				count1 = count2 = count3 = 0;
				int index;

				index = sequentialSearch(array, word2Search); //using  methods
				if (index == NOT_FOUND)
					System.out.println("sequentialSearch()      : " + word2Search + " is not found (comparison=" + count1 + ").");
				else
					System.out.println("sequentialSearch()      : " + word2Search + " is found in [" + index + "] (comparison=" + count1 + ").");

				index = binarySearch(array, word2Search);
				if (index == NOT_FOUND)
					System.out.println("iterative binarySearch(): " + word2Search + " is not found (comparison=" + count2 + ").");
				else
					System.out.println("iterative binarySearch(): " + word2Search + " is found in [" + index + "] (comparison=" + count2 + ").");

				index = binarySearch(array, 0, array.size()-1, word2Search);
				if (index == NOT_FOUND)
					System.out.println("recursive binarySearch(): " + word2Search + " is not found (comparison=" + count3 + ").");
				else
					System.out.println("recursive binarySearch(): " + word2Search + " is found in [" + index + "] (comparison=" + count3 + ").");
			}
		} while (wantToContinue);
	    
	    keyboard.close();
  }

} // end of TestSearch