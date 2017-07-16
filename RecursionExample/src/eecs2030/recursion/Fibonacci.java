package eecs2030.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private static Map<Integer, Long> values = new HashMap<Integer, Long>();
	static {
		Fibonacci.values.put(0, (long) 0);
		Fibonacci.values.put(1, (long) 1);
	}

	public static long getValue(int n) {
		Long value = Fibonacci.values.get(n);
		if (value != null) {
			return value;
		}
		value = Fibonacci.getValue(n - 1) + Fibonacci.getValue(n - 2);
		Fibonacci.values.put(n, value);
		return value;
	}

}
