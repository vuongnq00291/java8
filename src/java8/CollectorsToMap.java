package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsToMap {
	public static void main(String[] args) {
		List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
		
        list.add(new Hosting(6, "linode.com", 100000)); // new line

        // key = name, value - websites , but the key 'linode' is duplicated!?
        Map<String, Long> result1 = 
        		list
        		.stream()
        		.collect(
                 Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldo,newo)-> oldo));
        System.out.println("Result 1 : " + result1);
	}
}
class Hosting {

    private int Id;
    private String name;
    private long websites;

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getWebsites() {
		return websites;
	}

	public void setWebsites(long websites) {
		this.websites = websites;
	}
    
    
}