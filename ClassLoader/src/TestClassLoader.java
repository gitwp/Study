public class TestClassLoader {
	public static void main(String[] args) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		// sun.misc.Launcher$AppClassLoader@1f66cff
		System.out.println(loader);
		// sun.misc.Launcher$ExtClassLoader@16de49c
		System.out.println(loader.getParent());
		// null
		System.out.println(loader.getParent().getParent());

		ClassLoader loader2 = Test.class.getClassLoader();
		// sun.misc.Launcher$AppClassLoader@1f66cff
		System.out.println(loader2);
		//true
		System.out.println(loader==loader2);
	}
}
