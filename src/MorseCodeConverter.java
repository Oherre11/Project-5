import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * @author Oscar Herrera
 *
 */
public class MorseCodeConverter{
	
	 static MorseCodeTree tree = null;
	
	 /**
	  * No argument constructor
	  */
	public MorseCodeConverter() {
		  
	}
	
	/**
	 * Convert a file  from Morse code to English
	 * @param codeFile
	 * @return string of file, converted to English
	 */
	public static String convertToEnglish(File codeFile) {
		tree = new MorseCodeTree();
		
		 String fileCode = "";
		 String s = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(codeFile));
			
		   fileCode =  br.readLine();
		   br.close();
		} 
		
		catch ( IOException e) {
			e.printStackTrace();
		}
		
		return convertToEnglish(fileCode);
	}
	
	/**
	 * Convert string from morse code to English
	 * @param code
	 * @return string converted to English
	 */
	public static String convertToEnglish(String code){
		tree = new MorseCodeTree();
		
		String englishString = "";
		
		String[] morseCodeArray = code.split(" ");
		
		for (String words : morseCodeArray)
		{
			if (!words.equals("/")){
			englishString += tree.fetch(words);
			}
			
			else {
				englishString += " ";
			}
		}
		
		return englishString;
		
	}
	
	/**
	 * print out MorseCodeTree in order
	 * @return string containing all letters in MorseCodeTree
	 */
	public static String printTree() {
		
		tree = new MorseCodeTree();
		
		String s = "";
		
		for (String l : tree.toArrayList())
		{
			s += l + " ";
		}
		
		return s;
	}


}
