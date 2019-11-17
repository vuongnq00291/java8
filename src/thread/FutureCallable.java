package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallable {
	
	public static void main(String arg[]) throws Exception, ExecutionException{
		 ExecutorService executor = Executors.newFixedThreadPool(10);
		 Future<Test> fu =executor.submit(new Task());
		 System.out.println(" ...");
		 System.out.println(fu.get());
		 
	}
	
}
class Task implements Callable<Test>{

	public Test call() throws Exception {
		//throw new Exception();
		Thread.sleep(5000);
		return new Test(0);
	}
	
}

class Test{
	private int id;
	public Test(int id){
		this.id = id;
	}
}