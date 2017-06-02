package java8;

public class VTEST {
	private int a;
	private int b;
	public VTEST(int a, int b){
		this.a = a;
		this.b = b;
	}
	public boolean test(TestLamda lamda){
		return lamda.check(a, b);
	}
}
