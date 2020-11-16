import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterStudentTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvertToEnglishFile() {
		String text1 = "";
		String text2 = "";
		try {
			BufferedReader reader = new BufferedReader (new FileReader("ComeAsYouAre.txt"));
			BufferedReader reader2 = new BufferedReader (new FileReader("LoveLookNot.txt"));
			
			text1 = reader.readLine();
			text2 = reader2.readLine();
			
			reader.close();
			reader2.close();
			
		} catch ( IOException e) {
			
		}
		
		String converter = MorseCodeConverter.convertToEnglish(text1);
		String converter2 = MorseCodeConverter.convertToEnglish(text2);
		
		assertEquals(text1, converter);
		assertEquals(text2, converter2);
		
		
	}

	@Test
	void testConvertToEnglishString() {
		
		String test1 = "hello from the other side";
		String test2 = "computer science rocks";
		String test3 = "better to love and have lost";
		
		String string1 = MorseCodeConverter.convertToEnglish(" .... . .-.. .-.. --- / ..-. .-. --- -- / - .... . / --- - .... . .-. / ... .. -.. .");
		String string2 = MorseCodeConverter.convertToEnglish("-.-. --- -- .--. ..- - . .-. / ... -.-. .. . -. -.-. . / .-. --- -.-. -.- ...");
		String string3 = MorseCodeConverter.convertToEnglish("-... . - - . .-. / - --- / .-.. --- ...- . / .- -. -.. / .... .- ...- . / .-.. --- ... -");
		
		assertEquals(test1, string1);
		assertEquals(test2, string2);
		assertEquals(test3, string3);
	}

}
