
public class Main {

	public static void main(String[] args) {
		
		MorseCodeTree tree = new MorseCodeTree();
		
		for (String s : tree.toArrayList())
		{
			System.out.print(s + " ");
		}

		System.out.println("\n" + tree.fetch("...."));
		
		System.out.print(MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. "));
	}
}
