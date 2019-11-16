package java8;

import java.util.ArrayList;
import java.util.List;

public class ComparatorExample {

	public static void main(String[] args) {
		List<Developer> listDevs = getDevelopers();
	    listDevs.sort((left,right)->left.getAge()-right.getAge());
	    listDevs.forEach(s->System.out.println(s.getName()));
		
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