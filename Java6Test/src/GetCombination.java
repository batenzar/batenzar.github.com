import java.util.ArrayList;
import java.util.List;

public class GetCombination {

	private static class Dimension {

		int current = 0;

		int size;

		Dimension(int size) {
			this.size = size;
		}

		private int next() {
			int i = current % size;
			current++;
			return i;
		}

	}

	public static void main(String[] args) {
		List<Dimension> di = new ArrayList<Dimension>();

		di.add(new Dimension(3));
		di.add(new Dimension(5));
		di.add(new Dimension(8));

		// generate
		for (int didx = 0; didx < (3 * 5 * 1 * di.size()); didx++) {
			List<Integer> a = new ArrayList<Integer>();
			for (Dimension d : di) {
				a.add(d.next());
			}

			for (Integer i : a) {
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}
}
