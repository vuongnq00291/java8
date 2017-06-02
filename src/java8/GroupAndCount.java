package java8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAndCount {
	public static void main(String []args) throws Exception{
		String testString = "11aaa  bbb   ccc       12433";
		String s[] = testString.split("\\s+");
		System.out.println();
		most_frequent_char_java8(testString);
	}
	public static void most_frequent_char_java8(String sentence) throws IOException {
//	    Map<String, Long> frequentChars = Arrays.stream(
//	            new String[]{sentence.toLowerCase()}).collect(
//	            Collectors.groupingBy(c -> c, Collectors.counting()));
//
//	    frequentChars.forEach((k, v) -> System.out.println(k + ":" + v));
//	    List<Developer> listDevs = getDevelopers();
//	    listDevs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());
//		
//		VTEST test = new VTEST(2,2);
//		System.out.println(test.test((a,b)->a==b));
		
		List<String> names = new ArrayList<>();
		
	      names.add("Mahesh");
	      names.add("Suresh");
	      names.add("Ramesh");
	      names.add("Naresh");
	      names.add("Kalpesh");
			
	      names.forEach(System.out::println);
		
	}
	
	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", 33));
		result.add(new Developer("alvin", 20));
		result.add(new Developer("jason", 10));
		result.add(new Developer("iris", 55));

		return result;

	}
}
class Developer{
	private String name;
	private int age;
	public Developer(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
