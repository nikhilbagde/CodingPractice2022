package DataStructure.ThreadedBinaryTree;//main method to test the tbst.java
import java.util.*;
public class main
{
	public static void main(String args[])
	{
		TBST tree = new TBST();
		tree.insert(new Customer ("Arpan Kotecha",10,29,1985,29414),5);
		tree.insert(new Customer ("alwic skwwil",7,3,1981,29401),7);
		tree.insert(new Customer ("Akash Vithlani",8,5,1982,29414),8);
		tree.insert(new Customer ("Jerry Lin",4,11,1982,29414),4);
		tree.insert(new Customer ("Aristide ",4,11,1982,12321321),3);
		System.out.println (tree.find (7));
		System.out.println(tree);

		MyDate date = new MyDate (23,1,1985);
		System.out.println (date);
	}
}
	
