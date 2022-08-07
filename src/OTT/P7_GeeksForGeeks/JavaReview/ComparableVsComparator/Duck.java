package OTT.P7_GeeksForGeeks.JavaReview.ComparableVsComparator;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Duck /* 5. */ implements Comparable<Duck>{
	public Duck(String name) {
		this.name = name;
	}
	
	//8.
	public Duck(int age) {
		this.age = age;
	}
	public String name;
	//8.
	public int age;
	
	public String toString() {
		return (this.name == null? "Test": this.name) + " " + this.age;
	}

	/* 6. */
	@Override
	public int compareTo(Duck obj) {
		return this.name.compareTo(obj.name);
	}
	
	
}

class test {
	public static void main(String args[]) {
		//1.Sorting Array		
		String [] normalStringArray = {"aa","bb","cc"};
		Arrays.sort(normalStringArray);
		System.out.println(Arrays.toString(normalStringArray));
		
		//2. Sorting list of String
		//See for String class which already implements comparable 
		// Collections.sort(list<String>) did not throw any compatible error.
		List<String> listOfString = Arrays.asList("asa","asdas","kdhd");
		Collections.sort(listOfString);
		System.out.println(listOfString);

		//3. But for duck class if we do not implement comparable 
		// and directly use COllections.sort it will thorw complilation errror.
		//4. Fix: add implements comparable<Duck>
		List<Duck> ducks = Arrays.asList(new Duck("A"), new Duck("B"), new Duck("C"));
		Collections.sort(ducks);
		System.out.println(ducks);
		
		// 7. If we still want to compare with other parameters on top of
		// exisiting comparable name paramter
		// e.g. lets add age.
		
		// Now we can not add another comparable method compareTo
		//hence we have comparaTOR
		List<Duck> duckListWithAges =  Arrays.asList(new Duck(132), new Duck(321), new Duck(232));
		Comparator<Duck> ducksByAge = (Duck o1, Duck o2) -> o1.age - o2.age;
		Collections.sort(duckListWithAges, ducksByAge);
		System.out.println(duckListWithAges);
		
	}
}