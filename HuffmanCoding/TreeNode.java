
public class TreeNode {
	/*
	Methods:
	-  constructor(s)
	- printNode (T)
		// given a node, T, print T’s chStr, T’s prob, T’s next chStr, T’s left’s chStr, T ‘s right’s chStr 
		// print one treeNode per text line
	 */
	private String chStr, code;
	public TreeNode next;
	private TreeNode left;
	private TreeNode right;
	private int prob;
	
	public TreeNode() {
		chStr = "dummy";
		code = "";
		next = left = right = null;
		prob = 0;
	}
	
	public TreeNode(String chStr, int prob, TreeNode next) {
		this.chStr = chStr;
		this.prob = prob;
		this.next = next;
		left = right = null;
		code = "";
	}
	
	public TreeNode(String chStr, String code, TreeNode next, TreeNode left, TreeNode right, int prob) {
		this.chStr = chStr;
		this.code = code;
		this.next = next;
		this.left = left;
		this.right = right;
		this.prob = prob;
	}
	public String printNode() {
		if(getNext() != null)
			return getChStr() + " " + getProb() + " " +
				getNext().getChStr() + " " + getLeft() + " " + getRight();
		else
			return getChStr() + " " + getProb() + " " +
					getNext() + " " + getLeft() + " " + getRight();
	}
	public String printLNode() {
		if(getNext() != null)
			return "-->(" + getChStr() + ", " + getProb() + ", " +
				getNext().getChStr() + " )";
		else
			return "-->(" + getChStr() + ", " + getProb() + ", " +
					getNext() + " )";
	}
	
	public String getChStr() {
		return chStr;
	}
	public void setChStr(String chStr) {
		this.chStr = chStr;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public TreeNode getNext() {
		return next;
	}
	public void setNext(TreeNode next) {
		this.next = next;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public int getProb() {
		return prob;
	}
	public void setProb(int prob) {
		this.prob = prob;
	}
	public String toString() {
		return chStr.toString();
	}
	
	

}
