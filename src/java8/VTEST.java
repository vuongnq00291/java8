package java8;

import java.util.Calendar;

public class VTEST {
	private int a;
	private int b;
	public VTEST(int a, int b){
		this.a = a;
		this.b = b;
	}
	public static boolean test(TestLamda lamda){
		return lamda.check(2, 2);
	}
	public static void main(String arg[]){
		boolean res = VTEST.test((a,b)->a==b);
		System.out.println(res);
		
		 Calendar cal =  Calendar.getInstance();
	}
}
