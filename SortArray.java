import java.util.concurrent.TimeUnit;

public abstract class SortArray
{
	private SortAlgorithm algorithm;
    private int size;
    public int[] array;
    private int swapCounter;
    private int compareCounter;
    private boolean window;	//true -> right, false -> left

    public SortArray() {
    	size = 0;
    	swapCounter = 0;
    	compareCounter = 0;
    	array = null;
    	window = true;
    }

    public SortArray(int size, String algorithm) {
    	this.size = size;
    	array = new int[size];

    	for(int i = 0; i < this.size; i++) {
    		array[i] = (int)(Math.random() * this.size);
    	}

    	this.algorithm = selectAlgorithm(algorithm);
        this.swapCounter = 0;
        this.compareCounter = 0;
    }

    public SortArray(int size, String algorithm, boolean windowFrame) {
    	this.size = size;
    	this.window = windowFrame;
    	array = new int[size];

    	for(int i = 0; i < this.size; i++) {
    		array[i] = (int)(Math.random() * this.size);
    	}

    	this.algorithm = selectAlgorithm(algorithm);
        this.swapCounter = 0;
        this.compareCounter = 0;
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
        compareCounter++;
        ViDSortGUI gui = ViDSortGUI.getInstance();
    	gui.updateComparisonCount(compareCounter, window);
        gui.highlightCompare(i, j, window);
        System.out.println("Compare: " + array[i] + " at index " + i +
        						", " + array[j] + " at index " + j);
    	return array[i] - array[j];
    }

    public void swap(int i, int j) {
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    	System.out.println("Swap: " + array[i] + " at index " + i +
    							", " + array[j] + " at index " + j);
        swapCounter++;
        ViDSortGUI gui = ViDSortGUI.getInstance();
    	gui.updateSwapCount(swapCounter, window);
    }

    public boolean compareAndSwap(int i, int j) {
    	if (compare(i, j) > 0) {
    		swap(i, j);
    		System.out.println("Updating GUI\n");
    		ViDSortGUI gui = ViDSortGUI.getInstance();
    		gui.updateSwap(i,j, window);
            
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public SortAlgorithm selectAlgorithm(String algorithm) {
    	if (algorithm.equals("BubbleSort")) {
    		System.out.println("Algorithm is BubbleSort");
    		return new BubbleSort();
    	}
    	else if (algorithm.equals("InsertionSort")) {
    		System.out.println("Algorithm is InsertionSort");
    		return new InsertionSort();
    	}
    	else if (algorithm.equals("SelectionSort")) {
    		System.out.println("Algorithm is SelectionSort");
    		return new SelectionSort();
    	}
        else if (algorithm.equals("QuickSort")) {
        	System.out.println("Algorithm is QuickSort");
            return new QuickSort();
        }
        else if (algorithm.equals("MergeSort")) {
            System.out.println("Algorithm is MergeSort");
            return new QuickSort();
        }
    	else
    		return null;
    }

    public void sort() {
    	System.out.println("Array is sorting");
    	ViDSortGUI gui = ViDSortGUI.getInstance();
    	gui.setVisualArray(array, window);
    	algorithm.sort(this);
    	System.out.println("Array is finished sorting");

    }
	
	public int getElem(int i){
		if (i > size - 1)
			return array[size -1];
		else if(i < 0)
			return array[0];
		else
			return array[i];
	}

    public void setElem(int index, int newElem){
        if (index < 0 || index > size - 1)
            return;
        else
        {
            array[index] = newElem;
            return;
        }
    }

    public int getSwapCounter()
    {
        return swapCounter;
    }

    public int getCompareCounter()
    {
        return compareCounter;
    }

    public String getAlgorithm()
    {
        return algorithm.getName();
    }

    public SortArray copyArray(SortArray copyFrom)
    {
        int size = copyFrom.getSize();
        String alg = copyFrom.getAlgorithm();

        SortArray newArray = new VisualArray(size, alg, window);

        int i;
        for(i = 0; i < size; i++)
        {
            newArray.setElem(i, copyFrom.getElem(i));
        }

        return newArray;
    }

}
