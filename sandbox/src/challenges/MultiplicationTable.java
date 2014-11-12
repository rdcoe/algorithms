package challenges;

public class MultiplicationTable {

	public static void main(String[] args) {
		compute(12);
	}

	static void compute(int bound) {
		int[][] table = new int[bound][bound];

		for (int i = 0; i < bound; i++) {
			for (int j = 0; j < bound; j++) {
				table[i][j] = (i + 1) * (j + 1);

				System.out.printf("%d ", table[i][j]);
			}
			System.out.println();
		}
	}
}
