package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SortMap {
 public static void main(String arg[]){
	 List<Hosting> list = new ArrayList<>();
     list.add(new Hosting(1, "liquidweb.com", 80000));
     list.add(new Hosting(2, "linode.com", 90000));
     list.add(new Hosting(3, "digitalocean.com", 120000));
     list.add(new Hosting(4, "aws.amazon.com", 200000));
     list.add(new Hosting(5, "mkyong.com", 1));
     list.add(new Hosting(6, "linode.com", 100000));

     //example 1
     LinkedHashMap<String, Long> result1 = list.stream()
             .sorted(Comparator.comparing(Hosting::getWebsites).reversed())
             .collect(
                     Collectors.toMap(
                             Hosting::getName, Hosting::getWebsites, // key = name, value = websites
                             (oldValue, newValue) -> oldValue,       // if same key, take the old key
                             ()-> new LinkedHashMap<>() //  LinkedHashMap::new                    // returns a LinkedHashMap, keep order
                     ));

     System.out.println("Result 1 : " + result1);
 }
}
