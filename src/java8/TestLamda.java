package java8;

@FunctionalInterface
public interface TestLamda {
		boolean check(int a, int b);
		default boolean test(int a){
			return true;
		};
}
