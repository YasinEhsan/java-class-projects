import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
public class EhsanY_Project4_Java {
	public static void main(String[] args) throws Exception{
		
//		LinkedList l = new LinkedList();
		HuffmanBinaryTree h = new HuffmanBinaryTree();
		try {
			h.constructHuffmanLList(args[0], args[1]);
			h.constructHuffmanBinTree(args[0], args[1]);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
