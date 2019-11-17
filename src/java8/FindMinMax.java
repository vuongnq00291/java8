package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindMinMax {
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
		int max = 
		listOfIntegers
		.stream()
		.mapToInt(s->s)
		.max().orElse(0);
		System.out.println(max);
		
		
		
		
		
		Person alex = new Person("Alex", 23);
	    Person john = new Person("John", 40);
	    Person peter = new Person("Peter", 32);
	    List<Person> people = Arrays.asList(alex, john, peter);
	    Person result = people
	    		        .stream()
	    		        .max(Comparator.comparing(Person::getAge)).orElse(new Person());
	    System.out.println(result.getName());
	    
	    
	    people = Arrays.asList(alex, john, peter);
	    result =         people
	    		        .stream()
	    		        .collect(Collectors.maxBy(Comparator.comparing(Person::getAge))).orElse(new Person("no",0));
	    		        
	    System.out.println(result.getName());
	    		        
	}
}

class Person {
    String name;
    Integer age;
    public Person(){};
    public Person(String name,Integer age){
    	this.name = name;
    	this.age = age;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
    
    
       
}