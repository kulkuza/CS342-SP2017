public abstract class SortArray
{
	private SortAlgorithm algorithm;
    private int size;
    public int[] array;

    public SortArray() {
    	size = 0;
    	array = null;
    }

    public SortArray(int size, String algorithm) {
    	this.size = size;
    	array = new int[size];

    	for(int i = 0; i < this.size; i++) {
    		array[i] = (int)(Math.random() * this.size);
    	}

    	this.algorithm = selectAlgorithm(algorithm);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
		array = new int[size];
		
		for(int i = 0; i < this.size; i++) {
    		array[i] = (int)(Math.random() * this.size);
    	}
    }

    public int compare(int i, int j) {
    	return array[i] - array[j];
    }

    public void swap(int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }

    public boolean compareAndSwap(int i, int j) {
    	if (compare(i, j) > 0) {
    		swap(i, j);
    		ViDSortGUI gui = ViDSortGUI.getInstance();
    		gui.update(array);
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public SortAlgorithm selectAlgorithm(String algorithm) {
    	if (algorithm.equals("BubbleSort"))
    		return new BubbleSort();
    	else if (algorithm.equals("InsertionSort"))
    		return new InsertionSort();
    	else if (algorithm.equals("SelectionSort"))
    		return new SelectionSort();
    	else
    		return null;
    }

    public void sort() {
    	algorithm.sort(this);
    }
	
	public int getElem(int i){
		if (i > size - 1)
			return array[size -1];
		else if(i < 0)
			return array[0];
		else
			return array[i];
	}	

}
