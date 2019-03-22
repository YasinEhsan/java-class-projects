import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
public class HuffmanBinaryTree {
	/*
	 * - Root (treeNode *)

    	-  Method:
		- constructor(s)
		- constructHuffmanLList (inFile, outFile)
		- constructHuffmanBinTree (listHead)  
		- preOrderTraversal (Root, outFile) // algorithm is given below
		- inOrderTraversal (Root, outFile)
		- postOrderTraversal (Root, outFile)
		- isLeaf (node)// a given node is a leaf if both left and right are null.
*/
	private TreeNode root;
	private LinkedList llist;
	
	public HuffmanBinaryTree() {
		llist = new LinkedList();
		root = llist.getListHead();
	}

	public HuffmanBinaryTree(TreeNode root) {
		this.root = root;
	}
	
	public void constructHuffmanLList(String inFile, String outFile) throws Exception {
		/*Step 1:  listHead  get a newNode as the dummy treeNode with (“dummy” ,0),  listHead to point to.  

			Step 3: chr   get  from inFile
			            Prob   get  from inFile
				newNode  get a new listNode
			        	newNode’s chStr  chr
				newNode’s prob  Prob
				newNode’s next  null
			
			Step 4: spot  findSpot (listHead, newNode) // see algorithm below
			           
			step 5:  insertOneNode (spot, newNode) // insert newNode after spot
			
			Step 6: printList (listHead, outFile) 
			// print the list to outFile, from listHead to the end of the list 
			// using the format given in the above.
			
			Step 7: repeat step 3 – step 5 until the end of inFile .
	*/
		
		//code here
		try {
			Scanner read = new Scanner(new File(inFile));
			PrintWriter pw = new PrintWriter(outFile); 
			String store = read.nextLine().replaceAll("\\s","");
			
			while(!store.equals("")){
	            String str = store.substring(0,1);
	            int prob = Integer.parseInt(store.substring(1));
	            
	            TreeNode create = new TreeNode(str, prob, null);
	            llist.insertOneNode(create);
	            
	            
	            store = read.nextLine().replaceAll("\\s","");
	            pw.println(llist.getList());
		        }
			
		    read.close();
		    pw.close();

		}
		catch(Exception e) {
			e.printStackTrace();
			// java -jar hjjg.zip arguments 
		}
				
	}
	
	public void constructHuffmanBinTree (String inFile,String outFile) throws Exception{
//		this.constructHuffmanLList(inFile, outFile);
		
		/*Step 1: newNode  create a treeNode
		        newNode’s prob  the sum of prob of the first and second node of the list // first is the node after dummy
		        newNode’s chStr  concatenate chStr of the first node and chStr of the second node in the list
		        newNode’s left  the first node of the list
		        newNode’s right  the second node of the list
		
		Step 2: spot  findSpot(listHead, newNode)  
		
		          insertOneNode (spot, newNode)  // inserting newNode between spot and spot.next.
						// only need two statements.
		         listHead’s next’s next   listHead’s next’s next’s next’s next//  listHead is pointed to dummy node, 
						//therefore,  listHead’s next’s next is the dummy’s next 
		
			printList (listHead, outFile) 
		
		Step 3: repeat step 1 – step 2 until the list only has one node left which is the newNode
		
		Step 4:  Root  newNode*/
		
		try {
			PrintWriter pw = new PrintWriter(outFile);
			pw.println("\n\nCONSTRUCTING HUFFMAN BINARY TREE: \n");
			pw.println(llist.getList());
			
			TreeNode first = llist.getListHead().next;
			TreeNode sec = llist.getListHead().next.next;
			
			while(sec != null) {
				TreeNode create = new TreeNode(first.getChStr() + sec.getChStr(),
						first.getProb() + sec.getProb(), null);
				create.setLeft(first);
				create.setRight(sec);
				pw.println(create.printLNode() + "\n");
				
				
				llist.getListHead().setNext(sec.next);
				sec.setNext(null);
				
	            llist.insertOneNode(create);
	            pw.println(llist.getList());
	            
	            first = llist.getListHead().next;
				sec = llist.getListHead().next.next;
	            
			}
			root = first;
			System.out.print(root.getChStr());
			 pw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void preOrderTraversal (TreeNode r, String outFile) {
		/*
		 * if (T is null)
			     do nothing
			else
			      printNode (T) // output to outFile,  see printing format in treeNode in above
			      preOrderTraveral (T’s left, outFile)
			      preOrderTraveral (T’s right, outFile)
		 */
		
		try {
			if(r == null) {
				;
			}
			else {
				PrintWriter pw = new PrintWriter(outFile);
				pw.println(root.printNode());
//				preOrderTraversal(outfile);
			}
		}
		catch (Exception e) {
			e.getStackTrace();
		}
		
		
	}
	
	public void inOrderTraversal (String outFile) {
//		if(root.getLeft() != null)
//			root.getLeft().inOrderTraversal(outFile);
		
	} 
	
	public File postOrderTraversal (TreeNode root) {
		return new File("e");
	}
	
	public boolean isLeaf(TreeNode node) {
		return node.getLeft() == null &&  node.getRight() == null;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public String toString() {
		return root.toString();
	}
	
	

}
