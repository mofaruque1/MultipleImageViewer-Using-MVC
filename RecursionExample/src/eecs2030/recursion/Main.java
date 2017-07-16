package eecs2030.recursion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.out.println(fibonacci(7));
		System.out.println(countZeros(1250072003));

		System.out.println(computeTenPow(8));
		
		System.out.println(Fibonacci.getValue(7));

	}

	public static int fibonacci(int n) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static int countZeros(int z) {
		if (z == 0) {
			return 1;
		} else if (z < 10) {
			return 0;
		}
		int tmp = z % 10;
		if (tmp == 0) {
			return 1 + countZeros(z / 10);
		} else {
			return countZeros(z / 10);
		}
	}

	private static int computeTenPow(int n) {
		if (n == 0) {
			return 1;
		} else if(n>0) {
			return 10 * computeTenPow(n - 1);
		}
		else {
			return 0;
		}

	}

}
