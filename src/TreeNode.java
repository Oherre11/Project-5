
public class TreeNode<T> {
	
	T data;
	TreeNode<T> right;
	TreeNode<T> left;
	
	public TreeNode() {
		this.data = null;
		left = null;
		right = null;
	}
	
	public TreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	public TreeNode (TreeNode<T> node) {
		this.data = node.data;
		this.right  = node.right;
		this.left = node.left;
	}
	
	public T getData() {
		return data;
	}
	

}
