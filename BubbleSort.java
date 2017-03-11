public class BubbleSort extends SortAlgorithm {

	public BubbleSort() {
		super("BubbleSort");
	}

	public void sort(SortArray array) {
		for (int i = array.getSize(); i >= 1; i--) {
			for (int j = 0; j < i - 1; j++) {
				array.compareAndSwap(j, j+1);
			}
		}
	}
}
