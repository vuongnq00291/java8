package java8;

@FunctionalInterface
public interface TestLamda {
		VTEST check();
		default boolean test(int a){
			return true;
		};
}
