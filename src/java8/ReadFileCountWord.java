package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileCountWord {
	
	
	public static void main(String arg[]){
			String fileName = "/Users/apple/Documents/java/java8/sample.txt";
			List<String> list = new ArrayList<>();
		
			try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
				
			 Map<String,Integer> map= 	stream
				 .filter(line->!line.startsWith("#"))
			     .flatMap(line -> Stream.of(line.split("\\s+")))
			     .map(String::toLowerCase)
			     .collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));
			      // s ->s = Function.identity();
			     //.collect(Collectors.groupingBy(s ->s,Collectors.counting()));		
			 
			      map
			     .entrySet()
			     .stream()
			     .sorted((a,b)-> (int) (a.getValue() -  b.getValue()))
			      // comparator (a,b)-> (int) (a.getValue() -  b.getValue();
			     .forEach(System.out::println);
		
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			list.forEach(System.out::println);
	}

}
