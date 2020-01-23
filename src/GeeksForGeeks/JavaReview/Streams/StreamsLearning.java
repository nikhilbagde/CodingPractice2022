package GeeksForGeeks.JavaReview.Streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
public class StreamsLearning {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*There are 4 types of methods:
			1. Static (Collections.sort, System.out.println)
			2. Methods on instance object (s.startsWith("a"))
			3. Methods on instance objects called at runtime. (s.isEmpty())
			4. Constructors (new ArrayList<String>)
		*/
		
		/* 1. Static (Collections.sort, System.out.println) */
		List<Integer> intList = java.util.Arrays.asList(12,12,4,2,1,4634,4);
		 
		Consumer<List<Integer>> lymbda1 = o -> Collections.sort(o);
		Consumer<List<Integer>> methodReference1 = Collections::sort;
		
		intList.stream().sorted();
		intList.forEach(System.out::println);
		intList.forEach(o -> System.out.print(o + " "));
		System.out.println();
		
		System.out.println(lymbda1);
		System.out.println(methodReference1);
		//I dont know how to use this Consumer.

		/* 2. Methods on instance object (s.startsWith("a")) */
		String str = "Nikhil";
		Predicate<String> lymbda2 = o -> str.startsWith(o);
		Predicate<String> methodReference2 = str::startsWith;
		
		/* 3. Methods on instance objects called at runtime. (s.isEmpty()) */
		Predicate<String> lymbda3 = o -> o.isEmpty();
		Predicate<String> methodReference3 = String::isEmpty;
		
		/* 4. Constructors (new ArrayList<String>) */
		Supplier<ArrayList<String>> lymbda4 = () -> new ArrayList<String>();
		Supplier<ArrayList<String>> methodReference4 = ArrayList::new;
		System.out.println(lymbda4.get());
		
		//Common functional intefaces.
		//	Functional Interface	#Param	Return Type		Abstract method
//1.		Supplier<T>				0		T				get()
//2.		Consumer<T>				1<T>	void			accept()
//3. 		BiCOnsumer<T>			2<T,U>	void			accept()
//4. 		Predicate<T>			1<T>	boolean			test()
//5.		BiPredicate<T,U>		2<T,U>	boolean			test()
//6.		Function<T,R>			1<T>	R				apply()
//7.		BiFunction<T,U,R>		2<T,U>	R				apply()
//8. 		UnnaryOperator<T>		1<T>	T				apply()
//9.		BinaryOperator<T>		1<T,T>	T				apply()

		//1. Implementing supplier  (Constructors)
		// To create a date object.
		System.out.println("Implementing Supplier");
		Supplier<LocalDate> s1 = () -> LocalDate.now();
		Supplier<LocalDate> s2 = LocalDate::now;
		
		LocalDate d1 = s1.get();			// here actually it gets called.
		LocalDate d2 = s2.get();
		
		System.out.println(d1);	
		System.out.println(d2);
		
		//2. Implementing Consumer (Static methods)
		Consumer<String> c1 = (o) -> System.out.println(o);
		Consumer<String> c2 = System.out::println;
		
		c1.accept("test");			// this will print test
		System.out.println(c1);		// this will print $$Lambad
		
		Map<String,String> map = new HashMap<>();
		BiConsumer<String,String> b1 = (k,v)-> map.put(k,v);
		BiConsumer<String,String> b2 = map::put;
		
		b1.accept("one", "two");
		b1.accept("two", "three");
		System.out.println(map);
		
		//3. Predicate (Instance methods)
		
		Predicate<String> p1 = (o) -> o.isEmpty();
		Predicate<String> p2 = String::isEmpty;
		
		System.out.println(p1.test(""));
		
		String name = "American Amriprises";
		BiPredicate<String, String> bp1 = (t,u) -> t.startsWith(u);
		BiPredicate<String, String> bp2 = String::startsWith;
		
		System.out.println(bp1.test(name, "Ame"));
		
		//4. Functions
		Function<String, Integer> f1 = x -> x.length();
		Function<String, Integer> f2 = String::length;
		
		System.out.println(f1.apply("Nikhil"));
		
		BiFunction<String, String, String> bf1 = (t,u) ->t.concat(u);
		BiFunction<String, String, String> bf2 = String::concat;
		
		System.out.println(bf1.apply("Nikhil loves ", "Ankana"));
		
		//Unary Operator
		UnaryOperator<String> up1 = o -> o.toUpperCase();
		UnaryOperator<String> up2 = String::toUpperCase;
		
		System.out.println(up1.apply("nikhil always loves ankana"));
		
		BinaryOperator<String> bo1 = (st1, st2) -> st1.concat(st2);
		BinaryOperator<String> bo2 = String::concat;
		
		System.out.println(bo1.apply("Nikhil weds", " Ankana"));
		
		
		
	}

}
