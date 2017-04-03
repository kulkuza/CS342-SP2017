public class SelectionSort extends SortAlgorithm {

	public SelectionSort() {
		super("SelectionSort");
	}

	public void sort(SortArray array) {
		for (int i = 0; i < array.getSize(); i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.getSize(); j++) {
				if (array.compare(j, minIndex) < 0)
					minIndex = j;
			}
			array.compareAndSwap(i, minIndex);
		}
	}
}