package java8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAndCount {
	public static void main(String []args) throws Exception{
		String testString = "11a a a  b b b   ccc  1 24 3 3";
		String s[] = testString.split("\\s+");
		System.out.println();
		most_frequent_char_java8(s);
	}
	public static void most_frequent_char_java8(String[] sentence) throws IOException {
	    Map<String, Long> frequentChars = 
	    	Arrays.stream(sentence)
	    	.collect( Collectors.groupingBy(Function.identity(), Collectors.counting()));
	        frequentChars.forEach((key,value)->{
	    	System.out.println(key+":"+value);
	    });
		
	}
	
}

