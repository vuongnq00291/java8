package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Mapreduce {
	public static void main(String[] args){
		String[] myArray = new String[]{"1_1", "1_2", "2_1", "3_4","4_1", "4_2", "2_1", "5_4","5_1", "3_2", "5_1", "6_4"};
		Map<Integer,Integer> map = ( Arrays.stream(myArray)
	      .map(x-> new Tuple(x.split("_")[0], x.split("_")[1])))
				.filter(s->s.getId()==1)
	      .collect(Collectors.groupingBy(Tuple::getId,Collectors.summingInt(Tuple::gettest)));
		System.out.println(map);
		
		
		 List<String> items =
	                Arrays.asList("apple", "apple",
	                        "apple", "orange", "banana", "papaya");

	                items.stream().forEach(System.out::println);
	        
	}
	public static void consum(Consumer<Integer> action){
		action.accept(1);
	}
	public void getconsum(int x){
		System.out.println(x);
	}
}
class Tuple{
	private int id;
	private int value;
	public Tuple(String id, String value){
		this.id = Integer.parseInt(id);
		this.value = Integer.parseInt(value);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int gettest(){
		return value;
	}
	
}