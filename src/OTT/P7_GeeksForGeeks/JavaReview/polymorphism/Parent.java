package OTT.P7_GeeksForGeeks.JavaReview.polymorphism;

public class Parent implements InterfaceA{
	int a = 10;
	public void methodParent() {
		System.out.println(" Value of a =" + a);
	}
	@Override
	public void methodInterface() {
		System.out.println(" Value of a =" + a);
	}
}
// Defined other where just for reference quickly here.
//interface InterfaceA{
//	int a = 20;
//	public void methodInterface ();
//}

//class ChildA extends Parent implements InterfaceA{
//	int a = 30;
//	public void methodChild() {
//		System.out.println(" Value of a= " + a);
//	}
//	@Override
//	public void methodInterface() {
//		System.out.println(" Value of a = " + a);
//	}
//}

class test{
	public static void main (String args[]) {
		ChildA childA = new ChildA();
		System.out.println(childA.a);
		childA.methodChild();
		childA.methodParent();
		childA.methodInterface();
		
		Parent parent = childA;
		System.out.println(parent.a);
		//parent.methodChild();	// does not compile
		parent.methodParent();
		parent.methodInterface();
		
		InterfaceA interfaceA = childA;
		System.out.println(interfaceA.a);
		//interfaceA.methodChild();	// does not compile
		//interfaceA.methodParent();	// does not compile
		interfaceA.methodInterface();
		
		InterfaceA interfaceB = parent;
		System.out.println(interfaceB.a);
		//interfaceB.methodChild();	// does not compile
		//interfaceB.methodParent();	// does not compile
		interfaceB.methodInterface();
		
	}
}
