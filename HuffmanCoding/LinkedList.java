import java.io.PrintWriter;
public class LinkedList {
	
	private TreeNode listHead;

	public LinkedList() {
		listHead = new TreeNode("dummy", 0, null);
	}
	
	public LinkedList(TreeNode listHead) {
		this.listHead = listHead;
	}
	
	public TreeNode findSpot(TreeNode t) {
		/*- findSpot (…)  // Use the findSpot algorithm steps taught in class.
		 * step 0: spot  <-- listHead

			step 2: if spot's next is not null and newNode's data > spot's data
			         		 spot <-- spot's next
			
			step 3: repeat step 2 until spot's next is null or newNode's data <= spots' 
			data
			
			step 4: return spot

		*/
		TreeNode spot = listHead;
//		System.out.println("T: "+ t.getProb());
		while(spot.next != null && spot.next.getProb() < t.getProb() ) {// the OR condition
//			System.out.println("Spot BEFORE: "+ spot.getProb());
			spot = spot.next;							
//			System.out.println("Spot AFTER: "+ spot.getProb());
		}
		
		return spot;
		
		
	}
	public void insertOneNode(TreeNode t) {
		/*- insertOneNode (spot,  newNode)  
					// inserting newNode between spot and spot.next.
					// only need two statements (was given in class)*/
		
		TreeNode spot = findSpot(t); //gets spots
		t.next = spot.next;
		spot.next = (t);
	}
	public void printList(String fileName) throws Exception{
/*-  
		- printList (…)
			// print the list to outFIle1, from listHead to the end of the list in the following format:
				
				listHead -->(“dummy”, 0, next’s chStr1)-->( chStr1, prob1, next’s chStr2)...... --> (chStrj, prob j, NULL)--> NULL
				
					For example: 
				listHead -->(“dummy”, 0, “b”)-->( “b”, 5, “a”) -->( “a”, 7, “d”)............ --> (“x”, 45, NULL)--> NULL
*/
		try{
			PrintWriter pw = new PrintWriter(fileName);
			pw.println(getList());
			pw.close();
		}
		catch(Exception e){
            System.out.println("\n\nfile not found");
        }
		
	}
	
	public String getList() {
		TreeNode inspect = listHead;
		String theList = "listHead" + inspect.printLNode();
		inspect = inspect.getNext();
		while(inspect != null) {
			theList += inspect.printLNode();
			inspect = inspect.getNext();
		}
		
		return theList += "--> NULL";
	}
	
	

	public String toString() {
		return listHead.toString();
	}

	public TreeNode getListHead() {
		return listHead;
	}

	public void setListHead(TreeNode listHead) {
		this.listHead = listHead;
	}
	

}
