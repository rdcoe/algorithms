package challenges;

public class Fibonacci {
	public static void main(String[] args) {
		if (args.length != 1)
			System.exit(1);
		int n = Integer.parseInt(args[0]);

		if (n <= 0) {
			System.out.println("specify a natural number greater than 0.");
			return;
		}

		int val = Fibonacci.compute(n);
		System.out.printf("fibonacci number in position %d is %d", n, val);
	}

	public static int compute(int n) {
		// computer the Nth fibonacci: 1,1,2,3,5,8,13...
		return ( n <= 1 ? n : compute(n - 2) + compute(n - 1));
	}

}
