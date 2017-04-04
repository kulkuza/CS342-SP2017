public class MergeSort extends SortAlgorithm {
	public MergeSort() {
		super("MergeSort");
	}
	
	public void sort(SortArray array){
		int size = array.getSize();
		int l = 0;
		int r = size-1;

		sort(array, l, r);

		for(int i = 0; i < size; i++) {
			System.out.println(array.getElem(i));
		}
	}

	private void sort(SortArray array, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;

			sort(array, l, m);
			sort(array, m+1, r);

			merge(array, l, m, r);
		}
	}
	
	public void merge(SortArray array, int l, int m, int r){
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; i++)
			L[i] = array.getElem(l+i);

		for (int j = 0; j < n2; j++)
			R[j] = array.getElem(m+1+j);

		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array.setElem(k, L[i]);
				i++;
			}
			else {
				array.setElem(k, R[j]);
				j++;
			}
			k++;
		}

		while (i < n1) {
			array.setElem(k, L[i]);
			i++;
			k++;
		}

		while (j < n2) {
			array.setElem(k, R[j]);
			j++;
			k++;
		}
	}
}