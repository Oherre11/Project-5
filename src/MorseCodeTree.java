import java.util.ArrayList;

/**
 * 
 * @author Oscar Herrera
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode<String> root = null;
	String letter = "";
	
	/**
	 * Build Morsecode tree
	 */
	public MorseCodeTree() {
		// builds MorseCodeTree
		buildTree();
	}

	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @return the linkedConverterTree with the new node added
	 */
	@Override
	public MorseCodeTree insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		
		return fetchNode(root, code);
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	@Override
	public void buildTree() {
		//Builds MorseCodeTree
		root = new TreeNode<>("");
		
		insert( ".", "e");
		insert("-", "t");
		
		insert("..", "i");
		insert(".-" , "a");
		insert("-." , "n");
		insert("--" , "m");
		
		insert("...", "s");
		insert("..-" , "u");
		insert(".-." , "r");
		insert(".--" , "w");
		insert("-..", "d");
		insert("-.-" , "k");
		insert("--." , "g");
		insert("---" , "o");
		
		insert("....", "h");
		insert("...-" , "v");
		insert("..-." , "f");
		insert(".-..", "l");
		insert(".--." , "p");
		insert(".---" , "j");
		insert("-..." , "b");
		insert("-..-", "x");
		insert("-.-." , "c");
		insert("-.--" , "y");
		insert("--.." , "z");
		insert("--.-", "q");
		
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {

	       ArrayList<String> printTree = new ArrayList<String>();

	       LNRoutputTraversal(root, printTree);      

	       return printTree;
	}

	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}

	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
		
	}

	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		//Base Case for recursive method
		if(code.length() == 1)
		{
			if(code.equals("."))
			{
				root.left = new TreeNode<>(letter);
				return;
				
			}
			
			else if(code.equals("-"))
			{
				root.right = new TreeNode<>(letter);
				return;
			}

		}
		
		//Recursive Steps. Once code contains one character method will terminate.
		else if (code.length() > 1){
			
				String newCode = "";
				
				for (int i = 1; i < code.length(); i++)
				{
					newCode += code.charAt(i);
				}
			 
			if(code.charAt(0) == '.')
			{
				addNode(root.left, newCode, letter);
			}
			
			if(code.charAt(0) == '-')
			{
				addNode(root.right, newCode, letter);
			}
			
		}
		
		}
	

	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		
		
		//Base case. If code contains one character then terminate.
		if (code.length() == 1) {
			

			if (code.equals("."))
			{
				letter = root.left.getData();
				
				return letter;
			}
			
			else
			{
				letter = root.right.getData();
				
				return letter;
			}
		}
			
		
		// Recursive Step. Remove characters from code until one character is left.
		else if (code.length() > 1){
			
			String newCode = "";
			
			for (int i = 1; i < code.length(); i++)
			{
				newCode += code.charAt(i);
			}
			
		if (code.charAt(0) == '.')
		{
			
			fetchNode(root.left , newCode);
			
		}
		
		if (code.charAt(0) == '-')
		{	
			fetchNode(root.right , newCode);
		}
		
	}
		return letter;
		


	}
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		           
	           if(root != null) {
	        	   LNRoutputTraversal(root.left, list);
	        	   list.add(root.data);
	        	   LNRoutputTraversal(root.right, list);
	           }
	}

}
