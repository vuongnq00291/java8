package java8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingBy {
	public static void main(String[] args) {

        File file = new File("/Users/thaitran/Downloads/ontime/flights.csv");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Map<String, Integer> listMaps = br.lines().parallel().map(mapToItem).collect(Collectors.groupingBy(Item::getId, Collectors.summingInt(Item::getPrice)));
            listMaps.forEach((key, value) -> System.out.println(key + " : " + value));
        } catch (Exception e) {

        }

    }
	 private static Function<String, Item> mapToItem = (line) -> {
	        String[] p = line.split(",");

	        Item item = new Item(p[0], Integer.parseInt(p[7]));

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