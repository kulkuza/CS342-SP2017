public class InsertionSort extends SortAlgorithm {

	public InsertionSort() {
		super("InsertionSort");
	}

	public void sort(SortArray array) {
		for (int i = 0; i < array.getSize(); i++) {
			for (int j = i; j >= 1 && array.compareAndSwap(j - 1, j); j--);
		}
	}
}