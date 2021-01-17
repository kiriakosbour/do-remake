package doRemake;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoRemake {
public static ArrayList<String> doRemakeWords(String[] values) {
	Pattern patternOne = Pattern.compile("^[aeyiuo]+$");
	Matcher m = null;
	ArrayList<String> resultsArr = new ArrayList<String>();
	for (String s:values) {
		
		m = patternOne.matcher(s.subSequence(0, 1));
		if(m.matches()) {
			String concatenated = s.concat("way");
			resultsArr.add(concatenated);
		}else {
			char firstLetter = s.charAt(0); //get the first letter
			String firstChar=Character.toString(firstLetter);
			String input = s.replace(firstChar, ""); //remove the first letter from the input string
			input = input + firstLetter + "ay"; //add first letter and "ay" to end of input string
			resultsArr.add(input);
		}
	}
	

	return resultsArr;
	
}
public static void main(String args[]) {
	Scanner myObj = new Scanner(System.in); // Create a Scanner object
	System.out.println("Enter words");

	String word = myObj.nextLine(); // Read user input
	String[] values = word.split(" ");
	ArrayList<String> results = doRemakeWords(values);
	for (String result:results) {
		System.out.println(result);
	}
	myObj.close();
}
}
