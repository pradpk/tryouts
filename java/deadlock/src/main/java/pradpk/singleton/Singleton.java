package pradpk.singleton;

public class Singleton {

	private static Singleton object;

	private Singleton() {
	}

	public synchronized static Singleton create() {
		return object;
	}

	public static Singleton createObj() {
		if (null == object) {
			synchronized (object) {
				if (null == object) {
					object = new Singleton();
				}
			}
		}
		return object;
	}

}
