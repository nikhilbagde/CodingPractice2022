package OTT.P7_GeeksForGeeks.JavaReview.polymorphism;

public class ChildA extends Parent implements InterfaceA{
	int a = 30;
	public void methodChild() {
		System.out.println(" Value of a= " + a);
	}
	@Override
	public void methodInterface() {
		System.out.println(" Value of a = " + a);
	}
}
