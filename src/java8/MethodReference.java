package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class MethodReference {
	public static void main(String[]arg){
		List<VMethod> list = new ArrayList<VMethod>();
		for(int i=0;i<10;i++){
			list.add(new VMethod(i, i+"test"));
		}
		//BiConsumer<Integer, Integer> c = MathOperations::sum;
		V v = new V();
		Consumer<VMethod> c = v::println;
		ToIntFunction<VMethod> toint = VMethod::getId;
		Vlist vlist = new Vlist(list);
		vlist.forEach(c);
		vlist.sum(toint);
	}
}
final class V{
	public V(){};
	public void println(VMethod x) {
		System.out.println(x.toString());
    }
}
class MathOperations {
	   public static void sum(int a, int b) {
	      System.out.println("Sum of " + a + " and " + b + " is " + (a + b));
	   }
	}
class VMethod{
	private int id;
	private String name;
	
	public VMethod(int id,String name){
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void println() {
        System.out.println(name+":"+id);
    }
	@Override
	public String toString() {
		return name+":"+id;
	}
	
}
class Vlist{
	 private List<VMethod> list;
	 public Vlist(List<VMethod> list){
		 this.list = list;
	 }
	public void forEach(Consumer<VMethod> action) {
		 for(VMethod item:list){
			 action.accept(item);
		 }
	}
	public void sum(ToIntFunction<VMethod> action){
		int total=0;
		for(VMethod item:list){
			total+=action.applyAsInt(item);
		}
		System.out.println("total :" +total);
	}
	 
}