package java8;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingAndSum {
	public static void main(String[] args) {

        String file = "/Users/ashok/git/java8/flight.csv";
        try (Stream<String> stream = Files.lines(Paths.get(file))) {
            Map<String, Integer> listMaps = 
            		 stream
            		.parallel()
            		.map(mapToItem)
            		.collect(Collectors.groupingBy(Item::getId, Collectors.summingInt(Item::getPrice)));
                     listMaps.forEach((key, value) -> System.out.println(key + " : " + value));
        } catch (Exception e) {

        }

    }
	 private static Function<String, Item> mapToItem = (line) -> {
	        String[] p = line.split(",");
	        Item item = new Item(p[0], Integer.parseInt(p[1]));
	        return item;
	    };
	}

	class Item {
	    private String id;
	    private Integer price;

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public Integer getPrice() {
	        return price;
	    }

	    public void setPrice(Integer price) {
	        this.price = price;
	    }

	    public Item(String id, Integer price) {
	        this.id = id;
	        this.price = price;
	    }

	    public Item() {
	    }

	    @Override
	    public String toString() {
	        return "Item{" +
	                "id='" + id + '\'' +
	                ", price='" + price + '\'' +
	                '}';
	    }


	}