package loops;

public class Main {
	public static void main(String[] args) {
		int k = 1;
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
//				System.out.print(k);
//				System.out.print(i);

				System.out.print("  ");
				k++;
			}

			System.out.println();
		}

	}
}