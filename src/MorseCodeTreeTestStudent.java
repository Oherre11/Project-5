import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTestStudent {
	
	MorseCodeTree tree;

	@BeforeEach
	void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFetch() {
		String letter = tree.fetch("....");
		String letter2 = tree.fetch("...-");
		String letter3 = tree.fetch("-..-");
		
		assertEquals(letter, "h");
		assertEquals(letter2, "v");
		assertEquals(letter3, "x");
		}

	@Test
	void testToArrayList() {
		ArrayList<String> list = tree.toArrayList();
		String s = "";
		String alphabet = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		
		for (String l : list)
		{
			s += l + " ";
		}
		
		s = s.trim();
		
		assertEquals(alphabet, s);
	}

	@Test
	void testGetRoot() {
		assertEquals(tree.getRoot().data, "");
	}

}
